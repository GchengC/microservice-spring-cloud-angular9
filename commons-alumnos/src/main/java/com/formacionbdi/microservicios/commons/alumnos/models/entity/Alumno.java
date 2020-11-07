package com.formacionbdi.microservicios.commons.alumnos.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Lob
    @JsonIgnore
    private byte[] foto;

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

    public Integer getFotoHasCode() {
        return this.foto != null ? this.foto.hashCode() : null;
    }

}
