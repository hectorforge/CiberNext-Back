package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.UnidadVista;
import pe.edu.cibernext.models.dto.UnidadVistaDto;

public class UnidadVistaMapper {

    public static UnidadVista toEntity(UnidadVistaDto dto, Long registroAlumnoId) {
        return UnidadVista.builder()
                .unidadAprendizajeId(dto.getUnidadAprendizajeId())
                .registroAlumnoId(registroAlumnoId)
                .build();
    }
}
