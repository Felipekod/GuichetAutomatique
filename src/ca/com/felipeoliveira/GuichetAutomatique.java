/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira;
import ca.com.felipeoliveira.view.*;
import ca.com.felipeoliveira.model.*;
import ca.com.felipeoliveira.viewmodel.*;
import java.sql.*;

/**
 *
 * @author felipeoliveira
 */
public class GuichetAutomatique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ConnexionSQLite connexion = new ConnexionSQLite();
        GererBD gererBD = new GererBD(connexion);
        
        //Cree la table tbl_clients si elle n'existe pas
        //gererBD.creerTableClient();
        //gererBD.creerTableComptes();
        //gererBD.creerTableTransaction();
        //gererBD.creerTableGuichet();
        

        //utiliser les methodes de la classe ReplirBD pour faire des tests
        RemplirBD remplirBD = new RemplirBD();
            //remplirBD.remplirComptesCheque();
            //remplirBD.remplirClients();
            //remplirBD.remplirComptesEpargnes();
            //remplirBD.remplirComptesHypothecaire();
            //remplirBD.remplirMargeCredit();
            //gererBD.insererGuichet();
        Login login = new Login();
        login.setVisible(true);  
    }
    
    
}
