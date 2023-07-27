package controleur;

import modele.ImageModele;
import vue.Panneau;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

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
                    if (editeurImage.getImageModele() == null) {
                        editeurImage.setImageModele(new ImageModele());
                    }
                editeurImage.getImageModele();

                    panneau.getVignetteLabel().setIcon(image);
                    panneau.getPerspective1Label().setIcon(image);
                    panneau.getPerspective2Label().setIcon(image);
            }
                panneau.update();
         }

    }
}
