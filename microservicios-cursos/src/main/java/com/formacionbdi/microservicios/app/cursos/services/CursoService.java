package com.formacionbdi.microservicios.app.cursos.services;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.services.CommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/

public interface CursoService extends CommonService<Curso> {

    public Curso findCursoByAlumnoId(Long id);

    public Iterable<Long> obtenerExamanesIdsConRespuestasAlumno(Long alumnoId);

    public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);

}
