package vue;

import controleur.EditeurImage;
import modele.ImageModele;
import modele.Perspective;
import observateur.Observateur;

import javax.swing.*;
import java.awt.*;

public class VueModifiable extends Vue implements Observateur {

    transient EditeurImage editeurImage = EditeurImage.getInstance();


    public VueModifiable(ImageModele imageModele, Perspective perspective, String nom) {
        super(imageModele,perspective, nom);
    }

    @Override
    public void paintComponent(Graphics g)  {
        System.out.println("Paint Component called");
        super.paintComponent(g);
        if ( getImageModele()!= null) {
            Point translation = getPerspective().getPosition();
            if (getImageModele().getImage() != null) {
                ImageIcon image = getImageModele().getImage();
                g.drawImage(image.getImage(), translation.x, translation.y, this);
            }
        }
    }

    @Override
    public void update() {
        repaint();
        System.out.println("Update method called in VueModifiable");
    }
}
