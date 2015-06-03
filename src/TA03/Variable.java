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
public class Variable {
    private String nombre;
    private List<Valor> valoresVA;
 
    public Variable(){
        valoresVA = new ArrayList();
    }
    
    public void agregarValor(Valor v){
        valoresVA.add(v);
    }
    
    public Valor getValor(int indice){
        return valoresVA.get(indice);
    }
    
    public double calculaProbabilidadMarginal(int numIncidencias, int total){
        return  numIncidencias/total;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Valor> getValores() {
        return valoresVA;
    }

    public void setValores(List<Valor> valores) {
        this.valoresVA = valores;
    }

   
}
