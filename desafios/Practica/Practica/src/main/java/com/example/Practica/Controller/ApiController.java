package com.example.Practica.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/") // Cambié la ruta aquí para ser más específica
public class ApiController {

    List<Anime> lista = new LinkedList<>();

    Succes succes = new Succes("Eliminacion exitosa");

    public ApiController() {
        this.lista.add(new Anime("One piece", "11", "1"));
        this.lista.add(new Anime("Naruto", "1", "1"));
        this.lista.add(new Anime("Bleach", "3", "2"));
        this.lista.add(new Anime("Dragon Ball", "11", "1"));
    }

    @GetMapping("/")
    public List<Anime> index() {
        return this.lista;
    }

    @PostMapping("/")
    //Convierte el json que se envia desde el post y lo convierte a un objeto de la clase anime
     Anime create(@RequestBody Anime anime) {
        //Lo agrego a la lista
        this.lista.add(anime);
        return anime;
    }

    @PutMapping("/{animeName}")
    Anime update(@PathVariable String animeName, @RequestBody Anime updatedAnime) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAnime().equals(animeName)) {
                // Reemplaza el anime por el actualizado
                lista.set(i, updatedAnime);
                return updatedAnime;
            }
        }
        return null;  // Si no se encuentra el anime
    }

    @DeleteMapping("/{animeName}")
    //Con la variable enviada en forma de json busco coinciencia en la lista
    Succes delete(@PathVariable String animeName) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAnime().equals(animeName)) {
                // si encuentra elimina el indice de la lista
                lista.remove(lista.get(i));
                //Retorno un objeto improvisado que da un aviso de exito en la eliminacion
                return this.succes;
            }
        }
        return null;  // Si no se encuentra el anime
    }
    @PatchMapping("/{animeName}")
    Anime updatePatch(@PathVariable String animeName, @RequestBody Anime updatedAnime) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getAnime().equals(animeName)) {
                // Reemplaza el anime por el actualizado
                lista.set(i, updatedAnime);
                return updatedAnime;
            }
        }
        return null;  // Si no se encuentra el anime
    }
}


