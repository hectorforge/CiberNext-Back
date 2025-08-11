package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibernext.mapper.UnidadAprendizajeJerarquicoMapper;
import pe.edu.cibernext.mapper.UnidadAprendizajeMapper;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.*;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.repositories.UnidadAprendizajeRepository;
import pe.edu.cibernext.services.UnidadAprendizajeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnidadAprendizajeServiceImpl implements UnidadAprendizajeService {

    private final UnidadAprendizajeRepository unidadRepo;
    private final CursoRepository cursoRepo;
    private final UnidadAprendizajeMapper mapper;


    @Override
    public List<UnidadAprendizajeRespuestaDto> listarTodos() {
        return unidadRepo.findAll().stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }


    @Override
    public UnidadAprendizajeDto registrar(UnidadAprendizajeDto dto) {
        CursoEntity curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        UnidadAprendizajeEntity entity = mapper.toEntity(dto, curso);
        return mapper.toDto(unidadRepo.save(entity));
    }

    @Override
    public UnidadAprendizajeDto actualizar(UnidadAprendizajeDto dto) {
        UnidadAprendizajeEntity existente = unidadRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));

        CursoEntity curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        UnidadAprendizajeEntity actualizado = mapper.toEntity(dto, curso);
        actualizado.setId(existente.getId());

        return mapper.toDto(unidadRepo.save(actualizado));
    }

    @Override
    public void eliminarPorId(Long id) {
        unidadRepo.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public UnidadAprendizajeJerarquicoDto buscarJerarquicoPorId(Long id) {
        UnidadAprendizajeEntity entity = unidadRepo.findWithTreeById(id)
                .orElseThrow(() -> new RuntimeException("Unidad no encontrada"));
        return UnidadAprendizajeJerarquicoMapper.toDto(entity);
    }

    @Override
    public List<ConsultaPorUnidadAprendizajeDto> listarConsultasArbolPorUnidad(Long idUnidad) {
        if (!unidadRepo.existsById(idUnidad)) {
            throw new RuntimeException("Unidad de aprendizaje no encontrada con ID: " + idUnidad);
        }
        var consultas = unidadRepo.listarConsultasPorUnidad(idUnidad);
        return UnidadAprendizajeMapper.toConsultaArbol(consultas);
    }

    @Override
    public List<DocumentoPorUnidadAprendizajeDto> listarDocumentosPorUnidad(Long idUnidad) {
        if (!unidadRepo.existsById(idUnidad)) {
            throw new RuntimeException("Unidad de aprendizaje no encontrada con ID: " + idUnidad);
        }
        var documentos = unidadRepo.listarDocumentosPorUnidad(idUnidad);
        return UnidadAprendizajeMapper.toDocumentoList(documentos);
    }
}
