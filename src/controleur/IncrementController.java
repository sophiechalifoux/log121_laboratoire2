package controleur;

import modele.Nombre;

public class IncrementController {

    private final Nombre modele;

    public IncrementController(Nombre modele) {
        this.modele = modele;
    }

    public void incrementer(int step) {
        int valeur = modele.getValeur();
        modele.setValeur(valeur + step);
    }
}
