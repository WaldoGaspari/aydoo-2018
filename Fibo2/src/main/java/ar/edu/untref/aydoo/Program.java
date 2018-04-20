package ar.edu.untref.aydoo;

public class Program {

	private static int numero;
	private static int[] resultado;
	
    public static final void main(final String[] arg) {
    	if (arg.length == 2) {
    		String formato = String.valueOf(arg[0]);
    	    char orientacion = formato.charAt(3);
    	    char direccion = formato.charAt(4);
    	    if ((orientacion != 'h' && orientacion != 'v') || (direccion != 'd' && direccion != 'i')) {
    	    	System.out.printf("Opciones no validas");
    	    	
    	    } else {
    	    	numero = Integer.parseInt(arg[1]);
        	    resultado = new int[numero];
        	    calcularSerie();
        	    if (direccion == 'i') {
        	    	resultado = ordenarEnFormaDescendente(resultado);
        	    }
        	    mostrarNumerosSegunOrientacion(orientacion);
    	    }
    	    
    	} else {
    		numero = Integer.parseInt(arg[0]);
    	    resultado = new int[numero];
    	    calcularSerie();
    	    mostrarNumerosSegunOrientacion('h');
    	}
    }
    
    private static int[] ordenarEnFormaDescendente(final int[] numeros) {
		int[] numerosDescendentes = numeros;
		for (int i = 0; i < numerosDescendentes.length - 1; i++) {
			for (int j = i + 1; j < numerosDescendentes.length; j++) {
				if (numerosDescendentes[i] < numerosDescendentes[j]) {
					int auxiliar = numerosDescendentes[i];
					numerosDescendentes[i] = numerosDescendentes[j];
					numerosDescendentes[j] = auxiliar;
				}
			}
		}
		return numerosDescendentes;
	}
    
    private static void mostrarNumerosSegunOrientacion(final char orientacion) {
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
    
    private static void calcularSerie() {
    	for (int numeroDeLaSerie = 0; numeroDeLaSerie < numero; numeroDeLaSerie++) {
	    	resultado[numeroDeLaSerie] = SerieFibonacci.calcularSerieDeFibonacci(numeroDeLaSerie);
	    }
    }
}
