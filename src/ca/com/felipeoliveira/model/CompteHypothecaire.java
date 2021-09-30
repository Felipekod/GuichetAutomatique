/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.model;

import ca.com.felipeoliveira.viewmodel.GererBD;

/**
 *
 * @author felipeoliveira
 */
public class CompteHypothecaire extends Compte{
    
    public CompteHypothecaire(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 3);
    }
    public boolean depot(double montant){
        boolean depotReussit = true;
        
            if(montant > 0) 
                this.solde = this.solde + montant;
            else 
                depotReussit = false;
            
        return depotReussit;
    }
    
    public boolean prelevement(double valeur, MargeDeCredit credit, GererBD gererBD){
        boolean succes = true;
        boolean utiliseCredit = false;
        if(valeur - this.solde <= 0){
            this.solde -= valeur; 
            succes = gererBD.enregistrerSolde(credit.getNumero(), this.solde);
        }
        //Si la laveur de retrait n'est pas sufisant on verifie si le client a de credit
        else{
            if(credit != null){
                //On verifie la valeur moins ce que devrait rester dans la compte
               double valeurCreditDemande = (this.solde - valeur) * (-1);
               //On essaie de effectuer le retrait dans la marge de credit
               utiliseCredit = credit.retraitMargeCredit(valeurCreditDemande);
               if(utiliseCredit){
                   //Si le client utilise le credit on s'assure que la solde de cette compte est zero
                   this.solde = 0;
                   //On enregistre la solde du credit
                   boolean soldeCreditEnregistre = gererBD.enregistrerSolde(credit.getNumero(), credit.getSolde());
                   gererBD.enregistrerSolde(this.getNumero(), this.solde);
                   //S'il y a un erreur à la BD
                   if(!soldeCreditEnregistre) {
                       System.out.println("Enregistrer marge credit à la BD fail");
                       succes = false;
                   }
               }
               else succes = false;             
            }
        }
        return succes;
    }
    
}
