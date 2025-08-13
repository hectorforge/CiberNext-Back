package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class AlumnoSimpleDto {
    private Long id;
    private String nombre;
    private String dni;
    private String correo;
    private String fotoPerfil;
    private String codigoAlumno;
    private String correoPersonal;
    private String pais;
}