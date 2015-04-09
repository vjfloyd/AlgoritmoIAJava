/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.pruebas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vjrojasb
 */
public class Pruebas {
    
    
        public static void main(String[] args) {
        
//        String val = "912012";
//        
//        char c = val.charAt(1);
//        System.out.println(c);
//        String x = val.substring(3);
//        System.out.println(x);
//        String x1 = val.substring(3, 5);
//        System.out.println(x1);
//        
//        Map<String, Integer> stateDepth = new HashMap<String, Integer>();
//        Map<Integer, Integer> ll = new HashMap<Integer, Integer>();
//        
//        ll.put(1, 10);
//        ll.put(2, 19);
//        ll.put(3, 288);
//        
//        for (Map.Entry<Integer, Integer> entrySet : ll.entrySet()) {
//            Integer key = entrySet.getKey();
//            Integer value = entrySet.getValue();
//               System.out.println( "Datos " + value );
//        }
//        
//        stateDepth.put("1", 10);
//        stateDepth.put("2", 20);
//        stateDepth.put("3", 30);
//        
//        for (Map.Entry<String, Integer> entrySet : stateDepth.entrySet()) {
//            String key = entrySet.getKey();
//            Integer value = entrySet.getValue();
//             System.out.println( "Datos " + value );
//        }
       
        
            ArrayList<Integer> lista = new ArrayList<Integer>();
            lista.add(10);
            lista.add(91);
            lista.add(18);
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
            
            for (Integer val : lista) {
                if ( val.equals(17) ) {
                   System.out.println("ASI ES");
                }
            }
            
            boolean visitado = true;
             System.out.println(!visitado);
             
             //Numeros Ramdom
               int n1 = (int) Math.floor( Math.random()*(0-4)+5 );
                       
               int n2 = (int) Math.floor( Math.random()*(0-4)+5 );
               int n3 = (int) Math.floor( Math.random()*(0-4)+5 );
               int n4 = (int) Math.floor( Math.random()*(0-4)+5 );
                
                    
                System.out.println( n1 );
                System.out.println( n2 );
                System.out.println( n3 );
                System.out.println( n4 );
            }
    }
    

