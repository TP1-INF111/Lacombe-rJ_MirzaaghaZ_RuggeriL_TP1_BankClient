package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauRetrait extends JPanel {
    private JLabel titre, label;
    private JButton envoyer, annuler;
    private JTextField montant;

    public PanneauRetrait() {
        titre = new JLabel("Retrait");
        titre.setFont(new Font("Arial", Font.BOLD, 20));
        label = new JLabel("Montant à retirer : ");
        montant = new JTextField();
        envoyer = new JButton("Envoyer");
        annuler = new JButton("Annuler");

        envoyer.setActionCommand("RETRAIT ENVOYER");
        annuler.setActionCommand("RETRAIT ANNULER");

        JPanel panelRetrait = new JPanel();
        panelRetrait.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panelRetrait.add(titre);
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        panelRetrait.add(label, c);
        c.gridx = 1;
        c.gridy = 1;
        panelRetrait.add(montant, c);
        c.gridx = 0;
        c.gridy = 2;
        panelRetrait.add(envoyer, c);
        c.gridx = 1;
        c.gridy = 2;
        panelRetrait.add(annuler, c);
        panelRetrait.setBackground(Color.white);
        this.add(panelRetrait);
    }

    public void setEcouteur(ActionListener ecouteur){
        envoyer.addActionListener(ecouteur);
        annuler.addActionListener(ecouteur);
    }
    public String getMontant(){ return montant.getText(); }

    /**
     * Supprime le texte dans les JTextfield
     */
    public void effaceEntree(){ montant.setText(""); }
}
