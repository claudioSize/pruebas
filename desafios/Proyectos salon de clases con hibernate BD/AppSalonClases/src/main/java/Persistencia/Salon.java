package Persistencia;

import jakarta.persistence.*;

@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String asignatura;
    @OneToOne
    @JoinColumn(name = "id_profesores", nullable = true)
    private Profesores profesor;

    public Salon() {
    }

    public Salon(Long id, String asignatura, Profesores profesor) {
        this.id = id;
        this.asignatura = asignatura;
        this.profesor = profesor;
    }

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

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }
}


