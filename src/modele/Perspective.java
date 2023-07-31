package modele;

import commands.Commande;
import observateur.Observable;
import vue.Vue;

import java.awt.*;
import java.util.Stack;

/**
 * CLasse qui represente l'état de l'image
 */
public class Perspective extends Observable {

    private ImageModele imageModele;
    private boolean estActive;
    private Vue vue;
    private double echelleImage;
    private Point position;
    private Stack<PerspectiveMemento> historique;

    public Perspective(ImageModele imageModele, Vue vue) {
        this.imageModele = imageModele;
        this.vue = vue;
        this.echelleImage = 1.0;
        this.position = new Point(0,0);
        this.historique = new Stack<>();
        this.estActive = false;
        notifier();
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public Stack<PerspectiveMemento> getHistorique() {
        return historique;
    }
    public double getEchelleImage() {
        return echelleImage;
    }

    public void setEchelleImage(double echelleImage) {
        this.echelleImage = echelleImage;
        notifier();

    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
        notifier();
    }
    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public boolean isEstActive() {
        return estActive;
    }

    public void setEstActive(boolean estActive) {
        this.estActive = estActive;
    }

    /**
     * Methode pour sauvegarder l'état de la perspective
     * @return la sauvegarde de l'état
     */

    public PerspectiveMemento creerMemento() {
        return new PerspectiveMemento(this.imageModele, this.vue, this.position, this.echelleImage);
    }

    /**
     * Methode pour reprendre le dernier etat de la perspective
     */
    public void restaurerMemento(PerspectiveMemento perspectiveMemento){
        Perspective perspective = perspectiveMemento.getPerspective();
        this.echelleImage = perspectiveMemento.getEchelleImage();
        this.position = perspectiveMemento.getPosition();
        notifier();


    }

    //======================================================================//
    //================== METHODES LIEES AUX COMMANDES ======================//
    //======================================================================//

    /**
     * Une méthode pour mettre a jour la position de la perspective
     * @param translation, les valeurs de translation en x et y
     */
    public void translater(Point translation){
        position.x += translation.x;
        position.y += translation.y;
        historique.push(creerMemento());
        notifier();
    }

    /**
     * Une methode pour mettre a jour l'échelle de l'image
     * @param zoom, le pourcentage d'agrandissement de l'image
     */
    public void zoomer(double zoom) {
        echelleImage *= zoom;
        historique.push(creerMemento());
        notifier();
    }

    /**
     * Une méthode pour annuler les commandes de translation et de zoom effectuées sur l'image
     */
    public void annuler() {
        PerspectiveMemento perspectiveMemento = this.historique.pop();
        restaurerMemento(perspectiveMemento);
        notifier();

    }




}
