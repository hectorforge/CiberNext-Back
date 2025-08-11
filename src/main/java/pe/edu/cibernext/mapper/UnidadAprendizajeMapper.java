package pe.edu.cibernext.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.ConsultaPorUnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.DocumentoPorUnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeRespuestaDto;

import java.util.*;

@Component
@RequiredArgsConstructor
public class UnidadAprendizajeMapper {

    private final CursoMapper cursoMapper;

    public static UnidadAprendizajeDto toDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeDto dto = new UnidadAprendizajeDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCodigo(entity.getCodigo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setCursoId(entity.getCurso() != null ? entity.getCurso().getId() : null);
        return dto;
    }

    public UnidadAprendizajeRespuestaDto toRespuestaDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeRespuestaDto dto = new UnidadAprendizajeRespuestaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCodigo(entity.getCodigo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setCurso(cursoMapper.toDto(entity.getCurso()));
        return dto;
    }

    public UnidadAprendizajeEntity toEntity(UnidadAprendizajeDto dto, CursoEntity curso) {
        UnidadAprendizajeEntity entity = new UnidadAprendizajeEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCodigo(dto.getCodigo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCurso(curso);
        return entity;
    }

    public static ConsultaPorUnidadAprendizajeDto toConsultaDto(ConsultaEntity e) {
        ConsultaPorUnidadAprendizajeDto dto = new ConsultaPorUnidadAprendizajeDto();
        dto.setId(e.getId());
        dto.setTitulo(e.getTitulo());
        dto.setMensaje(e.getMensaje());
        dto.setFecha(e.getFecha());
        dto.setEstado(e.isEstado());

        if (e.getAutor() != null) {
            var autor = e.getAutor();
            // Detecta el subtipo por herencia JOINED (AlumnoEntity / ProfesorEntity)
            if (autor instanceof AlumnoEntity) {
                dto.setAutorTipo("ALUMNO");
            } else if (autor instanceof ProfesorEntity) {
                dto.setAutorTipo("PROFESOR");
            } else {
                dto.setAutorTipo("USUARIO");
            }
            dto.setAutorId(autor.getId());
            dto.setAutorNombre(autor.getNombre());
            dto.setAutorApellido(autor.getApellido());
            dto.setAutorEmail(autor.getEmail());
        } else {
            dto.setAutorTipo("USUARIO");
        }
        return dto;
    }

    /** Construye el árbol consulta -> respuestas a partir de todas las consultas de la unidad. */
    public static List<ConsultaPorUnidadAprendizajeDto> toConsultaArbol(List<ConsultaEntity> consultas) {
        Map<Long, ConsultaPorUnidadAprendizajeDto> mapa = new HashMap<>();
        for (ConsultaEntity c : consultas) {
            mapa.put(c.getId(), toConsultaDto(c));
        }

        List<ConsultaPorUnidadAprendizajeDto> raices = new ArrayList<>();
        for (ConsultaEntity c : consultas) {
            if (c.getConsultaPadre() != null) {
                ConsultaPorUnidadAprendizajeDto padreDto = mapa.get(c.getConsultaPadre().getId());
                if (padreDto != null) {
                    padreDto.getRespuestas().add(mapa.get(c.getId()));
                } else {
                    raices.add(mapa.get(c.getId()));
                }
            } else {
                raices.add(mapa.get(c.getId()));
            }
        }
        ordenarRecursivoPorFechaDesc(raices);
        return raices;
    }
    private static void ordenarRecursivoPorFechaDesc(List<ConsultaPorUnidadAprendizajeDto> nodos) {
        nodos.sort(Comparator.comparing(ConsultaPorUnidadAprendizajeDto::getFecha,
                Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        for (ConsultaPorUnidadAprendizajeDto n : nodos) {
            ordenarRecursivoPorFechaDesc(n.getRespuestas());
        }
    }

    public static DocumentoPorUnidadAprendizajeDto toDocumentoDto(DocumentoEntity e) {
        DocumentoPorUnidadAprendizajeDto dto = new DocumentoPorUnidadAprendizajeDto();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setDescripcion(e.getDescripcion());
        dto.setArchivo(e.getArchivo());
        if (e.getTipoDocumento() != null) {
            dto.setTipoDocumentoId(e.getTipoDocumento().getId());
            dto.setTipoDocumentoNombre(e.getTipoDocumento().getNombre());
            dto.setTipoDocumentoExtension(e.getTipoDocumento().getExtension());
        }
        return dto;
    }

    public static List<DocumentoPorUnidadAprendizajeDto> toDocumentoList(List<DocumentoEntity> entities) {
        List<DocumentoPorUnidadAprendizajeDto> list = new ArrayList<>();
        for (DocumentoEntity e : entities) {
            list.add(toDocumentoDto(e));
        }
        return list;
    }
}