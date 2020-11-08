package com.formacionbdi.microservicios.app.respuestas.models.repository;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

    @Query("SELECT r FROM Respuesta r JOIN FETCH r.alumno a JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE a.id = ?1 AND e.id = ?2")
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
}
