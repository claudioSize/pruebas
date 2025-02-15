package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AlumList extends JFrame {
    private JPanel alumList;
    private JTable table1;
    private JButton eliminarButton;

    public JPanel getAlumList() {
        return alumList;
    }

    public void setAlumList(JPanel alumList) {
        this.alumList = alumList;
    }

    public AlumList() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Identificacion");
        model.addColumn("Asignatura");
        model.addColumn("Año escolar");
        model.addColumn("Profesor");
        model.addColumn("Edad");



        Controlador controlador = new Controlador();
        ArrayList<Object> alumnoData = controlador.TablesFindQ("Alumno");

        for (Object alumnos : alumnoData) {
            model.addRow((Object[]) alumnos);
        }

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarAlum pantalla = new EliminarAlum();

                pantalla.setContentPane(new EliminarAlum().getEliminarPnel());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
    }






}
