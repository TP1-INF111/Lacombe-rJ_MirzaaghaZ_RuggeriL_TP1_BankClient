package com.atoudeft.vue;


import javax.swing.*;
import java.awt.*;

public class PanneauTransfert extends JPanel {
    private JLabel titre, compte, solde, labelMontant, labelCompte;
    private JButton envoyer, annuler;
    private JTextField montant, numCompte;

    public PanneauTransfert() {
        titre = new JLabel("Transfert");
        compte = new JLabel("Compte");
        solde = new JLabel("Solde : ");
        labelMontant = new JLabel("Montant à transférer : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");
        labelCompte = new JLabel("Numéro du compte : ");
        numCompte = new JTextField();

        this.add(titre);
        this.setLayout(new GridLayout(1,1));
        this.add(compte);
        this.add(solde);
        this.setLayout(new GridLayout(3,2));
        this.add(labelMontant);
        this.add(montant);
        this.add(labelCompte);
        this.add(numCompte);
        this.add(envoyer);
        this.add(annuler);
    }
}
