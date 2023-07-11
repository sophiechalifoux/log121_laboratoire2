package vue;

import controleur.DecrementController;
import controleur.IncrementController;
import modele.Nombre;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel {

    private final JPanel panneauGauche;
    private final PanneauCentre panneauCentre;
    private final JPanel panneauDroite;

    public Panneau(Nombre modele, IncrementController incrementController, DecrementController decrementController) {
        this.panneauGauche = new JPanel();
        this.panneauCentre = new PanneauCentre(modele, incrementController, decrementController);
        this.panneauDroite = new JPanel();
        initialiser();
    }

    private void initialiser() {

        // Ajouter les panneaux au panneau principal
        this.add(panneauGauche);
        this.add(panneauCentre);
        this.add(panneauDroite);

        panneauGauche.setBackground(Color.BLUE);
        panneauCentre.setBackground(Color.RED);
        panneauDroite.setBackground(Color.YELLOW);

        this.setLayout(new GridLayout(1,3));
    }
}
