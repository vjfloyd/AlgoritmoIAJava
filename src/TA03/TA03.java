/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.File;
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
private static String[][] matriz;
private static int contFilasDatos = 0;
private static Boolean pasoData =  false;

public void leerDatos(){
    String[]  var;
    String relacion;
    String atributo;
    int cont = 0;
    
    atributos = new HashMap<String, String[]>();
    data = new HashMap<String, String[]>();
    variable = new String[5];
    matriz = new String[20][5];
    
    try {
        //Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt" ) );
        Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
        String linea=""; 

        while( punteroArchivo.hasNextLine() ){
             linea = punteroArchivo.nextLine();

            //var = linea.split("@");
            valores = new String[5];
            //matriz = new String[variable.length][variable.length];

            try {
                
                if ( linea.contains("attribute")) {
                    String temp = linea.toString().replace("{", "");
                    temp = temp.replace("@", "");
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
                   // if (cont < 5) {
                        System.out.println("VARIABLE " + variable[cont]);
                        System.out.println(cont);
                   // }
                    cont++;
                } 
                if (pasoData) {
                   
                   String[] datos = linea.split(",");
                  // System.out.println("########### DATA #########");
                   
                    for (int j = 0; j < variable.length ; j++) {
                        matriz[contFilasDatos][j] = datos[j]; 
                       System.out.print(" " +matriz[contFilasDatos][j]+" ");
                    }
                    contFilasDatos++;
                    System.out.println();
                }
                
                ///System.out.println("########### FIN DATA #########");
                
                if (linea.contains("@data")) {
                    pasoData = true;
                }
      
             } catch (Exception e) {
            }
 
        }

    } catch (FileNotFoundException ex) {
        Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("************************************************");
}

public static void calcularMarginal( String[][] matriz ){
    
    for (int m = 0; m < variable.length ; m++) {
        for (int i = 0; i < variable.length ; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if ( variable[m].equalsIgnoreCase( matriz[j][i] ) ) {
                    
                }
            }
        }
    }
   
    
}

public static void main(String[] args) {

    TA03 obj =  new TA03();
    obj.leerDatos();
   

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
    
    System.out.println("contFilasDatos" + contFilasDatos);
    System.out.println("variable" + variable.length);
    System.out.println("********* MATRIZ DE DATOS ****************");
    for (int i = 0; i < contFilasDatos ; i++) {
        for (int j = 0; j < variable.length ; j++) {
            System.out.print(matriz[i][j] + "-" );
        }
        System.out.println();
    }
   // System.out.println( atributos. );
    
    System.out.println("*********VARIABLE****************");
    for (int i = 0; i < variable.length ; i++) {
        System.out.println(variable[i]);
    }
   // System.out.println("###" :  atributos.g );
    
     System.out.println("********* marginal ****************");
  
     for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : " + key);
        String[] value = entrySet.getValue();
        for (String v : value) {
            System.out.print(v+",");
        }
        System.out.println();
    }
     
     
     
     
  }
}
