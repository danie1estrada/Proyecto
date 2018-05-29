package proyecto;

import proyecto.ordenamiento.Algoritmo;
import proyecto.ordenamiento.Quicksort;
import proyecto.ordenamiento.Shell;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Prueba {
    
    private final Quicksort quicksort;
    private final Shell shell;
    private int[] arreglo;
    private boolean salir;
    
    public Prueba() {
        quicksort = new Quicksort();
        shell = new Shell();
        salir = false;
    }
    
    private void imprimir(Algoritmo metodo, String accion, int[] original) {
        metodo.setArreglo(original.clone());
        metodo.ordenar();
        
        String mensaje =
                "Original: " + arregloToString(original) + "\n" +
                "Ordenado: " + metodo.toString() + "\n" +
                accion + ": " + metodo.getAccion();
        
        JOptionPane.showMessageDialog(null, mensaje, metodo.getNombre(),
                                      JOptionPane.INFORMATION_MESSAGE);
    }
    
    private String arregloToString(int[] arreglo) {
        String ordenado = "";
        for (int i = 0; i < arreglo.length; i++) {
            ordenado += String.valueOf(arreglo[i]);
            if (i != arreglo.length - 1) {
                ordenado += ", ";
            }
        }
        return ordenado;
    }
    
    private int[] generarArreglo(int tam) {
        ArrayList<Integer> generados = new ArrayList();
        arreglo = new int[tam];
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
    
    private boolean estaRepetido(ArrayList<Integer> generados, int num) {
        for (int n : generados) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }
    
    public void menu() {
        String menu = "Elija:\n\n" + "1. Ingresar el arreglo\n" + 
                      "2. Ordenar por método Shell\n" + 
                      "3. Ordenar por método QuickSort\n" + 
                      "4. Ordenar por Mezcla Directa\n" + 
                      "5. Buscar por Hash\n" + 
                      "6. Salir";
        
        String opcion = JOptionPane.showInputDialog(menu);
        
        switch(opcion) {
            case "1":
                capturarArreglo();
                break;
            case "2":
                imprimir(shell, "Intercambios", arreglo);
                break;
            case "3":
                imprimir(quicksort, "Intercambios", arreglo);
                break;
            case "4": break;
            case "5": break;
            default:
                salir = true;
                break;
        }
    }
    
    private void capturarArreglo() {
        String mensaje = "¿Qué desea hacer?\n\n" + 
                         "1. Capturar arreglo manualmente.\n" + 
                         "2. Generar aleatoriamente.";
        
        String opcion = JOptionPane.showInputDialog(mensaje);
        mensaje = "Ingrese el tamaño del arreglo";
        
        switch(opcion) {
            case "1":
                int x;
                opcion = JOptionPane.showInputDialog(mensaje);
                arreglo = new int[Integer.parseInt(opcion)];
                mensaje = "Ingrese un número";
                for (int i = 0; i < arreglo.length; i++) {
                    x = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                    arreglo[i] = x;
                }
                break;
            default:
                mensaje = "Ingrese el tamaño del arreglo";
                opcion = JOptionPane.showInputDialog(mensaje);
                generarArreglo(Integer.parseInt(opcion));
                break;
        }
    }
    
    public boolean salir() {
        return salir;
    }
    
    public static void main(String[] args) {
        Prueba p = new Prueba();
        
        do {
            p.menu();
        } while(!p.salir());
    }
}