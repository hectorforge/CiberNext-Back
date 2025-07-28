package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Long> {
}