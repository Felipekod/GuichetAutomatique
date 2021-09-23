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
public class MargeDeCredit extends Compte {
    
     private double solde = 0;
     private double limite = 1000;
    
    public MargeDeCredit(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 4);
    }
    
    public void setLimite(int limite){
        this.limite = limite;
    }
    
    public double getLimite(){
        return this.limite;
    }
    
    public double getSolde(){
        return this.solde;
    }
    
    public boolean depotMargeCredit(double depotCredit){
        boolean success = true;
        boolean limiteAtteinte = false;
        //on teste le limite de credit
        if(depotCredit + this.solde > limite) 
            limiteAtteinte = true;
        if(depotCredit > 0 && limiteAtteinte == false)
            this.solde += depotCredit;
        else 
            success = false;
            return success;
    }
    

    
}