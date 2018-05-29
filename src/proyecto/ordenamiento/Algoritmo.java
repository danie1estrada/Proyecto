package proyecto.ordenamiento;

public abstract class Algoritmo {
    
    protected int accion;
    protected int[] arreglo;
    
    @Override
    public abstract String toString();
    
    public abstract String getNombre();
    
    public abstract void ordenar();
    
    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public int[] getArreglo() {
        return arreglo;
    }
    
    public int getAccion() {
        return accion;
    }
    
    public void intercambiar(int pos1, int pos2) {
        int aux = arreglo[pos1];
        arreglo[pos1] = arreglo[pos2];
        arreglo[pos2] = aux;
        accion++;
    }   
}
