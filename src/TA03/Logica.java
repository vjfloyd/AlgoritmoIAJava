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
public class Logica {
 
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
                        temp =  temp.replace(",", " ");

                        String[] tempVariable = temp.split(" ");
                        String[] valores = new String[tempVariable.length-2]; 
                        Variable objVariable = new Variable();        
                        for (int i = 0; i < tempVariable.length-2 ; i++) {
                            Valor valor = new Valor();
                            valor.setNombre(tempVariable[i+2]);
                            objVariable.agregarValor(valor);
                            valores[i] = tempVariable[i+2]; 
                            System.out.println("var = "+valores[i]);
                            System.out.println("OBJvar = "+ objVariable.getValor(i).getNombre());    
                        }
                        atributos.put( tempVariable[1] , valores );
                        variable[cont] = tempVariable[1]; 
                        cont++;
                    } 
                    if (pasoData) {
                       String[] datos = linea.split(",");
                       for (int j = 0; j < variable.length ; j++) {
                            matriz[contFilasDatos][j] = datos[j]; 
                       }
                       contFilasDatos++;
                    }
                    if (linea.contains("@data")) {
                        pasoData = true;
                    }
                } catch (Exception e) {
                }
        }
        for (int j = 0; j < variable.length ; j++) {
            String[] filas = new String[14];
            for (int i = 0; i < 14; i++) {
                filas[i] = matriz[i][j];
            }
            data.put(variable[j], filas);
        }

    } catch (FileNotFoundException ex) {
        Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("************************************************");
}

public static double calcularMarginal( String va, String valor){
    int cont = 0;
    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
        String key = entrySet.getKey();
         if (key.equals(va)) {
             String[] value = entrySet.getValue();
             for (String v : value) 
                  if (v.equals(valor)) 
                     cont++;
        }
    }
    
    System.out.println(" cont " + cont);
      double res = cont / (double) 14;
    return res;
}

public static double calculaProbCondicional(String vaA, String valorA, String vaB, String valorB){
    //  P(A/B) =  P(A) int P(B) / P(B)
    int[] coincidencias = new int[14];
    int contIncidencias = 0;        
    
    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
        String key = entrySet.getKey();
        if (key.equalsIgnoreCase(vaB)) {
             String[] value = entrySet.getValue();
             for (int i = 0; i < value.length ; i++) {
                   if ( valorB.equalsIgnoreCase( value[i] )) {
                       coincidencias[contIncidencias] = i;
                       contIncidencias++;
                 }
             }
        }
    }
    int contI = 0;
    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
        String key = entrySet.getKey();
         if (key.equalsIgnoreCase(vaA)) {
             String[] value = entrySet.getValue();
             for (int i = 0; i < contIncidencias ; i++) {
                   if ( valorA.equalsIgnoreCase( value[coincidencias[i]] )) {
                       contI++;
                 }
             }
        }
    }
    
    double  numerador = contI/(double)14;
    double denominador = calcularMarginal(vaB, valorB);
    return numerador/denominador;
}



public static void main(String[] args) {

    Logica obj =  new Logica();
    obj.leerDatos();
   
    double var = calculaProbCondicional("humidity","high","play","yes");
            
    System.out.println("*********PROBABILIDAD CONDICIONAL****************");
    System.out.println( var );

    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
        String key = entrySet.getKey();
         if ( key.equalsIgnoreCase("play")) {
             System.out.println(key);
        }
    }
    
    
    
//    System.out.println(" mar " + calcularMarginal("humidity", "normal"));
//    
//    System.out.println("**************Datos*********************");
//    for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
//        String key = entrySet.getKey();
//        System.out.println("KEY : " + key);
//        String[] value = entrySet.getValue();
//        for (String v : value) {
//            System.out.print(v+",");
//        }
//        System.out.println();
//    }
//    
//     System.out.println("**************Uso de MapHash para almacenar la Data *********************");
//    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
//        String key = entrySet.getKey();
//        System.out.println("KEY : " + key);
//        String[] value = entrySet.getValue();
//        for (String v : value) {
//            System.out.print(v+",");
//        }
//        System.out.println();
//    }
    
    
  
    
    }
}
