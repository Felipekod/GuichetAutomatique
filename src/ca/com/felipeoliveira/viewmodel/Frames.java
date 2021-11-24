/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.com.felipeoliveira.viewmodel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author felipeoliveira
 */
public class Frames {
    
    //On apelle la fenetre JFrame pour declarer la defaite
    JFrame frame = new JFrame();
    
    public void soldeGuichetInsufisant(){
        JOptionPane.showMessageDialog(frame,
        "Désolé, le guichet n'a pas assez d'argent papier pour la transaction.");
    }
    
    public void exceptionRetrait(){
        JOptionPane.showMessageDialog(frame,
        "La valeur de la retraite doit être:"+ "\n" + "\n" +
                "       Multiple de dix" + "\n" +
                "       Inferieur ou egal à $1000");
    }
    
    public void limiteCreditAtteint(){
        JOptionPane.showMessageDialog(frame,
        "Désolé, la limite de credit a été atteint.");
    }
    
    public void soldeGuicheAtteint(){
        JOptionPane.showMessageDialog(frame,
        "$20000  atteint!" );
    }
    
    public void compteBloquee(){
        JOptionPane.showMessageDialog(frame,
        "Vous avez échouez trois fois le login, voulez contacter la banque." );
    }
    
    public void valeurIntLimiteCredit(){
        JOptionPane.showMessageDialog(frame,
        "Vouz devez saisir une valeur numerique entière" );
    }
    
    public void memeCompteTransaction(){
        JOptionPane.showMessageDialog(frame,
        "Voulez choisir une compte destin differente de la compte source." );
    }
    
    public void clientNomTrouve(){
        JOptionPane.showMessageDialog(frame,
        "Client nom trouvé" );
    }
    
    public void compteClientCree(String compte){
        JOptionPane.showMessageDialog(frame,
        "Client: " + compte + " créé" );
    }
    
    public void nomNonValide(){
        JOptionPane.showMessageDialog(frame,
        "Le nom ne doit pas contenir des caractères speciaux." );
    }
    
    public void nipLenNonValide(){
        JOptionPane.showMessageDialog(frame,
        "Le NIP doit contenir quartre caractères." );
    }
    public void maxFiftenCaractères(){
        JOptionPane.showMessageDialog(frame,
        "Le Telephone doit contenir au maximum 15 caractères" );
    }
    
    public void interetComptesCheques(){
        JOptionPane.showMessageDialog(frame,
        "L'interêt de 1% a été apliqué dans toutes les comptes cheques" );
    }
    
    public void interetCredit(){
        JOptionPane.showMessageDialog(frame,
        "L'interêt de 5% a été apliqué dans toutes les marges de crédits." );
    }
    
}
