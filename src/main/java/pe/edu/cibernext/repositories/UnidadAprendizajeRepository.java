package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.ConsultaEntity;
import pe.edu.cibernext.models.DocumentoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;

import java.util.List;
import java.util.Optional;

public interface UnidadAprendizajeRepository extends JpaRepository<UnidadAprendizajeEntity,Long> {

    long countByCursoId(Long cursoId);

    List<UnidadAprendizajeEntity> findByCursoId(Long cursoId);

    @EntityGraph(attributePaths = { "subUnidades" })
    Optional<UnidadAprendizajeEntity> findWithTreeById(Long id);

    @Query("""
        select c
        from ConsultaEntity c
            join c.unidadAprendizaje u
            left join fetch c.consultaPadre
            left join fetch c.autor a
        where u.id = :idUnidad
    """)
    List<ConsultaEntity> listarConsultasPorUnidad(@Param("idUnidad") Long idUnidad);

    @Query("""
        select d
        from DocumentoEntity d
            left join fetch d.tipoDocumento td
        where d.unidadAprendizaje.id = :idUnidad
        order by d.id asc
    """)
    List<DocumentoEntity> listarDocumentosPorUnidad(@Param("idUnidad") Long idUnidad);
}
