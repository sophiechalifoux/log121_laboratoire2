package controleur;

import modele.Nombre;

public class DecrementController {

    private final Nombre modele;

    public DecrementController(Nombre modele) {
        this.modele = modele;
    }

    public void decrementer(int step) {
        int valeur = modele.getValeur();
        modele.setValeur(valeur - step);
    }
}
