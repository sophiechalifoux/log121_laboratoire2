package controleur;

import modele.ImageModele;
import vue.Panneau;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MenuItemListener implements ActionListener {
    EditeurImage editeurImage = EditeurImage.getInstance();
    Save save = Save.getInstanceSave();
    Panneau panneau;

    public MenuItemListener(Panneau panneau) {
        this.panneau = panneau;
    }
    public void actionPerformed(ActionEvent e) {
        if( ((JMenuItem) e.getSource()).getText().equals("Save")){
            save.save(panneau);

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

                // Notify the observers to update the views
                imageModele.notifier();

            }
                panneau.update();
         }

        if( ((JMenuItem) e.getSource()).getText().equals("Charger")){

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
                save.charger(file);
            }
        }


         /*if(((JMenu) e.getSource()).getText().equals("Undo")){



         }*/

    }
}
