package com.formacionbdi.microservicios.app.examenes.services;

import com.formacionbdi.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.formacionbdi.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Asignatura;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import com.formacionbdi.microservicios.commons.services.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Examen> findByNombre(String term) {
        return repository.findByNombre(term);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds) {
        return repository.findExamenesIdsConRespuestasByPreguntaIds(preguntaIds);
    }
}
