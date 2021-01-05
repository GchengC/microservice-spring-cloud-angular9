package com.formacionbdi.microservicios.app.examenes.models.repository;

import com.formacionbdi.microservicios.commons.examenes.models.entity.Examen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
//public interface ExamenRepository extends CrudRepository<Examen, Long> {
public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {

    @Query("SELECT e FROM Examen e WHERE e.nombre like %?1%")
    public List<Examen> findByNombre(String term);

    @Query("SELECT e.id FROM Pregunta p JOIN p.examen e WHERE p.id in ?1 GROUP BY e.id")
    public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds);
}
