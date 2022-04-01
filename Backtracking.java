
/**
 *
 * @author cmoyano
 */
class Algoritmo {
    
    int cantidadReinas;
    int[] solucion;

    public Algoritmo(int cantidadReinas) {
        this.cantidadReinas = cantidadReinas;
        this.solucion = new int[cantidadReinas+1];
    }

    private boolean place(int etapa) {
        for (int j = 1; j < etapa; j++)
        // (x [j] == x [k] significa alineación de columnas
        // abs (k-j) == abs (x [j] -x [k]) significa alineación de barra
        if ((this.solucion[j] == this.solucion[etapa]) || (Math.abs(etapa - j) == Math.abs(this.solucion[j] - this.solucion[etapa])))
            return false;
        return true;
    }

    public void backtrack(int etapa){
        if (etapa > this.cantidadReinas) {
            // etapa > cantidadReinas significa que se ha alcanzado el nodo hoja
            printResultado();
        } else {
            for (int i = 0; i < this.cantidadReinas; i++) {
                // i significa que hay 4 nodos debajo de cada nodo
                // t registra la línea t x [t] registra la posición de la reina colocada en la línea t
                this.solucion[etapa] = i;
                // Si x [t] puede colocar una reina, continúa la búsqueda profunda
                if (place(etapa)){
                    backtrack(etapa + 1);
                }
            }
        }
    }

    private void printResultado(){
        System.out.println();
        for (int i = 1; i <= this.cantidadReinas; i++) {
            System.out.print("" + "["+this.solucion[i]+"] ");
        }
    }
}





public class Backtracking {

    public static void main(String[] args) throws Exception {
        Algoritmo algoritmo = new Algoritmo(4);
        int etapa = 0;
        algoritmo.backtrack(etapa);
    }
    
}
