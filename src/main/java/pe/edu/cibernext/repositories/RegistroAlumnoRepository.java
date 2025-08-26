package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.RegistroAlumnoEntity;

import java.util.List;
import java.util.Optional;

public interface RegistroAlumnoRepository extends JpaRepository<RegistroAlumnoEntity,Long> {
    Optional<RegistroAlumnoEntity> findByCursoIdAndAlumno_Id(Long cursoId, Long alumnoId);
    RegistroAlumnoEntity findByAlumnoIdAndCursoId(Long alumnoId, Long cursoId);

    @Query("""
        select r
        from RegistroAlumnoEntity r
        join r.alumno a
        join r.curso c
        join c.profesores p
        where lower(a.nombre) like lower(concat('%', :filtro, '%'))
           or lower(c.nombre) like lower(concat('%', :filtro, '%'))
           or lower(p.nombre) like lower(concat('%', :filtro, '%'))
    """)
    List<RegistroAlumnoEntity> buscarPorFiltro(@Param("filtro") String filtro);

}
