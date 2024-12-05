package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauFacture extends JPanel {
    private JLabel titre, compte, solde, labelMontant, labelFacture;
    private JButton envoyer, annuler;
    private JTextField montant, numFacture;

    public PanneauFacture() {
        titre = new JLabel("Facture");
        compte = new JLabel("Compte");
        solde = new JLabel("Solde : ");
        labelMontant = new JLabel("Montant de la facture : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");
        labelFacture = new JLabel("Numéro de la facture : ");
        numFacture = new JTextField();

        this.add(titre);
        this.setLayout(new GridLayout(1,1));
        this.add(compte);
        this.add(solde);
        this.setLayout(new GridLayout(3,2));
        this.add(labelMontant);
        this.add(montant);
        this.add(labelFacture);
        this.add(numFacture);
        this.add(envoyer);
        this.add(annuler);
    }
}
