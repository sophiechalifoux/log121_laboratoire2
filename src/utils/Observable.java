package utils;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList<Observateur> ListObserver = new ArrayList<>();


    public void ajouterObservateur(Observateur observateur){ListObserver.add(observateur);}
    public void retirerObservateur(Observateur observateur){ListObserver.remove(observateur);}
    public void notifier(){
        for (Observateur observateur : ListObserver) {
            observateur.update();
        }
    }
}
