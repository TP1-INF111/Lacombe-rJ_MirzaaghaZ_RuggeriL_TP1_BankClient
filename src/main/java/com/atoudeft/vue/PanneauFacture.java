package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauFacture extends JPanel {
    private JLabel titre, labelMontant, labelFacture, labelDescrition;
    private JButton envoyer, annuler;
    private JTextField montant, numFacture, descrition;

    public PanneauFacture() {
        titre = new JLabel("Facture");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        labelMontant = new JLabel("Montant de la facture : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");
        labelFacture = new JLabel("Numéro de la facture : ");
        numFacture = new JTextField();
        labelDescrition = new JLabel("Descrition : ");
        descrition = new JTextField();

        envoyer.setActionCommand("FACTURE ENVOYER");
        annuler.setActionCommand("FACTURE ANNULER");

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
        panelFacture.add(labelDescrition, c);
        c.gridx = 1;
        c.gridy = 3;
        panelFacture.add(descrition, c);
        c.gridx = 0;
        c.gridy = 4;
        panelFacture.add(envoyer, c);
        c.gridx = 1;
        c.gridy = 4;
        panelFacture.add(annuler, c);
        panelFacture.setBackground(Color.white);
        this.add(panelFacture);
    }

    public void setEcouteur(ActionListener ecouteur){
        envoyer.addActionListener(ecouteur);
        annuler.addActionListener(ecouteur);
    }

    public String getMontant(){ return montant.getText(); }
    public String getNumFacture(){ return numFacture.getText(); }
    public String getDescrition(){ return descrition.getText(); }

    /**
     * Supprime le texte dans les JTextfield
     */
    public void effaceEntree(){
        montant.setText("");
        numFacture.setText("");
        descrition.setText("");
    }
}
