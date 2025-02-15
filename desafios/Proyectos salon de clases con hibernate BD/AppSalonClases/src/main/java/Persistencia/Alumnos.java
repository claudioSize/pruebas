package Persistencia;

import jakarta.persistence.*;

@Entity
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String asignaturas;
    private String anoEscolar;
    private int edad;
    @OneToOne
    @JoinColumn(name = "id_profesores", nullable = true)
    private Profesores profesores;


    public Alumnos() {
    }

    public Alumnos(String nombre, Long id, String apellido, String identificacion, String asignaturas, String anoEscolar, int edad, Profesores profesores) {
        this.nombre = nombre;
        this.id = id;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.asignaturas = asignaturas;
        this.anoEscolar = anoEscolar;
        this.edad = edad;
        this.profesores = profesores;
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

    public String getAsignaturas() {
        return asignaturas;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

    public void setAsignaturas(String asignaturas) {
        this.asignaturas = asignaturas;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}