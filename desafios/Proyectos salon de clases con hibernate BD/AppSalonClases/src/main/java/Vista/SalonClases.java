package Vista;

import Controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalonClases extends JFrame{
    private JTextField salonAsig;
    private JButton saveBtn;
    private JPanel panelSalon;
    private JButton volverButton;

    public JPanel getPanelSalon() {
        return panelSalon;
    }

    public void setPanelSalon(JPanel panelSalon) {
        this.panelSalon = panelSalon;
    }

    public SalonClases() {

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String asigs = salonAsig.getText();

                Controlador controlador = new Controlador();
                controlador.CrearSalon(asigs);
            }
        });

    }

}

