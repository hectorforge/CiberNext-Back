package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.ConsultaMapper;
import pe.edu.cibernext.models.ConsultaEntity;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.models.dto.ConsultaJerarquicaDto;
import pe.edu.cibernext.repositories.ConsultaRepository;
import pe.edu.cibernext.services.ConsultaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Override
    public List<ConsultaConRespuestaDto> listarRespondidasProfesor(Long idProfesor) {
        List<ConsultaEntity> consultas = consultaRepository.findConsultasRespondidasPorProfesor(idProfesor);
        return ConsultaMapper.toDtoList(consultas, idProfesor);
    }

    @Override
    public List<ConsultaConRespuestaDto> listarNoRespondidasProfesor(Long idProfesor) {
        List<ConsultaEntity> consultas = consultaRepository.findConsultasNoRespondidasPorProfesor(idProfesor);
        return ConsultaMapper.toDtoList(consultas, null); // No se busca respuesta
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasAlumno(Long idAlumno) {
        List<ConsultaEntity> consultas = consultaRepository.findConsultasAlumno(idAlumno);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasNoRespondidasAlumno(Long idAlumno) {
        List<ConsultaEntity> consultas = consultaRepository.findConsultasNoRespondidasAlumno(idAlumno);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }

    @Override
    public List<ConsultaJerarquicaDto> listarConsultasUnidadAprendizaje(Long idUnidad) {
        List<ConsultaEntity> consultas = consultaRepository.findConsultasByUnidadAprendizaje(idUnidad);
        return ConsultaMapper.toJerarquicoDtoList(consultas);
    }
}