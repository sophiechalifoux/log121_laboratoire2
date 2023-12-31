package vue;

import javax.swing.*;


/**
 * Fenetre de l'application
 */

public class Fenetre extends JFrame {

    private  Panneau panneau;
    private  Menu menu;

    public Fenetre() {
        this.panneau = new Panneau();
        this.menu = new Menu(panneau);
        initialiser();
    }

    private void initialiser() {
        this.setTitle("Éditeur d'image");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.add(panneau);
        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
