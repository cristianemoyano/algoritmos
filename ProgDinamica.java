class Cambio
{
    private int cantidad;
    private int[] monedas;
    
    Cambio(int cantidad, int[] monedas){
        this.cantidad = cantidad;
        this.monedas = monedas;
    }
    
 
    public int calcularCambio(int valorMoneda, int cantidad) {
        return cantidad/valorMoneda;
    }


    public int[][] calcularMonedas(){
        int[][] matrizCambio = new int[this.monedas.length][this.cantidad];
        for (int i = 0; i < this.monedas.length; i++) {
            for (int j = 0; j < this.cantidad; j++) {
               matrizCambio[i][j] = calcularCambio(this.monedas[i], j+1);
            }
        }
        return matrizCambio;
    }
    
    public void printMatrix(int[][] matrizCambio){
        System.out.println("-----");
        for (int i = 0; i < matrizCambio.length; i++) {
            for (int j = 0; j < matrizCambio[i].length; j++) {
                System.out.print(matrizCambio[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
    }
    
    public void getCambio(int[][] matrizCambio, int cantidad) {
        System.out.println("Para un cambio de $"+cantidad+" necesito:");
        for (int i = 0; i < matrizCambio.length; i++) {
             System.out.println("* "+matrizCambio[i][cantidad-1]+" monedas de $"+this.monedas[i]);
        }
       
    }


}
/**
 *
 * @author cmoyano
 */
public class ProgDinamica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Setup
        Cambio cambio = new Cambio(8, new int[]{1,4,6});
        int[][] calcularMonedas = cambio.calcularMonedas();
        cambio.printMatrix(calcularMonedas);
        
        // Obtener cambio
        cambio.getCambio(calcularMonedas, 5);
    }
    
}
