package vue;

import modele.Nombre;
import utils.Observateur;

import javax.swing.*;

public class NombreLabel extends JLabel implements Observateur<Integer> {

    private final Nombre modele;

    public NombreLabel(Nombre modele) {
        this.modele = modele;

        onChanged(modele.getValeur());
        modele.ajouterObservateur(this);
    }

    @Override
    public void onChanged(Integer newValue) {
        if (newValue != null) {
            setText(newValue.toString());
        } else {
            setText("null");
        }
    }
}
