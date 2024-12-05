package com.atoudeft.controleur;

import com.atoudeft.client.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurListeComptes extends MouseAdapter {

    private Client client;
    public EcouteurListeComptes(Client client) {
        this.client = client;
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JList<?> list = (JList<?>) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());
            if (index != -1) {
                Object item = list.getModel().getElementAt(index);
                String compte = (String) item;
                if (compte.contains("EPARGNE")){
                    client.envoyer("SELECT epargne");
                }
                else if (compte.contains("CHEQUE")){
                    client.envoyer("SELECT cheque");
                }
            }
        }
    }
}
