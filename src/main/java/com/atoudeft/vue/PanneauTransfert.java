package com.atoudeft.vue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauTransfert extends JPanel {
    private JLabel titre, labelMontant, labelCompte;
    private JButton envoyer, annuler;
    private JTextField montant, numCompte;

    public PanneauTransfert() {
        titre = new JLabel("Transfert");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        labelMontant = new JLabel("Montant à transférer : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");
        labelCompte = new JLabel("Numéro du compte : ");
        numCompte = new JTextField();

        envoyer.setActionCommand("TRANSFER ENVOYER");
        annuler.setActionCommand("TRANSFER ANNULER");

        JPanel panelTransfert = new JPanel();
        panelTransfert.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panelTransfert.add(titre);
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelTransfert.add(labelMontant, c);
        c.gridx = 1;
        c.gridy = 1;
        panelTransfert.add(montant, c);
        c.gridx = 0;
        c.gridy = 2;
        panelTransfert.add(labelCompte, c);
        c.gridx = 1;
        c.gridy = 2;
        panelTransfert.add(numCompte, c);
        c.gridx = 0;
        c.gridy = 3;
        panelTransfert.add(envoyer, c);
        c.gridx = 1;
        c.gridy = 3;
        panelTransfert.add(annuler, c);
        panelTransfert.setBackground(Color.white);
        this.add(panelTransfert);
    }

    public void setEcouteur(ActionListener ecouteur){
        envoyer.addActionListener(ecouteur);
        annuler.addActionListener(ecouteur);
    }

    public String getMontant(){ return montant.getText(); }
    public String getNumCompte(){ return numCompte.getText(); }

    /**
     * Supprime le texte dans les JTextfield
     */
    public void effaceEntree(){
        montant.setText("");
        numCompte.setText("");
    }
}
