package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.DocumentoMapper;
import pe.edu.cibernext.models.DocumentoEntity;
import pe.edu.cibernext.models.TipoDocumentoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.DocumentoDto;
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
    public DocumentoDto buscarPorId(Long id) {
        DocumentoEntity entity = documentoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public List<DocumentoDto> listarTodos() {
        return documentoRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoDto> listarPorUnidad(Long unidadId) {
        return documentoRepo.findByUnidadAprendizajeId(unidadId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public DocumentoDto registrar(DocumentoDto dto) {
        // Validar que vengan los IDs
        if (dto.getIdTipoDocumento() == null || dto.getIdUnidadAprendizaje() == null) {
            throw new RuntimeException("Debe especificar idTipoDocumento y idUnidadAprendizaje");
        }

        UnidadAprendizajeEntity unidad = unidadRepo.findById(dto.getIdUnidadAprendizaje())
                .orElseThrow(() -> new RuntimeException("Unidad de aprendizaje no encontrada"));

        TipoDocumentoEntity tipo = tipoRepo.findById(dto.getIdTipoDocumento())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        DocumentoEntity entity = new DocumentoEntity();
        entity.setNombre(dto.getNombre());
        entity.setArchivo(dto.getArchivo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setUnidadAprendizaje(unidad);
        entity.setTipoDocumento(tipo);

        return mapper.toDto(documentoRepo.save(entity));
    }

    @Override
    public DocumentoDto actualizar(DocumentoDto dto) {
        if (dto.getId() == null) {
            throw new RuntimeException("Debe indicar el ID del documento a actualizar");
        }
        if (dto.getIdTipoDocumento() == null || dto.getIdUnidadAprendizaje() == null) {
            throw new RuntimeException("Debe especificar idTipoDocumento y idUnidadAprendizaje");
        }

        DocumentoEntity existente = documentoRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));

        UnidadAprendizajeEntity unidad = unidadRepo.findById(dto.getIdUnidadAprendizaje())
                .orElseThrow(() -> new RuntimeException("Unidad de aprendizaje no encontrada"));

        TipoDocumentoEntity tipo = tipoRepo.findById(dto.getIdTipoDocumento())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        existente.setNombre(dto.getNombre());
        existente.setArchivo(dto.getArchivo());
        existente.setDescripcion(dto.getDescripcion());
        existente.setUnidadAprendizaje(unidad);
        existente.setTipoDocumento(tipo);

        return mapper.toDto(documentoRepo.save(existente));
    }


    @Override
    public void eliminar(Long id) {
        documentoRepo.deleteById(id);
    }

    @Override
    public List<DocumentoDto> listarDocumentosPorCurso(Long cursoId) {
        return unidadRepo.findByCursoId(cursoId).stream()
                .flatMap(unidad -> documentoRepo.findByUnidadAprendizajeId(unidad.getId()).stream())
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
