package com.formacionbdi.microservicios.app.respuestas.models.entity;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;
import com.formacionbdi.microservicios.commons.examenes.models.entity.Pregunta;
import lombok.Data;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
//@Entity
//@Table(name = "respuestas")
@Data
@Document(collection = "respuestas")
public class Respuesta {
    /**
     * Se comenta lo relacionados a JPA y se adecua a MONGO_DB
     */
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String texto;
//
//    //    Al existir esta entidad en otra BD se tiene que elimnar de la relacion en MySql
////    @ManyToOne(fetch = FetchType.LAZY)
////    @Transient
//    private Alumno alumno;
//
////    @Column(name = "alumno_id")
//    private Long alumnoId;
//
////    @OneToOne(fetch = FetchType.LAZY)
//    private Pregunta pregunta;

    @Id
    private String id;
    private String texto;
    //    @Transient
    private Alumno alumno;
    private Long alumnoId;
    //    @Transient
    private Pregunta pregunta;
    private Long preguntaId;


}
