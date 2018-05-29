package proyecto.ordenamiento;

public class Quicksort extends Algoritmo {
    
    @Override
    public void ordenar() {
        quicksort(0, arreglo.length - 1);
    }
    
    public void quicksort(int limInf, int limSup) {
        int izq = limInf;
        int der = limSup;
        int pivote = arreglo[izq];
        
        while (izq <= der) {
            while (pivote > arreglo[izq]) {
                izq++;
            }
            
            while (pivote < arreglo[der]) {
                der--;
            }
             
            if (izq <= der) {
                intercambiar(izq, der);
                izq++;
                der--;
            }
        }

        if (limInf < der) {
            quicksort(limInf, der);
        }
        if (izq < limSup) {
            quicksort(izq, limSup);
        }
    }
    
    @Override
    public String getNombre() {
        return "Quicksort";
    }
    
    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            cadena += String.valueOf(arreglo[i]);
            if (i != arreglo.length - 1) {
                cadena += ", ";
            }
        }
        return cadena;
    }
}
