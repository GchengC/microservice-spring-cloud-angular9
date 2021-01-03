package com.formacionbdi.microservicios.app.cursos.controllers;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import com.formacionbdi.microservicios.app.cursos.models.entity.CursoAlumno;
import com.formacionbdi.microservicios.app.cursos.services.CursoService;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<>();
        response.put("balanceador", balanceadorTest);
        response.put("cursor", service.findAll());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors())
            return this.validar(result);

        Optional<Curso> o = this.service.findById(id);

        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso cursoDB = o.get();
        cursoDB.setNombre(curso.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
        Optional<Curso> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso cursoDB = o.get();
//        la siguiente linea cambia dado a la nueva relacion transient de las 2 BD
//        alumnos.forEach(a -> cursoDB.addAlumno(a));
        alumnos.forEach(a -> {
            CursoAlumno cursoAlumno = new CursoAlumno();
            cursoAlumno.setAlumnoId(a.getId());
            cursoAlumno.setCurso(cursoDB);
            cursoDB.addCursoAlumno(cursoAlumno);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso cursoDB = o.get();
//        la siguiente linea cambia dado a la nueva relacion transient de las 2 BD
        CursoAlumno cursoAlumno = new CursoAlumno();
        cursoAlumno.setAlumnoId(alumno.getId());
        cursoDB.removeCursoAlumno(cursoAlumno);
//        cursoDB.removeAlumno(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<?> filtrar(@PathVariable Long id) {
        Curso curso = service.findCursoByAlumnoId(id);
        if (Optional.ofNullable(curso).isPresent()) {
            List<Long> examenesIds = (List<Long>) service.obtenerExamanesIdsConRespuestasAlumno(id);
            List<Examen> examenes = curso.getExamenes()
                    .stream()
                    .map(ex -> {
                        if (examenesIds.contains(ex.getId())) {
                            ex.setRespondido(true);
                        }
                        return ex;
                    })
                    .collect(Collectors.toList());
            curso.setExamenes(examenes);
        }

        return ResponseEntity.ok(curso);
    }


    @PutMapping("/{id}/asignar-examenes")
    public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
        Optional<Curso> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso cursoDB = o.get();
        examenes.forEach(cursoDB::addExamen);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
    }

    @PutMapping("/{id}/eliminar-examen")
    public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id) {
        Optional<Curso> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso cursoDB = o.get();
        cursoDB.removeExamen(examen);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cursoDB));
    }

}