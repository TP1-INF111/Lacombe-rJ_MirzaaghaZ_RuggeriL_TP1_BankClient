package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.vue.PanneauDepot;
import com.atoudeft.vue.PanneauOperationsCompte;
import com.atoudeft.vue.PanneauPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    PanneauDepot panneauDepot;
    PanneauOperationsCompte panneauOperationsCompte;
    PanneauPrincipal panneauPrincipal;

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
            default:
                if (commande.equals("DEPOT")||commande.equals("RETRAIT")||commande.equals("FACTURE")||commande.equals("TRANSFER")) {
                    panneauPrincipal.ajoutPanelOperations(commande);
                }
                break;
        }
    }
}
