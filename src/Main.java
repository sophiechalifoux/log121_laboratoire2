import controleur.DecrementController;
import controleur.IncrementController;
import modele.Nombre;
import vue.Fenetre;

public class Main {

    public static void main(String[] args) {
        // Modele
        Nombre nombre = new Nombre();

        // Controlleurs
        IncrementController increment = new IncrementController(nombre);
        DecrementController decrement = new DecrementController(nombre);

        // Vue
        Fenetre fenetre = new Fenetre(nombre, increment, decrement);
    }
}
