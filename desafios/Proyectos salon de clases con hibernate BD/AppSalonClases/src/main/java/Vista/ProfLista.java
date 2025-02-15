package Vista;

import Controlador.Controlador;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ProfLista extends JFrame {
    private JButton button1;
    private JTable table1;
    private JPanel panelListaPro;

    public JPanel getPanelListaPro() {
        return panelListaPro;
    }

    public void setPanelListaPro(JPanel panelListaPro) {
        this.panelListaPro = panelListaPro;
    }


    public ProfLista() {


        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Identificacion");
        model.addColumn("Asignatura");


        Controlador controlador = new Controlador();
        ArrayList<Object> profesoresData = controlador.TablesFindQ("Profesor");
        for (Object profesor : profesoresData) {
            model.addRow((Object[]) profesor);

        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EliminarProf pantalla = new EliminarProf();

                pantalla.setContentPane(new EliminarProf().getPanelEliminarPro());
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
