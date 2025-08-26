package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.ProfesorEntity;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity,Long> {
    @Query("""
        select p
        from ProfesorEntity p
        where lower(p.codigoProfesor) like lower(concat('%', :filtro, '%'))
           or lower(p.nombre) like lower(concat('%', :filtro, '%'))
           or lower(p.apellido) like lower(concat('%', :filtro, '%'))
           or lower(p.email) like lower(concat('%', :filtro, '%'))
    """)
    List<ProfesorEntity> buscarPorFiltro(@Param("filtro") String filtro);
}
