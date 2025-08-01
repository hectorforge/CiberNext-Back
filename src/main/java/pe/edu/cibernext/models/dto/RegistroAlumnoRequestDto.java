package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class RegistroAlumnoRequestDto {
    private Long cursoId;
    private Long alumnoId;
    private Long profesorId;
}
