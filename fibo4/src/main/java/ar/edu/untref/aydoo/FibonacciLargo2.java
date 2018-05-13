package ar.edu.untref.aydoo;

public class FibonacciLargo2 {

    private static int[] resultadoInverso;
    private static String fibonacci;

    public static String calcularFibonacci(final int numero, final String opcion) {

        switch (opcion) {
            case "-o=hd":
               fibonacciHorizontalDirecto(numero);
                break;
            case "-o=hi":
                fibonacciHorizontalInverso(numero);
                break;
            case "-o=vd":
                fibonacciVerticalDirecto(numero);
                break;
            case "-o=vi":
                fibonacciVerticalInverso(numero);
                break;
            case "-o=pd":
                fibonacciProgresivaDirecta(numero);
                break;
            case "-o=pi":
                fibonacciProgresivaInversa(numero);
                break;
            case "-n=p":
                calcularNumerosPares(numero);
                break;
            default:
                fibonacci = "Opciones no validas";
                break;
        }

        return fibonacci;
    }

    private static void fibonacciHorizontalDirecto(final int numero) {
        fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            fibonacci += " " + Fibonacci.calcularFibonacci(i);
        }
    }

    private static void fibonacciHorizontalInverso(final int numero) {
        fibonacci = "fibo<" + numero + ">:";
        inversor(numero);
        for (int i = numero - 1; i >= 0; i--) {
            fibonacci += " " + resultadoInverso[i];
        }
    }

    private static void fibonacciVerticalDirecto(final int numero) {
        fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            fibonacci += "\n" + Fibonacci.calcularFibonacci(i);
        }
    }

    private static void fibonacciVerticalInverso(final int numero) {
        fibonacci = "fibo<" + numero + ">:";
        inversor(numero);
        for (int i = numero - 1; i >= 0; i--) {
            fibonacci += "\n" + resultadoInverso[i];
        }
    }

    private static void inversor(final int numero) {
        resultadoInverso = new int[numero];
        for (int i = 0; i <= numero - 1; i++) {
            resultadoInverso[i] = Fibonacci.calcularFibonacci(i);
        }
    }

    private static void fibonacciProgresivaDirecta(final int numero) {
    	fibonacci = "fibo<" + numero + ">:";
    	fibonacci += "\n";
    	for (int i = 0; i < numero; i++) {
            for (int j = 0; j <= i; j++) {
            	fibonacci += " " + Fibonacci.calcularFibonacci(j);
            }
            fibonacci += "\n";
        }
    }

    private static void fibonacciProgresivaInversa(final int numero) {
    	fibonacci = "fibo<" + numero + ">:";
    	fibonacci += "\n";
    	for (int i = numero - 1; i >= 0; i--) {
            for (int j = numero - 1; j >= i; j--) {
            	fibonacci += " " + Fibonacci.calcularFibonacci(j);
            }
            fibonacci += "\n";
        }
    }

    private static void calcularNumerosPares(final int numero) {
    	int numeroPar = 0;
    	fibonacci = "fibo<" + numero + ">:";
    	for (int i = 1; i < numero; i++) {
    		numeroPar = Fibonacci.calcularFibonacci(i); 
    		if (numeroPar % 2 == 0) {
    			fibonacci += " " + numeroPar;
    		}
    	}
    }
}
