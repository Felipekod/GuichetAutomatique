/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;

import ca.com.felipeoliveira.model.Client;
import ca.com.felipeoliveira.model.CompteCheque;
import ca.com.felipeoliveira.model.CompteEpargne;
import ca.com.felipeoliveira.model.CompteHypothecaire;
import ca.com.felipeoliveira.model.MargeDeCredit;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author felipeoliveira
 */
public class RemplirBD {
    
        ConnexionSQLite connexion = new ConnexionSQLite();
    
       //Teste inserir cliente --------------------------------------------------------------------------------------------
       
        public boolean remplirClients(){
            
            boolean reussite = true;
                
            for(int i = 0; i < 999; i++){

                String clientCode = String.format("%06d", Integer.parseInt(""+i));
                String clientNom = "Nom"+i;
                String clientPrenom = "Prenom"+i;
                String clientTelephone = String.format("%08d", Integer.parseInt(""+i));
                String clientNIP = String.format("%04d", Integer.parseInt(""+i));

                Client client = new Client(clientCode, clientPrenom, clientNom, clientTelephone, clientNIP);

                String sqlInsert = "INSERT INTO tbl_clients (codeClient, nom, prenom, telephone, nip, essaieLogin) VALUES(?,?,?,?,?,?)";

                connexion.connect();

                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);

                try{
                    System.out.println(client.getCodeClient());

                    preparedStatement.setString(1, client.getCodeClient());
                    preparedStatement.setString(2, client.getNom());
                    preparedStatement.setString(3, client.getPrenom());
                    preparedStatement.setString(4, client.getTelephone());
                    preparedStatement.setString(5, client.getNIP());
                    preparedStatement.setInt(6, 0);

                    int result = preparedStatement.executeUpdate();

                    if(result == 1){
                        System.out.println("Insert ok");

                    }
                    else{
                        System.out.println("Insert fail");
                        reussite = false;
                    }
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
                finally{
                    try{
                        if(preparedStatement != null){
                        preparedStatement.close();
                        }
                    }
                    catch(SQLException e){
                        System.err.println(e.getMessage());
                    }

                }

            }// ---
                 return reussite;
        }
        
        public boolean remplirComptesCheque(){
            
            boolean reussite = true;
                
            for(int i = 0; i < 999; i++){

                String clientCode = String.format("%06d", Integer.parseInt(""+i));
                int depot = randomSolde(3000, 2000000);
                String numeroCompte = String.format("%05d", Integer.parseInt(""+i));
                

                CompteCheque cc = new CompteCheque(numeroCompte, clientCode);
                cc.depot(depot);

                String sqlInsert = "INSERT INTO tbl_comptes (type, numero, codeTitulaire, solde) VALUES(?,?,?,?)";

                connexion.connect();

                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);

                try{
                    System.out.println(cc.getSolde());
                    
                    preparedStatement.setInt(1, cc.getType()); 
                    preparedStatement.setString(2, cc.getNumero());
                    preparedStatement.setString(3, cc.getCodeTitulaire());
                    preparedStatement.setDouble(4, cc.getSolde());
                    
                    

                    int result = preparedStatement.executeUpdate();

                    if(result == 1){
                        System.out.println("Insert ok");

                    }
                    else{
                        System.out.println("Insert fail");
                        reussite = false;
                    }
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
                finally{
                    try{
                        if(preparedStatement != null){
                        preparedStatement.close();
                        }
                    }
                    catch(SQLException e){
                        System.err.println(e.getMessage());
                    }

                }

            }// ---
                 return reussite;
        }
        
