package modele;

import vue.Vue;

import java.awt.*;
import java.io.Serializable;

public class PerspectiveMemento implements Serializable {
    private transient Perspective perspective;
    private transient ImageModele imageModele;
    private transient Vue vue;
    private transient Point position;
    private transient double echelleImage;

    public PerspectiveMemento(ImageModele imageModele, Vue vue, Point position, double echelleImage) {
        this.imageModele = imageModele.clone();
        this.vue = vue;
        this.position = new Point(position);
        this.echelleImage = echelleImage;
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public Vue getVue() {
        return vue;
    }

    public Point getPosition() {
        return position;
    }

    public double getEchelleImage() {
        return echelleImage;
    }
}