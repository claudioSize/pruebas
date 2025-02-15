package Persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorPersistencias {

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;


    public void crearSalon(String asig){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("BD");
            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Salon salon = new Salon();
            salon.setAsignatura(asig);

            entityManager.persist(salon);

            entityTransaction.commit();

        }catch(Exception e){
            e.printStackTrace();
            if (entityTransaction != null){
                entityTransaction.rollback();
            }
        }finally{
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }
    public void crearPorfesores(String name, String lastName, String ide, String asig){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("BD");
            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Profesores profesores = new Profesores();

            profesores.setNombre(name);
            profesores.setApellido(lastName);
            profesores.setIdentificacion(ide);

            try{
                String jpql = "SELECT p FROM Salon p WHERE p.asignatura = :asignatura";

                Salon salon = entityManager.createQuery(jpql, Salon.class)
                        .setParameter("asignatura", asig).getSingleResult();

                salon.setProfesor(profesores);
                profesores.setSalon(salon);
                entityManager.persist(profesores);

                entityTransaction.commit();

                JOptionPane optionPane = new JOptionPane("Profesor creado");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Titulo");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }catch (Exception ex){

                JOptionPane optionPane = new JOptionPane("No existe la asignatura");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Titulo");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }



        }catch(Exception e){
            e.printStackTrace();
            if (entityTransaction != null){
                entityTransaction.rollback();
            }
        }finally{
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }
    public void crearAlumno(String name, String lastName, String ide, String asignatura, String anoEscolar, int edad){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("BD");
            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            //objeto alumno
            Alumnos alumnos = new Alumnos();
            alumnos.setNombre(name);
            alumnos.setApellido(lastName);
            alumnos.setIdentificacion(ide);
            alumnos.setAsignaturas(asignatura);
            alumnos.setAnoEscolar(anoEscolar);
            alumnos.setEdad(edad);

            //Busca salon ingresado en el texfield como asignatura y lo relaciona tanto como con el profesor como el salon de clases
            try {
                String jpql = "SELECT p FROM Salon p WHERE p.asignatura = :asignatura";

                Salon salon = entityManager.createQuery(jpql, Salon.class)
                        .setParameter("asignatura", asignatura).getSingleResult();

                if (salon.getProfesor() != null){
                    alumnos.setProfesores(salon.getProfesor());

                    entityManager.persist(alumnos);
                    JOptionPane optionPane = new JOptionPane("Alumno creado");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }else{
                    JOptionPane optionPane = new JOptionPane("No existe profesor en la asignatura");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

            }catch (Exception ex){
                JOptionPane optionPane = new JOptionPane("No existe la asignatura");
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("Titulo");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }

            entityTransaction.commit();

        }catch(Exception e){
            e.printStackTrace();
            if (entityTransaction != null){
                entityTransaction.rollback();
            }
        }finally{
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }
    }

    public ArrayList<Object> tablesFind(String query){
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("BD");
            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            String jpqlS = "SELECT s FROM Salon s";
            String jpqlP = "SELECT p FROM Profesores p";
            String jpqlA = "SELECT a FROM Alumnos a";



            if (query.equals("Profesor")){
                //Busco en la base de datos todos los profesores y los recorro para ir insertandolos en un array para asi utilizarlos en form de tablas
                ArrayList<Object> lista = new ArrayList<>();
                List<Profesores> profesores = entityManager.createQuery(jpqlP, Profesores.class).getResultList();
                for (Profesores profesor : profesores) {
                    Object[] datosProfesor = {profesor.getId(),profesor.getNombre(), profesor.getApellido(), profesor.getIdentificacion(), profesor.getSalon().getAsignatura()};
                    lista.add(datosProfesor);
                }
                return lista;

            } else if (query.equals("Alumno")) {
                ArrayList<Object> lista = new ArrayList<>();
                List<Alumnos> alumnos = entityManager.createQuery(jpqlA, Alumnos.class).getResultList();

                for (Alumnos alumnos1 : alumnos) {
                    Object[] datosAlumno = {alumnos1.getId(), alumnos1.getNombre(), alumnos1.getApellido(), alumnos1.getIdentificacion() , alumnos1.getAsignaturas() ,alumnos1.getAnoEscolar(), alumnos1.getProfesores().getNombre(), alumnos1.getEdad()};
                    lista.add(datosAlumno);
                }
                return lista;

            }else if (query.equals("Salon")) {
                List<Salon> salon = entityManager.createQuery(jpqlS, Salon.class).getResultList();
                ArrayList<Object> lista = new ArrayList<>();
                for (Salon salon1 : salon) {
                    Object[] datoSalon = {salon1.getId(),salon1.getAsignatura()};

                    lista.add(datoSalon);
                }
                return lista;
            }

            entityTransaction.commit();

        }catch(Exception e){
            e.printStackTrace();
            if (entityTransaction != null){
                entityTransaction.rollback();
            }
        }finally{
            if (entityManagerFactory != null){
                entityManagerFactory.close();
            }
        }

        return null;
    }

    public ArrayList<Object> eliminarActualizar(Long id, String claseElec, String query, String text1, String text2, String text3, String text4, String elecedit) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("BD");
            entityManager = entityManagerFactory.createEntityManager();

            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();



            //Busco en la base de datos por el id dado desde el texfiel de buscar y doy 2 posibilidades eliminar o actualizar datos
            if (claseElec.equals("Profesores")) {
                String jpqlP = "SELECT p FROM Profesores p WHERE p.id = :id";
                Profesores profesores = entityManager.createQuery(jpqlP, Profesores.class).setParameter("id", id).getSingleResult();

                if (profesores != null) {
                    if (query.equals("Eliminar")){
                        try {
                            //Busco el salon asignado al profesor y elimino la relacion y luego elimino el profesor sin problemas
                            profesores.getSalon().setProfesor(null);
                            profesores.setSalon(null);
                            entityManager.remove(profesores);
                        }catch (Exception e){
                            //Si no se encuentran relaciones lo elimina directamente
                            entityManager.remove(profesores);
                        }
                    }else if (query.equals("Actualizar")){
                        try {

                            profesores.setNombre(text1);
                            profesores.setApellido(text2);
                            profesores.setIdentificacion(text3);
                            entityManager.merge(profesores);

                        }catch (Exception e){
                            JOptionPane optionPane = new JOptionPane("Error al actualizar informacion");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }
                    }  else if(query.equals("Lista")){
                        //Solo sirve para mostrar la entidad encontrada con la id
                        ArrayList<Object> lista = new ArrayList<>();
                        Object[] datoProfesor = {profesores.getNombre(),profesores.getApellido(), profesores.getIdentificacion(), profesores.getSalon().getAsignatura()};
                        lista.add(datoProfesor);
                        return lista;
                    }

                } else {
                    JOptionPane optionPane = new JOptionPane("Ninguna entidad encontrada");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

            } else if (claseElec.equals("Salon")) {
                String jpqlS = "SELECT s FROM Salon s WHERE s.id = :id";

                Salon salon = entityManager.createQuery(jpqlS, Salon.class).setParameter("id", id).getSingleResult();

                if (salon != null) {

                        if (query.equals("Actualizar")){
                        try {
                            salon.setAsignatura(text1);
                            entityManager.merge(salon);
                        }catch (Exception e){
                            JOptionPane optionPane = new JOptionPane("Error al actualizar informacion");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }
                    } else if (query.equals("Lista")) {
                        ArrayList<Object> lista = new ArrayList<>();
                        Object[] datoSalon = {salon.getAsignatura()};
                        lista.add(datoSalon);

                        return lista;
                    }


                } else {
                    JOptionPane optionPane = new JOptionPane("Ninguna entidad encontrada");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }else if (claseElec.equals("Alumno")) {
                String jpqlA = "SELECT a FROM Alumnos a WHERE a.id = :id";
                Alumnos alumnos1 = entityManager.createQuery(jpqlA, Alumnos.class).setParameter("id", id).getSingleResult();
                if (alumnos1 != null) {


                    if (query.equals("Eliminar")){

                        try {
                            alumnos1.getProfesores().setAlumno(null);
                            alumnos1.setProfesores(null);
                            entityManager.remove(alumnos1);
                        }catch (Exception e){
                            entityManager.remove(alumnos1);
                        }
                    }else if (query.equals("Actualizar")){
                        try {
                            String jpqlS = "SELECT s FROM Salon s WHERE s.asignatura = :asignatura";
                            Salon salon1 = entityManager.createQuery(jpqlS, Salon.class).setParameter("asignatura", text3).getSingleResult();

                            if (salon1.getProfesor() != null) {
                                alumnos1.setNombre(text1);
                                alumnos1.setIdentificacion(text2);
                                alumnos1.setProfesores(salon1.getProfesor());
                                alumnos1.setAsignaturas(salon1.getAsignatura());
                                entityManager.merge(alumnos1);
                            }else {
                                JOptionPane optionPane = new JOptionPane("No existe profesor en la asignatura");
                                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                                JDialog dialog = optionPane.createDialog("Titulo");
                                dialog.setAlwaysOnTop(true);
                                dialog.setVisible(true);
                            }
                        }catch (Exception e){
                            JOptionPane optionPane = new JOptionPane("Error al actualizar informacion");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }
                    } else if (query.equals("Lista")) {
                        ArrayList<Object> lista = new ArrayList<>();
                        Object[] datoAlumno = {alumnos1.getNombre(),alumnos1.getApellido(),alumnos1.getIdentificacion()};
                        lista.add(datoAlumno);

                        return lista;
                    }

                } else {
                    JOptionPane optionPane = new JOptionPane("Ninguna entidad encontrada");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }
            }



            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }


        return null;
    }
}
