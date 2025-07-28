package pe.edu.cibernext.models.enums;


public enum Roles {
    ADMIN(1L),
    PROFESOR(2L),
    ALUMNO(3L);

    private final Long codigo;

    Roles(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }
}
