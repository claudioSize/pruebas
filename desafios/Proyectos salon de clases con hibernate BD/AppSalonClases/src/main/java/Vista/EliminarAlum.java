package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EliminarAlum extends JFrame{
    private JButton eliminarButton;
    private JPanel eliminarPnel;
    private JTable table1;
    private JButton buscarButton;
    private JTextField inputEliminar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton actualizarButton;
    private JCheckBox confirmarActualizarCheckBox;
    private JCheckBox checkElim;

    public JPanel getEliminarPnel() {
        return eliminarPnel;
    }

    public void setEliminarPnel(JPanel eliminarPnA) {
        this.eliminarPnel = eliminarPnA;
    }


    public EliminarAlum() {
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controlador controlador = new Controlador();
                controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Alumno","Eliminar","","","","","");
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
                            controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Alumno","Actualizar",textField1.getText(),textField2.getText(),textField3.getText(),"","");

                            JOptionPane optionPane = new JOptionPane("Actualizacion de datos exitoso");
                            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Titulo");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                            textField1.setText("");
                            textField2.setText("");
                            textField3.setText("");
                            inputEliminar.setText("");
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
                buscarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();



                        Controlador controlador = new Controlador();
                        ArrayList<Object> alumnoData = controlador.ActualizarEliminar(Long.valueOf(inputEliminar.getText()),"Alumno","Lista","","","","","");
                        //evito que se acomulen las columnas
                        if (alumnoData.size() != 0){
                            model.addColumn("Nombre");
                            model.addColumn("Apellido");
                            model.addColumn("Identificacion");
                            for (Object alumno : alumnoData) {
                                model.addRow((Object[]) alumno);

                            }
                        }
                    }
                });
            }
        });
    }
}
