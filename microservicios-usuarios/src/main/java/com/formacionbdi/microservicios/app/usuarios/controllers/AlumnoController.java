package com.formacionbdi.microservicios.app.usuarios.controllers;

import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.controllers.CommonController;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {


    @GetMapping("/alumnos-por-curso")
    public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(this.service.findAllById(ids));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Alumno alumno, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors())
            return this.validar(result);

        Optional<Alumno> o = this.service.findById(id);

        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Alumno alumnoDB = o.get();
        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(alumnoDB));
    }


    @GetMapping("/filtrar/{term}")
    public ResponseEntity<?> filtrar(@PathVariable String term) {
        return ResponseEntity.ok(service.findByNombreOrApellido(term));
    }

    @PostMapping("/crear-con-foto")
    public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo) throws IOException {
        if (!archivo.isEmpty()) alumno.setFoto(archivo.getBytes());
        return super.crear(alumno, result);
    }

    @PutMapping("/editar-con-foto/{id}")
    public ResponseEntity<?> editarConFoto(@Valid Alumno alumno, BindingResult result, @PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException {
        if (result.hasErrors())
            return this.validar(result);

        Optional<Alumno> o = this.service.findById(id);

        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Alumno alumnoDB = o.get();
        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());
        if (!archivo.isEmpty()) alumnoDB.setFoto(archivo.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(alumnoDB));
    }

    @GetMapping("/uploads/img/{id}")
    public ResponseEntity<?> verFoto(@PathVariable Long id) {
        Optional<Alumno> o = this.service.findById(id);
        if (!o.isPresent() || o.get().getFoto() == null) {
            return ResponseEntity.notFound().build();
        }

        Resource imagen = new ByteArrayResource(o.get().getFoto());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagen);
    }

}
