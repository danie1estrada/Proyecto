package proyecto.ordenamiento;

public class Quicksort {
    
    private final int[] arreglo;
    private int intercambios;
    
    public Quicksort(int[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public void intercambiar(int pos1, int pos2) {
        int aux = arreglo[pos1];
        arreglo[pos1] = arreglo[pos2];
        arreglo[pos2] = aux;
        intercambios++;
    }
    
    public void quicksort() {
        quicksort(0, arreglo.length - 1);
    }
    
    public void quicksort(int limInf, int limSup) {
        int izq = limInf;
        int der = limSup;
        int pivote = arreglo[izq];
        System.out.println(toString());
        
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
    
    public int[] getArreglo() {
        return arreglo;
    }
    
    @Override
    public String toString() {
        String ordenado = "";
        for (int i = 0; i < arreglo.length; i++) {
            ordenado += String.valueOf(arreglo[i]);
            if (i != arreglo.length - 1) {
                ordenado += ", ";
            }
        }
        return ordenado;
    }
}
