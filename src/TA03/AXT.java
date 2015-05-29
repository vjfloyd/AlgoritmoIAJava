/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import static TA03.Logica.calcularMarginal;
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
public class AXT {
 
    /**
     * @param args the command line arguments
     */
    
/*--------------  AXT.arff --------------------*/    
private static HashMap<String, String[]> atributos;
private static HashMap<String, String[]> data;
private static String[] valores; 
private static String[] variable;
private static ArrayList<String> lista = new ArrayList<>();
private static String[][] matriz;
private static int contFilasDatos = 0;
private static Boolean pasoData =  false;

/*--------------  AXTest.arff --------------------*/
private static HashMap<String, String[]> atributos2;
private static HashMap<String, String[]> data2;
private static String[] valores2; 
private static String[] variable2;
private static ArrayList<String> lista2 = new ArrayList<>();
private static String[][] matriz2;

public void leerDatos(){
    String[]  var;
    String relacion;
    String atributo;
    int cont = 0;
    
    atributos = new HashMap<String, String[]>();
    data = new HashMap<String, String[]>();
    variable = new String[13];
    matriz = new String[5989][13];
    try {
        // Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\TA3\\DatosAX\\AXTest.arff" ) );
         Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\TA3\\DatosAX\\AX.arff" ) );
        //Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
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
                    System.out.println("########### Atributo : [variables]");
                    for (int i = 0; i < tempVariable.length ; i++) {
                        System.out.print(tempVariable[i]+"-");
                    }
                    String[] valores = new String[tempVariable.length-2];
                    System.out.println("###########");
                    for (int i = 0; i < tempVariable.length-2 ; i++) {
                        valores[i] = tempVariable[i+2]; 
                        System.out.println("var =  "+valores[i]);

                    }
                   
                    atributos.put( tempVariable[1] , valores );
                    variable[cont] = tempVariable[1]; 
                        System.out.println("VARIABLE " + variable[cont]);
                        System.out.println(cont);
                    cont++;
                } 
                if (pasoData) {
                   
                   String[] datos = linea.split(",");
                   
                    for (int j = 0; j < variable.length ; j++) {
                        matriz[contFilasDatos][j] = datos[j]; 
                       System.out.print(" " +matriz[contFilasDatos][j]+" ");
                    }
                    contFilasDatos++;
                    System.out.println();
                }
                
                
                if (linea.contains("@data")) {
                    pasoData = true;
                }
      
             } catch (Exception e) {
            }
 
        }
        
        for (int j = 0; j < variable.length ; j++) {
            String[] filas = new String[contFilasDatos];
            for (int i = 0; i < contFilasDatos; i++) {
                filas[i] = matriz[i][j];
            }
            data.put(variable[j], filas);
        }

    } catch (FileNotFoundException ex) {
        Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("************************************************");
}
public void leerDatos2(){
    String[]  var;
    String relacion;
    String atributo;
    int cont = 0;
    
    atributos2 = new HashMap<String, String[]>();
    data2 = new HashMap<String, String[]>();
    variable2 = new String[13];
    matriz2 = new String[10][13];
    try {
        // Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\TA3\\DatosAX\\AXTest.arff" ) );
         Scanner punteroArchivo = new Scanner( new FileReader( "F:\\UNIVERSIDAD\\2015-1\\IA\\TA3\\DatosAX\\AXTest.arff" ) );
        //Scanner punteroArchivo = new Scanner( new FileReader( "/Users/vjrojasb/2015-1/IA/weather.nominal.txt" ) );
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
                    System.out.println("########### Atributo : [variables]");
                    for (int i = 0; i < tempVariable.length ; i++) {
                        System.out.print(tempVariable[i]+"-");
                    }
                    String[] valores = new String[tempVariable.length-2];
                    System.out.println("###########");
                    for (int i = 0; i < tempVariable.length-2 ; i++) {
                        valores[i] = tempVariable[i+2]; 
                        System.out.println("var =  "+valores[i]);

                    }
                   
                    atributos2.put( tempVariable[1] , valores );
                    variable2[cont] = tempVariable[1]; 
                        System.out.println("VARIABLE " + variable2[cont]);
                        System.out.println(cont);
                    cont++;
                } 
                if (pasoData) {
                   
                   String[] datos = linea.split(",");
                   
                    for (int j = 0; j < variable2.length ; j++) {
                        matriz2[contFilasDatos][j] = datos[j]; 
                       System.out.print(" " +matriz2[contFilasDatos][j]+" ");
                    }
                    contFilasDatos++;
                    System.out.println();
                }
                
                
                if (linea.contains("@data")) {
                    pasoData = true;
                }
      
             } catch (Exception e) {
            }
 
        }
        
        for (int j = 0; j < variable.length ; j++) {
            String[] filas = new String[contFilasDatos];
            for (int i = 0; i < contFilasDatos; i++) {
                filas[i] = matriz2[i][j];
            }
            data.put(variable[j], filas);
        }

    } catch (FileNotFoundException ex) {
        Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("************************************************");
}


