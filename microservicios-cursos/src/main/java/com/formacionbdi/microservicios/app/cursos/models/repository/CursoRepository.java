package com.formacionbdi.microservicios.app.cursos.models.repository;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/

public interface CursoRepository extends CrudRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c JOIN FETCH c.alumnos a WHERE a.id = ?1")
    public Curso findCursoByAlumnoId(Long id);
}
