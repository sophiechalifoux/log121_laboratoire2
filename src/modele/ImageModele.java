package modele;

import controleur.*;
import utils.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class ImageModele extends Observable{

    private static ImageModele instanceModele;
    private ImageIcon image;
    private double echelle;
    private Point position;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        echelle = 100.0;
        position = new Point(0,0);
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

    public ImageMemento creerMemento(){return null;}

    public void restaurerMemento(ImageMemento m){}
    
}
