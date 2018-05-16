package ar.edu.untref.aydoo;

public class Fibonacci {

    private static String fibonacci;

    public static int calcularFibonacci(final int numero) {
        if (numero <= 0) {
            return 0;
        } else if (numero == 1) {
        	return 1;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }

    public static String fibonacciNormal(final int numero) {
        fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            fibonacci += " " + calcularFibonacci(i);
        }
        return fibonacci;
    }
}