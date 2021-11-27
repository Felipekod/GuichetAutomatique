/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.model;

import ca.com.felipeoliveira.viewmodel.Frames;
import ca.com.felipeoliveira.viewmodel.GererBD;
import javax.swing.JFrame;

/**
 *
 * @author felipeoliveira
 */
public class MargeDeCredit extends Compte {

    private double limite;
    Frames frame = new Frames();
    
    public MargeDeCredit(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 4);
    }
    public void setLimite(int limite){
        this.limite = limite;
    }
    public double getLimite(){
        return this.limite;
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
    
    public boolean interetCredit(GererBD gererBD){
        boolean succes = true;
        double interet = this.solde * 0.05;
        this.solde += interet;
        succes = gererBD.enregistrerSolde(this.numero, this.solde);
        return succes;
    }
    
    public boolean retraitMargeCredit(double valeur){
        boolean succes = true;
        if(this.solde + valeur <= this.limite){
            this.solde += valeur;
        }
        else 
        {
            succes = false;
            System.out.println("Limite atteint dans la marge de credit");
            frame.limiteCreditAtteint();
            
        
        }
        return succes;
    }
    

    
}
