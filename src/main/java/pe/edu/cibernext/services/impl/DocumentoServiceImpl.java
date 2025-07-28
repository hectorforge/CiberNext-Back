package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.DocumentoMapper;
import pe.edu.cibernext.models.DocumentoEntity;
import pe.edu.cibernext.models.TipoDocumentoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.DocumentoDto;
import pe.edu.cibernext.models.dto.DocumentoRespuestaDto;
import pe.edu.cibernext.repositories.DocumentoRepository;
import pe.edu.cibernext.repositories.TipoDocumentoRepository;
import pe.edu.cibernext.repositories.UnidadAprendizajeRepository;
import pe.edu.cibernext.services.DocumentoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImpl implements DocumentoService {

    private final DocumentoRepository documentoRepo;
    private final UnidadAprendizajeRepository unidadRepo;
    private final TipoDocumentoRepository tipoRepo;
    private final DocumentoMapper mapper;

    @Override
    public DocumentoRespuestaDto buscarPorId(Long id) {
        DocumentoEntity entity = documentoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
        return mapper.toRespuestaDto(entity);
    }

    @Override
    public List<DocumentoRespuestaDto> listarTodos() {
        return documentoRepo.findAll().stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoRespuestaDto> listarPorUnidad(Long unidadId) {
        return documentoRepo.findByUnidadAprendizajeId(unidadId).stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentoDto registrar(DocumentoDto dto) {
        UnidadAprendizajeEntity unidad = unidadRepo.findById(dto.getUnidadAprendizajeId())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        TipoDocumentoEntity tipo = tipoRepo.findById(dto.getTipoDocumentoId())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        DocumentoEntity entity = mapper.toEntity(dto, unidad, tipo);
        return mapper.toDto(documentoRepo.save(entity));
    }

    @Override
    public DocumentoDto actualizar(DocumentoDto dto) {
        DocumentoEntity existente = documentoRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        UnidadAprendizajeEntity unidad = unidadRepo.findById(dto.getUnidadAprendizajeId())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        TipoDocumentoEntity tipo = tipoRepo.findById(dto.getTipoDocumentoId())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        DocumentoEntity actualizado = mapper.toEntity(dto, unidad, tipo);
        actualizado.setId(existente.getId());
        return mapper.toDto(documentoRepo.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        documentoRepo.deleteById(id);
    }
}