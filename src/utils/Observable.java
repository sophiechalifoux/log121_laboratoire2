package utils;

public interface Observable<T> {

    void ajouterObservateur(Observateur<T> observateur);
    void retirerObservateur(Observateur<T> observateur);
}
