package com.formacionbdi.microservicios.app.usuarios.services;

import com.formacionbdi.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}
