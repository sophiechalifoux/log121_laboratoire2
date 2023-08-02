package observateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Observable implements Serializable {

    private transient List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObservateur(Observateur observateur){observateurs.add(observateur);}
    public void retirerObservateur(Observateur observateur){observateurs.remove(observateur);}
    public void notifier(){
        for (Observateur observateur : observateurs) {
            observateur.update();
        }
    }
}
