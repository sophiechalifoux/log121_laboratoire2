package commands;

import vue.Perspective;

import java.awt.*;

public class TranslationCommande implements Commande {

    private Perspective perspective;
    private Point translation;

    public TranslationCommande(Perspective perspective, Point translation) {
        this.perspective = perspective;
        this.translation = translation;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {
    }
}