    public boolean remplirComptesEpargnes(){
            
            boolean reussite = true;
                
            for(int i = 0; i < 999; i++){
                int numeroEpargne = 998 + i;
                String clientCode = String.format("%06d", Integer.parseInt(""+ i));
                int depot = randomSolde(1000, 500000);
                String numeroCompte = String.format("%05d", Integer.parseInt(""+ numeroEpargne));
                
                CompteEpargne cc = new CompteEpargne(numeroCompte, clientCode);
                cc.depot(depot);

                String sqlInsert = "INSERT INTO tbl_comptes (type, numero, codeTitulaire, solde) VALUES(?,?,?,?)";

                connexion.connect();

                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);

                try{
                    System.out.println(cc.getSolde());
                    
                    preparedStatement.setInt(1, cc.getType()); 
                    preparedStatement.setString(2, cc.getNumero());
                    preparedStatement.setString(3, cc.getCodeTitulaire());
                    preparedStatement.setDouble(4, cc.getSolde());
                    
                    

                    int result = preparedStatement.executeUpdate();

                    if(result == 1){
                        System.out.println("Insert ok");

                    }
                    else{
                        System.out.println("Insert fail");
                        reussite = false;
                    }
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
                finally{
                    try{
                        if(preparedStatement != null){
                        preparedStatement.close();
                        }
                    }
                    catch(SQLException e){
                        System.err.println(e.getMessage());
                    }

                }

            }// ---
                 return reussite;
        }
        
    public boolean remplirComptesHypothecaire(){
            
            boolean reussite = true;
                
            for(int i = 0; i < 999; i++){
                int numeroEpargne = 1996 + i;
                String clientCode = String.format("%06d", Integer.parseInt("" + i));
                String numeroCompte = String.format("%05d", Integer.parseInt("" + numeroEpargne));
                
                CompteHypothecaire cc = new CompteHypothecaire(numeroCompte, clientCode);
                

                String sqlInsert = "INSERT INTO tbl_comptes (type, numero, codeTitulaire, solde) VALUES(?,?,?,?)";

                connexion.connect();

                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);

                try{
                    System.out.println(cc.getSolde());
                    
                    preparedStatement.setInt(1, cc.getType()); 
                    preparedStatement.setString(2, cc.getNumero());
                    preparedStatement.setString(3, cc.getCodeTitulaire());
                    preparedStatement.setDouble(4, cc.getSolde());
                    
                    

                    int result = preparedStatement.executeUpdate();

                    if(result == 1){
                        System.out.println("Insert ok");

                    }
                    else{
                        System.out.println("Insert fail");
                        reussite = false;
                    }
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
                finally{
                    try{
                        if(preparedStatement != null){
                        preparedStatement.close();
                        }
                    }
                    catch(SQLException e){
                        System.err.println(e.getMessage());
                    }

                }

            }// ---
                 return reussite;
        }
  
    public boolean remplirMargeCredit(){
            
            boolean reussite = true;
                
            for(int i = 0; i < 999; i++){
                int numeroEpargne = 2995 + i;
                String clientCode = String.format("%06d", Integer.parseInt("" + i));
                String numeroCompte = String.format("%05d", Integer.parseInt("" + numeroEpargne));
                
                MargeDeCredit cc = new MargeDeCredit(numeroCompte, clientCode);
                

                String sqlInsert = "INSERT INTO tbl_comptes (type, numero, codeTitulaire, solde, limite) VALUES(?,?,?,?,?)";

                connexion.connect();

                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);

                try{
                    System.out.println(cc.getSolde());
                    
                    preparedStatement.setInt(1, cc.getType()); 
                    preparedStatement.setString(2, cc.getNumero());
                    preparedStatement.setString(3, cc.getCodeTitulaire());
                    preparedStatement.setDouble(4, cc.getSolde());
                    preparedStatement.setDouble(5, cc.getLimite());
                    

                    int result = preparedStatement.executeUpdate();

                    if(result == 1){
                        System.out.println("Insert ok");

                    }
                    else{
                        System.out.println("Insert fail");
                        reussite = false;
                    }
                }catch(SQLException ex){
                    System.err.println(ex.getMessage());
                }
                finally{
                    try{
                        if(preparedStatement != null){
                        preparedStatement.close();
                        }
                    }
                    catch(SQLException e){
                        System.err.println(e.getMessage());
                    }

                }

            }// ---
                 return reussite;
        }
    
       
        private int randomSolde(int min, int max) {
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
        
           
}