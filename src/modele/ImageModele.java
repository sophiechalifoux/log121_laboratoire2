package modele;

import controleur.*;
import utils.*;
import javax.swing.ImageIcon;

public class ImageModele extends Observable{

    private static ImageModele instanceModele;
    private ImageModele Memento;
    private ImageIcon imageGauche;
    private ImageIcon imageCentre;
    private ImageIcon imageDroite;

    public ImageIcon getImageGauche() {
        return imageGauche;
    }

    public void setImageGauche(ImageIcon imageGauche) {
        this.imageGauche = imageGauche;
        notifier();
    }

    public ImageIcon getImageCentre() {
        return imageCentre;
    }

    public void setImageCentre(ImageIcon imageCentre) {
        this.imageCentre = imageCentre;        
        notifier();

    }

    public ImageIcon getImageDroite() {
        return imageDroite;
    }

    public void setImageDroite(ImageIcon imageDroite) {
        this.imageDroite = imageDroite;
        notifier();

    }

    public static ImageModele getInstanceModele() {
        if (instanceModele == null){
            instanceModele = new ImageModele();
        }
        return instanceModele;
    }

    public ImageMemento creerMemento(){return new ImageMemento(instanceModele);}

    public void restaurerMemento(ImageMemento m){instanceModele = m.getImageSauvegarder();}
    
}
