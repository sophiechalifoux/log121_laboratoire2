package vue;
import controleur.Controleur;
import modele.ImageModele;
import modele.Perspective;

import javax.swing.*;

import java.awt.*;

/**
 * Classe qui regroupe les trois Perspectives :
 * - 1 Vignette
 * - 2 VueModifiable
 */

public class Panneau extends JPanel {

    private ImageModele imageModele;
    private Vue vueVignette;
    private Vue vue1;
    private Vue vue2;
    private Controleur controleur;

    public Panneau() {
        imageModele = new ImageModele();

        Perspective perspectiveVignette = new Perspective(imageModele,null);
        Perspective perspectiveVue1 = new Perspective(imageModele,null);
        Perspective perspectiveVue2 = new Perspective(imageModele, null);

        this.vueVignette = new Vignette(imageModele, perspectiveVignette,"Vignette");
        this.vue1 = new VueModifiable(imageModele, perspectiveVue1, "Vue1");
        this.vue2 = new VueModifiable(imageModele, perspectiveVue2,"Vue2");

        perspectiveVignette.setVue(vueVignette);
        perspectiveVue1.setVue(vue1);
        perspectiveVue2.setVue(vue2);

        initialiser();

        perspectiveVignette.ajouterObservateur(vueVignette);
        perspectiveVue1.ajouterObservateur(vue1);
        perspectiveVue2.ajouterObservateur(vue2);

        this.controleur = new Controleur(imageModele, perspectiveVignette, perspectiveVue1, perspectiveVue2, this);

    }

    private void initialiser() {
        // Ajouter les panneaux au panneau principal
        this.add(vueVignette);
        this.add(vue1);
        this.add(vue2);
        this.setLayout(new GridLayout(1,3));

        vueVignette.setBackground(Color.BLUE);
        vue1.setBackground(Color.RED);
        vue2.setBackground(Color.YELLOW);
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public Vue getVueVignette() {
        return vueVignette;
    }

    public Vue getVue1() {
        return vue1;
    }

    public Vue getVue2() {
        return vue2;
    }

    public void update() {
        repaint();
    }
}
