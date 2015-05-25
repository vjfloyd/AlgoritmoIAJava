/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.util.List;

/**
 *
 * @author Vj
 */
public class Variable {
    private String nombre;
    private List<Valor> listaValores;
    
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
        return listaValores;
    }

    public void setValores(List<Valor> valores) {
        this.listaValores = valores;
    }

    public void agregarValor(Valor v){
        listaValores.add(v);
    }
    
    public Valor getValor(int indice){
        return listaValores.get(indice);
    }
    
    
}
