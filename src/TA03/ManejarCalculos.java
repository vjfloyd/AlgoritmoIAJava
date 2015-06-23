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
    Relacion relaciones;
    
    public ManejarCalculos( String archivo) throws FileNotFoundException{
        leerData = new LeerData();
        listaVA = leerData.leerVA(archivo);
        listaValores = leerData.leerData(archivo);
        relaciones =  new Relacion();
    } 
    
    public int getIndiceVariable(String nombreVA){
        int indice = 0;
        for (Variable var : listaVA) {
            if ( var.getNombre().equalsIgnoreCase(nombreVA)) {
                 indice = listaVA.indexOf(var);
            }
        }
        return indice;
    }
    public double calcularProbabilidadMarginal( String nombreVA, String valor){
        int cont = 0;
        int indice = getIndiceVariable(nombreVA);
        for (int i = 0; i < listaValores.size() ; i++) {
            if ( listaValores.get(i).get(indice).getNombre().equalsIgnoreCase( valor) ) {
                cont++;
            }
        }
        double denominador = listaValores.size();
        double res = cont / (double) denominador;
        return res;
    }
    public void establecerRelaciones(String relacionA, String relacionB ){
      // rA -> rB
        if ( relacionA != relacionB ) {
            relaciones.agregarHijo(relacionB);
            relaciones.agregarPadre( relacionA);
        }
    }
    
    public void calcularProbabilidadConjuntaConRelaciones(){
        // A , B, C
        
        int index = 0, linea=0;
        double pc = 1.0;
        //calcularProbabilidadMarginal( String nombreVA, String valor){
        for (List<Valor> listaData : listaValores) {
            for (Valor valor : listaData) {
                String vaActual = listaVA.get(index).getNombre();
                for (int i = 0; i < relaciones.getHijos().size()  ; i++) {
                    if (   !vaActual.equalsIgnoreCase( relaciones.getHijos().get(i)) 
                        && !vaActual.equalsIgnoreCase(relaciones.getPadres().get(i))
                        || !vaActual.equalsIgnoreCase( relaciones.getHijos().get(i)) ) {
                            pc = pc *calcularProbabilidadMarginal(vaActual, valor.getNombre());
                            index++;
                    }else{
                          if ( vaActual.equalsIgnoreCase( relaciones.getHijos().get(i) )) {
                               
                              if (vaActual.equalsIgnoreCase( relaciones.getPadres().get(i) )) {
                                  
                              }
                              
                        }
                         
                        pc = pc * calcularProbabilidadCondicional(vaActual, vaActual, vaActual, vaActual);
                    }
                }
                
                
               
            }
            index = 0;
            linea++;
            System.out.println("Prob. Conj("+ linea +") = " + pc);
        }
    }
    
    
    
    public double calcularProbabilidadCondicional(String vaA, String valorA, String vaB, String valorB ){
        //  P(A/B) =  P(A) int P(B) / P(B)
        int[] coincidencias = new int[listaValores.size()];
        int contIncidencias = 0;
        int cont = 0;
        int indice = getIndiceVariable(vaB);
        for (List<Valor> lista : listaValores) {
             if (lista.get(indice).getNombre().equalsIgnoreCase(valorB)) {
                coincidencias[contIncidencias] = cont;
                 contIncidencias++;
            }
            cont++;
        }
        cont = 0;
        int contIncidencias2=0;
        contIncidencias = 0;
        indice = getIndiceVariable(vaA);
        for (List<Valor> lista : listaValores) {
                if ( coincidencias[contIncidencias] == cont ) {
                     if ( lista.get(indice).getNombre().equalsIgnoreCase(valorA) ) {
                             contIncidencias2++;
                      }
                    contIncidencias++;
                }
            cont++;
        }
        
        
        double denominador = calcularProbabilidadMarginal(vaB, valorB);
        double numerador = contIncidencias2 / (double) listaValores.size();
        return numerador / denominador;
    }
    public void calcularProbabilidadConjunta(){
        int index = 0, linea=0;
        double pc = 1.0;
        for (List<Valor> listaData : listaValores) {
            for (Valor valor : listaData) {
                 pc = pc *calcularProbabilidadMarginal(listaVA.get(index).getNombre(), valor.getNombre());
                index++;
            }
            index = 0;
            linea++;
            System.out.println("Prob. Conj("+ linea +") = " + pc);
        }
       
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
       String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt";
      //  String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\TA3\\DatosAX\\AXTest.arff"
//       LeerData objva = new LeerData();
        
//       List<Variable> listaVA =  objva.leerVA(archivo);
//      
//       LeerData objData = new LeerData();
//       List<List<Valor>>  listaValores =  objData.leerData();
//       
       ManejarCalculos objCal = new ManejarCalculos(archivo);
//       
//       double res =  objCal.calcularProbabilidadMarginal("play","yes");
//        System.out.println(" res " + res);      
       double res2 =  objCal.calcularProbabilidadCondicional("outlook","overcast" ,"play","yes");
        System.out.println(" res2 " + res2);     
        
        
        objCal.calcularProbabilidadConjunta();
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
