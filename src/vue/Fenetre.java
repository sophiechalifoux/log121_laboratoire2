package vue;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fenetre extends JFrame {

    private final Panneau panneau;
    private final Menu menu;

    public Fenetre() {
        this.panneau = new Panneau();
        this.menu = new Menu();
        initialiser();
    }

    private void initialiser() {
        this.setTitle("Éditeur d'image");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(panneau);
        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
