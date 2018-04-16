package ar.edu.untref.aydoo;

public class Program {

    public static final void main(final String[] arg) {
	    int numero = Integer.parseInt(arg[0]);
	    int[] resultado = new int[numero];
	    for (int i = 0; i < numero; i++) {
	    	resultado[i] = SerieFibonacci.calcularSerieDeFibonacci(i);
	    }
	    System.out.printf("fibo<%d>: ", numero);
	    for (int i = 0; i < numero; i++) {	
	    	System.out.printf("%d ", resultado[i]);
	    }
    }
}
