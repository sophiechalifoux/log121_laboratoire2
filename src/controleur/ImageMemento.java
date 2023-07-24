package controleur;

import modele.ImageModele;

public class ImageMemento{

    private ImageModele imageSauvegarder;

    public ImageMemento(ImageModele instanceModele) {
        imageSauvegarder = instanceModele;
    }

    public ImageModele getImageSauvegarder() {
        return imageSauvegarder;
    }

    public void setImageSauvegarder(ImageModele imageSauvegarder) {
        this.imageSauvegarder = imageSauvegarder;
    }


}