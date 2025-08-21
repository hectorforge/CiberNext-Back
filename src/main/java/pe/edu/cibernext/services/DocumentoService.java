package pe.edu.cibernext.services;


import pe.edu.cibernext.models.dto.DocumentoDto;

import java.util.List;

public interface DocumentoService {
    DocumentoDto buscarPorId(Long id);
    List<DocumentoDto> listarTodos();
    List<DocumentoDto> listarPorUnidad(Long unidadId);
    DocumentoDto registrar(DocumentoDto dto);
    DocumentoDto actualizar(DocumentoDto dto);
    void eliminar(Long id);
    List<DocumentoDto> listarDocumentosPorCurso(Long cursoId);
}