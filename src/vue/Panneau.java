package vue;

import controleur.Controleur;
import controleur.EditeurImage;
import modele.ImageModele;
import modele.Perspective;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui regroupe les trois Perspectives :
 * - 1 Vignette
 * - 2 VueModifiable
 */

public class Panneau extends JPanel  {

    EditeurImage editeurImage = EditeurImage.getInstance();
    private ImageModele imageModele;
//    private List<Perspective> listePerspectives;
    private Perspective perspectiveVignette;
    private Perspective perspectiveVue1;
    private Perspective perspectiveVue2;
    private Vue vueVignette;
    private Vue vue1;
    private Vue vue2;
    private Controleur controleur;

    public Panneau() {
        imageModele = editeurImage.getImageModele();

        perspectiveVignette = new Perspective(imageModele,null, "Vignette");
        perspectiveVue1 = new Perspective(imageModele,null, "Vue1");
        perspectiveVue2 = new Perspective(imageModele, null, "Vue2");

        this.vueVignette = new Vignette(imageModele, perspectiveVignette,"Vignette");
        this.vue1 = new VueModifiable(imageModele, perspectiveVue1, "Vue1");
        this.vue2 = new VueModifiable(imageModele, perspectiveVue2,"Vue2");

        perspectiveVignette.setVue(vueVignette);
        perspectiveVue1.setVue(vue1);
        perspectiveVue2.setVue(vue2);

        initialiser();

        this.controleur = new Controleur(imageModele, perspectiveVignette, perspectiveVue1, perspectiveVue2, this);

        editeurImage.setPanneau(this);
        // Associer les perspectives au panneau
//        listePerspectives = new ArrayList<>();
//        listePerspectives.add(perspectiveVignette);
//        listePerspectives.add(perspectiveVue1);
//        listePerspectives.add(perspectiveVue2);
    }

    private void initialiser() {
        // Ajouter les panneaux au panneau principal
        this.add(vueVignette);
        this.add(vue1);
        this.add(vue2);
        this.setLayout(new GridLayout(1,3));
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

    public Perspective getPerspectiveVignette() {
        return perspectiveVignette;
    }

    public Perspective getPerspectiveVue1() {
        return perspectiveVue1;
    }

    public Perspective getPerspectiveVue2() {
        return perspectiveVue2;
    }

    public void setImageModele(ImageModele imageModele) {
        this.imageModele = imageModele;
    }

//    public List<Perspective> getListePerspectives() {
//        return listePerspectives;
//    }

//    public void setListePerspectives(List<Perspective> listePerspectives) {
//        this.listePerspectives = listePerspectives;
//    }

    public void update() {
        repaint();
    }
}
