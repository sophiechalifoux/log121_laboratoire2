package modele;

import controleur.*;
import utils.*;
import javax.swing.ImageIcon;

public class ImageModele extends Observable{

    private static ImageModele instanceModele;
    private ImageIcon image;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        notifier();
    }

    public static ImageModele getInstanceModele() {
        if (instanceModele == null){
            instanceModele = new ImageModele();
        }
        return instanceModele;
    }

    public ImageMemento creerMemento(){return null;}

    public void restaurerMemento(ImageMemento m){}
    
}
