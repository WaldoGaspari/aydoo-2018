package ar.edu.untref.aydoo;

import java.util.Scanner;

public class Program {

    public static final void main(final String[] arg) {
    	
    	Scanner entrada = new Scanner(System.in);
	    System.out.println("Escribe un numero");
	    int numero = entrada.nextInt();
	    int[] resultado = new int[numero];
	    for(int i = 0; i<numero; i++){
	    	resultado[i] = SerieFibonacci.calcularSerieDeFibonacci(i);
	    }
	    System.out.printf("fibo<%d>: ", numero);
	    for(int i = 0; i < numero; i++){	
	    	System.out.printf("%d ",resultado[i]);
	    }
    }
}
