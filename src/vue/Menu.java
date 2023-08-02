package vue;

import javax.swing.*;
import controleur.*;

/**
 * Menu de l'application qui contient les onglets pour :
 * - Charger un fichier
 * - Sauvegarder un fichier
 */

public class Menu extends JMenuBar  {
    EditeurImage editeurImage = EditeurImage.getInstance();
    private final JMenu ongletFichier;
    private final JMenuItem open;
    private final JMenuItem save;

    public Menu(Panneau panneau) {
        this.ongletFichier = new JMenu("Fichier");
        this.open = new JMenuItem("Open");
        this.save = new JMenuItem("Save");
        initialiser(panneau);
    }

    private void initialiser(Panneau panneau) {
        MenuItemListener menuItemListener = new MenuItemListener(editeurImage.getPanneau());

        save.addActionListener(menuItemListener);
        open.addActionListener(menuItemListener);

        this.add(ongletFichier);
        ongletFichier.add(open);
        ongletFichier.add(save);

    }
}
