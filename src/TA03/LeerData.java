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
   
    public List<Variable> leerVA( String archivo ) throws FileNotFoundException{
     Scanner punteroArchivo = new Scanner( new FileReader( archivo ) );
       // Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
       String linea="";
       ConjuntoVA conjVA = new ConjuntoVA();
       
        while( punteroArchivo.hasNextLine() ){
             linea = punteroArchivo.nextLine();
            try {
                    if ( linea.contains("attribute")) {
                        String temp = linea.toString().replace("{", "");
                        temp = temp.replace("@", "");
                        temp = temp.replace("}", "");
                        temp =  temp.replace(",", "");

                        String[] tempVariable = temp.split(" ");
                       // String[] valores = new String[tempVariable.length-2]; 
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
                        conjVA.Variables.add(objVA);
                    }
                } catch (Exception e) {
                }
        }
        return conjVA.Variables;
    }
    public List<List<Valor>> leerData(String archivo  ) throws FileNotFoundException{
     
     Data data = new Data();
     Boolean paso = false; 
     //String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt"; 
     Scanner punteroArchivo = new Scanner( new FileReader( archivo ) );
     //Scanner punteroArchivo = new Scanner( new FileReader( "E:\\weather.nominal.txt" ) );
     // Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
     String linea=""; 
        while( punteroArchivo.hasNextLine() ){
             linea = punteroArchivo.nextLine();
            try {
                    if (paso) {
                        String tempLine = linea.toString().replace(",", " ");
                        String[] lineaValores = tempLine.split(" ");
                        List<Valor> valoresFila = new ArrayList<>();   
                        for (int i = 0; i < lineaValores.length; i++) {
                            Valor valor = new Valor();
                            valor.setNombre(lineaValores[i]);
                            valoresFila.add(valor);
                        }
                        
                        data.dataMatriz.add(valoresFila);
                    }
                    if ( linea.contains("@data")) {
                        paso = true;
                    }
                } catch (Exception e) {
                }
        }
        return data.dataMatriz;
    }
    
}
