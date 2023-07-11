package vue;

import controleur.DecrementController;
import controleur.IncrementController;
import modele.Nombre;
import utils.Observable;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private final Panneau panneau;
    private final Menu menu;

    public Fenetre(
        Nombre modele,
        IncrementController incrementController,
        DecrementController decrementController
    ) {
        this.panneau = new Panneau(modele, incrementController, decrementController);
        this.menu = new Menu();
        initialiser();
    }

    private void initialiser() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(panneau);
        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
