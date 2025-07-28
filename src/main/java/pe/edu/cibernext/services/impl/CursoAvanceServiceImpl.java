package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.UnidadVistaMapper;
import pe.edu.cibernext.models.AvanceResponse;
import pe.edu.cibernext.models.RegistroAlumnoEntity;
import pe.edu.cibernext.models.UnidadVista;
import pe.edu.cibernext.models.dto.UnidadVistaDto;
import pe.edu.cibernext.repositories.RegistroAlumnoRepository;
import pe.edu.cibernext.repositories.UnidadAprendizajeRepository;
import pe.edu.cibernext.repositories.UnidadVistaRepository;
import pe.edu.cibernext.services.CursoAvanceService;

@Service
@RequiredArgsConstructor
public class CursoAvanceServiceImpl implements CursoAvanceService {

    private final UnidadVistaRepository vistaRepo;
    private final RegistroAlumnoRepository registroRepo;
    private final UnidadAprendizajeRepository unidadRepo;

    @Override
    public AvanceResponse calcularAvance(Long cursoId, Long alumnoId) {
        RegistroAlumnoEntity registro = registroRepo.findByCursoIdAndAlumno_Id(cursoId, alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no registrado en el curso"));

        long total = unidadRepo.countByCursoId(cursoId);
        int vistas = vistaRepo.countByRegistroAlumnoId(registro.getId());

        int porcentaje = total == 0 ? 0 : (int) ((vistas * 100.0) / total);

        return AvanceResponse.builder()
                .porcentajeAvance(porcentaje)
                .totalUnidades(total)
                .unidadesVistas(vistas)
                .build();
    }

    @Override
    public void registrarUnidadVista(UnidadVistaDto request) {
        RegistroAlumnoEntity registro = registroRepo.findByCursoIdAndAlumno_Id(request.getCursoId(), request.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no registrado en el curso"));

        boolean yaVista = vistaRepo.existsByUnidadAprendizajeIdAndRegistroAlumnoId(
                request.getUnidadAprendizajeId(), registro.getId());

        if (!yaVista) {
            UnidadVista vista = UnidadVistaMapper.toEntity(request, registro.getId());
            vistaRepo.save(vista);
        }
    }
}
