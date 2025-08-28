package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.ConsultaMapper;
import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.*;
import pe.edu.cibernext.repositories.*;
import pe.edu.cibernext.services.ConsultaService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final ProfesorRepository profesorRepository;
    private final AlumnoRepository alumnoRepository;
    private final UnidadAprendizajeRepository unidadAprendizajeRepository;

    private final UsuarioRepository usuarioRepository;
    private final RegistroAlumnoRepository registroAlumnoRepository;

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasPorProfesor(idProfesor);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasNoRespondidasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasNoRespondidasPorProfesor(idProfesor);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasAlumno(Long idAlumno) {
        if (!alumnoRepository.existsById(idAlumno)) {
            throw new RecursoNoEncontradoException("Alumno no encontrado con ID: " + idAlumno);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasAlumno(idAlumno);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasNoRespondidasAlumno(Long idAlumno) {
        if (!alumnoRepository.existsById(idAlumno)) {
            throw new RecursoNoEncontradoException("Alumno no encontrado con ID: " + idAlumno);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasNoRespondidasAlumno(idAlumno);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasUnidadAprendizaje(Long idUnidad) {
        if (!unidadAprendizajeRepository.existsById(idUnidad)) {
            throw new RecursoNoEncontradoException("Unidad de aprendizaje no encontrada con ID: " + idUnidad);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasByUnidadAprendizaje(idUnidad);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    @Transactional
    public ConsultaResponseDto registrarConsulta(ConsultaRequestDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Solicitud nula");
        }

        String titulo = dto.getTitulo();
        if (titulo != null) {
            titulo = titulo.trim();
            if (titulo.isEmpty()) {
                titulo = null; // tratar blanco como null
            } else if (titulo.length() > 200) {
                throw new IllegalArgumentException("Titulo excede 200 caracteres");
            }
        }

        // Validar mensaje
        String mensaje = dto.getMensaje();
        if (mensaje == null || (mensaje = mensaje.trim()).isEmpty()) {
            throw new IllegalArgumentException("Mensaje obligatorio");
        }
        if (mensaje.length() > 2000) {
            throw new IllegalArgumentException("Mensaje excede 2000 caracteres");
        }

        // Validar unidad
        Long unidadId = dto.getUnidadAprendizajeId();
        if (unidadId == null) {
            throw new IllegalArgumentException("unidadAprendizajeId obligatorio");
        }
        UnidadAprendizajeEntity unidad = unidadAprendizajeRepository.findById(unidadId)
                .orElseThrow(() -> new IllegalArgumentException("Unidad no encontrada"));

        // Usuario (puede ser alumno o profesor)
        Long usuarioId = dto.getUsuarioId();
        if (usuarioId == null) throw new IllegalArgumentException("usuarioId obligatorio");
        UsuarioEntity autor = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Validar registro alumno
        Long registroId = dto.getRegistroAlumnoId();
        if (registroId == null) {
            // obtenerlo con el id del alumno + id de la unidad
            UnidadAprendizajeEntity unidadTemporal = unidadAprendizajeRepository.findById(unidadId).orElseThrow(() -> new IllegalArgumentException("No existe registro del alumno para esta unidad"));
            Long cursoIdTemporal = unidadTemporal.getCurso().getId();
            RegistroAlumnoEntity registro = registroAlumnoRepository.findByCursoIdAndAlumno_Id(cursoIdTemporal, autor.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe registro del alumno para esta unidad"));
            registroId = registro.getId();
        }
        RegistroAlumnoEntity registro = registroAlumnoRepository.findById(registroId)
                .orElseThrow(() -> new IllegalArgumentException("Registro alumno no encontrado"));

        // Crear entidad
        ConsultaEntity consulta = new ConsultaEntity();
        consulta.setTitulo(titulo);
        consulta.setMensaje(mensaje);
        consulta.setAutor(autor);
        consulta.setRegistroAlumno(registro);
        consulta.setUnidadAprendizaje(unidad);

        // Validar y asignar consulta padre (opcional)
        Long padreId = dto.getConsultaPadreId();
        if (padreId != null) {
            ConsultaEntity padre = consultaRepository.findById(padreId)
                    .orElseThrow(() -> new IllegalArgumentException("Consulta padre no encontrada"));
            consulta.setConsultaPadre(padre);
        }

        ConsultaEntity guardada = consultaRepository.save(consulta);
        return ConsultaMapper.toResponseDto(guardada);
    }

    @Override
    @Transactional
    public ConsultaResponseDto registrarRespuesta(RespuestaProfesorDto dto) {
        UsuarioEntity profesor = usuarioRepository.findById(dto.getProfesorId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Profesor no encontrado"));
        ConsultaEntity consultaPadre = consultaRepository.findById(dto.getConsultaPadreId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Consulta padre no encontrada"));
        ConsultaEntity respuesta = new ConsultaEntity();
        respuesta.setMensaje(dto.getMensaje());
        respuesta.setTitulo(dto.getTitulo());
        respuesta.setFecha(LocalDateTime.now());
        respuesta.setEstado(true);
        respuesta.setAutor(profesor);
        respuesta.setConsultaPadre(consultaPadre);
        respuesta.setUnidadAprendizaje(consultaPadre.getUnidadAprendizaje());
        return ConsultaMapper.toResponseDto(consultaRepository.save(respuesta));
    }


    @Override
    public List<ConsultaConRespuestaDto> listarRespondidasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }

        List<ConsultaEntity> consultas = consultaRepository.findConsultasPorProfesor(idProfesor);

        // Filtrar solo las que ya tienen respuesta de ese profesor
        return consultas.stream()
                .filter(c -> c.getRespuestas() != null &&
                        c.getRespuestas().stream()
                                .anyMatch(r -> r.getAutor().getId().equals(idProfesor)))
                .map(c -> ConsultaMapper.toDto(c, idProfesor))
                .toList();
    }

    @Override
    public List<ConsultaConRespuestaDto> listarNoRespondidasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }

        List<ConsultaEntity> consultas = consultaRepository.findConsultasPorProfesor(idProfesor);

        // Filtrar las que no tienen respuesta de ese profesor
        return consultas.stream()
                .filter(c -> c.getRespuestas() == null ||
                        c.getRespuestas().stream()
                                .noneMatch(r -> r.getAutor().getId().equals(idProfesor)))
                .map(c -> ConsultaMapper.toDto(c, idProfesor))
                .toList();
    }

}
