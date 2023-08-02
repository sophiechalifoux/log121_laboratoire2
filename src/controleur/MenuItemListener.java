package controleur;

import vue.Panneau;

import java.awt.event.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Classe qui effectue les actions suivantes à partir du menu :
 * - Sauvegarde de la perspective
 * - Ouverture d'un fichier de sauvegarde ou image et affichage de celui-ci dans l'editeur
 */

public class MenuItemListener implements ActionListener {

    EditeurImage editeurImage = EditeurImage.getInstance();
    Panneau panneau;

    public MenuItemListener(Panneau panneau) {
        this.panneau = panneau;
    }

    public void actionPerformed(ActionEvent e) {


        // -------------------- MENU "SAVE" -------------------------- //

        if (((JMenuItem) e.getSource()).getText().equals("Save")) {
            JFileChooser saveFileChooser = new JFileChooser();
            saveFileChooser.setDialogTitle("Sauvegarder un fichier");
            saveFileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier (*.ser)", "ser");
            saveFileChooser.addChoosableFileFilter(filtre);
            int saveReturnValue = saveFileChooser.showSaveDialog(null);

            if (saveReturnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    String filePath = saveFileChooser.getSelectedFile().getAbsolutePath();
                    if (!filePath.endsWith(".ser")) {
                        filePath += ".ser";
                    }

                    // Serialisation des perspectives
                    FileOutputStream fileOut = new FileOutputStream(filePath);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(panneau);
                    out.close();
                    fileOut.close();

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        }

            // -------------------- MENU "OPEN" -------------------------- //

            if (((JMenuItem) e.getSource()).getText().equals("Open")) {

                JFileChooser openFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                openFileChooser.setDialogTitle("Sélectionnez un fichier");
                openFileChooser.setAcceptAllFileFilterUsed(false);

                // Filtre images
                FileNameExtensionFilter filtreImages = new FileNameExtensionFilter("Toutes les images (*.jpeg;*.jpg;*.png;*.gif)", "jpg", "png", "jpeg", "gif");
                openFileChooser.addChoosableFileFilter(filtreImages);

                // Filtre sauvegarde
                FileNameExtensionFilter filtreSer = new FileNameExtensionFilter("Fichier (*.ser)", "ser");
                openFileChooser.addChoosableFileFilter(filtreSer);

                int returnValue = openFileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = openFileChooser.getSelectedFile();
                    String file = selectedFile.getAbsolutePath();

                // -------------------- "OPEN" FICHIER DE SAUVEGARDE -------------------------- //

                    if (file.endsWith(".ser")) {

                    try {
                        // Deserialisation des perspectives
                        FileInputStream fileIn = new FileInputStream(file);
                        ObjectInputStream in = new ObjectInputStream(fileIn);

                        Panneau newPanneau = (Panneau) in.readObject();
                        in.close();
                        fileIn.close();

                        // Ajouter le panneau deserialisee
                        panneau = newPanneau;
                        panneau.revalidate();

                    } catch (IOException i) {
                        i.printStackTrace();
                        return;
                    } catch (ClassNotFoundException c) {
                        c.printStackTrace();
                        return;
                    }
                }

                // -------------------- "OPEN" FICHIER IMAGE -------------------------- //

                if (file.endsWith(".jpeg") || file.endsWith(".jpg") || file.endsWith(".png") || file.endsWith(".gif")) {
                    ImageIcon image = new ImageIcon(file);
                    editeurImage.getImageModele().setImage(image);
                }
            }
            panneau.repaint();
            }
        }
    }

