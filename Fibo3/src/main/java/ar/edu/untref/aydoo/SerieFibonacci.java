package ar.edu.untref.aydoo;

public class SerieFibonacci {

	public static int calcularElementoEnLaSerieDeFibonacci(int numero) {
		if (numero <= 0) {
			return 0;
		} else if (numero == 1) {
			return 1;
		} else {
			return (calcularElementoEnLaSerieDeFibonacci(numero - 1) + calcularElementoEnLaSerieDeFibonacci(numero - 2));
		}
	}
}
