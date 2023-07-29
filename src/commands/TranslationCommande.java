package commands;

import modele.ImageModele;
import modele.Perspective;
import vue.Vue;

import java.awt.*;

/**
 * Classe qui permet la translation d'une image a l'aide de la souris.
 */

public class TranslationCommande implements Commande {

    private Perspective perspective;
    private Point translation;

    public TranslationCommande(Perspective perspective, Point translation) {
        this.perspective = perspective;
        this.translation = translation;
    }

    @Override
    public void execute() {
        perspective.translater(translation);
    }

    @Override
    public void undo() {
    }
}
