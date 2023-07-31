package vue;

import modele.ImageModele;
import modele.Perspective;

/**
 * Vue concrète qui affiche seulement l'image (aucune modification possible)
 */

public class Vignette extends Vue {

    public Vignette(ImageModele imageModele, Perspective perspective, String name) {
        super(imageModele, perspective, name);
    }

    @Override
    public void update() {
        repaint();
    }
}
