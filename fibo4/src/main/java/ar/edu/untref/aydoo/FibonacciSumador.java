package ar.edu.untref.aydoo;

public class FibonacciSumador {

    private Fibonachi fibo = new Fibonachi();
    private FibonacciLargo2 fibonacciLargo2 = new FibonacciLargo2();
    private String resultado;

    public String calcularFibonacci(final int numero, final String[] opciones) {

        int posicion = opciones.length - 2;
        String opcion = opciones[posicion].substring(0, 2);

        if (opciones[posicion].equals("-m=s")) {
            this.resultado = this.calcularSumaFibonachi(numero, opciones);
        } else if (opciones[posicion].equals("-m=l") || opcion.equals("-f")) {
            this.resultado = this.fibonacciLargo2.calcularFibonacci(numero, opciones[0]);
        } else {
            this.resultado = "Opciones no validas";
        }

        return this.resultado;
    }

    public String calcularSumaFibonachi(final int numero, final String[] opciones) {
        this.resultado = "fibo<" + numero + ">s:";
        int total = 0;

        for (int i = 0; i < numero; i++) {
            total += this.fibo.calcularFibonachi(i);
        }

        String orientacion = opciones[0].substring(0, 4);
        if (orientacion.equals("-o=h")) {
            this.resultado = this.resultado + " " + total;
        } else if (orientacion.equals("-o=v")) {
            this.resultado = this.resultado + "\n" + total;
        }

        return this.resultado;
    }
}
