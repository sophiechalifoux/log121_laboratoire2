package modele;

import observateur.*;
import javax.swing.ImageIcon;
import java.io.Serializable;

/**
 * Classe representant l'image téléchargée
 */
public class ImageModele extends Observable implements Serializable {
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
