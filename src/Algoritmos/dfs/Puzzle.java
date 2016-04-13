/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.dfs;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author vjrojasb
 */
public class Puzzle {

    ArrayList<String> lista = new ArrayList<String>();
   private String estado_inicial;// = "201475863";
   private String estado_final = "123456780";
   private String estado_actual;
   private String estado_anterior;
   private String estado_siguiente;
   private Boolean visitado;
   private static List<String> nodosVisitados = new ArrayList<String>();
   private static List<String> nodosHijos =  new ArrayList<String>();
   
  
   
   public static  List<String> expandirNodos(String puzzle){
        //012345678 
        //201475863
        String mov;
        int indice = puzzle.indexOf("0");
        if( indice != 0 && indice != 3 && indice != 6  ){
            mov = puzzle.substring(0, indice - 1) + "0" + puzzle.charAt(indice-1) + puzzle.substring(indice+1);
            nodosHijos.add(mov);
        }
        if( indice != 2 && indice != 5 && indice != 8){
            mov = puzzle.substring(0, indice) + puzzle.charAt(indice + 1) + "0"+ puzzle.substring(indice + 2);
            nodosHijos.add(mov);
        }
        if( indice > 2 ){           
            mov = puzzle.substring(0, indice-3) + puzzle.charAt(indice) + puzzle.substring(indice-2, indice)+ puzzle.charAt(indice-3)+ puzzle.substring(indice +1);
            nodosHijos.add(mov);    
        }        
        if( indice < 6) {
            mov = puzzle.substring(0, indice )+ puzzle.charAt(indice+3)+ puzzle.substring(indice+1, indice+3)+ puzzle.charAt(indice) + puzzle.substring(indice+4);
            nodosHijos.add(mov);
        }     
        return nodosHijos;
   }
        
   public static boolean discovered(String w){
       for (int i = 0; i <  nodosVisitados.size() ; i++) {
           if (w.equals(nodosVisitados.get(i))) {
               return true;
           }
       }
       return false;
   } 
   
    public Boolean esta_en_lista(String estado){
        Boolean visitado = false;
        for (String l : lista) {
            if ( l.equals(estado)) {
                return !visitado;
            }
        }
        return visitado;
    }
      
    public void dfs(String v ){
        v = nodosHijos.get(0);
        nodosVisitados.add(v);
        for (int i = 0; i < nodosHijos.size(); i++) {
            if( !discovered(nodosHijos.get(i)) ){
                dfs(nodosHijos.get(i));
            }
        }
    }
    
    public static void dfs_Iterative(String v){
        Stack stack = new Stack();
        stack.push(v);
        int x = 0;
        while ( !stack.isEmpty()) {            
             v = (String) stack.pop();
            if( !discovered(v)){
                nodosVisitados.add(v);
                List<String> n_expandidos = expandirNodos(v);
                for (int i = 0; i < n_expandidos.size() ; i++) {
                    stack.push( n_expandidos.get(i) );
                }
                 x++;
            }
            x++;
            if(x == 20){
                return;
            }
        }
    }
    
    
    
    public void imprimir(String v){
        System.out.println(v);
    }
            
            
    public static void main(String[] args) {
       
       
        dfs_Iterative("801723654");
         for (int i = 0; i < nodosVisitados.size() ; i++) {
             System.out.println( nodosVisitados.get(i));
        }
       
            
    }

    
}
    
    
    
    
