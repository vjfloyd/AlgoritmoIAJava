/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vj
 */
public class ConjuntoVA {
 
    List<Variable> Variables;
    
    public ConjuntoVA(){
        Variables = new ArrayList<Variable>();        
    }
    
    public void agregar(Variable v){
        Variables.add(v);
    }
    
}
