package commands;

import modele.Perspective;

/**
 * Commande pour changer le facteur d'echelle
 */
public class ZoomCommande implements Commande {

    Perspective perspective;
    double zoom;

    public ZoomCommande(Perspective perspective, double zoom) {
        this.perspective = perspective;
        this.zoom = zoom;
    }

    @Override
    public void execute() {
        perspective.zoomer(zoom);
    }

    @Override
    public void undo() {

    }
}
