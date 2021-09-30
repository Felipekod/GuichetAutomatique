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
public abstract class Compte {
    
    public final int COMPTE_CHEQUE = 1;
    public final int COMPTE_EPARGNE = 2;
    public final int COMPTE_HYPOTHECAIRE = 3;
    public final int COMPTE_MARGECREDIT = 4;
    
    protected String  numero;
    private String codeTitulaire;
    private static int total = 0;
    private int compteType;
    protected double solde = 0;
    
    
    public Compte(String numero, String codeTitulaire, int compteType){
        Compte.total++;
        this.numero = numero;
        this.codeTitulaire = codeTitulaire;
        this.compteType = compteType;
    }
    
    public String getNumero(){
        return this.numero;
    }
    
    public int getType(){
        return this.compteType;
    }
    
    public String getCodeTitulaire(){
        return this.codeTitulaire;
    }
    
       public double getSolde(){
        return this.solde;
    }
    
    public void setSolde(double solde){
        this.solde = solde;
    }
    
    
}
