package ar.edu.untref.aydoo;

public class ImpresionPantalla {

	public static void mostrarNumerosSegunOrientacion(final char orientacion, final int numero, final int[] resultado) {
    	System.out.printf("fibo<%d>: ", numero);
	    if (orientacion == 'v') {
	    	System.out.printf("\r\n");
	    	for (int i = 0; i < numero; i++) {
		    	System.out.printf("%d \r\n", resultado[i]);
		    }
	    
	    } else {
	    	for (int i = 0; i < numero; i++) {
		    	System.out.printf("%d ", resultado[i]);
		    }
	    }
    }
	
	public static void mostrarNumerosSegunModoDeFuncionamiento(final char funcionamiento, final char orientacion, final int numero, final int[] resultado) {
    	if (funcionamiento == 'l') {
    		ImpresionPantalla.mostrarNumerosSegunOrientacion(orientacion, numero, resultado);
			
		} else {
			if (orientacion == 'h') {
				System.out.printf("fibo<%d>s: %d", numero, SerieFibonacci.sumatoriaDeLaSerieDeFibonacci(resultado));
				
			} else {
				System.out.printf("fibo<%d>s: ", numero);
				System.out.printf("\r\n");
				System.out.printf("%d ", SerieFibonacci.sumatoriaDeLaSerieDeFibonacci(resultado));
			}
		}
    }
}
