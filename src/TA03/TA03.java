/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vj
 */
public class TA03 {

    /**
     * @param args the command line arguments
     */
private static HashMap<String, String[]> atributos;
private static HashMap<String, String[]> data;
private static String[] valores; 
private static String[] variable;
private static ArrayList<String> lista = new ArrayList<>();
        
public static void leerDatos(){
    String[]  var;

    String relacion;
    String atributo;
    int cont = 0;
    int contv = 0;
    atributos = new HashMap<String, String[]>();
    data = new HashMap<String, String[]>();

    try {
        Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt" ) );
        String linea="";

        while( punteroArchivo.hasNextLine() ){
             linea = punteroArchivo.nextLine();

            var = linea.split("@");
            valores = new String[5];


            try {
                if ( var[1].equalsIgnoreCase("data")) {
                    String[] datos = var[1].split(",");
                    lista.add(datos[0]);
                    lista.add(datos[1]);
                    lista.add(datos[2]);
                    lista.add(datos[3]);
                    lista.add(datos[4]);
                    int data;
                    
                    
//                    data.put(variable[contv] , var);
//                    contv++;
//                    
                }else{
                        if ( !var[1].contains("relation")) {
                        String temp = var[1].toString().replace("{", "");
                        temp = temp.replace("}", "");
                        temp =  temp.replace(",", "");

                        String[] tempVariable = temp.split(" ");
                        System.out.println("###########");
                        for (int i = 0; i < tempVariable.length ; i++) {
                            System.out.print(tempVariable[i]+"-");
                        }
                        String[] valores = new String[tempVariable.length-2];
                        System.out.println("###########");
                        for (int i = 0; i < tempVariable.length-2 ; i++) {
                            valores[i] = tempVariable[i+2]; 
                            System.out.println("var = "+valores[i]);

                        }
                          atributos.put( tempVariable[1] , valores );
                          variable[cont] = tempVariable[1]; 
                          cont++;
                        }
                }
            } catch (Exception e) {
            }

        }

    } catch (FileNotFoundException ex) {
        Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
    }
   for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : "+ key);
        String[] value = entrySet.getValue();
        for (String v : value) {
            System.out.print("Variables : " +v+",");
        }
        System.out.println();
    }

    System.out.println("************************************************");
}


public static void main(String[] args) {

    leerDatos();

    System.out.println("**************Datos*********************");
    for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : " + key);
        String[] value = entrySet.getValue();
        for (String v : value) {
            System.out.print(v+",");
        }
        System.out.println();
    }
    
   // System.out.println("###" :  atributos.g );
}


}