public static double calcularProbMarginal( String va, String valor){
    int cont = 0;
    for (Map.Entry<String, String[]> entrySet : data.entrySet()) {
        String key = entrySet.getKey();
         if (key.equalsIgnoreCase(va)) {
             String[] value = entrySet.getValue();
             for (String v : value) 
                  if (v.equalsIgnoreCase(valor)) 
                     cont++;
        }
    }
    System.out.println(cont);
    double res = cont / (double) contFilasDatos;
    return res;
    
}
public double clasificarInstancias(){
    
    double s = 0.0;
    for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : " + key);
        String[] value = entrySet.getValue();
    
        for (int i = 0; i < 10; i++) {
            calcularMarginal(key, matriz2[0][i]);
        }
            
        }
    }
    
    //EVENTO CENTINELA
//    double e = calcularMarginal("edad" , "gastrico");
//    double p = calcularMarginal("Procedimiento", "JovenesAdultos");
//    double m = calcularMarginal("Medicamentos", "AMOXICILINA500");
//    double g = calcularMarginal("Grupo", "JovenesAdultos");
//    double o = calcularMarginal("Ocupacion", "JovenesAdultos");
//    double s = calcularMarginal("Sintomas", "JovenesAdultos");
//    double n = calcularMarginal("NivelDano", "JovenesAdultos");
//    double r = calcularMarginal("RedAsist", "JovenesAdultos");
//    double f = calcularMarginal("Factores", "JovenesAdultos");
//    double d = calcularMarginal("DetalleFactores", "JovenesAdultos");
//    double pr = calcularMarginal("ProcAtencion", "JovenesAdultos");
//    double ni = calcularMarginal("NivelPericia", "JovenesAdultos");
//    double c = calcularMarginal("Clase", "JovenesAdultos");
//    
//    double res = e*p*m*g*o*s*n*r*f*d*pr*ni*c;
//    
    return 0.0;
}
public static double calculaProbCondicional(String vaA, String valorA, String vaB, String valorB){
    //  P(A/B) =  P(A) int P(B) / P(B)
    int[] coincidencias = new int[contFilasDatos];
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
    
    double  numerador = contI/(double)contFilasDatos;
    double denominador = calcularMarginal(vaB, valorB);
    return numerador/denominador;
}
public static void agregarRelacion(){
    
    
    
}
public static void calcularDistribucionMarginal(){
   double s = 0.0;
    for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : " + key);
        String[] value = entrySet.getValue();
            for (String v : value) {
                double var = calcularProbMarginal(key, v);
                System.out.print("P(" + v + ") = " + var );
                 s = s + var;
            }
             System.out.print("Suma : " + s );
            System.out.println();
            s = 0.0;
    }     
}   



public static void main(String[] args) {

    AXT obj =  new AXT();
    obj.leerDatos();
    Double var = obj.clasificarInstancias();
   calcularProbMarginal("Edad", "GASTRICO");
   
// System.out.println("Valor EVENTOCENTINELA " + obj.clasificarInstancias());
//    
    calcularDistribucionMarginal();
   
     System.out.println("************** Variable : [Valores] ********************");
    for (Map.Entry<String, String[]> entrySet : atributos.entrySet()) {
        String key = entrySet.getKey();
        System.out.println("KEY : " + key);
        String[] value = entrySet.getValue();
        for (String v : value) {
            System.out.print(v+",");
        }
        System.out.println();
    }
  
    
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
