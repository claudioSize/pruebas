package com.example.salonclases.Persistencia;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Salon implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asignatura;

    @OneToOne(mappedBy = "salon")
    private Profesor profesor;

    public Salon() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
