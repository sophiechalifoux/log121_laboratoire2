import controleur.Controleur;
import controleur.*;
import modele.ImageModele;
import vue.Fenetre;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Save save = Save.getInstanceSave();
        Fenetre fenetre = new Fenetre();
        save.setFenetre(fenetre);
        EditeurImage editeurImage = EditeurImage.getInstance();
        editeurImage.setImageModele(new ImageModele());
        editeurImage.getImageModele().setImage(new ImageIcon(("C:\\Users\\sophi\\Documents\\log121_laboratoire2\\src\\marmotte.jpg")));


    }
}
