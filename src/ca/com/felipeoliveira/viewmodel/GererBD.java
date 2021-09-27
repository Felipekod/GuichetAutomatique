/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;


import ca.com.felipeoliveira.model.Transaction;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author felipeoliveira
 */
public class GererBD {
    
    private final ConnexionSQLite connexion;
    
    public GererBD(ConnexionSQLite connexion){
        this.connexion = connexion;
    }
    
    public void creerTableClient(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_clients(codeClient text PRIMARY KEY NOT NULL, nom text NOT NULL, prenom text NOT NULL, telephone text NOT NULL, nip text NOT NULL, essaieLogin integer)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connexion.connect();
            
            Statement stmt = this.connexion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela clients cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connexion.deconnecter();
        }
    }
    
        public void creerTableComptes(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_comptes(type int, numero text PRIMARY KEY, codeTitulaire text, solde real, limite real)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connexion.connect();
            
            Statement stmt = this.connexion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela cheques cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connexion.deconnecter();
        }

    }
        
    public void creerTableTransaction(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_transaction(numero_transaction integer PRIMARY KEY AUTOINCREMENT, transaction_type integer NOT NULL, compte_source text, compte_destin text, valeur real, quand text)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connexion.connect();
            
            Statement stmt = this.connexion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela transaction cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connexion.deconnecter();
        }
    }
    
    public boolean enregistrerSolde(String numeroCompte, double solde){
        boolean succes = true;
        boolean connecter = false;
        String sql = "UPDATE tbl_comptes SET solde = " + solde + " WHERE numero = '" + numeroCompte + "';";
        try{
            connecter = this.connexion.connect();
            Statement stmt = this.connexion.statement();
            stmt.execute(sql);
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            succes = false;
        }
        finally{
            if(connecter) this.connexion.deconnecter();
        }
        return succes;
    }
        
     public boolean enregistrerTransaction(int type, String compteSource, String compteDestin, double valeur){
            boolean succes = true;
            boolean connecter = false;
            //On cree la trnasaction
            Transaction transaction = new Transaction(type,compteSource, compteDestin, valeur);
            //On enregistre la date en String
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String quand = formatter.format(date);
            
            System.out.println("Enregistrer methode " + compteDestin);
            
            //On cree la string query
            String sqlInsert = "INSERT INTO tbl_transaction (transaction_type, compte_source, compte_destin, valeur, quand) VALUES(?,?,?,?,?)";
            try{
                //On oeuvre la connexion
                connecter = this.connexion.connect();
                //On cree le preparedStatement
                PreparedStatement preparedStatement = connexion.preparedStatement(sqlInsert);
                
                preparedStatement.setInt(1, transaction.getTransactionType()); 
                preparedStatement.setString(2, transaction.getCompteSource());
                preparedStatement.setString(3, transaction.getCompteDestin());
                preparedStatement.setDouble(4, transaction.getValeur());
                preparedStatement.setString(5, quand);
                   
                int result = preparedStatement.executeUpdate();

                if(result == 1){
                    System.out.println("Insert ok");
                    System.out.println(transaction.getCompteDestin());
                }
                else{
                    System.out.println("Insert fail");
                    succes = false;
                }
                
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
            finally{
                if(connecter) this.connexion.deconnecter();
            }
            return succes;
        }
        
     
      

    
}
