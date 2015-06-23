/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vj
 */
public class Tarea {

    private static HashMap<String, Integer> incidencias;
     public static void leerDatos() {
        String[] var;
        String relacion;
        String atributo;
        int cont = 0;
          
         incidencias = new HashMap<String, Integer>();  
         String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\ppi.txt";
        
        try {
            //Scanner punteroArchivo = new Scanner( new FileReader( "E:\\weather.nominal.txt" ) );
            Scanner punteroArchivo = new Scanner( new FileReader( archivo ) );
            boolean pasoData = false;
            
            String [] pronombres  = {"to", "with","of","was","the","and", "that","by","but","were","either","or","for",
                                    "in","on"};
            String [] tags  = {"</PROT2_5970>","<PROT2_5970>"};
            String [] tags2  = {"</PROT2_5970>","<PROT2_5970>"};
            
            
            String linea = "";
            int contWordIgual= 0;
            while (punteroArchivo.hasNextLine()) {
                linea = punteroArchivo.nextLine();
                try {
                         String temp = linea.toString();
                         String[] palabras = temp.split("==>");
                         
                        for (int i = 0; i < palabras.length ; i++) {
                             for (int j = 1; j < 10; j++) {
                                 String[] words = palabras[j].split(" ");
                                  for (int k = 0; k < words.length; k++) {
                                      for (int l = 0; l < words.length; l++) {
                                            contWordIgual= 0;
                                            
                                            if ( words[k].equalsIgnoreCase(" dd")) {
                                              //
                                          }
                                           if ( words[k].equalsIgnoreCase(words[l])) {
                                                contWordIgual++;
                                                
                                                   
                                            }
                                           incidencias.put(words[k],contWordIgual );
                                      }
                                        contWordIgual = 0;
                                     
                                 }
                                         
                            }
                                                        
                        }
                         
                         
                    
                                                  
                         
                  
                } catch (Exception e) {
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TA03.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("************************************************");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        leerDatos();
    }
    
}