package modele;

import observateur.Observable;

import java.awt.*;

public class Perspective extends Observable implements java.io.Serializable{

    private ImageModele imageModele;
    private double facteurEchelle;
    private Point position;

    public Perspective(ImageModele imageModele) {
        this.imageModele = imageModele;
        this.facteurEchelle = 1.0;
        this.position = new Point(0,0);
        notifier();
    }

    public double getFacteurEchelle() {
        return facteurEchelle;
    }

    public void setFacteurEchelle(double facteurEchelle) {
        this.facteurEchelle = facteurEchelle;
        notifier();

    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
        notifier();
    }

    public void translater(Point translation){
        position.x += translation.x;
        position.y += translation.y;
        notifier();


    }
    public void zoomer(){}

    //    public ImageMemento creerMemento(){return new ImageMemento(instanceModele);}
//    public void restaurerMemento(ImageMemento m){instanceModele = m.getImageSauvegarder();}




}
