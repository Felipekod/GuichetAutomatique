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
public class CompteCheque extends Compte{
    
    
    public CompteCheque(String numero, String codeTitulaire){
        super(numero, codeTitulaire, 1);
    }
    
    //Getters and setters
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
        if(valeur - this.solde <= 0){
            this.solde -= valeur; 
        }
        else{
            succes = false;
        }
        
        return succes;
    }
     
     public boolean retrait(double valeur, MargeDeCredit credit, GererBD gererBD){
        boolean succes = true;
        boolean utiliseCredit = false;
        if(valeur - this.solde <= 0){
            this.solde -= valeur; 
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
     
     public boolean paiementFacture(double valeur){
        boolean succes = true;
        if(valeur - this.solde <= 0){
            this.solde -= valeur; 
        }
        else{
            succes = false;
        }
        
        return succes;
    }
    
    public boolean transfertSolde(Compte compteDestin, double valeur){
        boolean succes = true;
        if(this.solde >= valeur)
        {
            //On verifie la solde de la compte destin
            double soldeCompteDestin =  compteDestin.getSolde();
            //On enleve la valeur de la compte source
            this.solde -= valeur;
            //On set la nouvelle solde de la compte destin
            compteDestin.setSolde(soldeCompteDestin + valeur);
        }
        else{
            succes = false;
        }
        return succes;
    }
    
    public boolean transfertSolde(MargeDeCredit compteDestin, double valeur){
        boolean succes = true;
        if(this.solde > valeur)
        {
            //On verifie la solde de credit de la compte destin
            double soldeCredit = compteDestin.getSolde();
            //Si la valeur est moins grande ou egale que la solde de credit
            if(valeur <= soldeCredit){
                //On enleve la valeur de la compte source
                this.solde -= valeur;
                //On set la nouvelle solde de la compte destin
                compteDestin.setSolde(soldeCredit - valeur);
            }
            //Si la valeur est plus grande que la solde de credit
            //om envele juste le montant du credit
            else{
                valeur = soldeCredit;
                //On enleve la valeur de la compte source
                this.solde -= valeur;
                //On set la nouvelle solde de la compte destin
                compteDestin.setSolde(soldeCredit - valeur);
            }
           
        }
        else{
            succes = false;
        }
        return succes;
    }
    
    public boolean payerInteret(GererBD gererBD){
        boolean succes = true;
        double interet = this.solde * 0.01;
        this.solde += interet;
        succes = gererBD.enregistrerSolde(this.numero, solde);
        return succes;
    }
    
}
