package ar.edu.untref.aydoo;

public class Fibonacci {

    private String fibonacci;

    public int calcularFibonacci(final int numero) {
        if (numero <= 0) {
            return 0;
        } else if (numero == 1) {
        	return 1;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }

    public String fibonacciNormal(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            this.fibonacci += " " + this.calcularFibonacci(i);
        }
        return this.fibonacci;
    }

}