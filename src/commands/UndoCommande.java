package commands;
import java.util.Stack;

import modele.PerspectiveMemento;
import modele.Perspective;

/**
 * Commande permettant de defaire la dernière operation.
 */

public class UndoCommande implements Commande {

    private Perspective perspective;

    public UndoCommande(Perspective perspective) {
        this.perspective = perspective;
    }

    public void execute(){
        perspective.annuler();
    }

    @Override
    public void undo() {}

    public void save(){

    }
}
