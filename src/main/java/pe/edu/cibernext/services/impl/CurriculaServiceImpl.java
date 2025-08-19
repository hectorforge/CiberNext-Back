package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.CurriculaMapper;
import pe.edu.cibernext.models.AreaEspecializacionEntity;
import pe.edu.cibernext.models.CurriculaEntity;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.dto.CurriculaDto;
import pe.edu.cibernext.models.dto.CurriculaRespuestaDto;
import pe.edu.cibernext.repositories.AreaEspecializacionRepository;
import pe.edu.cibernext.repositories.CurriculaRepository;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.services.CurriculaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurriculaServiceImpl implements CurriculaService {

    private final CurriculaRepository curriculaRepo;
    private final CursoRepository cursoRepo;
    private final AreaEspecializacionRepository areaRepo;
    private final CurriculaMapper mapper;

    @Override
    public CurriculaRespuestaDto buscarPorId(Long id) {
        CurriculaEntity entity = curriculaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Currícula no encontrada"));
        return mapper.toRespuestaDto(entity);
    }

    @Override
    public List<CurriculaRespuestaDto> listarTodos() {
        return curriculaRepo.findAll().stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CurriculaRespuestaDto> listarPorCurso(Long cursoId) {
        return curriculaRepo.findByCursoId(cursoId).stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }

    @Override
    public CurriculaDto registrar(CurriculaDto dto) {
        CursoEntity curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        AreaEspecializacionEntity area = areaRepo.findById(dto.getAreaEspecializacionId())
                .orElseThrow(() -> new RuntimeException("Área de especialización no encontrada"));

        CurriculaEntity entity = mapper.toEntity(dto, curso, area);
        return mapper.toDto(curriculaRepo.save(entity));
    }

    @Override
    public CurriculaDto actualizar(CurriculaDto dto) {
        CurriculaEntity existente = curriculaRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Currícula no encontrada"));

        CursoEntity curso = cursoRepo.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        AreaEspecializacionEntity area = areaRepo.findById(dto.getAreaEspecializacionId())
                .orElseThrow(() -> new RuntimeException("Área de especialización no encontrada"));

        CurriculaEntity actualizado = mapper.toEntity(dto, curso, area);
        actualizado.setId(existente.getId());
        return mapper.toDto(curriculaRepo.save(actualizado));
    }

    @Override
    public void eliminar(Long id) {
        curriculaRepo.deleteById(id);
    }

    @Override
    public List<CurriculaRespuestaDto> listarPorAreaEspecialidad(Long areaId) {
        List<CurriculaEntity> entidades = curriculaRepo.findByAreaEspecializacionId(areaId);
        return entidades.stream()
                .map(mapper::toRespuestaDto)
                .collect(Collectors.toList());
    }
}
