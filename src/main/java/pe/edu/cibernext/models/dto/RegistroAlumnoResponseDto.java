package pe.edu.cibernext.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroAlumnoResponseDto {
    private Long id;
    private LocalDateTime fechaInscripcion;

    private Long cursoId;
    private String nombreCurso;

    private Long alumnoId;
    private String nombreAlumno;
    private String correoAlumno;
    private String codigoAlumno;
    private String fotoAlumno;

    private Long profesorId;
    private String nombreProfesor;
    private String correoProfesor;
    private String codigoProfesor;
    private String fotoProfesor;
}
