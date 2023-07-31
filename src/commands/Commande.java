package commands;

/**
 * Interface des commandes disponibles dans l'éditeur d'image :
 * - Translation
 * - Zoom
 * - Undo
 */
public interface  Commande {

    public void execute();
    public void undo();
    
}
