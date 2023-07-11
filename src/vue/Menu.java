package vue;

import javax.swing.*;

public class Menu extends JMenuBar {

    private final JMenu ongletFichier;

    public Menu() {
        this.ongletFichier = new JMenu("Fichier");
        initialiser();
    }

    private void initialiser() {
        this.add(ongletFichier);

    }


}
