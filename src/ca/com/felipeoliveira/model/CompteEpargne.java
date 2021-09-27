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
public class CompteEpargne extends Compte {
    
    //private double solde = 0;
    
    public CompteEpargne(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 2);
    
    
    }
    
    public boolean depot(double montant){
        boolean depotReussit = true;
        
            if(montant > 0) 
                this.solde = this.solde + montant;
            else 
                depotReussit = false;
            
        return depotReussit;
    }
    
    public boolean retrait(double valeur){
        boolean succes = true;
        if(valeur - this.solde < 0){
            this.solde -= valeur; 
        }
        
        return succes;
    }
}
