package com.formacionbdi.microservicios.app.respuestas.models.repository;

import com.formacionbdi.microservicios.app.respuestas.models.entity.Respuesta;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.CrudRepository;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
//public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {
public interface RespuestaRepository extends MongoRepository<Respuesta, Long> {

//    //    @Query("SELECT r FROM Respuesta r JOIN FETCH r.alumno a JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE a.id = ?1 AND e.id = ?2")
//    @Query("SELECT r FROM Respuesta r JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE r.alumnoId = ?1 AND e.id = ?2")
//    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
//
//    //    @Query("SELECT e.id FROM Respuesta r JOIN r.alumno a JOIN r.pregunta p JOIN p.examen e WHERE a.id = ?1 GROUP BY e.id")
//    @Query("SELECT e.id FROM Respuesta r JOIN r.pregunta p JOIN p.examen e WHERE r.alumnoId = ?1 GROUP BY e.id")
//    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);

    @Query("{'alumnoId': ?0, 'preguntaId': {$in: ?1}}")
    public Iterable<Respuesta> findRespuestaByAlumnoByPreguntaIds(Long alumnoId, Iterable<Long> preguntaIds);

    @Query
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);

}
