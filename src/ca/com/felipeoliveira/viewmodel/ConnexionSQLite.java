/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author felipeoliveira
 */
public class ConnexionSQLite {
    
    private Connection connexion;
    
    /**
     * Methode pour connecter a la BD
     * @return 
     */
    public boolean connect(){
        try{
            String url = "jdbc:sqlite:bd/bd_sqlite.db";
            this.connexion = DriverManager.getConnection(url);
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        
        System.out.println("It works");
        return true;
    }
    
    public boolean deconnecter(){
        
        try{
            if(this.connexion.isClosed() == false){
                this.connexion.close();
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public Statement statement(){
        try{
            return this.connexion.createStatement();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
        public PreparedStatement preparedStatement(String sql){
        try{
            return this.connexion.prepareStatement(sql);
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public Connection getConnexion(){
        return this.connexion;
    }
    
}
