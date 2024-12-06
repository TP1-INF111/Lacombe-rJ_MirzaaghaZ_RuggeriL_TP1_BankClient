package com.atoudeft.vue;

import com.atoudeft.client.Client;
import com.atoudeft.controleur.EcouteurConnexion;
import com.atoudeft.controleur.EcouteurListeComptes;
import com.atoudeft.controleur.EcouteurOperationsCompte;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2024-11-01
 */
public class PanneauPrincipal  extends JPanel {
    private Client client;
    private PanneauConnexion panneauConnexion;
    private JPanel panneauCompteClient;
    private PanneauOperationsCompte panneauOperationsCompte;
    private EcouteurOperationsCompte ecouteurOperationsCompte;

    private DefaultListModel<String> numerosComptes;
    private JList<String> jlNumerosComptes;
    private JDesktopPane bureau;

    private PanneauDepot panneauDepot;
    private PanneauRetrait panneauRetrait;
    private PanneauFacture panneauFacture;
    private PanneauTransfert panneauTransfert;

    private String nouveauSolde;

    public PanneauPrincipal(Client client) {
        this.client = client;

        panneauConnexion = new PanneauConnexion();
        panneauConnexion.setEcouteur(new EcouteurConnexion(client,panneauConnexion));

        panneauOperationsCompte = new PanneauOperationsCompte();

        panneauCompteClient = new JPanel();

        panneauCompteClient.setLayout(new BorderLayout());
        panneauCompteClient.setBackground(Color.WHITE);
        panneauOperationsCompte.setBackground(Color.WHITE);

        numerosComptes = new DefaultListModel<>();

        jlNumerosComptes = new JList<>(numerosComptes);
        jlNumerosComptes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        jlNumerosComptes.setBorder(BorderFactory.createTitledBorder("Comptes bancaires"));
        jlNumerosComptes.setPreferredSize(new Dimension(250,500));


        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);
        //Enregistrement de l'écouteur de souris:
        jlNumerosComptes.addMouseListener(new EcouteurListeComptes(client));

        this.setLayout(new BorderLayout());

        this.add(panneauConnexion, BorderLayout.NORTH);
        this.add(panneauCompteClient, BorderLayout.CENTER);
        panneauCompteClient.setVisible(false);

        ecouteurOperationsCompte = new EcouteurOperationsCompte(client, this);
        panneauOperationsCompte.setEcouteur(ecouteurOperationsCompte);
        panneauDepot = new PanneauDepot();
        panneauRetrait = new PanneauRetrait();
        panneauFacture = new PanneauFacture();
        panneauTransfert = new PanneauTransfert();

        panneauDepot.setEcouteur(ecouteurOperationsCompte);
        panneauRetrait.setEcouteur(ecouteurOperationsCompte);
        panneauFacture.setEcouteur(ecouteurOperationsCompte);
        panneauTransfert.setEcouteur(ecouteurOperationsCompte);
    }

    /**
     * Ajoute le panneau sélectionné et enleve tous les autres
     * @param panel choisi sur la navbar
     */
    public void ajoutPanelOperations(String panel){
        panneauCompteClient.removeAll();
        panneauCompteClient.add(panneauOperationsCompte, BorderLayout.NORTH);
        panneauCompteClient.add(jlNumerosComptes, BorderLayout.WEST);

        switch (panel) {
            case "DEPOT":
                panneauCompteClient.add(panneauDepot, BorderLayout.CENTER);
                panneauCompteClient.revalidate();
                panneauCompteClient.repaint();
                break;
            case "RETRAIT":
                panneauCompteClient.add(panneauRetrait, BorderLayout.CENTER);
                panneauCompteClient.revalidate();
                panneauCompteClient.repaint();
                break;
            case "FACTURE":
                panneauCompteClient.add(panneauFacture, BorderLayout.CENTER);
                panneauCompteClient.revalidate();
                panneauCompteClient.repaint();
                break;
            case "TRANSFER":
                panneauCompteClient.add(panneauTransfert, BorderLayout.CENTER);
                panneauCompteClient.revalidate();
                panneauCompteClient.repaint();
                break;
        }
    }

    /**
     * Cherche les informations entrées du client selon l'opération sélectionné
     * @param commande est le bouton envoyer de l'opération sélectionnée
     * @return La String des informations à envoyer au serveur
     */
    public String getEntree(String commande){
        switch (commande) {
            case "DEPOT ENVOYER":
                String depotMontant = panneauDepot.getMontant();
                panneauDepot.effaceEntree();
                return depotMontant;
            case "RETRAIT ENVOYER":
                String retraitMontant = panneauRetrait.getMontant();
                panneauRetrait.effaceEntree();
                return retraitMontant;
            case "FACTURE ENVOYER":
                String factMontant = panneauFacture.getMontant();
                String factNum = panneauFacture.getNumFacture();
                String factDescription = panneauFacture.getDescrition();
                panneauFacture.effaceEntree();
                return factMontant + " " + factNum + " " + factDescription;
            case "TRANSFER ENVOYER":
                String transferMontant = panneauTransfert.getMontant();
                String transferNum = panneauTransfert.getNumCompte();
                panneauTransfert.effaceEntree();
                return transferMontant + " " + transferNum;
        }
        return "";
    }

    public void effacerEntree(String commande) {
        switch (commande){
            case "DEPOT ANNULER":
                panneauDepot.effaceEntree();
                break;
            case "RETRAIT ANNULER":
                panneauRetrait.effaceEntree();
                break;
            case "FACTURE ANNULER":
                panneauFacture.effaceEntree();
                break;
            case "TRANSFER ANNULER":
                panneauTransfert.effaceEntree();
                break;
        }
    }

    /**
     * Vide les éléments d'interface du panneauPrincipal.
     */
    public void vider() {
        this.numerosComptes.clear();
        this.bureau.removeAll();
    }
    public void cacherPanneauConnexion() {
        panneauConnexion.effacer();
        panneauConnexion.setVisible(false);
    }
    public void montrerPanneauConnexion() {
        panneauConnexion.setVisible(true);
    }
    public void cacherPanneauCompteClient() {
        panneauCompteClient.setVisible(false);
        this.numerosComptes.clear();
    }
    public void montrerPanneauCompteClient() {
        panneauCompteClient.setVisible(true);
    }
    /**
     * Affiche un numéro de compte dans le JList des comptes.
     *
     * @param str chaine contenant le numéros de compte
     */
    public void ajouterCompte(String str) {
        numerosComptes.addElement(str);
    }

    public void setSolde(String nouveauSolde){
        this.nouveauSolde = nouveauSolde;
        panneauOperationsCompte.reecritureSolde(nouveauSolde);
    }

    public String getSolde(){ return nouveauSolde; }

}