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
    public List<ConsultaConRespuestaDto> listarRespondidasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasRespondidasPorProfesor(idProfesor);
        return ConsultaMapper.toDtoList(consultas, idProfesor);
    }

    @Override
    public List<ConsultaConRespuestaDto> listarNoRespondidasProfesor(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<ConsultaEntity> consultas = consultaRepository.findConsultasNoRespondidasPorProfesor(idProfesor);
        return ConsultaMapper.toDtoList(consultas, null);
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
        UsuarioEntity alumno = usuarioRepository.findById(dto.getAlumnoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado"));
        UnidadAprendizajeEntity unidad = unidadAprendizajeRepository.findById(dto.getUnidadAprendizajeId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Unidad no encontrada"));
        RegistroAlumnoEntity registro = registroAlumnoRepository
                .findByAlumnoIdAndCursoId(alumno.getId(), unidad.getCurso().getId());
        ConsultaEntity consulta = new ConsultaEntity();
        consulta.setTitulo(dto.getTitulo());
        consulta.setMensaje(dto.getMensaje());
        consulta.setFecha(LocalDateTime.now());
        consulta.setEstado(true);
        consulta.setAutor(alumno);
        consulta.setRegistroAlumno(registro);
        consulta.setUnidadAprendizaje(unidad);
        return ConsultaMapper.toResponseDto(consultaRepository.save(consulta));
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
}
