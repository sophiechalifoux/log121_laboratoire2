package modele;

import utils.Observable;
import utils.ObservateurManager;
import utils.Observateur;

public class Nombre implements Observable<Integer> {

    private final ObservateurManager<Integer> observateurManager = new ObservateurManager<>();
    private Integer valeur = 0;

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
        observateurManager.notifier(valeur);
    }

    @Override
    public void ajouterObservateur(Observateur<Integer> observateur) {
        observateurManager.ajouterObservateur(observateur);
    }

    @Override
    public void retirerObservateur(Observateur<Integer> observateur) {
        observateurManager.retirerObservateur(observateur);
    }
}
