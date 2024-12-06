package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauOperationsCompte extends JPanel {
    private JButton bEpargne, bDepot, bRetrait, bTransfert, bFacture, bHistorique;
    private JLabel lblSolde;

    public PanneauOperationsCompte() {
        bEpargne = new JButton("Créer compte épargne");
        bDepot = new JButton("Déposer");
        bRetrait = new JButton("Retirer");
        bTransfert = new JButton("Transferer");
        bFacture = new JButton("Payer Facture");
        bHistorique = new JButton("Historique du compte");
        lblSolde = new JLabel("Solde : ");

        bEpargne.setActionCommand("EPARGNE");
        bDepot.setActionCommand("DEPOT");
        bRetrait.setActionCommand("RETRAIT");
        bTransfert.setActionCommand("TRANSFER");
        bFacture.setActionCommand("FACTURE");
        bHistorique.setActionCommand("HIST");

        //à compléter :
        this.setLayout(new GridLayout(2,1));
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        navPanel.add(lblSolde);
        navPanel.add(bEpargne);
        navPanel.add(bDepot);
        navPanel.add(bRetrait);
        navPanel.add(bTransfert);
        navPanel.add(bFacture);
        navPanel.add(bHistorique);
        navPanel.setBackground(Color.white);

        this.add(navPanel);
    }
    public void setEcouteur(ActionListener ecouteur) {
        bEpargne.addActionListener(ecouteur);
        bDepot.addActionListener(ecouteur);
        bRetrait.addActionListener(ecouteur);
        bTransfert.addActionListener(ecouteur);
        bFacture.addActionListener(ecouteur);
        bHistorique.addActionListener(ecouteur);
    }
    public void reecritureSolde(String nouveauSolde){
        lblSolde.setText("Solde : " + nouveauSolde);
    }
}
