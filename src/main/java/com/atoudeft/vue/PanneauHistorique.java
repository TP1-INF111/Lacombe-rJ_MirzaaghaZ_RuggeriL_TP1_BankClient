package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

public class PanneauHistorique {
    // Trouver un nom francais a scrollPane
    private JScrollPane scrollPane;
    private JPanel panneauHistorique;
    private JTextArea listeHistorique;

    public PanneauHistorique() {
        //scrollPane = new JScrollPane();
        panneauHistorique = new JPanel();
        //listeHistorique = new JTextArea();
        //listeHistorique.setEditable(false);
//
        //panneauHistorique.setLayout(new BorderLayout());
        //scrollPane.add(listeHistorique);
        //scrollPane.setSize(400, 400);
        //panneauHistorique.add(scrollPane, BorderLayout.CENTER);
        listeHistorique = new JTextArea();
        listeHistorique.setEditable(false);
        scrollPane = new JScrollPane(listeHistorique);

        panneauHistorique.setLayout(new BorderLayout());
        scrollPane.setPreferredSize(new Dimension(600, 300));
        panneauHistorique.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() { return panneauHistorique; }
    /**
     * Change le texte dans la listeHistorique
     * @param historique envoyer par le serveur
     */
    public void setListeHistorique(String historique) {
        listeHistorique.setText(historique);
    }
}
