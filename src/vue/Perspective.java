package vue;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.ImageModele;
import utils.Observateur;

public class Perspective extends JPanel implements Observateur{

    private ImageModele model = ImageModele.getInstanceModele();
    private ImageIcon image = new ImageIcon();


    

    public Perspective(){

    }

    public void paint(Graphics g) {   

        if (image != null){        
            g.drawImage(image.getImage(),0,0,null);
           
        }
    }

    public void update(){

        image = model.getImage();
        repaint();

    }
}
