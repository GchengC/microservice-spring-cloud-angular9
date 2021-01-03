package com.formacionbdi.microservicios.app.cursos.clients;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since ene. 2021.
 **/
@FeignClient(name = "microservicios-usuarios")
public interface AlumnoFeignClient {

    @GetMapping("/alumnos-por-curso")
    public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
