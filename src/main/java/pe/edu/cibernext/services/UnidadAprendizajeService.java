package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.*;

import java.util.List;

public interface UnidadAprendizajeService {

    List<UnidadAprendizajeRespuestaDto> listarTodos();

    UnidadAprendizajeDto registrar(UnidadAprendizajeDto dto);
    UnidadAprendizajeDto actualizar(UnidadAprendizajeDto dto);
    void eliminarPorId(Long id);

    UnidadAprendizajeJerarquicoDto buscarJerarquicoPorId(Long id);

    List<ConsultaPorUnidadAprendizajeDto> listarConsultasArbolPorUnidad(Long idUnidad);

    List<DocumentoPorUnidadAprendizajeDto> listarDocumentosPorUnidad(Long idUnidad);

}
