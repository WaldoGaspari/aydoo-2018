package ar.edu.untref.aydoo;

public class FibonacciLargo2 {

    private int[] resultadoInverso;
    private String fibonacci;

    public String calcularFibonacci(final int numero, final String opcion) {

        switch (opcion) {
            case "-o=hd":
                this.fibonacciHorizontalDirecto(numero);
                break;
            case "-o=hi":
                this.fibonacciHorizontalInverso(numero);
                break;
            case "-o=vd":
                this.fibonacciVerticalDirecto(numero);
                break;
            case "-o=vi":
                this.fibonacciVerticalInverso(numero);
                break;
            case "-o=pd":
                this.fibonacciProgresivaDirecta(numero);
                break;
            case "-o=pi":
                this.fibonacciProgresivaInversa(numero);
                break;
            default:
                this.fibonacci = "Opciones no validas";
                break;
        }

        return this.fibonacci;

    }


    private void fibonacciHorizontalDirecto(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            this.fibonacci += " " + Fibonacci.calcularFibonacci(i);
        }
    }

    private void fibonacciHorizontalInverso(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += " " + this.resultadoInverso[i];
        }

    }

    private void fibonacciVerticalDirecto(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";

        for (int i = 0; i < numero; i++) {
            this.fibonacci += "\n" + Fibonacci.calcularFibonacci(i);
        }

    }

    private void fibonacciVerticalInverso(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += "\n" + this.resultadoInverso[i];
        }

    }

    private void inversor(final int numero) {
        this.resultadoInverso = new int[numero];
        for (int i = 0; i <= numero - 1; i++) {
            this.resultadoInverso[i] = Fibonacci.calcularFibonacci(i);
        }
    }
    
    private void fibonacciProgresivaDirecta(final int numero) {
    	this.fibonacci = "fibo<" + numero + ">:";
    	this.fibonacci += "\n";
    	for (int i = 0; i < numero; i++) {
            for (int j = 0; j <= i; j++) {
            	this.fibonacci += " " + Fibonacci.calcularFibonacci(j);
            }
            this.fibonacci += "\n";
        }
    }
    
    private void fibonacciProgresivaInversa(final int numero) {
    	this.fibonacci = "fibo<" + numero + ">:";
    }
}
