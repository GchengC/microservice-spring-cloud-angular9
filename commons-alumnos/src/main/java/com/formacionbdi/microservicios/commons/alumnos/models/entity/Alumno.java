package com.formacionbdi.microservicios.commons.alumnos.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prepersist() {
        this.createAt = new Date();
    }

    /**
     * Adecuacion para buscar POR ID en el objeto Alumno, cuando sean iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return this.id != null && this.id.equals(alumno.getId());
    }

}
