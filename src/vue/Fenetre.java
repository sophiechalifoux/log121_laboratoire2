package vue;


import javax.swing.*;

public class Fenetre extends JFrame {

    private final Panneau panneau;
    private final Menu menu;

    public Fenetre() {
        this.panneau = new Panneau();
        this.menu = new Menu();
        initialiser();
    }

    private void initialiser() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(panneau);
        this.setJMenuBar(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
