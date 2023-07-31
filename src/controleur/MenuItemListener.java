package controleur;

import modele.ImageModele;
import vue.Panneau;

import java.awt.event.*;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Classe qui effectue les actions suivantes à partir du menu :
 * - Sauvegarde de la perspective
 * - Ouverture du fichier image et affichage de celui-ci dans l'éditeur
 */

public class MenuItemListener implements ActionListener {
    EditeurImage editeurImage = EditeurImage.getInstance();
    Panneau panneau;

    public MenuItemListener(Panneau panneau) {
        this.panneau = panneau;
    }
    public void actionPerformed(ActionEvent e) {
        if( ((JMenuItem) e.getSource()).getText().equals("Save")){
            //TODO

         }
         if( ((JMenuItem) e.getSource()).getText().equals("Open")){

            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle( "Sélectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Créer un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
			fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String file = selectedFile.getAbsolutePath();

                ImageIcon image = new ImageIcon(file);
                ImageModele imageModele = panneau.getImageModele();
                imageModele.setImage(image);
            }
                panneau.update();
         }
    }
}
