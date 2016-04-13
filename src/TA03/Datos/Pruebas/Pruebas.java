/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03.Datos.Pruebas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author Vj
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    private static HashMap<String, String[]> subjects;
    
    public static void main(String[] args) {
        subjects = new HashMap<String, String[]>();
        subjects.put("calculus",new String[] {"math","logic"});
        subjects.put("chemisty",new String[] {"ions","electrons"});
        subjects.put("biology",new String[] {"life","bacteria"});
        for(String s:subjects.get("biology")){
            System.out.println(s);
        }
        
        String var = "boo:and:foo";
        
        String[] var2 = var.split(":");
        //var.split(var)
                
         for (String v : var2) {
              System.out.print(v + "-");
        }
        String var3 = "boo:and:foo";
        // var3.replace(oldChar, newChar)
        
        String[] arreglo =  new String[2]; // = new ArrayList<String>();
        
        arreglo[0] = "hola1";
        arreglo[1] = "hola2";
        
        for (int i = 0; i < arreglo.length ; i++) {
            System.out.println(arreglo[i]);
                    
        }

        subjects.put("physics", arreglo);
        
        for (Map.Entry<String, String[]> entrySet : subjects.entrySet()) {
            String key = entrySet.getKey();
            System.out.println("Key : " + key);
            String[] value = entrySet.getValue();
            for (int i = 0; i < value.length ; i++) {
                System.out.print(value[i]+",");
            }
            System.out.println();
        }
        
        String tmp = "mesquite in your cellar";
        tmp = tmp.replace("e", "o");
        tmp = tmp.replace("o", "u");
        tmp = tmp.replace("u", "?");
        System.out.println(tmp);
        
        HashMap<String, String> hash = new HashMap<>();

	// Put three keys with values.
//	hash.put("dog", 1);
//	hash.put("cat", 2);
//	hash.put("rabbit", 3);
//        hash.put("rabbit2", 2);
        hash.put("rabbit2", "2");
        hash.put("rabbit2", "3");
        hash.put("rabbit2", "6");

	// Look up some known values.
	
        for (Map.Entry<String, String> entrySet : hash.entrySet()) {
            String key = entrySet.getKey();
            System.out.println(key);
            String value = entrySet.getValue();
            
        }
     
        String[][] matriz = new String[2][2];
        
        int [][] numeros = {{6,7,5}, {3, 8, 4,10}, {1,0,2}, {9,5,2}};
        
        for (int i = 0; i < numeros[1].length ; i++) {
            System.out.println( numeros[i][1]);
        }
       
        String [][] letras = {{"uno","dos" ,"cinco"}, {"tres", "ocho", "cuatro", "diez"}, { "uno", "cero", "dos"}, {"nueve", "cinco", "dos"}};
        for (int i = 0; i < letras[1].length ; i++) {
            System.out.println( letras[i][0]);
        }
        
        int[][] test; 
        test = new int[5][10];

        int row = test.length;
        int col = test[0].length;

        System.out.println(row);
        System.out.println(col);
        
        List<String> first;// = new List<String> { "one", "two", "three" };
        List<String> second;// = new List<String> { "four", "five", "six" };

        first = new ArrayList<>();
        
        first.add("uno");
        first.add("dos");
        
        //Uso de STRING
        
        
    }
    
    
    
    
    
    
}
