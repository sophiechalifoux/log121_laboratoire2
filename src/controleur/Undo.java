package controleur;
import java.util.Stack;

import modele.*;

public class Undo implements Command{

    private ImageMemento memento;
    private Stack<ImageMemento> PileMemento = new Stack<>();
    
    public void execute(){
        if (!(PileMemento.empty())){
            memento = PileMemento.pop();
            ImageModele.getInstanceModele().restaurerMemento(memento);
        }
    }

    public void save(){

        memento = ImageModele.getInstanceModele().creerMemento();
        PileMemento.push(memento);
    }
}
