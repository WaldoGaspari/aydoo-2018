package ar.edu.untref.aydoo;

public class Program {

	private static int numero;
	private static int[] resultado;
	private static String formato;
	private static char orientacion;
	private static char direccion;
	
    public static final void main(final String[] arg) {
	    numero = Integer.parseInt(arg[arg.length - 1]);
	    resultado = new int[numero];
	    SerieFibonacci.calcularSerie(numero, resultado);
	    
	    if (arg.length == 1) {
	    	ImpresionPantalla.mostrarNumerosSegunOrientacion('h', numero, resultado);
	    	
	    } else {
	    	String modoFuncionamiento = null;
	    	char funcionamiento = ' ';
	    	String salida = null;
	    	String[] salidaPartes = null;
	    	String nombreDelArchivo = null;
	    	for (int i = 0; i < arg.length - 1; i++) {
	    		if (arg[i].startsWith("-o")) {
	    			formato = String.valueOf(arg[i]);
	    			orientacion = formato.charAt(3);
				    direccion = formato.charAt(4);
				    if (direccion == 'i') {
				    	resultado = ordenarEnFormaDescendente(resultado);
				    }
	    			
	    		} else if (arg[i].startsWith("-m")) {
	    			modoFuncionamiento = String.valueOf(arg[i]);
	    			funcionamiento = modoFuncionamiento.charAt(3);
	    			
	    		} else if (arg[i].startsWith("-f")) {
	    			salida = String.valueOf(arg[i]);
	    			salidaPartes = salida.split("=");
	    			nombreDelArchivo = salidaPartes[1];
	    		}
	    	}
	    	
	    	if ((orientacion != 'h' && orientacion != 'v') || (direccion != 'd' && direccion != 'i')) {
		    	System.out.printf("Opciones no validas");
		    	
		    } else {
		    	if (formato != null && modoFuncionamiento == null && salida == null) {
		    		if (direccion == 'i') {
				    	resultado = ordenarEnFormaDescendente(resultado);
				    }
		    		ImpresionPantalla.mostrarNumerosSegunOrientacion(orientacion, numero, resultado);
				    
		    	} else if (formato != null && modoFuncionamiento != null && salida == null) {
		    		ImpresionPantalla.mostrarNumerosSegunModoDeFuncionamiento(funcionamiento, orientacion, numero, resultado);
		    		
		    	} else {
		    		Archivo.escribirSobreArchivo(nombreDelArchivo, funcionamiento, orientacion, numero, resultado);
		    	}
		    }
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
}
