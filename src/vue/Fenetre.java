package vue;


import controleur.EditeurImage;

import javax.swing.*;
import java.awt.*;

/**
 * Fenetre de l'application
 */

public class Fenetre extends JFrame {
    private  Panneau panneau;
    private  Menu menu;

    public Fenetre() {
        this.panneau = new Panneau();
        System.out.println("Panneau instancie");
        this.menu = new Menu(panneau);
        System.out.println("Menu instancie");

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

    public Panneau getPanneau() {
        return panneau;
    }

    public Menu getMenu() {
        return menu;
    }
}
