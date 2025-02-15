package Vista;

import Controlador.Controlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SaList extends JFrame {
    private JTable table1;
    private JButton eliminarButton;
    private JPanel panelSList;

    public JPanel getPanelSList() {
        return panelSList;
    }

    public void setPanelSList(JPanel panelSList) {
        this.panelSList = panelSList;
    }

    public SaList() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addColumn("Id");
        model.addColumn("Asignatura");

        Controlador controlador = new Controlador();
        ArrayList<Object> salonData = controlador.TablesFindQ("Salon");

        for (Object salon : salonData) {
            model.addRow((Object[]) salon);
        }


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarSalon pantalla = new EliminarSalon();

                pantalla.setContentPane(new EliminarSalon().getEliminarPnSa());
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
