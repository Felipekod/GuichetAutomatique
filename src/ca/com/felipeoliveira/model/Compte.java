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
    
    protected final int COMPTE_CHEQUE = 1;
    protected final int COMPTE_EPARGNE = 2;
    protected final int COMPTE_HYPOTHECAIRE = 3;
    protected final int COMPTE_MARGECREDIT = 4;
    
    private String  numero;
    private String codeTitulaire;
    private static int total = 0;
    private int compteType;
    
    
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
    
    
}
