/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;

/**
 *
 * @author Vj
 */
public class ManejarCalculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Variable obj = new Variable();
        //LeerData objLeer = new LeerData();
        //objLeer.leerVA();
        LeerData objLeer2 = new LeerData();
        
        objLeer2.leerData();
        
       
        /*
                Para toda la columna de Datos
                    si vaA == columna_x entonces
                        contIncidenciasValor++
        
                PM(temp= hot) = contIncidencias / totalFilas;        
        */
        
        
    }
    
}
