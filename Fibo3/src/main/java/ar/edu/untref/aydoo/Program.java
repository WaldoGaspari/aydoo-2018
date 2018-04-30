package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Program {

	private static int numero;
	private static int[] resultado;
	private static String formato;
	private static char orientacion;
	private static char direccion;
	
    public static final void main(final String[] arg) {
    	formato = String.valueOf(arg[0]);
	    orientacion = formato.charAt(3);
	    direccion = formato.charAt(4);
	    numero = Integer.parseInt(arg[arg.length-1]);
	    resultado = new int[numero];
	    calcularSerie();
	    if (direccion == 'i') {
	    	resultado = ordenarEnFormaDescendente(resultado);
	    }
    	if (arg.length == 3){
    		String modoFuncionamiento = String.valueOf(arg[1]);
    		char funcionamiento = modoFuncionamiento.charAt(3);
    		if (funcionamiento == 'l') {
    			mostrarNumerosSegunOrientacion(orientacion);
    			
    		} else {
    			if (orientacion == 'h') {
    				System.out.printf("fibo<%d>s: %d", numero, sumatoriaDeLaSerieDeFibonacci(resultado));
    				
    			} else {
    				System.out.printf("fibo<%d>s: ", numero);
    				System.out.printf("\r\n");
    				System.out.printf("%d ",sumatoriaDeLaSerieDeFibonacci(resultado));
    			}
    		}
    		
    	} else if (arg.length == 2) {
    		mostrarNumerosSegunOrientacion(orientacion);
    		
    	} else {
    		if ((orientacion != 'h' && orientacion != 'v') || (direccion != 'd' && direccion != 'i')) {
    	    	System.out.printf("Opciones no validas");
    	    	
    	    } else {
        	    escribirSobreArchivo(arg);
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
    
    private static void escribirSobreArchivo(String[] arg) {
    	String salida = String.valueOf(arg[1]);
		String[] salidaPartes = salida.split("=");
		String nombreDelArchivo = salidaPartes[1];
		char funcionamiento = 'l';
		if (arg.length == 5) {
			String modoFuncionamiento = String.valueOf(arg[3]);
			funcionamiento = modoFuncionamiento.charAt(3);
		}
    	File archivo;
    	BufferedWriter escritura;
    	System.out.printf("fibo<%d> guardado en %s.txt", numero, nombreDelArchivo);
    	if (funcionamiento == 'l') {
    		try {
        		archivo = new File(nombreDelArchivo);
    			escritura = new BufferedWriter(new FileWriter(archivo));
    			escritura.write("fibo<" + String.valueOf(numero) + ">: ");
    			if (orientacion == 'v') {
    				escritura.newLine();
    				for(int i = 0; i < resultado.length; i++){
    					String valor = String.valueOf(resultado[i]);
    					escritura.write(valor);
    					escritura.newLine();
    				}
    				
    			} else {
    				for(int i = 0; i < resultado.length; i++){
    					String valor = String.valueOf(resultado[i]);
    					escritura.write(valor + " ");
    				}
    			}
    			escritura.close();
        	}catch (Exception e) {
        		
        	}
    		
    	} else {
    		try {
        		archivo = new File(nombreDelArchivo);
    			escritura = new BufferedWriter(new FileWriter(archivo));
    			escritura.write("fibo<" + String.valueOf(numero) + ">s: ");
    			if (orientacion == 'v') {
    				escritura.newLine();
    				escritura.write(String.valueOf(sumatoriaDeLaSerieDeFibonacci(resultado)));
    				
    			} else {
    				escritura.write(String.valueOf(sumatoriaDeLaSerieDeFibonacci(resultado)));
    			}
    			escritura.close();
        	}catch (Exception e) {
        		
        	}
    	}
    }
    
    private static int sumatoriaDeLaSerieDeFibonacci(int[] numeros) {
    	int total = 0;
    	for (int i = 0; i < resultado.length; i++) {
    		total += resultado[i];
    	}
    	return total;
    }
}
