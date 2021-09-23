/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.model;

/**
 *
 * @author felipeoliveira
 */
public class Client {
    
    private String codeClient;
    private String nom;
    private String prenom;
    private String telephone;
    private String NIP;
    private int essaieLogin = 0;
    private static int total = 0;
   
    
    public Client(String codeClient, String nom, String prenom, String telephone, String NIP){
        Client.total ++;
        this.NIP = NIP;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.codeClient = codeClient;
    }
    
    public int getEsssaieLogin(){
        return this.essaieLogin;
    }
    
    public void setEssaieLogin(int essaieLogin){
        this.essaieLogin = essaieLogin;
    }
    
    public String getCodeClient(){
        return this.codeClient;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public String getNIP(){
        return this.NIP;
    }
    
}
