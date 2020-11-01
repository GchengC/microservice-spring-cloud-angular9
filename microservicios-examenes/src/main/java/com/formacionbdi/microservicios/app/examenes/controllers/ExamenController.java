package com.formacionbdi.microservicios.app.examenes.controllers;

import com.formacionbdi.microservicios.app.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.app.examenes.models.entity.Pregunta;
import com.formacionbdi.microservicios.app.examenes.services.ExamenService;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {
        Optional<Examen> o = this.service.findById(id);

        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Examen examenDB = o.get();
        examenDB.setNombre(examen.getNombre());

        examenDB.getPreguntas()
                .stream()
                .filter(f -> !examen.getPreguntas().contains(f))
                .forEach(examenDB::removePregunta);

        examenDB.setPreguntas(examen.getPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(examenDB));
    }

    @PutMapping("/{id}/asignar-preguntas")
    public ResponseEntity<?> asignarAlumnos(@RequestBody List<Pregunta> preguntas, @PathVariable Long id) {
        Optional<Examen> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Examen examenDB = o.get();
        preguntas.forEach(examenDB::addPreguntas);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(examenDB));
    }

    @PutMapping("/{id}/eliminar-pregunta")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Pregunta pregunta, @PathVariable Long id) {
        Optional<Examen> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Examen examenDB = o.get();
        examenDB.removePregunta(pregunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(examenDB));
    }

}
