package commands;
import java.util.Stack;

import controleur.ImageMemento;
import vue.Perspective;

public class UndoCommande implements Commande {

    private Perspective perspective;
    private ImageMemento memento;
    private Stack<ImageMemento> PileMemento = new Stack<>();
    
    public void execute(){
        if (!(PileMemento.empty())){
            memento = PileMemento.pop();
//            ImageModele.getInstanceModele().restaurerMemento(memento);
        }
    }

    @Override
    public void undo() {

    }

    public void save(){

//        memento = ImageModele.getInstanceModele().creerMemento();
        PileMemento.push(memento);
    }
}
