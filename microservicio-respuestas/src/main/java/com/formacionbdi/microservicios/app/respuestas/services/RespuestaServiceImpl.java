package com.formacionbdi.microservicios.app.respuestas.services;

//import com.formacionbdi.microservicios.app.respuestas.clients.ExamenFeingClient;
import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import com.formacionbdi.microservicios.app.respuestas.models.repository.RespuestaRepository;
//import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
//import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

//    @Autowired
//    ExamenFeingClient examenClient;

    /**
     * MongoDB no es transaccional asi que se quita esa etiqueta
     */

    @Override
//    @Transactional
    public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
        return repository.saveAll(respuestas);
    }

    @Override
//    @Transactional(readOnly = true)
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
//        Examen examen = examenClient.obtenerExamenPorId(examenId);
//        List<Pregunta> preguntas = examen.getPreguntas();
//        List<Long> preguntasIds = preguntas.stream().map(Pregunta::getId).collect(Collectors.toList());
//        List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByPreguntaIds(alumnoId, preguntasIds);
//        respuestas = respuestas.stream().map(r -> {
//            preguntas.forEach(p -> {
//                if (p.getId().equals(r.getPreguntaId())) {
//                    r.setPregunta(p);
//                }
//            });
//            return r;
//        }).collect(Collectors.toList());
//        return respuestas;
        List<Respuesta> respuestas = (List<Respuesta>) repository.findRespuestaByAlumnoByExamen(alumnoId, examenId);

        return respuestas;
    }

    @Override
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
//        List<Respuesta> respuestasAlumno = (List<Respuesta>) repository.findAlumnoId(alumnoId);
//        List<Long> examenIds = Collections.emptyList();
//        if (respuestasAlumno.size() > 0) {
//            List<Long> preguntasIds = respuestasAlumno.stream().map(Respuesta::getPreguntaId).collect(Collectors.toList());
//            examenIds = examenClient.obtenerExamenesIdsPorPreguntasRespondidas(preguntasIds);
//        }

        List<Respuesta> respuestasAlumno = (List<Respuesta>) repository.findExamenesIdsConRespuestasByAlumno(alumnoId);
        List<Long> examenIds = respuestasAlumno
                .stream()
                .map(r -> r.getPregunta().getExamen().getId())
                .distinct()
                .collect(Collectors.toList());

        return examenIds;
    }

    @Override
    public Iterable<Respuesta> findByAlumnoId(Long alumnoId) {
        return repository.findAlumnoId(alumnoId);
    }
}
