package com.formacionbdi.microservicios.app.respuestas.controllers;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@RestController
public class RespuestaController {

    @Autowired
    RespuestaService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {
        Iterable<Respuesta> respuestasBD = service.saveAll(respuestas);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestasBD);
    }

    @GetMapping("/alumno/{alumnoId}/examen/{examenId}")
    public ResponseEntity<?> obtenerRespuestaPorAlumnoPorExamen(
            @PathVariable Long alumnoId,
            @PathVariable Long examenId,
            @RequestBody Iterable<Respuesta> respuestas) {
        Iterable<Respuesta> respuestasBD = service.findRespuestaByAlumnoByExamen(alumnoId, examenId);

        return ResponseEntity.ok(respuestasBD);
    }
}
