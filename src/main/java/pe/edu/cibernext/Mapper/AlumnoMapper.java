package pe.edu.cibernext.Mapper;

import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.dto.AlumnoDto;

public class AlumnoMapper {
    public static AlumnoDto toDto(AlumnoEntity entity) {
        if (entity == null) return null;

        AlumnoDto dto = new AlumnoDto();
        dto.setId(entity.getId());
        dto.setUsuario(UsuarioMapper.toDto(entity));
        return dto;
    }


}
