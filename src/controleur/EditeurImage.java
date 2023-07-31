package controleur;

import modele.ImageModele;

/**
 * Gestionnaire de l'application
 */
public class EditeurImage {
    private static EditeurImage instance;

    private ImageModele imageModele;

    private EditeurImage() {
        imageModele = new ImageModele();

    }

    public static EditeurImage getInstance() {
        if (instance == null) {
            return new EditeurImage();
        }
        return instance;
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public void setImageModele(ImageModele imageModele) {
        this.imageModele = imageModele;
    }
}
