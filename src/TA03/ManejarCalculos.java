/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA03;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.math.MathContext;
/**
 *
 * @author Vj
 */
public class ManejarCalculos {

    LeerData leerData;
    List<Variable> listaVA;
    List<List<Valor>> matrizValores;
    Relacion relaciones;
    
    public ManejarCalculos( String archivo) throws FileNotFoundException{
        leerData = new LeerData();
        listaVA = leerData.leerVA(archivo);
        matrizValores = leerData.leerData(archivo);
        relaciones =  new Relacion();
    } 
    
    public List<String> getVA(){
        List<String> listaVariable = new ArrayList<>();
        for (Variable var : listaVA) {
             listaVariable.add(  var.getNombre() );
        }
        return listaVariable;
    }
    
    public int getCantVariables(){
        int cont = 0;
        for (Variable variable : listaVA) {
            cont++;
        }
        return cont;
    }
    
    public List<String> getValoresVA(String varVA){
        List<String> valoresVA = new ArrayList<>();
        for (Variable var : listaVA) {
             if ( var.getNombre().equalsIgnoreCase(varVA)) {
                  for (Valor valor : var.getValores()) {
                     valoresVA.add(valor.getNombre());
                 }
            }
        }
        return valoresVA;
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
        for (int i = 0; i < matrizValores.size() ; i++) {
            if ( matrizValores.get(i).get(indice).getNombre().equalsIgnoreCase( valor) ) {
                cont++;
            }
        }
        double denominador = matrizValores.size();
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
    
    public boolean esPadre(String valor){
        boolean relacionado = false;
          for (int i = 0; i < relaciones.getHijos().size(); i++) 
               if ( relaciones.getPadres().get(i).equalsIgnoreCase(valor)) 
                  relacionado = true;
              
 
          return relacionado;
    }
    
    public boolean esHijo(String valor){
        boolean relacionado = false;
          for (int i = 0; i < relaciones.getHijos().size(); i++) 
              if ( relaciones.getHijos().get(i).equalsIgnoreCase(valor)) 
                  relacionado = true;
              
           
        return relacionado;
    }
    
    public boolean noPadreNoHijo(){
        boolean boolRelaciones = false;
        if ( relaciones.getPadres().size() > 0 || relaciones.getHijos().size() > 0) 
                boolRelaciones = true;
        
        return boolRelaciones;
    }
    
   
    public double calcularProbabilidadCondicional(String vaA, String valorA, String vaB, String valorB ){
        //  P(A/B) =  P(A) int P(B) / P(B)
        int[] coincidencias = new int[matrizValores.size()];
        int contIncidencias = 0;
        int cont = 0;
        int indice = getIndiceVariable(vaB);
        for (List<Valor> lista : matrizValores) {
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
        for (List<Valor> lista : matrizValores) {
                if ( coincidencias[contIncidencias] == cont ) {
                     if ( lista.get(indice).getNombre().equalsIgnoreCase(valorA) ) {
                             contIncidencias2++;
                      }
                    contIncidencias++;
                }
            cont++;
        }
        
        
        double denominador = calcularProbabilidadMarginal(vaB, valorB);
        double numerador = contIncidencias2 / (double) matrizValores.size();
        return numerador / denominador;
    }
    
     public int calcularExponenteProbabilidadCondicional(String vaA, String valorA, String vaB, String valorB ){
         int[] coincidencias = new int[matrizValores.size()];
        int contIncidencias = 0;
        int cont = 0;
        int indice = getIndiceVariable(vaB);
        for (List<Valor> lista : matrizValores) {
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
        for (List<Valor> lista : matrizValores) {
                if ( coincidencias[contIncidencias] == cont ) {
                     if ( lista.get(indice).getNombre().equalsIgnoreCase(valorA) ) {
                             contIncidencias2++;
                      }
                    contIncidencias++;
                }
            cont++;
        }
        return contIncidencias2;
     }
    
    public void calcularProbabilidadConjunta(){
        int index = 0, linea=0;
        double pc = 1.0;
        for (List<Valor> listaData : matrizValores) {
            for (Valor valor : listaData) {
                 pc = pc *calcularProbabilidadMarginal(listaVA.get(index).getNombre(), valor.getNombre());
                index++;
            }
            index = 0;
            linea++;
            System.out.println("Prob. Conj("+ linea +") = " + pc);
        }
       
    }
    
    public void calcularProbabilidadConjuntaConRelaciones(){
        // A , B, C
        int index = 0, linea=0;
        double pc = 1.0;
        //calcularProbabilidadMarginal( String nombreVA, String valor){
        for (List<Valor> listaData : matrizValores) {
            for (Valor valor : listaData) {
                String vaActual = listaVA.get(index).getNombre(); // saca el Variable aleatoria de un valor
                if ( noPadreNoHijo() || esPadre(vaActual) ) {
                    pc = pc * calcularProbabilidadMarginal(vaActual, valor.getNombre());
                    index++;
                }else{
                     if ( esPadre(vaActual) ) {
                         
                       // pc = pc * calcularProbabilidadCondicional(vaActual, vaActual, vaActual, vaActual)
                    }
                }
           }
            index = 0;
            linea++;
            System.out.println("Prob. Conj("+ linea +") = " + pc);    
        }
    }
    public int calcularIncidencias(String valor){
        int indice = getIndiceVariable(valor);
        int cont = 0;
        for (List<Valor> listaData : matrizValores) {
            if ( listaData.get(indice).getNombre().equalsIgnoreCase(valor)) {
                cont++;
            }
        }
        return cont;
    }
    
    public boolean variablesIndependientes(int matrizVariable[][], int nvar){
        for (int i = 0; i < nvar; i++) 
            for (int j = 0; j < nvar; j++) 
                if (matrizVariable[i][j] == 1) 
                    return false;
                
        return true;
    }
    
    public boolean hayRelaciones( int matrizVariable[][] ){
        for (int i = 0; i < 10; i++) 
            for (int j = 0; j < 10; j++) 
                if ( matrizVariable[i][j] == 1 ) 
                    return true;
         
        return false;
    }
    
    public String getVariable(int indice){
        int cont = 0;
        for (Variable var : listaVA) {
            if ( cont == indice) {
               return var.getNombre();
            }
            cont++;
        }
        return null;
    }
    
    public List<Valor> getValoresxVariable(String variable){
        for (Variable var : listaVA) 
            if ( var.getNombre().equalsIgnoreCase(variable)) 
                return var.getValores();
        return null; 
    }
    
    
    public double heuristicaEntropiaNC(int matrizVariable[][], int n){
        int index = 0, linea=0;
        double pc = 1.0;
        boolean relaciones = false;
        int exponente = 1;
        double pt = 1.0;
        double entropia = 1.0;
        //calcularProbabilidadMarginal( String nombreVA, String valor){
        for (Variable var : listaVA) {
            if ( !relaciones ) {
                for ( Valor val : var.getValores()) {
                     exponente = calcularIncidencias(val.toString());
                     pt = pt * calcularProbabilidadMarginal( var.getNombre() , val.getNombre() );
                     
                }
            }
        }
        
        String valorA, valorB;
        valorA = valorB = "";
        double sumando = 0.0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ( matrizVariable[i][j] == 1 ) {
                    for (int k = 0; k < getValoresxVariable(getVariable(i)).size(); k++) {
                        valorA = getValoresxVariable(getVariable(i)).get(k).getNombre();
                        sumando = calcularProbabilidadMarginal(getVariable(i), valorA);
                        exponente = calcularIncidencias( valorA );
                        entropia += exponente*Math.log10( sumando);
                    }
                    for (int k = 0; k < getValoresxVariable(getVariable(j)).size(); k++){
                        valorA = getValoresxVariable(getVariable(j)).get(k).getNombre();
                        valorB = getValoresxVariable(getVariable(i)).get(k).getNombre();
                        exponente = calcularExponenteProbabilidadCondicional( getVariable(j), valorA , getVariable(i), valorB);
                        sumando =  calcularProbabilidadCondicional( getVariable(j), valorA , getVariable(i), valorB  );
                    }
                }
                if (matrizVariable[i][j] == 0) {
                     for (int k = 0; k < getValoresxVariable(getVariable(j)).size(); k++)
                        entropia = entropia * calcularProbabilidadMarginal(getVariable(i), getValoresxVariable(getVariable(i)).get(k).getNombre());
                }
            }
        }
        return 0;
        
        
    }
    
    public int agregarArista(int[][] matrizVariables, int x, int y ){
        if (matrizVariables[x][y] != 1) {
            matrizVariables[x][y] = 1;
        }else{
            return -1;
        }
        return 0;
    }
    
    public int eliminarArista(int[][] matrizVariables, int x, int y){
        if ( matrizVariables[x][y] == 1) {
            matrizVariables[x][y] = 0;
        }else{
            return -1;
        }
        return 0;
    }
    
    public int invertirArista( int[][] matrizVariables, int x, int y){
        if ( matrizVariables[x][y] == 1) {
            matrizVariables[y][x] = 1;
            matrizVariables[x][y] = 0;
        }else{
            return -1;
        }
        return 0;
    }
    
    public static int[][] copiarMatriz( int[][] T ){
        int i,j;
        int[][] nuevaMatriz = new int[8][8];
        for( i=0; i<8; i++ ){
            for( j=0; j<8; j++ ){
                nuevaMatriz[i][j] = T[i][j];
            }
        }
        return nuevaMatriz;
    }
    public List<int[][]> obtenerHijos(int[][] matrizVariables, int n){
        
       List<int[][]> hijos = new ArrayList<>();
        
        int x = (int) Math.ceil(Math.random()*n);
        int y = (int) Math.ceil(Math.random()*n);
        int res = -5;
        for (int i = 0; i < 3; i++) {
            int[][] hijoVar = copiarMatriz(matrizVariables);
            switch(i){
                case 0 :  res = agregarArista(hijoVar, x, y);
                case 1 :  res = eliminarArista(hijoVar, x, y);
                case 2 :  res = invertirArista(hijoVar, x, y);
            }
            if (res == 0) {
                hijos.add(hijoVar);
            }
        }
        return hijos;
    }
        
    public void HillClimbing(int matrizVariable[][]){
        boolean alcanzoMaximoLocal = false;
        Integer valorMinimo = Integer.MAX_VALUE;
        Integer posicionValorMinimo = -1;
        Double heuristicaPadre = 0.0;
        
        while ( alcanzoMaximoLocal == false ) {
           // heuristicaPadre = calcularEntropiaNC(matrizVariable);
            
            
        }
        
    }
    
    
    public int[][] inicilizarMatriz(int n){
        int[][] matrizVariables = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizVariables[i][j] = 0;
            }
        }
        return matrizVariables;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
       String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\weather.nominal.txt";
      // String archivo = "F:\\UNIVERSIDAD\\2015-1\\IA\\TF\\audiology.arff";
       
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
//       double res2 =  objCal.calcularProbabilidadCondicional("outlook","overcast" ,"play","yes");
//        System.out.println(" res2 " + res2);     
        
        objCal.calcularProbabilidadConjuntaConRelaciones();
        
        int numVariable = objCal.getCantVariables();
        //int[][] matrizVariables = new int[numVariable][numVariable];
         int[][] matrizVariables = objCal.inicilizarMatriz( numVariable);
        
        
        
//  objCal.calcularProbabilidadConjunta();
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
