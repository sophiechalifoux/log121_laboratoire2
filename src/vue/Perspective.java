package vue;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modele.ImageModele;
import utils.Observateur;

public class Perspective extends JPanel implements Observateur, MouseListener {

    private String perspectiveName;
    private ImageModele model = ImageModele.getInstanceModele();
    private ImageIcon image = new ImageIcon();
    private String position;
        
    public String getPosition() {
        return position;
    }

    public Perspective(String position){
        this.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (perspectiveName.equals("gauche")) {
            System.out.println("Left Click");
        } else if (perspectiveName.equals("centre")) {
            System.out.println("Center Click");
        } else if (perspectiveName.equals("droite")) {
            System.out.println("Right Click");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
