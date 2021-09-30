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
    private int limite = 20000;
    Frames frame = new Frames();
    
    public Guichet(double solde){
        this.solde = solde;
    }
    
    
    public double getSolde(){
        return this.solde;
    }
    public void retrait(double valeur){
        this.solde -= valeur;
    }
    
    public boolean setSoldePlus5k(){
        if(this.solde >= limite){
            frame.soldeGuicheAtteint();
            return false;
        }
        else{
            double nvSolde = this.solde + 5000 ;
           
            if(nvSolde >= limite) this.solde = 20000;
            else this.solde = nvSolde;
            return true;
        }
    }
}
