package com.formacionbdi.microservicios.app.cursos.services;

import com.formacionbdi.microservicios.app.cursos.clients.AlumnoFeignClient;
import com.formacionbdi.microservicios.app.cursos.clients.RespuestaFeignClient;
import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.repository.CursoRepository;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.services.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

    @Autowired
    RespuestaFeignClient client;

    @Autowired
    AlumnoFeignClient clientAlumno;

    @Override
    public Curso findCursoByAlumnoId(Long id) {
        return repository.findCursoByAlumnoId(id);
    }

    @Override
    public Iterable<Long> obtenerExamanesIdsConRespuestasAlumno(Long alumnoId) {
        return client.obtenerExamanesIdsConRespuestasAlumno(alumnoId);
    }

    @Override
    public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids) {
        return clientAlumno.obtenerAlumnosPorCurso(ids);
    }

    @Override
    @Transactional
    public void eliminarCursoAlumnoPorId(Long id) {
        repository.eliminarCursoAlumnoPorId(id);
    }
}
