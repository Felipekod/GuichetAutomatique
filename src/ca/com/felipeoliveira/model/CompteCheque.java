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
public class CompteCheque extends Compte{
    
    private double solde = 0;
    
    
    public CompteCheque(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 1);
    }
    
    //Getters and setters
    public double getSolde(){
        return this.solde;
    }
    
    public void setSolde(double solde){
        this.solde = solde;
    }
    
    public boolean depot(double montant){
        boolean depotReussit = true;
        
            if(montant > 0) 
                this.solde = this.solde + montant;
            else 
                depotReussit = false;
            
        return depotReussit;
    }
    
}