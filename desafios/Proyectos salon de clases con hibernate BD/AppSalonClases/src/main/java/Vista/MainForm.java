package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton crearSalonButton;
    private JButton buscarSalonesButton;
    private JButton crearProfesorButton;
    private JButton buscarProfesoresButton;
    private JButton crearAlumnoButton;
    private JButton buscarAlumnosButton;
    private JPanel panelMain;

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public MainForm() {
        crearSalonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SalonClases pantalla = new SalonClases();
                pantalla.setContentPane(new SalonClases().getPanelSalon());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
        crearProfesorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profesor pantalla = new Profesor();

                pantalla.setContentPane(new Profesor().getPanelPro());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
        crearAlumnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno pantalla = new Alumno();

                pantalla.setContentPane(new Alumno().getPanelAlum());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);

            }
        });
        buscarProfesoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfLista pantalla = new ProfLista();

                pantalla.setContentPane(new ProfLista().getPanelListaPro());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
        buscarSalonesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaList pantalla = new SaList();

                pantalla.setContentPane(new SaList().getPanelSList());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
        buscarAlumnosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumList pantalla = new AlumList();

                pantalla.setContentPane(new AlumList().getAlumList());
                pantalla.setVisible(true);
                pantalla.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - pantalla.getWidth()) / 2;
                int y = (screenSize.height - pantalla.getHeight()) / 2;
                pantalla.setLocation(x, y);
            }
        });
    }
    public static void main(String[] args) {

        MainForm mainForm = new MainForm();
        mainForm.setContentPane(new MainForm().panelMain);
        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainForm.setVisible(true);
        mainForm.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - mainForm.getWidth()) / 2;
        int y = (screenSize.height - mainForm.getHeight()) / 2;
        mainForm.setLocation(x, y);

    }


}
