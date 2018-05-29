package proyecto;

import java.util.ArrayList;
import proyecto.ordenamiento.Quicksort;

public class Prueba {
    
    public static void imprimir(int[] arreglo, String accion, int num) {
        String mensaje = "Arreglo: " + arregloToString(arreglo) + "\n" +
                         accion + num;
    }
    
    public static String arregloToString(int[] arreglo) {
        String ordenado = "";
        for (int i = 0; i < arreglo.length; i++) {
            ordenado += String.valueOf(arreglo[i]);
            if (i != arreglo.length - 1) {
                ordenado += ", ";
            }
        }
        return ordenado;
    }
    
    public static int[] generarArreglo(int tam) {
        ArrayList<Integer> generados = new ArrayList();
        int[] arreglo = new int[tam];
        int i = 0;
        
        while (generados.size() < tam) {
            int nuevo = (int) (Math.random() * tam) + 1;
            
            if (!estaRepetido(generados, nuevo)) {
                generados.add(nuevo);
                arreglo[i] = nuevo;
                i++;
            }
        }
        return arreglo;
    }
    
    public static boolean estaRepetido(ArrayList<Integer> generados, int num) {
        for (int n : generados) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }
    
    public static void menu() {
        
    }
    
    public static void main(String[] args) {
        int arreglo[] = generarArreglo(10);
        Quicksort qs = new Quicksort(arreglo);
    }
}
