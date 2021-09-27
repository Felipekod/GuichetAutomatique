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
public class Transaction {
    
    
    private int transactionType;
    private String compteSource;
    private String compteDestin;
    double valeur;
    int id;
    
    public Transaction(int transactionType, String compteSource, String compteDestin, double valeur){
        this.transactionType = transactionType;
        this.compteSource = compteSource;
        this.compteDestin = compteDestin;
        this.valeur = valeur;
    }
    
    public int getTransactionType(){
        return this.transactionType;
    }
    public String getCompteSource(){
        return this.compteSource;
    }
    public String getCompteDestin(){
        return this.compteDestin;
    }
    public double getValeur(){
        return this.valeur;
    }
    
            
}
