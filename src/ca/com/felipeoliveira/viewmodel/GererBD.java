/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;


import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felipeoliveira
 */
public class GererBD {
    
    private final ConnexionSQLite connextion;
    
    public GererBD(ConnexionSQLite connexion){
        this.connextion = connexion;
    }
    
    public void creerTableClient(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_clients(codeClient text PRIMARY KEY NOT NULL, nom text NOT NULL, prenom text NOT NULL, telephone text NOT NULL, nip text NOT NULL, essaieLogin integer)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connextion.connect();
            
            Statement stmt = this.connextion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela clients cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connextion.deconnecter();
        }
    }
    
        public void creerTableComptes(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_comptes(type int, numero text PRIMARY KEY, codeTitulaire text, solde real, limite real)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connextion.connect();
            
            Statement stmt = this.connextion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela cheques cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connextion.deconnecter();
        }

    }
        
    public void creerTableTransaction(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_transaction(numero_transaction integer PRIMARY KEY AUTOINCREMENT, transaction_type integer NOT NULL, compte_source text, compte_destin text)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connextion.connect();
            
            Statement stmt = this.connextion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela cheques cree");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        finally{
            if(connecte) this.connextion.deconnecter();
        }
    }
        
     
     
      

    
}
