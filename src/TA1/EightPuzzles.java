/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA1;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

/**
 *
 * @author vjrojasb
 */
public class EightPuzzles {
 
    
    public static int[][] estado_ini(){
        int[][] res = new int[][] { {8,5,2},
                                    {1,3,0},
                                    {6,7,4}};
        
        return res;
    }
    
    public static int[][] estado_fin(){
        int[][] res = new int[][] { {8,5,2},
                                    {1,3,0},
                                    {6,7,4}};
        
        return res;
    }
//    public static int[][] estado_fin(){
//        int[][] res = { {1,2,3},
//                        {4,5,6},
//                        {7,8,0}};
//        
//        return res;
//    }
//    
    
    
    
    public static void main(String[] args) {
    
        int[][] arreglo1 = estado_ini();
        int[][] arreglo2 = estado_fin();
        
        
         for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                  
                  System.out.print(arreglo1[i][j] + " ");
            }
             System.out.println("");
        }
         
         if( java.util.Arrays.equals(arreglo1, arreglo2) ){
             System.out.println("OK");
         }else{
               System.out.println("NO");
         }
        
         
//          for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                 if ( arreglo1[i][j] == arreglo2[i][j]) {
//                    
//                }
// 
//                 
//            }
//             System.out.println("");
//        }
          
          
    }
}
