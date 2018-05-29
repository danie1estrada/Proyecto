package proyecto.ordenamiento;

public abstract class Algoritmo {
    
    protected final int[] arreglo;
    protected int intercambios;
    
    public Algoritmo(int[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public void intercambiar(int pos1, int pos2) {
        int aux = arreglo[pos1];
        arreglo[pos1] = arreglo[pos2];
        arreglo[pos2] = aux;
        intercambios++;
    }
    
    public int[] getArreglo() {
        return arreglo;
    }
    
    public int getIntercambios() {
        return intercambios;
    }
    
    public abstract String getNombre();
    
    @Override
    public abstract String toString();
}
