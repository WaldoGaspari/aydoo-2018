package ar.edu.untref.aydoo;

public class Program {

    public static final void main(final String[] arg) {
	    String formato = String.valueOf(arg[0]);
	    char orientacion = formato.charAt(3);
	    char direccion = formato.charAt(4);
    	int numero = Integer.parseInt(arg[1]);
	    int[] resultado = new int[numero];
	    for (int i = 0; i < numero; i++) {
	    	resultado[i] = SerieFibonacci.calcularSerieDeFibonacci(i);
	    }
	    
	    if (direccion == 'i') {
	    	resultado = ordenarEnFormaDescendente(resultado);
	    }
	    
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
    
    private static int[] ordenarEnFormaDescendente(int[] numeros){
		int[] numerosEnOrdenDescendente = numeros;
		for (int i = 0; i < numerosEnOrdenDescendente.length-1; i ++){
			for (int j = i+1; j < numerosEnOrdenDescendente.length; j ++){
				if(numerosEnOrdenDescendente[i] < numerosEnOrdenDescendente[j]){
					int auxiliar = numerosEnOrdenDescendente[i];
					numerosEnOrdenDescendente[i] = numerosEnOrdenDescendente[j];
					numerosEnOrdenDescendente[j] = auxiliar;	
				}
			}
		}
		return numerosEnOrdenDescendente;
	}
}
