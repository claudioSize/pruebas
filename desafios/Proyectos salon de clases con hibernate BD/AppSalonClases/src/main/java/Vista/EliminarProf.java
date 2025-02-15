package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminarProf extends JFrame{
    private JButton eliminarButton;
    private JPanel panelEliminarPro;
    private JTextField inputEliminar;
    private JTable table1;
    private JButton actualizarButton;
    private JCheckBox confirmarActualizarCheckBox;
    private JButton buscarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JCheckBox checkElim;
    private JTextField textField4;
    private JPanel eliminarPN;

    public JPanel getPanelEliminarPro() {
        return panelEliminarPro;
    }

    public void setPanelEliminarPro(JPanel panelEliminarPro) {
        this.panelEliminarPro = panelEliminarPro;
    }

    public EliminarProf() {

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();

                model.addColumn("Nombre");
                model.addColumn("Apellido");
                model.addColumn("Identificacion");
                model.addColumn("Asignatura");


                Controlador controlador = new Controlador();
                ArrayList<Object> profesoresData = controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Profesores","Lista","","","","","");

                for (Object profesor : profesoresData) {
                    model.addRow((Object[]) profesor);

                }
            }
        });
        confirmarActualizarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("")){
                            Controlador controlador = new Controlador();
                            controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Profesores","Actualizar",textField1.getText(),textField2.getText(),textField3.getText(),"","");

                            JOptionPane optionPane = new JOptionPane("Actualizacion de datos exitoso");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }else {
                            JOptionPane optionPane = new JOptionPane("Campos vacios no aceptados");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                        }

                    }
                });
            }
        });

        checkElim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Controlador controlador = new Controlador();
                        controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Profesores","Eliminar","","","","","");

                        JOptionPane optionPane = new JOptionPane("Eliminado");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Titulo");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                });
            }
        });
    }



}
