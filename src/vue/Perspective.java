package vue;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.ImageModele;
import utils.Observateur;

public class Perspective extends JPanel implements Observateur{

    private ImageModele model = ImageModele.getInstanceModele();
    private ImageIcon image = new ImageIcon();
    private String position;

    

    public String getPosition() {
        return position;
    }

    public Perspective(String position){
        this.position = position;
    }

    public void paint(Graphics g) {   

        if (image != null){        
            g.drawImage(image.getImage(),0,0,null);
           
        }
    }

    public void update(){

        if (image != null){

            if (position.equals("Centre")){
                image = model.getImageCentre();
            }else if(position.equals("Droite")){
                image = model.getImageDroite();
            }
        }else {
            image = model.getImageGauche();

        }
        repaint();

    }
}
