package controleur;

import commands.Commande;
import commands.TranslationCommande;
import commands.UndoCommande;
import commands.ZoomCommande;
import modele.ImageModele;
import modele.Perspective;
import vue.Panneau;
import vue.Vue;
import vue.VueModifiable;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe permettant à l'usager de modifier le modèle
 */

public class Controleur implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

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
    Vue vueActive;

    //

    private Point positionInitiale = new Point();
    private int echelleImage;


    public Controleur(ImageModele imageModele, Perspective perspectiveVignette, Perspective perspectiveVue1, Perspective perspectiveVue2,Panneau panneau) {
        this.imageModele = imageModele;
        this.panneau = panneau;

        this.perspectiveVignette = perspectiveVignette;
        this.perspectiveVue1 = perspectiveVue1;
        this.perspectiveVue2 = perspectiveVue2;

        this.vueVignette = panneau.getVueVignette();
        this.vue1 = panneau.getVue1();
        this.vue2 = panneau.getVue2();

        // Ajout des MouseListener aux vues
        vue1.addMouseListener(this);
        vue1.addMouseMotionListener(this);
        vue1.addMouseWheelListener(this);
        vue1.addKeyListener(this);

        vue2.addMouseListener(this);
        vue2.addMouseMotionListener(this);
        vue2.addMouseWheelListener(this);
        vue2.addKeyListener(this);

        vue1.setFocusable(true);
        vue2.setFocusable(true);



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vue1) {
            vueActive = vue1;
            vue1.requestFocusInWindow();

        } else if (e.getSource() == vue2) {
            vueActive = vue2;
            vue2.requestFocusInWindow();
        }
        System.out.println(vueActive.getNom());

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

    /*
     *
     */
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

    // ======================================================================== //
    //
    // ======================================================================== //
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int nbWheelRotation = e.getWheelRotation();
        double zoom;
        Vue vue = (VueModifiable)e.getSource();
        Perspective perspective = vue.getPerspective();
        if (nbWheelRotation > 0) {
            zoom = Math.pow(1.1, nbWheelRotation);
            Commande zoomCommande = new ZoomCommande(perspective, zoom);
            zoomCommande.execute();
            System.out.println("Its zoomed " + zoom );

            perspective.notifier();

        } else {

            zoom = Math.pow(0.9, - nbWheelRotation);
            Commande dezoomCommande = new ZoomCommande(perspective, zoom);
            dezoomCommande.execute();
            System.out.println("Its dezoomed " + zoom );

            perspective.notifier();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        int keyModifier = e.getModifiers();
        Perspective perspectiveActive = vueActive.getPerspective();

        if ((key == KeyEvent.VK_Z) && ((keyModifier & KeyEvent.CTRL_MASK) != 0))
        {
            System.out.println("UNDO UNDO :D!");
            if (perspectiveActive.getHistorique() != null) {
                Commande undoCommande = new UndoCommande(perspectiveActive);
                undoCommande.execute();
            }

        }
        perspectiveActive.notifier();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
