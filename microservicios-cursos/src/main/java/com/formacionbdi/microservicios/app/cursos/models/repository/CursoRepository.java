package com.formacionbdi.microservicios.app.cursos.models.repository;

import com.formacionbdi.microservicios.app.cursos.models.entity.Curso;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/

//public interface CursoRepository extends CrudRepository<Curso, Long> {
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {
    //Cambia cuando son 2 BD y Alumnos se volvio Transient
//    @Query("SELECT c FROM Curso c JOIN FETCH c.alumnos a WHERE a.id = ?1")
    @Query("SELECT c FROM Curso c JOIN FETCH c.cursoAlumnos a WHERE a.alumnoId = ?1")
    public Curso findCursoByAlumnoId(Long id);

    @Modifying
    @Query("DELETE FROM CursoAlumno ca WHERE ca.alumnoId = ?1")
    public void eliminarCursoAlumnoPorId(Long id);
}
