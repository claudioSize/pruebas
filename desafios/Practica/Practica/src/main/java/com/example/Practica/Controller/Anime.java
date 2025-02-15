package com.example.Practica.Controller;

public class Anime {
    private String anime;
    private String capitulo;
    private String temporada;

    public Anime(String anime, String capitulo, String temporada) {
        this.anime = anime;
        this.capitulo = capitulo;
        this.temporada = temporada;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
}
