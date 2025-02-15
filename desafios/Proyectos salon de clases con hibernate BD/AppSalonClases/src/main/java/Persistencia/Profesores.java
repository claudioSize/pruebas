package Persistencia;

import jakarta.persistence.*;

@Entity
public class Profesores {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;

    @OneToOne
    @JoinColumn(name = "id_alumnos", nullable = true)
    private Alumnos alumno;

    @OneToOne
    @JoinColumn(name = "id_salon", nullable = true)
    private Salon salon;

    public Profesores() {
    }

    public Profesores(Long id, String nombre, String apellido, String identificacion, Alumnos alumno, Salon salon) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.alumno = alumno;
        this.salon = salon;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

}