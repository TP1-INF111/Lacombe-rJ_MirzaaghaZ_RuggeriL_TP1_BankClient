package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JLabel titre, labelMontant, labelFacture;
    private JButton envoyer, annuler;
    private JTextField montant, numFacture;

    public PanneauFacture() {
        titre = new JLabel("Facture");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        labelMontant = new JLabel("Montant de la facture : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");
        labelFacture = new JLabel("Numéro de la facture : ");
        numFacture = new JTextField();

        JPanel panelFacture = new JPanel();
        panelFacture.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panelFacture.add(titre);
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelFacture.add(labelMontant, c);
        c.gridx = 1;
        c.gridy = 1;
        panelFacture.add(montant, c);
        c.gridx = 0;
        c.gridy = 2;
        panelFacture.add(labelFacture, c);
        c.gridx = 1;
        c.gridy = 2;
        panelFacture.add(numFacture, c);
        c.gridx = 0;
        c.gridy = 3;
        panelFacture.add(envoyer, c);
        c.gridx = 1;
        c.gridy = 3;
        panelFacture.add(annuler, c);
        panelFacture.setBackground(Color.white);
        this.add(panelFacture);
    }
}
