package com.formacionbdi.microservicios.app.examenes.services;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.commons.services.CommonService;

import java.util.List;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
public interface ExamenService extends CommonService<Examen> {
    public List<Examen> findByNombre(String term);

    public Iterable<Asignatura> findAllAsignaturas();
}
