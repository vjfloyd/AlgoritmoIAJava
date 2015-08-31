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
 * @author vjrojasb
 */
public class Relacion {
    private Variable vaA;
    private Variable vaB;
    private List<String> padres;
    private List<String> hijos;
    
    public Relacion(){
        padres = new ArrayList();
        hijos = new ArrayList();  
    }
    
    public void agregarHijo( String va){
        hijos.add(va);
    }
    
    public void agregarPadre( String va){
        padres.add(va);
    }
    

    public Variable getVaA() {
        return vaA;
    }

    public void setVaA(Variable vaA) {
        this.vaA = vaA;
    }

    public Variable getVaB() {
        return vaB;
    }

    public void setVaB(Variable vaB) {
        this.vaB = vaB;
    }

    public List<String> getPadres() {
        return padres;
    }

    public void String(List<String> padres) {
        this.padres = padres;
    }

    public List<String> getHijos() {
        return hijos;
    }

    public void setHijos(List<String> hijos) {
        this.hijos = hijos;
    }
    
    public String dameHijo(String padre){
        int indice = 0;
        for (int i = 0; i < padres.size(); i++) 
            if ( padres.get(i).equalsIgnoreCase(padre) ) 
                indice = i;
      
        return hijos.get(indice);
    }
    
    public String damePadre(String hijo){
        int indice = 0;
        for (int i = 0; i < hijos.size() ; i++) 
            if ( hijos.get(i).equalsIgnoreCase(hijo)) 
                indice = i;
            
        return padres.get(indice);
    }
}
