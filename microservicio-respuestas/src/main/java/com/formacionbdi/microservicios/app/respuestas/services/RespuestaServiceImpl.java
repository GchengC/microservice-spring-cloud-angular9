package com.formacionbdi.microservicios.app.respuestas.services;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.models.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    RespuestaRepository repository;

    @Override
    @Transactional
    public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
        return repository.saveAll(respuestas);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
//        return repository.findRespuestaByAlumnoByExamen(alumnoId, examenId);
        return null;
    }

    @Override
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
//        return repository.findExamenesIdsConRespuestasByAlumno(alumnoId);
        return null;
    }
}
