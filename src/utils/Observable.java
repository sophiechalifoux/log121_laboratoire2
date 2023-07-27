package utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObservateur(Observateur observateur){observateurs.add(observateur);}
    public void retirerObservateur(Observateur observateur){observateurs.remove(observateur);}
    public void notifier(){
        for (Observateur observateur : observateurs) {
            observateur.update();
        }
    }
}
