package com.atoudeft.client;

import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.commun.evenement.GestionnaireEvenement;
import com.atoudeft.commun.net.Connexion;
import com.atoudeft.vue.PanneauHistorique;
import com.atoudeft.vue.PanneauPrincipal;
import com.programmes.MainFrame;

import javax.swing.*;

public class GestionnaireEvenementClient2 implements GestionnaireEvenement {
    private Client client;
    private PanneauPrincipal panneauPrincipal;
    private PanneauHistorique panneauHistorique;

    /**
     * Construit un gestionnaire d'événements pour un client.
     *
     * @param client Client Le client pour lequel ce gestionnaire gère des événements
     */
    public GestionnaireEvenementClient2(Client client, PanneauPrincipal panneauPrincipal) {
        this.client = client;
        this.panneauPrincipal = panneauPrincipal;
        this.client.setGestionnaireEvenement(this);
        this.panneauHistorique = new PanneauHistorique();
    }
    @Override
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();
        //Connexion cnx;
        String typeEvenement, arg, str;
        int i;
        String[] t;
        MainFrame fenetre;

        if (source instanceof Connexion) {
            //cnx = (Connexion) source;
            typeEvenement = evenement.getType();
            switch (typeEvenement) {
                /******************* COMMANDES GÉNÉRALES *******************/
                case "END": //Le serveur demande de fermer la connexion
                    client.deconnecter(); //On ferme la connexion
                    break;
                /******************* CREATION et CONNEXION *******************/
                case "HIST":
                    arg = evenement.getArgument();
                    panneauHistorique.setListeHistorique(arg);
                    JOptionPane.showMessageDialog(panneauPrincipal, panneauHistorique.getPanel(), "Historique", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "OK":
                    panneauPrincipal.setVisible(true);
                    fenetre = (MainFrame)panneauPrincipal.getTopLevelAncestor();
                    fenetre.setTitle(MainFrame.TITRE);//+" - Connecté"
                    break;
                case "NOUVEAU":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal,"Nouveau refusé");
                    }
                    else {
                        panneauPrincipal.cacherPanneauConnexion();
                        panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK")+2).trim();
                        panneauPrincipal.ajouterCompte(str);
                    }
                    break;
                case "CONNECT":
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("NO")) {
                        JOptionPane.showMessageDialog(panneauPrincipal,"Connexion refusée");
                    }
                    else {
                        panneauPrincipal.cacherPanneauConnexion();
                        panneauPrincipal.montrerPanneauCompteClient();
                        str = arg.substring(arg.indexOf("OK")+2).trim();
                        t = str.split(":");
                        for (String s:t) {
                            panneauPrincipal.ajouterCompte(s.substring(0,s.indexOf("]")+1));
                        }
                    }
                    break;
                /******************* SÉLECTION DE COMPTES *******************/
                case "EPARGNE" :
                    arg = evenement.getArgument();
                    if (arg.trim().startsWith("YES")) {
                        panneauPrincipal.ajouterCompte(arg);
                    } else {
                        JOptionPane.showMessageDialog(panneauPrincipal, "Vous possédez déjà un compte épargne");
                    }
                    break;
                case "SELECT" :
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal,"SELECT "+arg);
                    String[] argSplite = arg.split(" ");
                    panneauPrincipal.setSolde(argSplite[argSplite.length-1]);
                    break;

                /******************* OPÉRATIONS BANCAIRES *******************/
                case "DEPOT" :
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal,"DEPOT "+arg);
                    if (arg.contains("OK ")){
                        String solde = arg.replace("OK ", "");
                        panneauPrincipal.setSolde(solde);
                    }
                    break;
                case "RETRAIT" :
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal,"RETRAIT "+arg);
                    if (arg.contains("OK ")){
                        String solde = arg.replace("OK ", "");
                        panneauPrincipal.setSolde(solde);
                    }
                    break;
                case "FACTURE" :
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal,"FACTURE" + arg);
                    if (arg.contains("OK ")){
                        String solde = arg.replace("OK ", "");
                        panneauPrincipal.setSolde(solde);
                    }
                    break;
                case "TRANSFER" :
                    arg = evenement.getArgument();
                    JOptionPane.showMessageDialog(panneauPrincipal,"TRANSFER " + arg);
                    if (arg.contains("OK ")){
                        String solde = arg.replace("OK ", "");
                        panneauPrincipal.setSolde(solde);
                    }
                    break;
                /******************* TRAITEMENT PAR DÉFAUT *******************/
                default:
                    System.out.println("RECU : "+evenement.getType()+" "+evenement.getArgument());
            }
        }
    }
}