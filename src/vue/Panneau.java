package vue;
import javax.swing.*;

import modele.ImageModele;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panneau extends JPanel {

    private final Perspective panneauGauche;
    private final Perspective panneauCentre;
    private final Perspective panneauDroite;

    public Panneau() {
        this.panneauGauche = new Perspective("Gauche");
        this.panneauCentre = new Perspective("Centre");
        this.panneauDroite = new Perspective("Droite");
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

        ImageModele.getInstanceModele().ajouterObservateur(panneauCentre);
        ImageModele.getInstanceModele().ajouterObservateur(panneauDroite);        
        ImageModele.getInstanceModele().ajouterObservateur(panneauGauche);



        this.setLayout(new GridLayout(1,3));
    }

}
