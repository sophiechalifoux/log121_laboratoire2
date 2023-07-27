package vue;

import java.awt.*;

import javax.swing.*;

import controleur.EditeurImage;
import modele.ImageModele;
import utils.Observateur;

/**
 * Classe qui agit comme l'invocateur (invoker)
 */

public abstract class Perspective extends JPanel implements Observateur {

    private EditeurImage editeurImage = EditeurImage.getInstance();
    private ImageModele imageModele;


    public Perspective(ImageModele imageModele){
        this.imageModele = imageModele;
        imageModele.ajouterObservateur(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageModele != null) {
            if (imageModele.getImage() != null) {
                ImageIcon image = imageModele.getImage();
//                ImageIcon scaledImage = imageModele.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
                g.drawImage(image.getImage(), (this.getWidth() - image.getIconWidth()) / 2, (this.getHeight() - image.getIconHeight()) / 2, this);
                revalidate();
            }
        }
    }

    public void update(){
        repaint();

    }

}
