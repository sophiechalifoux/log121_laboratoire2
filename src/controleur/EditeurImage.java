package controleur;

import modele.ImageModele;
import vue.Panneau;

import java.io.Serializable;


/**
 * Gestionnaire de l'application
 */
public class EditeurImage implements Serializable {

    private static EditeurImage instance;
    private ImageModele imageModele;
    private transient Panneau panneau;

    private EditeurImage() {
        imageModele = new ImageModele();
    }

    public static EditeurImage getInstance() {
        if (instance == null) {
            instance = new EditeurImage();
        }
        return instance;
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public void setImageModele(ImageModele imageModele) {
        this.imageModele = imageModele;
    }

    public void setPanneau(Panneau panneau) {
        this.panneau = panneau;
    }

    public Panneau getPanneau() {
        return panneau;
    }
}
