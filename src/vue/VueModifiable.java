package vue;

import controleur.EditeurImage;
import modele.ImageModele;
import modele.Perspective;
import observateur.Observateur;

import javax.swing.*;
import java.awt.*;

/**
 * Vue concrète qui permet d'effectuer des changements à l'image :
 * - Translation
 * - Zoom
 * - Undo
 */

public class VueModifiable extends Vue implements Observateur {

    EditeurImage editeurImage = EditeurImage.getInstance();


    public VueModifiable(ImageModele imageModele, Perspective perspective, String nom) {
        super(imageModele,perspective, nom);
    }

    @Override
    public void paintComponent(Graphics g)  {
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

    @Override
    public void update() {
        repaint();
    }
}
