package controleur;

import commandes.Commande;
import commandes.TranslationCommande;
import commandes.UndoCommande;
import commandes.ZoomCommande;
import modele.ImageModele;
import modele.Perspective;
import vue.Panneau;
import vue.Vue;
import vue.VueModifiable;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Classe permettant à l'usager de modifier le modèle
 */

public class Controleur implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener, Serializable {

    EditeurImage editeurImage = EditeurImage.getInstance();

    // Modele
    ImageModele imageModele;
    Perspective perspectiveVignette;
    Perspective perspectiveVue1;
    Perspective perspectiveVue2;

    // Vue
    transient Panneau panneau;
    transient Vue vueVignette;
    transient Vue vue1;
    transient Vue vue2;
    transient Vue vueActive;

    private Point positionInitiale = new Point();
    private int echelleImage;




    public Controleur(ImageModele imageModele, Perspective perspectiveVignette, Perspective perspectiveVue1, Perspective perspectiveVue2,Panneau panneau) {
        this.imageModele = imageModele;
        this.panneau = panneau;
        editeurImage.setImageModele(imageModele);
        editeurImage.setPanneau(panneau);

        this.perspectiveVignette = perspectiveVignette;
        this.perspectiveVue1 = perspectiveVue1;
        this.perspectiveVue2 = perspectiveVue2;

        this.vueVignette = panneau.getVueVignette();
        this.vue1 = panneau.getVue1();
        this.vue2 = panneau.getVue2();


        // Ajouter les vues comme Observateur a leurs perspectives respectives
        perspectiveVignette.ajouterObservateur(vueVignette);
        perspectiveVue1.ajouterObservateur(vue1);
        perspectiveVue2.ajouterObservateur(vue2);

        // Ajout des MouseListener et KeyListener aux vues
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

    // -------------------- ACTIONS ASSOCIEES AUX COMMANDES -------------------------- //

    /**
     * Methode pour determiner la vue active
     * @param e, mouseEvent quand l'usager utilise le bouton gauche de la souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vue1) {
            vueActive = vue1;
            vue1.requestFocusInWindow();

        } else if (e.getSource() == vue2) {
            vueActive = vue2;
            vue2.requestFocusInWindow();
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {
        positionInitiale = e.getPoint();
        VueModifiable vue = (VueModifiable) e.getSource();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point positionFinale = e.getPoint();
        Vue vue = (VueModifiable)e.getSource();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Methode pour deplacer la position de l'image
     * @param e, mouseEvent quand l'usager tient enfonce le bouton gauche de la souris
     */
    @Override
    public void mouseDragged(MouseEvent e) {
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

    /**
     * Methode pour mettre a jour le facteur d'echelle de l'image
     * @param e, mouseWheelEvent quand l'usager fait rouler la molette de la souris
     */
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
            perspective.notifier();
        } else {
            zoom = Math.pow(0.9, - nbWheelRotation);
            Commande dezoomCommande = new ZoomCommande(perspective, zoom);
            dezoomCommande.execute();
            perspective.notifier();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Methode pour annuler les commandes effectuees sur l'image
     * @param e, keyEvent quand l'usager appui sur les touches CTRL+Z
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int keyModifier = e.getModifiers();

        if (vueActive != null) {
            Perspective perspectiveActive = vueActive.getPerspective();
            if ((key == KeyEvent.VK_Z) && ((keyModifier & KeyEvent.CTRL_MASK) != 0))
            {
                if (perspectiveActive.getHistorique() != null) {
                    Commande undoCommande = new UndoCommande(perspectiveActive);
                    undoCommande.execute();
                }
            }
            perspectiveActive.notifier();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
