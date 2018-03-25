package ar.edu.untref.aydoo;

public class SerieFibonacci {

	public static int calcularSerieDeFibonacci(int numero) {	
		if(numero == 0){
			return 0;	
		} else if (numero == 1){
			return 1;
		} else {
			return (calcularSerieDeFibonacci(numero-1) + calcularSerieDeFibonacci(numero-2));
		}
	}
}
