package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

   /* @Query("SELECT u FROM UsuarioEntity u WHERE u.dni = :dni")
    UsuarioEntity findByDni(@Param("dni") String dni);

    @Query("SELECT u FROM UsuarioEntity u WHERE u.correo = :correo")
    UsuarioEntity findByCorreo(@Param("correo") String correo);*/

    @Query("SELECT u FROM UsuarioEntity u WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :filtro, '%')) OR LOWER(u.dni) = :filtro OR LOWER(u.correo) = :filtro")
    List<UsuarioEntity> buscarPorFiltro(@Param("filtro") String filtro);

}
