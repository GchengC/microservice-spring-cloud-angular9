package com.formacionbdi.microservicios.app.respuestas.clients;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since ene. 2021.
 **/
@FeignClient(name = "microservicios-examenes")
public interface ExamenFeingClient {

    @GetMapping("/{id}")
    public Examen obtenerExamenPorId(@PathVariable Long id);

}
