package vue;

import controleur.DecrementController;
import controleur.IncrementController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecrementButton extends JButton implements ActionListener {

    private final DecrementController controller;
    private final String text = " - ";

    public DecrementButton(DecrementController controller) {
        this.controller = controller;
        initialiser();
    }

    private void initialiser() {
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.decrementer(3);
    }

    public String getText() {
        return this.text;
    }
}
