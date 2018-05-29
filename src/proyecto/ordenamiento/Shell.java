package proyecto.ordenamiento;

public class Shell extends Algoritmo {
    
    @Override
    public void ordenar() {
        boolean cambio;
        
        for (int salto = arreglo.length / 2; salto != 0; salto /= 2) {
            cambio = true;
            while (cambio) {
                cambio = false;
                for (int i = salto; i < arreglo.length; i++) {
                    if (arreglo[i - salto] > arreglo[i]) {
                        intercambiar(i, i - salto);
                        cambio = true;
                    }

                }
            }
        }
    }
    
    @Override
    public String getNombre() {
        return "Shell";
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
