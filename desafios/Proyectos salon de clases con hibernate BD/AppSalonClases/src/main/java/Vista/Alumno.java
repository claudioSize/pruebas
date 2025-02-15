package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alumno extends JFrame {
    private JTextField alumName;
    private JTextField alumLastN;
    private JTextField alumIden;
    private JTextField alumAsig;
    private JButton saveBtn;
    private JPanel panelAlum;
    private JTextField anoEsolar;
    private JTextField edad;

    public JPanel getPanelAlum() {
        return panelAlum;
    }

    public void setPanelAlum(JPanel panelAlum) {
        this.panelAlum = panelAlum;
    }

    public Alumno() {
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Reviso que los textfiel no esten vacios y el textfiel de años sea solo entero
                if (!alumName.getText().equals("") && !alumLastN.getText().equals("") && !alumIden.getText().equals("") && !alumAsig.getText().equals("") && !anoEsolar.getText().equals("") && !edad.getText().equals("")){
                    try{
                        int valor = Integer.parseInt(edad.getText());
                        Controlador controlador = new Controlador();
                        controlador.CrearAlumno(alumName.getText(), alumLastN.getText(), alumIden.getText(), alumAsig.getText(), anoEsolar.getText(), valor);
                    }catch (Exception ex){
                        JOptionPane optionPane = new JOptionPane("La edad deben ser numeros enteros solamente");
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = optionPane.createDialog("Titulo");
                        dialog.setAlwaysOnTop(true);
                        dialog.setVisible(true);
                    }
                }else {
                    JOptionPane optionPane = new JOptionPane("Todos los campos deben estar llenos");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

            }
        });
    }


    //String name, String lastName, String ide, String asignatura, String anoEscolar, int edad
}
