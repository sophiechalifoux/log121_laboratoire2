package controleur;

import java.awt.event.*;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import modele.ImageModele;

public class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {  
         if( ((JMenuItem) e.getSource()).getText() == "Save"){

         }
         if( ((JMenuItem) e.getSource()).getText() == "Open"){

            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			fileChooser.setDialogTitle( "S�lectionnez un fichier de configuration");
			fileChooser.setAcceptAllFileFilterUsed(false);
			// Cr�er un filtre
			FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
			fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                String file = selectedFile.getAbsolutePath();
                System.out.println(file);

                ImageIcon image = new ImageIcon(file);

                ImageModele.getInstanceModele().setImageGauche(image);

            }

         }
      }
}
