package controleur;

import commands.Commande;
import commands.TranslationCommande;
import modele.ImageModele;
import modele.Perspective;
import vue.Panneau;
import vue.Vue;
import vue.VueModifiable;

import java.awt.*;
import java.awt.event.*;

public class Controleur implements MouseListener, MouseMotionListener, MouseWheelListener {

    // Modele
    ImageModele imageModele;
    Perspective perspectiveVignette;
    Perspective perspectiveVue1;
    Perspective perspectiveVue2;


    // Vue
    Panneau panneau;
    Vue vueVignette;
    Vue vue1;
    Vue vue2;

    //
    private Point positionInitiale = new Point();


    public Controleur(ImageModele imageModele, Perspective perspectiveVignette, Perspective perspectiveVue1, Perspective perspectiveVue2,Panneau panneau) {
        this.imageModele = imageModele;
        this.panneau = panneau;

        this.perspectiveVignette = perspectiveVignette;
        this.perspectiveVue1 = perspectiveVue1;
        this.perspectiveVue2 = perspectiveVue2;

        this.vueVignette = panneau.getVueVignette();
        this.vue1 = panneau.getVue1();
        this.vue2 = panneau.getVue2();

        vue1.addMouseListener(this);
        vue1.addMouseMotionListener(this);
        vue1.addMouseWheelListener(this);

        vue2.addMouseListener(this);
        vue2.addMouseMotionListener(this);
        vue2.addMouseWheelListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vue1) {
            System.out.println("Clicked on Vue1");
        } if (e.getSource() == vue2) {
            System.out.println("Clicked on Vue2");
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        positionInitiale = e.getPoint();
        VueModifiable vue = (VueModifiable) e.getSource();
        System.out.println("Position initiale " + positionInitiale.x + ", " + positionInitiale.y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point positionFinale = e.getPoint();
        Vue vue = (VueModifiable)e.getSource();

        System.out.println("Position arrivee " + positionFinale.x + "," + positionFinale.y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Its dragged");
        Point translation = new Point((e.getX() - positionInitiale.x),(e.getY() - positionInitiale.y));
        Vue vue = (VueModifiable)e.getSource();
        Perspective perspective = vue.getPerspective();

        Commande translationCommande = new TranslationCommande(perspective,translation);
        translationCommande.execute();


        positionInitiale = e.getPoint();

        perspective.notifier();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
