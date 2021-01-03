package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
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
//public interface AlumnoRepository extends CrudRepository<Alumno, Long> { //Hasta el video 46 lo usamos, se cambia por tema de paginacion
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

    @Query("SELECT a FROM Alumno a WHERE upper(a.nombre)LIKE upper(concat('%',?1,'%')) OR upper(a.apellido) LIKE upper(concat('%',?1,'%'))")
    public List<Alumno> findByNombreOrApellido(String term);
}
