/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vj
 */
public class LeerData {
    List<Variable> tempLista = new ArrayList<>();
       
    public List<Variable> leerVA() throws FileNotFoundException{
     Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt" ) );
       // Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
        String linea=""; 
        
        while( punteroArchivo.hasNextLine() ){
             linea = punteroArchivo.nextLine();
            try {
                    if ( linea.contains("attribute")) {
                        String temp = linea.toString().replace("{", "");
                        temp = temp.replace("@", "");
                        temp = temp.replace("}", "");
                        temp =  temp.replace(",", "");

                        String[] tempVariable = temp.split(" ");
                        String[] valores = new String[tempVariable.length-2]; 
                        Variable objVA = new Variable(); 
                        
                        for (int i = 0; i < tempVariable.length ; i++) {
                            if ( i == 1) {
                                objVA.setNombre(tempVariable[i]);
                            }
                            if ( i >= 2) {
                                 Valor valor = new Valor();
                                valor.setNombre(tempVariable[i]);
                                objVA.agregarValor(valor);
                            }
                            
                        }
                          tempLista.add(objVA);
                    }
                  
                } catch (Exception e) {
                }
        }
        return tempLista;
        
    }
    
    public List<List<String>> leerData(){
        return null;
    }
    
}