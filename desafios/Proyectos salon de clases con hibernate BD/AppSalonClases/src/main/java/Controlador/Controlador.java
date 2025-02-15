package Controlador;


import Persistencia.ControladorPersistencias;

import java.util.ArrayList;

public class Controlador {
     ControladorPersistencias controladorPersistencias = new ControladorPersistencias();

     public void CrearProfesor(String name, String lastName, String ide, String asig){

          controladorPersistencias.crearPorfesores(name,lastName,ide, asig);

     }

     public void CrearSalon(String asig){

          controladorPersistencias.crearSalon(asig);

     }

     public void CrearAlumno(String name, String lastName, String ide, String asignatura, String anoEscolar, int edad){

          controladorPersistencias.crearAlumno(name, lastName, ide, asignatura, anoEscolar, edad);
     }

     public ArrayList<Object> TablesFindQ(String query){
          return controladorPersistencias.tablesFind(query);
     }

     public ArrayList<Object> ActualizarEliminar(Long id, String claseElec, String query, String text1, String text2, String text3, String text4, String elecedit){

          return controladorPersistencias.eliminarActualizar(id, claseElec,query,text1, text2, text3, text4,elecedit);
     }

}
