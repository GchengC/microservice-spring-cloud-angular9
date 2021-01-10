package com.formacionbdi.microservicios.commons.controllers;

import com.formacionbdi.microservicios.commons.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
//@CrossOrigin({"http://localhost:4200"})
public class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/pagina")
    public ResponseEntity<?> listar(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> o = service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(o.get());
    }

    @PostMapping()
    public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result) {
        if (result.hasErrors())
            return this.validar(result);

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


    protected ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage())));
        return ResponseEntity.badRequest().body(errores);
    }
}
