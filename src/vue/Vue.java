package vue;

import java.awt.*;

import javax.swing.*;

import controleur.EditeurImage;
import modele.ImageModele;
import modele.Perspective;
import observateur.Observateur;

/**
 * Classe qui agit comme l'invocateur (invoker)
 */

public abstract class Vue extends JPanel implements Observateur {

    private EditeurImage editeurImage = EditeurImage.getInstance();
    private ImageModele imageModele;
    private Perspective perspective;
    private String nom;


    public Vue(ImageModele imageModele, Perspective perspective, String nom){
        this.imageModele = imageModele;
        this.perspective = perspective;
        this.nom = nom;
        imageModele.ajouterObservateur(this);
        perspective.ajouterObservateur(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Paint Component called");

        super.paintComponent(g);
        if ( getImageModele()!= null) {
            Point translation = getPerspective().getPosition();
            if (getImageModele().getImage() != null) {
                ImageIcon image = getImageModele().getImage();
                g.drawImage(image.getImage(), translation.x, translation.y, this);
            }
        }    }

    public String getNom() {
        return nom;
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public Perspective getPerspective() {
        return perspective;
    }

}
