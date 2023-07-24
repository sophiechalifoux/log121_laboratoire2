package modele;

import controleur.*;
import utils.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class ImageModele extends Observable{

    private static ImageModele instanceModele;
    private double echelle;
    private Point position;
    private ImageIcon imageGauche;
    private ImageIcon imageCentre;
    private ImageIcon imageDroite;

    public ImageIcon getImageGauche() {
        return imageGauche;
    }
        
    public void setImageGauche(ImageIcon imageGauche) {
        echelle = 100.0;
        position = new Point(0,0);
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

    public double getEchelle() {
        return echelle;
    }

    public void setEchelle(double echelle) {
        this.echelle = echelle;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public ImageMemento creerMemento(){return new ImageMemento(instanceModele);}

    public void restaurerMemento(ImageMemento m){instanceModele = m.getImageSauvegarder();}
    
}
