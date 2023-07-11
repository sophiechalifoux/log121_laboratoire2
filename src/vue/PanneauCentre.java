package vue;

import controleur.DecrementController;
import controleur.IncrementController;
import modele.Nombre;

import javax.swing.*;
import java.awt.*;

import static javax.swing.text.StyleConstants.Bold;

public class PanneauCentre extends JPanel {

    private final NombreLabel nombreLabel;
    private final JPanel boutons;
    private final IncrementButton incrementButton;
    private final DecrementButton decrementButton;

    private final JOptionPane jOptionPane;

    public PanneauCentre(
        Nombre modele,
        IncrementController incrementController,
        DecrementController decrementController
    ) {
        nombreLabel = new NombreLabel(modele);
        boutons = new JPanel();
        incrementButton = new IncrementButton(incrementController);
        decrementButton = new DecrementButton(decrementController);
        jOptionPane = new JOptionPane();
        initialiser();
    }

    private void initialiser() {
        setLayout(new BorderLayout());
        this.add(nombreLabel);
        this.add(boutons, BorderLayout.SOUTH);

        nombreLabel.setVerticalAlignment(JLabel.CENTER);
        nombreLabel.setHorizontalAlignment(JLabel.CENTER);
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 36));


        boutons.setLayout(new FlowLayout());
        boutons.setBackground(Color.RED);
        boutons.add(decrementButton);
        boutons.add(incrementButton);

        decrementButton.setPreferredSize(new Dimension(50,50));
        incrementButton.setPreferredSize(new Dimension(50,50));

        decrementButton.setText(decrementButton.getText());
        incrementButton.setText(incrementButton.getText());

        //JOptionPane.showConfirmDialog();
    }
}
