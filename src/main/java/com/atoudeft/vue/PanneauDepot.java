package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauDepot extends JPanel {
    private JLabel titre, label;
    private JButton envoyer, annuler;
    private JTextField montant;

    public PanneauDepot() {
        titre = new JLabel("Dépot");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        label = new JLabel("Montant à déposer : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");

        JPanel panelDepot = new JPanel();
        panelDepot.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panelDepot.add(titre);
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelDepot.add(label, c);
        c.gridx = 1;
        c.gridy = 1;
        panelDepot.add(montant, c);
        c.gridx = 0;
        c.gridy = 2;
        panelDepot.add(envoyer, c);
        c.gridx = 1;
        c.gridy = 2;
        panelDepot.add(annuler, c);
        panelDepot.setBackground(Color.white);
        this.add(panelDepot);
    }
}
