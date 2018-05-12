package ar.edu.untref.aydoo;

public class FibonacciLargo2 {
    private Fibonachi fibo = new Fibonachi();
    private int[] resultadoInverso;
    private String fibonacci;

    public String calcularFibonacci(final int numero, final String opcion) {

        switch (opcion) {
            case "-o=hd":
                this.fibonachiHorizontalDirecto(numero);
                break;
            case "-o=hi":
                this.fibonachiHorizontalInverso(numero);
                break;
            case "-o=vd":
                this.fibonachiVerticalDirecto(numero);
                break;
            case "-o=vi":
                this.fibonachiVerticalInverso(numero);
                break;
            default:
                this.fibonacci = "Opciones no validas";
                break;
        }

        return this.fibonacci;

    }


    private void fibonachiHorizontalDirecto(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        for (int i = 0; i < numero; i++) {
            this.fibonacci += " " + this.fibo.calcularFibonachi(i);
        }
    }

    private void fibonachiHorizontalInverso(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += " " + this.resultadoInverso[i];
        }

    }

    private void fibonachiVerticalDirecto(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";

        for (int i = 0; i < numero; i++) {
            this.fibonacci += "\n" + this.fibo.calcularFibonachi(i);
        }

    }

    private void fibonachiVerticalInverso(final int numero) {
        this.fibonacci = "fibo<" + numero + ">:";
        this.inversor(numero);

        for (int i = numero - 1; i >= 0; i--) {
            this.fibonacci += "\n" + this.resultadoInverso[i];
        }

    }

    private void inversor(final int numero) {
        this.resultadoInverso = new int[numero];
        for (int i = 0; i <= numero - 1; i++) {
            this.resultadoInverso[i] = this.fibo.calcularFibonachi(i);
        }
    }
}
