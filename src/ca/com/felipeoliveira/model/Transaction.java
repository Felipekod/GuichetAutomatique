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
    private String quand;
    int numeroTransaction;
    
    public Transaction(int transactionType, String compteSource, String compteDestin, double valeur){
        this.transactionType = transactionType;
        this.compteSource = compteSource;
        this.compteDestin = compteDestin;
        this.valeur = valeur;
    }
    
    public Transaction(int transactionType, String compteSource, String compteDestin, double valeur, String quand, int numeroTransaction){
        this.transactionType = transactionType;
        this.compteSource = compteSource;
        this.compteDestin = compteDestin;
        this.valeur = valeur;
        this.quand = quand;
        this.numeroTransaction = numeroTransaction;
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
    
    public String getQuand(){
        return this.quand;
    }
    
    public int getNumeroTransaction(){
        return this.numeroTransaction;
    }
            
}
