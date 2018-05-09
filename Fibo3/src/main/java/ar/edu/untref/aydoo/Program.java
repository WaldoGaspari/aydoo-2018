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
	    numero = Integer.parseInt(arg[arg.length - 1]);
	    resultado = new int[numero];
	    calcularSerie();
	    
	    if (arg.length == 1) {
	    	mostrarNumerosSegunOrientacion('h');
	    	
	    } else if (arg.length == 2) {
	    	formato = String.valueOf(arg[0]);
		    orientacion = formato.charAt(3);
		    direccion = formato.charAt(4);
		    if (direccion == 'i') {
		    	resultado = ordenarEnFormaDescendente(resultado);
		    }
		    mostrarNumerosSegunOrientacion(orientacion);
		    
	    } else {
	    	String modoFuncionamiento = null;
	    	char funcionamiento = ' ';
	    	String salida = null;
	    	String[] salidaPartes = null;
	    	String nombreDelArchivo = null;
	    	for (int i = 0; i < arg.length-1; i++) {
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
	    	
	    	if (formato != null && modoFuncionamiento != null && salida == null) {
	    		mostrarNumerosSegunModoDeFuncionamiento(funcionamiento, orientacion);
	    	} else {
	    		escribirSobreArchivo(nombreDelArchivo, funcionamiento);
	    	}
		 
	    }
	    /*
	    if ((orientacion != 'h' && orientacion != 'v') || (direccion != 'd' && direccion != 'i')) {
	    	System.out.printf("Opciones no validas");
	    	
	    } else {
	    	
	    	
	    }
	    */
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
    
    private static void mostrarNumerosSegunOrientacion(char orientacion) {
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
    
    private static void mostrarNumerosSegunModoDeFuncionamiento(final char funcionamiento, char orientacion) {
    	if (funcionamiento == 'l') {
			mostrarNumerosSegunOrientacion(orientacion);
			
		} else {
			if (orientacion == 'h') {
				System.out.printf("fibo<%d>s: %d", numero, sumatoriaDeLaSerieDeFibonacci(resultado));
				
			} else {
				System.out.printf("fibo<%d>s: ", numero);
				System.out.printf("\r\n");
				System.out.printf("%d ", sumatoriaDeLaSerieDeFibonacci(resultado));
			}
		}
    }
    
    private static void calcularSerie() {
    	for (int numeroDeLaSerie = 0; numeroDeLaSerie < numero; numeroDeLaSerie++) {
	    	resultado[numeroDeLaSerie] = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(numeroDeLaSerie);
	    }
    }
    
    private static void escribirSobreArchivo(String archivoDestino, char funcionamiento) {
		if (funcionamiento == ' ') {
			funcionamiento = 'l';
		}
    	File archivo;
    	BufferedWriter escritura;
    	System.out.printf("fibo<%d> guardado en %s.txt", numero, archivoDestino);
    	try {
        	archivo = new File(archivoDestino);
    		escritura = new BufferedWriter(new FileWriter(archivo));
    		if (funcionamiento == 'l') {
    			escritura.write("fibo<" + String.valueOf(numero) + ">: ");
        		if (orientacion == 'v') {
        			escritura.newLine();
        			for (int posicion = 0; posicion < resultado.length; posicion++) {
        				String valor = String.valueOf(resultado[posicion]);
        				escritura.write(valor);
        				escritura.newLine();
        			}
        				
        		} else {
        			for (int posicion = 0; posicion < resultado.length; posicion++) {
        				String valor = String.valueOf(resultado[posicion]);
        				escritura.write(valor + " ");
        			}
        		}
        		
    		} else {
    			escritura.write("fibo<" + String.valueOf(numero) + ">s: ");
    			if (orientacion == 'v') {
    				escritura.newLine();
    				escritura.write(String.valueOf(sumatoriaDeLaSerieDeFibonacci(resultado)));
    				
    			} else {
    				escritura.write(String.valueOf(sumatoriaDeLaSerieDeFibonacci(resultado)));
    			}
    		}
    		escritura.close();
        } catch (Exception e) {
        		
        }
    }
    
    private static int sumatoriaDeLaSerieDeFibonacci(final int[] numeros) {
    	int total = 0;
    	for (int posicion = 0; posicion < resultado.length; posicion++) {
    		total += resultado[posicion];
    	}
    	return total;
    }
}
