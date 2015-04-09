/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vjrojasb
 */
public class Puzzle {

    ArrayList<String> lista = new ArrayList<String>();
   private String estado_inicial;// = "201475863";
   private String estado_final;// = "123456780";
   private String estado_actual;
   private String estado_anterior;
   private String estado_siguiente;
   private Boolean visitado;
   String mov;
   
   public String retonar_estados(String puzzle){
       
      
       int n = (int) Math.floor( Math.random()*(0-4)+5 );
       
        int indice = puzzle.indexOf("0");
        
        switch(n){
            case 1 : if( indice != 0 && indice != 3 && indice != 6  ){
                        return mov = puzzle.substring(0, indice - 1) + "0" + puzzle.charAt(indice-1) + puzzle.substring(indice+1);
                       }else{
                                
                        }
                       break; 
        
            case 2 :  if( indice != 2 && indice != 5 && indice != 8){
                          return  mov = puzzle.substring(0, indice) + puzzle.charAt(indice + 1) + "0"+ puzzle.substring(indice + 2);
                       }break; 
            case 3 :  if( indice > 2 ){           
                          return  mov = puzzle.substring(0, indice) + puzzle.charAt(indice + 1) + "0"+ puzzle.substring(indice + 2);
                       }break; 
                
                
            case 4 : if( indice < 6) {
                       return mov = puzzle.substring(0, indice)+ puzzle.charAt(indice+3)+ puzzle.substring(indice+1, indice+3)+ puzzle.charAt(indice);
                      }break; 
            }
        
        
        return puzzle;
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
      
    public void dfs(Puzzle p){
        
         p.estado_actual = retonar_estados(p.estado_anterior);
        if (esta_en_lista(p.estado_actual)) {
            
            do{
                p.estado_actual = retonar_estados(p.estado_anterior);
            }while(esta_en_lista(p.estado_actual));
            
            lista.add(p.estado_actual);
        }else{
              lista.add(p.estado_actual);
        }
        
        
        
    }
    
    public void imprimir(String v){
        System.out.println(v);
    }
            
            
    public static void main(String[] args) {
       
        Puzzle gPuzzle =  new Puzzle();
        gPuzzle.estado_anterior = "801723654";
        
        
        for (int i = 0; i < 4; i++) {
             gPuzzle.dfs(gPuzzle);
             gPuzzle.estado_anterior = gPuzzle.estado_actual;
             System.out.println( gPuzzle.lista.get(i));
        }
        
//        for (int i = 0; i < gPuzzle.lista.size() ; i++) {
//           // gPuzzle.imprimir( lista.get(i) );
//             System.out.println( gPuzzle.lista.get(i));
//        }
    }

    
}
    
    
    
    
