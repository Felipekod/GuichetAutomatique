/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;


import ca.com.felipeoliveira.model.Client;
import ca.com.felipeoliveira.model.Compte;
import ca.com.felipeoliveira.model.CompteCheque;
import ca.com.felipeoliveira.model.MargeDeCredit;
import ca.com.felipeoliveira.model.Transaction;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author felipeoliveira
 */
public class GererBD {
    
    private final ConnexionSQLite connexion;
    Statement statement = null;
    ResultSet resultSet = null;
    
    public GererBD(ConnexionSQLite connexion){
        this.connexion = connexion;
    }
//Methodes CREATE
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
    
    public void creerTableGuichet(){
        String sql = "CREATE TABLE IF NOT EXISTS tbl_guichet(id INTEGER PRIMARY KEY AUTOINCREMENT,montant_disponible real,limite real)";
        
        //boolean pour verifier le succes dans la connexion 
        boolean connecte = false;
        
        try{
            connecte = this.connexion.connect();
            
            Statement stmt = this.connexion.statement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela guichet cree");
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
    
//Methodes UPDATE
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
    
    public boolean enregistrerLimiteCredit(String numeroCompte, int limite){
        boolean succes = true;
        boolean connecter = false;
        String sql = "UPDATE tbl_comptes SET limite = " + limite + " WHERE numero = '" + numeroCompte + "';";
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
    
    public boolean enregistrerSoldeGuichet(double solde){
        boolean succes = true;
        boolean connecter = false;
        String sql = "UPDATE tbl_guichet SET montant_disponible = " + solde + " WHERE id = 1;";
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
        
   public boolean loginClient(int clientStatus, String codeClient){
        boolean succes = true;
        boolean connecter = false;
        String sql = "UPDATE tbl_clients SET essaieLogin = " + clientStatus + " WHERE codeClient = '" + codeClient + "';";
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
// Methodes INSERT
    public boolean insererMargeCredit(String codeTitulaire){
        boolean succes = true;
        
        return succes;
    }
    
    public boolean insererCompteHypothecaire(String codeTitulaire){
        boolean succes = true;
        
        return succes;
    }
    
    public boolean insererCompteEparne(String codeTitulaire){
        boolean succes = true;
        
        return succes;
    }
      
    public boolean insererCompte(String codeTitulaire, int type){
        boolean succes = true;
        String numeroCompte = recupererNumeroCompte();
        Compte compte = new CompteCheque(numeroCompte, codeTitulaire);
        double limite = 0;
          
          try{
              connexion.connect();
              String sql = "INSERT INTO tbl_comptes (type, numero, codeTitulaire, solde, limite) VALUES(?,?,?,?,?);";
              //On cree le preparedStatement
               PreparedStatement preparedStatement = connexion.preparedStatement(sql);
               preparedStatement.setInt(1,compte.getType());
               preparedStatement.setString(2,compte.getNumero());
               preparedStatement.setString(3,compte.getCodeTitulaire());
               preparedStatement.setDouble(4,compte.getSolde());
               preparedStatement.setDouble(5,limite);
               
               int result = preparedStatement.executeUpdate();

                if(result == 1){
                    System.out.println("Insert compteCheque ok");
                }
                else{
                    System.out.println("Insert fail");
                    succes = false;
                }
              
          }catch(SQLException e){
              e.printStackTrace();
          }finally{
              connexion.deconnecter();
          }
        return succes;
    }
    
    public boolean insererTransaction(int type, String compteSource, String compteDestin, double valeur){
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
    
    public boolean insererClient(String codeClient, String nom, String prenom, String telephone, String nip){
          boolean succes = true;
          //On cree le client
          Client client = new Client(codeClient, nom, prenom, telephone, nip);
          
          try{
              connexion.connect();
              String sql = "INSERT INTO tbl_clients (codeClient, nom, prenom, telephone, nip) VALUES(?,?,?,?,?);";
              //On cree le preparedStatement
               PreparedStatement preparedStatement = connexion.preparedStatement(sql);
               preparedStatement.setString(1,client.getCodeClient());
               preparedStatement.setString(2,client.getNom());
               preparedStatement.setString(3,client.getPrenom());
               preparedStatement.setString(4,client.getTelephone());
               preparedStatement.setString(5,client.getNIP());
               
               int result = preparedStatement.executeUpdate();

                if(result == 1){
                    System.out.println("Insert ok");
                }
                else{
                    System.out.println("Insert fail");
                    succes = false;
                }
              
          }catch(SQLException e){
              e.printStackTrace();
          }finally{
              connexion.deconnecter();
          }
          
          return succes;
      }
    
    public boolean insererGuichet(){
        boolean succes = true;
          try{
              connexion.connect();
              String sql = "INSERT INTO tbl_guichet (montant_disponible, limite) VALUES(?,?);";
              //On cree le preparedStatement
               PreparedStatement preparedStatement = connexion.preparedStatement(sql);
               preparedStatement.setDouble(1,10000);
               preparedStatement.setDouble(2,20000);
               
               int result = preparedStatement.executeUpdate();

                if(result == 1){
                    System.out.println("Insert guichet ok");
                }
                else{
                    System.out.println("Insert fail");
                    succes = false;
                }
              
          }catch(SQLException e){
              e.printStackTrace();
          }finally{
              connexion.deconnecter();
          }
        return succes;
    }
    
//Methodes SELECT
    public Client retournerClient(String codeClient){
        
           //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
           String sql = "SELECT * FROM tbl_clients WHERE codeClient = '" + codeClient + "';";
           Client client = null;
           try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   String nom = resultSet.getString("nom");
                   String prenom = resultSet.getString("prenom");
                   String telephone = resultSet.getString("telephone");
                   String nip = resultSet.getString("nip");
                   int essaieLogin = resultSet.getInt("essaieLogin");
                   client = new Client(codeClient, nom, prenom, telephone, nip, essaieLogin);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
           
           return client;
    }
    
    public List<Transaction> retournerTransactions(String codeClient){
        String sql = "SELECT numero_transaction, transaction_type,  compte_source, compte_destin, valeur,  quand FROM tbl_clients INNER JOIN tbl_comptes ON tbl_clients.codeClient = tbl_comptes.codeTitulaire AND tbl_comptes.codeTitulaire = '" + codeClient + "' INNER JOIN tbl_transaction ON tbl_comptes.numero = tbl_transaction.compte_destin OR tbl_comptes.numero = tbl_transaction.compte_source;";
        
        List<Transaction> transactions  = new ArrayList();
        
        //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
        try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   int numeroTransaction = resultSet.getInt("numero_transaction");
                   int typeTransaction = resultSet.getInt("transaction_type");
                   String compteSource = resultSet.getString("compte_source");
                   String compteDestin = resultSet.getString("compte_destin");
                   double valeur = resultSet.getDouble("valeur");
                   String quand = resultSet.getString("quand");
                   
                   Transaction transaction = new Transaction(typeTransaction, compteSource, compteDestin, valeur, quand, numeroTransaction);
                   transactions.add(transaction);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
        
        return transactions;
        
    }
    
    public String recupererNumeroClient(){
           String sql = "SELECT COUNT(*) as quantiteClients FROM tbl_clients;";
           String numeroClient = "";
           //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
           try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   int numero = resultSet.getInt("quantiteClients");
                   numeroClient = String.format("%06d", Integer.parseInt("" + numero));
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
           
           return numeroClient;
       }
       
    public String recupererNumeroCompte(){
           String sql = "SELECT COUNT(*) as quantiteComptes FROM tbl_comptes";
           String numeroClient = "";
           //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
           try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   int numero = resultSet.getInt("quantiteComptes");
                   numeroClient = String.format("%05d", Integer.parseInt("" + numero));
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
           
           return numeroClient;
       }
    
    public MargeDeCredit retournerCredit(String codeClient){
        String sql = "SELECT * from tbl_comptes where type = 4 AND codeTitulaire ='" + codeClient + "';";
        
        MargeDeCredit credit = null;
        
        //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
        try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   String numeroCompte = resultSet.getString("numero");
                   int limite = resultSet.getInt("limite");
                   double solde = resultSet.getDouble("solde");
                   
                    credit = new MargeDeCredit(numeroCompte,codeClient);
                    credit.setLimite(limite);
                    credit.setSolde(solde);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
        
        return credit;
        
    }
    
    public Guichet retournerGuichet(){
        String sql = "SELECT * from tbl_guichet where id = 1;";
        
        Guichet guichet = null;
        //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
        try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   double solde = resultSet.getDouble("montant_disponible");
                   
                    guichet = new Guichet(solde);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
        
        return guichet;
        
    }
    
    public List<CompteCheque> retournerListCheque(){
        String sql = "SELECT * FROM tbl_comptes where type = 1";
        
        List<CompteCheque> cheques  = new ArrayList();
        
        //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
        try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   String numero = resultSet.getString("numero");
                   String codeTitulaire = resultSet.getString("codeTitulaire");
                   double solde = resultSet.getDouble("solde");
                   
                   CompteCheque cheque = new CompteCheque(numero, codeTitulaire);
                   cheque.setSolde(solde);
                   cheques.add(cheque);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
        
        return cheques;
        
    }
    
    public List<MargeDeCredit> retournerListCredit(){
        String sql = "SELECT * FROM tbl_comptes where type = 4";
        
        List<MargeDeCredit> credits  = new ArrayList();
        
        //On ouvre la connexion sql
           connexion.connect();
           statement = connexion.statement();
        try{
               resultSet = statement.executeQuery(sql);
               while(resultSet.next()){
                   String numero = resultSet.getString("numero");
                   String codeTitulaire = resultSet.getString("codeTitulaire");
                   double solde = resultSet.getDouble("solde");
                   
                   MargeDeCredit credit = new MargeDeCredit(numero, codeTitulaire);
                   credit.setSolde(solde);
                   credits.add(credit);
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           finally{
               connexion.deconnecter();
           }
        
        return credits;
        
    }
    
    
}
