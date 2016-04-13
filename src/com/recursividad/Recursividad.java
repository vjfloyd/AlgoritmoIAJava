/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursividad;

import java.util.Random;

/**
 *
 * @author vjrojasb
 */
public class Recursividad {
    
    public int seed(int max){
        Random rand = new Random();
           return rand.nextInt(20)+1;
    }
    
    public int[] getArray(int n , int max){
        int array[] = new int[max];
        for (int i = 0; i < n; i++) {
            array[i] = seed(20);
        } 
        return array;
    }
    
    
    public void mostrar(int array[]){
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ ", ");
        } 
        System.out.println("");
    }
    
    
    
    public void Main(){
        Recursividad rec = new Recursividad();
        
        //int array[] = rec.getArray(n, max)
        
        
    }
    
}
