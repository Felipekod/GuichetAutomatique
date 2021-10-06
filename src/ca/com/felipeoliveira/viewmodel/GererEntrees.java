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
public class GererEntrees {
    
    Frames frame = new Frames();
    
    public boolean isInt(String str) { 
          try {  
            Integer.parseInt(str);  
            return true;
          } catch(NumberFormatException e){  
            return false;  
          }  
        }
        
    public boolean isDouble(String str) { 
          try {  
            Double.parseDouble(str);  
            return true;
          } catch(NumberFormatException e){  
            return false;  
          }  
        }
    
    public boolean isTelFifteenChars(String str) {
    if(str.length() <= 15)     {
        return true;
    }  
    else{
        frame.maxFiftenCaractères();
        return false;
    } 
}
    
    public boolean isFourDigits(String str) {
    if(str.length() == 4) {
        return true;
    }  
    else{
        frame.nipLenNonValide();
        return false;
    }
}
    
    public boolean isFullname(String str) {
    String expression = "^[a-zA-Z\\s]+"; 
    if(!str.matches(expression))
    frame.nomNonValide();
    return str.matches(expression);        
    }
}


