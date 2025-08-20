package pe.edu.cibernext.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.AlumnoCursoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajePorCursoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeRespuestaDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CursoMapper {


    public static CursoDto toDto(CursoEntity entity) {
        CursoDto dto = new CursoDto();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public static CursoEntity toEntity(CursoDto dto) {
        CursoEntity entity = new CursoEntity();
        entity.setId(dto.getId());
        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public static List<CursoDto> toDtoList(List<CursoEntity> entities) {
        return entities.stream().map(CursoMapper::toDto).collect(Collectors.toList());
    }


    // Convierte AlumnoEntity -> AlumnoCursoDto
    public static AlumnoCursoDto toAlumnoCursoDto(pe.edu.cibernext.models.AlumnoEntity entity) {
        AlumnoCursoDto dto = new AlumnoCursoDto();
        dto.setIdAlumno(entity.getId());
        dto.setCodigoAlumno(entity.getCodigoAlumno());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setPais(entity.getPais());
        dto.setFotoPerfil(entity.getFotoPerfil());
        dto.setDni(entity.getDni());
        return dto;
    }

    // Convierte lista de AlumnoEntity -> lista de AlumnoCursoDto
    public static List<AlumnoCursoDto> toAlumnoCursoList(List<pe.edu.cibernext.models.AlumnoEntity> entities) {
        List<AlumnoCursoDto> lista = new ArrayList<>();
        for (pe.edu.cibernext.models.AlumnoEntity entity : entities) {
            lista.add(toAlumnoCursoDto(entity));
        }
        return lista;
    }

    // ---- Unidades por curso (árbol) ----
    public static UnidadAprendizajePorCursoDto toUnidadPorCursoDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajePorCursoDto dto = new UnidadAprendizajePorCursoDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public static List<UnidadAprendizajePorCursoDto> toUnidadesArbolPorCurso(List<UnidadAprendizajeEntity> unidades) {
        Map<Long, UnidadAprendizajePorCursoDto> mapa = new HashMap<>();
        for (UnidadAprendizajeEntity u : unidades) {
            mapa.put(u.getId(), toUnidadPorCursoDto(u));
        }

        List<UnidadAprendizajePorCursoDto> raices = new ArrayList<>();
        for (UnidadAprendizajeEntity u : unidades) {
            if (u.getPadre() != null) {
                var padreDto = mapa.get(u.getPadre().getId());
                if (padreDto != null) {
                    padreDto.getSubUnidades().add(mapa.get(u.getId()));
                } else {
                    raices.add(mapa.get(u.getId()));
                }
            } else {
                raices.add(mapa.get(u.getId()));
            }
        }

        ordenarUnidadesRecursivoPorNombre(raices);
        return raices;
    }
    private static void ordenarUnidadesRecursivoPorNombre(List<UnidadAprendizajePorCursoDto> lista) {
        lista.sort(java.util.Comparator.comparing(
                UnidadAprendizajePorCursoDto::getNombre,
                String.CASE_INSENSITIVE_ORDER));
        for (UnidadAprendizajePorCursoDto dto : lista) {
            ordenarUnidadesRecursivoPorNombre(dto.getSubUnidades());
        }
    }

}
