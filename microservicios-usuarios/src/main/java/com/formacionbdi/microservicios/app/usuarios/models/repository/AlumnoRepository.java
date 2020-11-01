package com.formacionbdi.microservicios.app.usuarios.models.repository;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
