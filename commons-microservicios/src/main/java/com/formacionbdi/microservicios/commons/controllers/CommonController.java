package com.formacionbdi.microservicios.commons.controllers;

import com.formacionbdi.microservicios.commons.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
public class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> o = service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(o.get());
    }

    @PostMapping()
    public ResponseEntity<?> crear(@RequestBody E entity) {
        E entityDB = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
    }

    /**
     * EL UNICO QUE NO AMERITA ESTAR EN GENERICOS ES EL ACTUALIZAR, YA QUE DEPENDE MUCHO DEL ENTITY Y LOS VALORES QUE QUERRAMOS ACTUALIZAR
     */
//    @PutMapping("/{id}")
//    public ResponseEntity<?> editar(@RequestBody E entity, @PathVariable Long id) {
//        Optional<E> o = service.findById(id);
//
//        if (!o.isPresent())
//            return ResponseEntity.notFound().build();
//
//        E entityDB = o.get();
//        entityDB.setNombre(entity.getNombre());
//        entityDB.setApellido(entity.getApellido());
//        entityDB.setEmail(entity.getEmail());
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entityDB));
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
