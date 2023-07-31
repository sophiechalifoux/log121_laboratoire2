package modele;

import observateur.*;
import javax.swing.ImageIcon;

/**
 * Classe representant l'image téléchargée
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

    public ImageModele clone() {
        ImageModele imageModeleClone = new ImageModele();
        imageModeleClone.setImage(this.image);
        return imageModeleClone;
    }
}
