package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profesor extends JFrame{

    private JPanel panelPro;
    private JTextField proName;
    private JButton saveBtn;
    private JTextField proLastN;
    private JTextField proIden;
    private JTextField proAsig;

    public JPanel getPanelPro() {
        return panelPro;
    }

    public void setPanelPro(JPanel panelPro) {
        this.panelPro = panelPro;
    }

    public Profesor() {
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String name = proName.getText();
                String lastName = proLastN.getText();
                String ide = proIden.getText();
                String asig = proAsig.getText();

                if (!name.isEmpty() && !lastName.isEmpty() && !ide.isEmpty() && !asig.isEmpty()){
                    Controlador controlador = new Controlador();
                    controlador.CrearProfesor(name,lastName,ide,asig);
                }else {
                    JOptionPane optionPane = new JOptionPane("Los campos no pueden estar vacios");
                    optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Titulo");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

            }
        });

    }

}
