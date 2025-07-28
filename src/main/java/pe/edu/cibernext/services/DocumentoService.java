package pe.edu.cibernext.services;


import pe.edu.cibernext.models.dto.DocumentoDto;
import pe.edu.cibernext.models.dto.DocumentoRespuestaDto;

import java.util.List;

public interface DocumentoService {
    DocumentoRespuestaDto buscarPorId(Long id);
    List<DocumentoRespuestaDto> listarTodos();
    List<DocumentoRespuestaDto> listarPorUnidad(Long unidadId);
    DocumentoDto registrar(DocumentoDto dto);
    DocumentoDto actualizar(DocumentoDto dto);
    void eliminar(Long id);
}