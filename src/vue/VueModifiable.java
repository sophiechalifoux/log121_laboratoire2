package vue;

import commands.Commande;
import modele.ImageModele;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VueModifiable extends Perspective {
    public VueModifiable(ImageModele imageModele) {
        super(imageModele);
        addMouseListener(new ImageMouseListener());
    }

    // Méthodes liées aux commandes
    public void translate(Point point){}
    public void zoom(double echelle){}
    public void undo(Commande commande){}

    private class ImageMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("Click");
        }


    }


}
