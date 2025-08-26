package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.CursoEntity;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity,Long> {
    @Query("""
        select c
        from RegistroAlumnoEntity ra
            join ra.curso c
        where ra.alumno.id = :idAlumno
        order by c.nombre asc
    """)
    List<CursoEntity> listarCursosPorAlumno(@Param("idAlumno") Long idAlumno);


    @Query("""
        select a
        from AlumnoEntity a
        where lower(a.codigoAlumno) like lower(concat('%', :filtro, '%'))
           or lower(a.nombre) like lower(concat('%', :filtro, '%'))
           or lower(a.apellido) like lower(concat('%', :filtro, '%'))
           or lower(a.pais) like lower(concat('%', :filtro, '%'))
           or lower(a.email) like lower(concat('%', :filtro, '%'))
    """)
    List<AlumnoEntity> buscarPorFiltro(@Param("filtro") String filtro);

}
