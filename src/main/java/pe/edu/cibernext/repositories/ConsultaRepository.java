package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.cibernext.models.ConsultaEntity;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    // Consultas respondidas por el profesor
    @Query("""
        SELECT c FROM ConsultaEntity c
        WHERE c.consultaPadre IS NULL
        AND EXISTS (
            SELECT 1 FROM ConsultaEntity r
            WHERE r.consultaPadre.id = c.id AND r.autor.id = :idProfesor
        )
    """)
    List<ConsultaEntity> findConsultasRespondidasPorProfesor(Long idProfesor);

    // Consultas NO respondidas por el profesor
//    @Query("""
//        SELECT c FROM ConsultaEntity c
//        WHERE c.consultaPadre IS NULL
//        AND NOT EXISTS (
//            SELECT 1 FROM ConsultaEntity r
//            WHERE r.consultaPadre.id = c.id AND r.autor.id = :idProfesor
//        )
//    """)
//    List<ConsultaEntity> findConsultasNoRespondidasPorProfesor(Long idProfesor);

    @Query("""
        SELECT c FROM ConsultaEntity c
        JOIN c.registroAlumno ra
        WHERE c.consultaPadre IS NULL
        AND ra.profesor.id = :idProfesor
        AND NOT EXISTS (
            SELECT 1 FROM ConsultaEntity r
            WHERE r.consultaPadre.id = c.id
            AND r.autor.id = :idProfesor
        )
    """)
    List<ConsultaEntity> findConsultasNoRespondidasPorProfesor(Long idProfesor);


    // Todas las consultas del alumno
    @Query("""
        SELECT c FROM ConsultaEntity c
        JOIN c.registroAlumno ra
        WHERE c.consultaPadre IS NULL
        AND ra.alumno.id = :idAlumno
    """)
    List<ConsultaEntity> findConsultasAlumno(Long idAlumno);

    // Consultas sin responder del alumno
    @Query("""
        SELECT c FROM ConsultaEntity c
        JOIN c.registroAlumno ra
        WHERE c.consultaPadre IS NULL
        AND ra.alumno.id = :idAlumno
        AND NOT EXISTS (
            SELECT 1 FROM ConsultaEntity r
            WHERE r.consultaPadre.id = c.id
            AND r.autor.id = ra.profesor.id
        )
    """)
    List<ConsultaEntity> findConsultasNoRespondidasAlumno(Long idAlumno);


    @Query("""
        SELECT c FROM ConsultaEntity c
        WHERE c.consultaPadre IS NULL
        AND c.unidadAprendizaje.id = :idUnidad
    """)
    List<ConsultaEntity> findConsultasByUnidadAprendizaje(Long idUnidad);
}
