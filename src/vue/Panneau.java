package vue;
import controleur.EditeurImage;
import modele.ImageModele;

import javax.swing.*;

import java.awt.*;

public class Panneau extends JPanel {

    private ImageModele imageModele;
    private  Perspective vignette;
    private    JLabel vignetteLabel;
    private  Perspective perspective1;
    private JLabel perspective1Label;
    private  Perspective perspective2;
    private JLabel perspective2Label;

    public Panneau() {
        imageModele = new ImageModele();
        this.vignette = new Vignette(imageModele);
        this.perspective1 = new VueModifiable(imageModele);
        this.perspective2 = new VueModifiable(imageModele);

        this.vignetteLabel = new JLabel(imageModele.getImage());
        this.perspective1Label = new JLabel(imageModele.getImage());
        this.perspective2Label = new JLabel(imageModele.getImage());

        initialiser();
    }

    private void initialiser() {
        // Ajouter les panneaux au panneau principal
        this.add(vignette);
        this.add(perspective1);
        this.add(perspective2);
        this.setLayout(new GridLayout(1,3));


        vignette.setBackground(Color.BLUE);
        perspective1.setBackground(Color.RED);
        perspective2.setBackground(Color.YELLOW);

        vignette.add(vignetteLabel);
        perspective1.add(perspective1Label);
        perspective2.add(perspective2Label);


        vignetteLabel.setIcon(new ImageIcon("C:\\Users\\sophi\\Documents\\log121_laboratoire2\\src\\marmotte.jpg"));
        perspective1Label.setIcon(new ImageIcon("C:\\Users\\sophi\\Documents\\log121_laboratoire2\\src\\marmotte.jpg"));
        perspective2Label.setIcon(new ImageIcon("C:\\Users\\sophi\\Documents\\log121_laboratoire2\\src\\marmotte.jpg"));
    }

    public JLabel getVignetteLabel() {
        return vignetteLabel;
    }

    public JLabel getPerspective1Label() {
        return perspective1Label;
    }

    public JLabel getPerspective2Label() {
        return perspective2Label;
    }

    public ImageModele getImageModele() {
        return imageModele;
    }

    public Perspective getVignette() {
        return vignette;
    }

    public Perspective getPerspective1() {
        return perspective1;
    }

    public Perspective getPerspective2() {
        return perspective2;
    }



    public void update() {
        vignetteLabel.repaint();
        perspective1Label.repaint();
        perspective2Label.repaint();
    }
}
