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
public class Data {
    
    List<List<Valor>> dataMatriz;

    public Data() {
        dataMatriz = new ArrayList();
    }

    public List<List<Valor>> getDataMatriz() {
        return dataMatriz;
    }

    public void setDataMatriz(List<List<Valor>> dataMatriz) {
        this.dataMatriz = dataMatriz;
    }
      
    public void agregarArreglo(List<Valor> linea){
        dataMatriz.add(linea);
    }
    
//    void agregarArreglo(String[] arreglo) {
//        dataMatriz.add(arreglo);
//    }
   
}


