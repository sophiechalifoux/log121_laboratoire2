package vue;

import java.awt.*;

import javax.swing.*;

import modele.ImageModele;
import modele.Perspective;
import observateur.Observateur;

/**
 * Classe abstraite qui représente la vue des modèles :
 * - ImageModèle
 * - Perspective
 */

public abstract class Vue extends JPanel implements Observateur {

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
        super.paintComponent(g);
        if ( getImageModele()!= null) {
            Point translation = getPerspective().getPosition();
            double zoom = getPerspective().getEchelleImage();
            if (getImageModele().getImage() != null) {
                ImageIcon image = getImageModele().getImage();
                g.drawImage(image.getImage(),translation.x, translation.y, (int)(zoom * image.getIconWidth()), (int)(zoom * image.getIconHeight()), this);
            }
        }
    }

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
