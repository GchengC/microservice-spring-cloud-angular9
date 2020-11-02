package com.formacionbdi.microservicios.app.examenes.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GchengC.
 * @version v-a.0.0.0.0
 * @IDE IntelliJ IDEA
 * @since nov. 2020.
 **/
@Entity
@Table(name = "examenes")
@Data
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @JsonIgnoreProperties(value = {"examen"}, allowSetters = true)
    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pregunta> preguntas;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Examen() {
        this.preguntas = new ArrayList<>();
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas.clear();
        preguntas.forEach(this::addPregunta);
    }

    public void addPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
        pregunta.setExamen(this);
    }

    public void removePregunta(Pregunta pregunta) {
        this.preguntas.remove(pregunta);
        pregunta.setExamen(null);
    }

    /**
     * Adecuacion para buscar POR ID de pregunta en el objeto Examen, cuando sean iguales
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Pregunta)) return false;
        Pregunta pregunta = (Pregunta) o;
        return this.id != null && this.id.equals(pregunta.getId());
    }
}
