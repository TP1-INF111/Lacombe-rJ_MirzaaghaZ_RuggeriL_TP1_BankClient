package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauRetrait extends JPanel {
    private JLabel titre, compte, solde, label;
    private JButton envoyer, annuler;
    private JTextField montant;

    public PanneauRetrait() {
        titre = new JLabel("Retrait");
        compte = new JLabel("Compte");
        solde = new JLabel("Solde : ");
        label = new JLabel("Montant à déposer : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");

        this.add(titre);
        this.setLayout(new GridLayout(1,1));
        this.add(compte);
        this.add(solde);
        this.setLayout(new GridLayout(2,2));
        this.add(label);
        this.add(montant);
        this.add(envoyer);
        this.add(annuler);
    }
}
