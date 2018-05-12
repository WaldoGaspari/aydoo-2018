package ar.edu.untref.aydoo;

public class Fibonachi {

    private String fibonacci;

    public int calcularFibonachi(final int numero) {
        if (numero <= 1) {
            return numero;
        } else {
            return calcularFibonachi(numero - 1) + calcularFibonachi(numero - 2);
        }
    }

    public String fibonacciNormal(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            this.fibonacci += " " + this.calcularFibonachi(i);
        }
        return this.fibonacci;
    }

}