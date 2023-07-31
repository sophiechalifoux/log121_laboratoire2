package controleur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vue.Fenetre;
import vue.Panneau;

public class Save {

    public static Save instanceSave;
    private Fenetre fenetre;


    public Fenetre getFenetre() {
        return fenetre;
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public static Save getInstanceSave() {
        if (instanceSave == null){
            instanceSave = new Save();
        }
        return instanceSave;
    }

    public void save(Panneau panneau){
        try {
         FileOutputStream fileOut = new FileOutputStream("test.jpg");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(panneau);
         out.close();
         fileOut.close();
      } catch (IOException i) {
         i.printStackTrace();
      }
    }

    public void charger(String chemin){

        try {
                FileInputStream fileIn = new FileInputStream(chemin);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Panneau panneau = (Panneau) in.readObject();
                fenetre.setPanneau(panneau);
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("Employee class not found");
                c.printStackTrace();
                return;
            }
    }
    
    
}
