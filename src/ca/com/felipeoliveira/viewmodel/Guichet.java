/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;

/**
 *
 * @author felipeoliveira
 */
public class Guichet {
    private double solde = 0;
    
    public double getSolde(){
        return this.solde;
    }
    
    public boolean setSoldePlus5k(){
        if(this.solde >= 20000){
            return false;
        }
        else{
            double nvSolde = this.solde + 5000 ;
           
            if(nvSolde >= 20000) this.solde = 20000;
            else this.solde = nvSolde;
            
            return true;
        }
    }
}
