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
    @Query("""
        SELECT c FROM ConsultaEntity c
        WHERE c.consultaPadre IS NULL
        AND NOT EXISTS (
            SELECT 1 FROM ConsultaEntity r
            WHERE r.consultaPadre.id = c.id AND r.autor.id = :idProfesor
        )
    """)
    List<ConsultaEntity> findConsultasNoRespondidasPorProfesor(Long idProfesor);
}