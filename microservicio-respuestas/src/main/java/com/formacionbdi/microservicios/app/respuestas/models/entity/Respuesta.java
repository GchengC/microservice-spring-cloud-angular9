package com.formacionbdi.microservicios.app.respuestas.models.entity;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import lombok.Data;

import javax.persistence.*;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Entity
@Table(name = "respuestas")
@Data
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    //    Al existir esta entidad en otra BD se tiene que elimnar de la relacion en MySql
//    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
    private Alumno alumno;

    @Column(name = "alumno_id")
    private Long alumnoId;

    @OneToOne(fetch = FetchType.LAZY)
    private Pregunta pregunta;
}
