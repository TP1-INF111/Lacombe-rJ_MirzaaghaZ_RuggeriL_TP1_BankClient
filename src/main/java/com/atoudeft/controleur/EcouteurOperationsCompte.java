package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private PanneauPrincipal panneauPrincipal;
    private PanneauHistorique panneauHistorique;

    public EcouteurOperationsCompte(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        switch (commande) {
            case "EPARGNE":
                client.envoyer(commande);
                break;
            case "DEPOT ENVOYER":
                client.envoyer("DEPOT" + " " + panneauPrincipal.getEntree(commande));
                break;
            case "RETRAIT ENVOYER":
                client.envoyer("RETRAIT" + " " + panneauPrincipal.getEntree(commande));
                break;
            case "FACTURE ENVOYER":
                client.envoyer("FACTURE" + " " + panneauPrincipal.getEntree(commande));
                break;
            case "TRANSFER ENVOYER":
                client.envoyer("TRANSFER" + " " + panneauPrincipal.getEntree(commande));
                break;
            case "HIST":
                client.envoyer("HIST");
                break;
            default:
                if (commande.equals("DEPOT")||commande.equals("RETRAIT")||commande.equals("FACTURE")||commande.equals("TRANSFER")) {
                    panneauPrincipal.ajoutPanelOperations(commande);
                }
                if (commande.equals("DEPOT ANNULER")||commande.equals("RETRAIT ANNULER")||commande.equals("FACTURE ANNULER")||commande.equals("TRANSFER ANNULER")) {
                    panneauPrincipal.effacerEntree(commande);
                }
                break;
        }
    }
}
