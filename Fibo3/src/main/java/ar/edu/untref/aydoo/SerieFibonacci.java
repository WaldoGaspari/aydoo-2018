package ar.edu.untref.aydoo;

public class SerieFibonacci {

	public static int calcularElementoEnLaSerieDeFibonacci(final int numero) {
		if (numero <= 0) {
			return 0;
		} else if (numero == 1) {
			return 1;
		} else {
			return (calcularElementoEnLaSerieDeFibonacci(numero - 1) + calcularElementoEnLaSerieDeFibonacci(numero - 2));
		}
	}
	
	public static int sumatoriaDeLaSerieDeFibonacci(final int[] numeros) {
    	int total = 0;
    	for (int posicion = 0; posicion < numeros.length; posicion++) {
    		total += numeros[posicion];
    	}
    	return total;
    }
	
	public static void calcularSerie(final int numero, final int[] resultado) {
    	for (int numeroDeLaSerie = 0; numeroDeLaSerie < numero; numeroDeLaSerie++) {
	    	resultado[numeroDeLaSerie] = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(numeroDeLaSerie);
	    }
    }
}
