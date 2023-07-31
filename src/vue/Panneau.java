package vue;
import controleur.Controleur;
import modele.ImageModele;
import modele.Perspective;

import javax.swing.*;

import java.awt.*;

public class Panneau extends JPanel {

    private ImageModele imageModele;
    private Vue vueVignette;
    private Vue vue1;
    private Vue vue2;
    private transient Controleur controleur;

    public Panneau() {
        imageModele = new ImageModele();

        Perspective perspectiveVignette = new Perspective(imageModele);
        Perspective perspectiveVue1 = new Perspective(imageModele);
        Perspective perspectiveVue2 = new Perspective(imageModele);

        this.vueVignette = new Vignette(imageModele, perspectiveVignette,"Vignette");
        this.vue1 = new VueModifiable(imageModele, perspectiveVue1, "Vue1");
        this.vue2 = new VueModifiable(imageModele, perspectiveVue2,"Vue2");
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

        vue1.addMouseListener(controleur);
        vue1.addMouseMotionListener(controleur);
        vue1.addMouseWheelListener(controleur);

        vue2.addMouseListener(controleur);
        vue2.addMouseMotionListener(controleur);
        vue2.addMouseWheelListener(controleur);
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
    
    public void recharger(){
        vue1.update();
        vue2.update();
        vueVignette.update();
    }
}
