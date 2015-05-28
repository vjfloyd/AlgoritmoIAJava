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
    private ArrayList<Valor> vaValores;
    
    public Variable(){
        vaValores = new ArrayList<Valor>();
        
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
        return vaValores;
    }

    public void setValores(List<Valor> valores) {
        this.vaValores = (ArrayList<Valor>) valores;
    }

    public void agregarValor(Valor v){
        vaValores.add(v);
    }
    
    public Valor getValor(int indice){
        return vaValores.get(indice);
    }
    
    
}
