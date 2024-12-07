package com.atoudeft.vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;
    private JLabel labelAdr, labelPort;

    public PanneauConfigServeur(String adr, int port) {
        //à compléter
        labelAdr = new JLabel("Adresse IP : ");
        labelPort = new JLabel("Port : ");
        txtAdrServeur = new JTextField(adr);
        txtNumPort = new JTextField(Integer.toString(port));

        GridLayout gridLayout = new GridLayout(2, 2);
        this.setLayout(gridLayout);

        add(labelAdr);
        add(txtAdrServeur);
        add(labelPort);
        add(txtNumPort);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
