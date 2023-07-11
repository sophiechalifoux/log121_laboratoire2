package vue;

import controleur.IncrementController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IncrementButton extends JButton implements ActionListener {

    private final IncrementController controller;
    private final String text = " + ";

    public IncrementButton(IncrementController controller) {
        this.controller = controller;
        initialiser();
    }

    private void initialiser() {
        this.addActionListener(this);
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.incrementer(3);
    }
}
