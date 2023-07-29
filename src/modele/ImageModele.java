package modele;

import observateur.*;
import javax.swing.ImageIcon;

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

}
