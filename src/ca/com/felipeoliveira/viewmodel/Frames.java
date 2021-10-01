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
}
