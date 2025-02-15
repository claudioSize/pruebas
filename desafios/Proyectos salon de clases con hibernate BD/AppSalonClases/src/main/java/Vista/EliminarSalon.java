package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminarSalon extends JFrame{
    private JPanel eliminarPnSa;
    private JButton eliminarButton;
    private JTextField inputEliminar;
    private JCheckBox confirmarActualizacion;
    private JTable table1;
    private JButton actualizarButton;
    private JButton buscarButton;
    private JCheckBox checkEliminar;
    private JTextField textAct;

    public JPanel getEliminarPnSa() {
        return eliminarPnSa;
    }

    public void setEliminarPnSa(JPanel eliminarPnSa) {
        this.eliminarPnSa = eliminarPnSa;
    }

    public EliminarSalon() {




        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                model.addColumn("Asignatura");

                Controlador controlador = new Controlador();
                ArrayList<Object> salonData = controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Salon","Lista", "","","","","");

                for (Object salon : salonData) {
                    model.addRow((Object[]) salon);

                }
            }
        });

        confirmarActualizacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!textAct.getText().equals("")){
                            Controlador controlador = new Controlador();
                            controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Salon","Actualizar",textAct.getText(),"","","","");

                            JOptionPane optionPane = new JOptionPane("Actualizacion de datos exitoso");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }else{
                            JOptionPane optionPane = new JOptionPane("No se aceptan campos vacios");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);

                        }

                    }
                });
            }
        });
    }
}
