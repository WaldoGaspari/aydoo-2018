package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Program {

	private static int numero;
	private static int[] resultado;
	
    public static final void main(final String[] arg) {
    	if (arg.length != 0) {
    		String formato = String.valueOf(arg[0]);
    		String salida = String.valueOf(arg[1]);
    	    char orientacion = formato.charAt(3);
    	    char direccion = formato.charAt(4);
    	    if ((orientacion != 'h' && orientacion != 'v') || (direccion != 'd' && direccion != 'i')) {
    	    	System.out.printf("Opciones no validas");
    	    	
    	    } else {
    	    	numero = Integer.parseInt(arg[4]);
        	    resultado = new int[numero];
        	    calcularSerie();
        	    if (direccion == 'i') {
        	    	resultado = ordenarEnFormaDescendente(resultado);
        	    }
        	    mostrarNumerosSegunOrientacion(orientacion);
        	    escribirSobreArchivo(salida, orientacion);
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
    
    private static void escribirSobreArchivo(String salida, char orientacion) {
    	File archivo;
    	BufferedWriter escritura;
    	PrintWriter pw;
    	
    	try {
    		archivo = new File(salida);
			escritura = new BufferedWriter(new FileWriter(archivo));
			pw = new PrintWriter(escritura);
			pw.write("fibo< >: ");
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
			pw.close();
			escritura.close();
    	}catch (Exception e) {
    		
    	}
    }
}
