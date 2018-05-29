package proyecto;

import proyecto.ordenamiento.Algoritmo;
import proyecto.ordenamiento.Quicksort;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Prueba {
    
    public static void imprimir(Algoritmo metodo, String accion, int[] original) {
        String mensaje =
                "Original: " + arregloToString(original) + "\n" +
                "Ordenado: " + metodo.toString() + "\n" +
                accion + ": " + metodo.getIntercambios();
        JOptionPane.showMessageDialog(null, mensaje, metodo.getNombre(), JOptionPane.INFORMATION_MESSAGE);
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
        int original[] = generarArreglo(10);
        Quicksort qs = new Quicksort(original.clone());
        
        imprimir(qs, "Intercambios", original);
    }
}
