import java.util.Scanner;

/**
 *
 * @author cmoyano
 */
class Calculadora {
    
    int monedas[];
    int vuelto[];

    public Calculadora() {
        this.monedas = new int[5];
        this.monedas[0] = 100;
        this.monedas[1] = 20;
        this.monedas[2] = 10;
        this.monedas[3] = 5;
        this.monedas[4] = 1;
        
        this.vuelto = new int[5];
        this.vuelto[0] = 0;
        this.vuelto[1] = 0;
        this.vuelto[2] = 0;
        this.vuelto[3] = 0;
        this.vuelto[4] = 0;
    }
    
    public int[] obtenerMonedas(float vuelto) {

        float aux = vuelto;
        for (int i=0; i <  this.monedas.length; i++) {
            if (aux - this.monedas[i] < 0){
                continue;
            }
            aux = aux - this.monedas[i];
            System.out.println("Moneda: "+ this.monedas[i]);
            while(aux > 0) {
                
                aux = aux - this.monedas[i];
                if (aux<0) {
                    aux = aux + this.monedas[i];
                    // System.out.println("Moneda: "+ this.monedas[i]);
                    break;
                }
                System.out.println("Moneda: "+ this.monedas[i]);
            }
        }
        
        return this.vuelto;
    }
    
    /**
     *
     * @param pago
     * @param costo
     * @return
     * @throws java.lang.Exception
     */
    public float obtenerVuelto(float pago, float costo) throws Exception {
        if (pago < costo){
            throw new Exception("Pago insuficiente.");
        }
        return pago - costo;
    }
}


public class AlgoritmoVoraz {
    public static void main(String[] args) throws Exception {
        try (Scanner lectura = new Scanner (System.in)) {
            System.out.println("Ingrese el importe total: ");
            float costo = lectura.nextFloat();

            System.out.println("Ingrese monto pagado: ");
            float pago = lectura.nextFloat();

            Calculadora calc = new Calculadora();
            float vuelto = calc.obtenerVuelto(pago, costo);

            System.out.println("El vuelto es: " + vuelto);
            calc.obtenerMonedas(vuelto);
        }
     }
}
