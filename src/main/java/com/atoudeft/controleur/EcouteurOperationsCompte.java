package com.atoudeft.controleur;

import com.atoudeft.client.Client;
import com.atoudeft.client.GestionnaireEvenementClient2;
import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.vue.PanneauPrincipal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurOperationsCompte implements ActionListener {
    private Client client;
    private PanneauPrincipal panneauPrincipal;

    public EcouteurOperationsCompte(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter :
        String commande = e.getActionCommand();
        if (commande.equals("EPARGNE")) {
            if (!panneauPrincipal.aCompteEpargne()){
                String evenementReussi = commande + "YES";
                Evenement evenement = new Evenement(e, "Click", evenementReussi);
                GestionnaireEvenementClient2 gestion = new GestionnaireEvenementClient2(client, panneauPrincipal);
                gestion.traiter(evenement);
                System.out.println("On est correct!");
            } else {
                String evenementNonReussi = commande + "NO";
                Evenement evenement = new Evenement(e, "Click", evenementNonReussi);
                System.out.println("On n'est pas correct!");
            }
        }
    }
}
