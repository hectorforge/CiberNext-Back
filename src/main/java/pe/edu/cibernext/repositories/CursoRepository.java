package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.AlumnoCursoDto;
import pe.edu.cibernext.models.dto.ProfesorCursoDto;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {

    boolean existsByCodigo(String codigo);
    @Query("""
        select new pe.edu.cibernext.models.dto.AlumnoCursoDto(
            a.id,
            a.codigoAlumno,
            a.nombre,
            a.apellido,
            a.email,
            a.pais,
            a.fotoPerfil,
            a.dni
        )
        from RegistroAlumnoEntity ra
            join ra.curso c
            join ra.alumno a
        where c.id = :idCurso
        order by a.apellido, a.nombre
    """)
    List<AlumnoCursoDto> listarAlumnosPorCurso(@Param("idCurso") Long idCurso);

    @Query("""
        select new pe.edu.cibernext.models.dto.ProfesorCursoDto(
            p.id,
            p.codigoProfesor,
            p.nombre,
            p.apellido,
            p.email,
            p.correoProfesional,
            p.biografia,
            p.fotoPerfil,
            p.dni         
        )
        from CursoEntity c
            join c.profesores p
        where c.id = :idCurso
        order by p.apellido, p.nombre
    """)
    List<ProfesorCursoDto> listarProfesoresPorCurso(@Param("idCurso") Long idCurso);

    @Query("""
        select u
        from CursoEntity c
            join c.unidades u
            left join fetch u.padre
        where c.id = :idCurso
    """)
    List<UnidadAprendizajeEntity> listarUnidadesPorCurso(@Param("idCurso") Long idCurso);

    List<CursoEntity> findByProfesores_Id(Long profesorId);
}

