/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vj
 */
public class ManejarCalculos {

    LeerData leerData;
    List<Variable> listaVA;
    List<List<Valor>> listaValores;
         
    public ManejarCalculos( String archivo) throws FileNotFoundException{
        leerData = new LeerData();
        listaVA = leerData.leerVA(archivo);
        listaValores = leerData.leerData(archivo);
        
    } 
    
    public double calcularProbabilidadMarginal( String valor, String variable){
              
        int cont = 0;
        int ccc = listaValores.size();
        System.out.println(" " + ccc  );
        for (int i = 0; i < listaValores.size() ; i++) {
            if ( listaValores.get(i).get(0).getNombre().equalsIgnoreCase( valor) ) {
                cont++;
            }
          
        }
        double denominador = listaValores.size();
        double res = cont / (double) denominador;
        return res;

        
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
       String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt";
//       LeerData objva = new LeerData();
        
//       List<Variable> listaVA =  objva.leerVA(archivo);
//      
//       LeerData objData = new LeerData();
//       List<List<Valor>>  listaValores =  objData.leerData();
//       
       ManejarCalculos objCal = new ManejarCalculos(archivo);
       
      double res =  objCal.calcularProbabilidadMarginal("sunny","dd");
        System.out.println(" res " + res);      
      
//        for (Variable var : lista) {
//            System.out.println(" " + var.getNombre() + ":"  );
//            for (int i = 0; i < var.getValores().size() ; i++) {
//                System.out.print( var.getValor(i).getNombre() + "," );
//            }
//            System.out.println();
//        }
// 
        
        
//         List<Valor> arreglo1 = new ArrayList<Valor>();
//       
//      
//        
//        for (int i = 0; i <5 ; i++) {
//             Valor valor = new Valor();
//             valor.setNombre("hola");
//              arreglo1.add( valor );
//        }
//        data.agregarArreglo(arreglo1);
//         List<Valor> arreglo2 = new ArrayList<Valor>();
//        for (int i = 0; i <8 ; i++) {
//             Valor valor = new Valor();
//             valor.setNombre("xau");
//              arreglo2.add( valor );
//        }
//        data.agregarArreglo(arreglo2);
//        
//        data.getDataMatriz().get(0).size();
//        
//        for (int i = 0; i <  data.getDataMatriz().get(1).size(); i++) {
//            System.err.println( data.getDataMatriz().get(1).get(i).getNombre() + " -");
//        }
//        
        /*
                Para toda la columna de Datos
                    si vaA == columna_x entonces
                        contIncidenciasValor++
        
                PM(temp= hot) = contIncidencias / totalFilas;        
        */
        
        
    }
    
}
