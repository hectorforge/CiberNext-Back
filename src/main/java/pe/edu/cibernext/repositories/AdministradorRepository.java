package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.AdministradorEntity;
import pe.edu.cibernext.models.UsuarioEntity;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity,Long> {

    @Query("SELECT u FROM UsuarioEntity u " +
            "WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :filtro, '%')) " +
            "   OR LOWER(u.dni) = LOWER(:filtro) " +
            "   OR LOWER(u.email) = LOWER(:filtro)")
    List<AdministradorEntity> buscarPorFiltro(@Param("filtro") String filtro);

}
