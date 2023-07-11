package utils;

import java.util.LinkedList;
import java.util.List;

public class ObservateurManager<T> implements Observable<T> {

    private final List<Observateur<T>> observateurs = new LinkedList<>();
    private T ancienneValeur = null;

    @Override
    public void ajouterObservateur(Observateur<T> observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void retirerObservateur(Observateur<T> observateur) {
        observateurs.remove(observateur);
    }

    public void notifier(T newValue) {
        boolean sameValeur = (ancienneValeur == null && newValue == null)
                || (ancienneValeur != null && ancienneValeur.equals(newValue));

        if (!sameValeur) {
            System.out.println("new value: " + newValue);
            for (Observateur<T> observateur : observateurs) {
                observateur.onChanged(newValue);
            }
            ancienneValeur = newValue;
        }
    }
}
