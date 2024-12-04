package com.atoudeft.controleur;

import com.atoudeft.client.Client;
//import com.atoudeft.client.GestionnaireEvenementClient2;
//import com.atoudeft.commun.evenement.Evenement;
//import com.atoudeft.vue.PanneauPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;

    public EcouteurOperationsCompte(Client client) {
        this.client = client;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter :
        String commande = e.getActionCommand();
        client.envoyer(commande);
    }
}
