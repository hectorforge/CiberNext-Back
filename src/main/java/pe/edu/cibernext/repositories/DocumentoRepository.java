package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.DocumentoEntity;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Long> {
    List<DocumentoEntity> findByUnidadAprendizajeId(Long unidadAprendizajeId);
}