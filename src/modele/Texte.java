package modele;

import utils.Observable;
import utils.Observateur;
import utils.ObservateurManager;

public class Texte implements Observable<String> {

    private final ObservateurManager<String> observateurManager = new ObservateurManager<>();
    private String valeur;

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
        observateurManager.notifier(valeur);
    }

    @Override
    public void ajouterObservateur(Observateur<String> observateur) {
        observateurManager.ajouterObservateur(observateur);
    }

    @Override
    public void retirerObservateur(Observateur<String> observateur) {
        observateurManager.retirerObservateur(observateur);
    }
}
