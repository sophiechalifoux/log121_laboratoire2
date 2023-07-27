package modele;

import controleur.*;
import utils.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe representant le sujet
 */
public class ImageModele extends Observable {

    private ImageIcon image;

    public ImageModele() {
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        notifier();
    }

    public ImageIcon getImage() {
        return image;
    }

    // Methodes liees aux commandes
    public void translater(){}
    public void zoomer(){}


//    public ImageMemento creerMemento(){return new ImageMemento(instanceModele);}
//
//    public void restaurerMemento(ImageMemento m){instanceModele = m.getImageSauvegarder();}
    
}
