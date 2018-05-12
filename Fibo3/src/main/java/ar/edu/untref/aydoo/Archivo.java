package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Archivo {

	public static void escribirSobreArchivo(final String archivoDestino, char funcionamiento, final char orientacion, final int numero, final int[] resultado) {
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
    				escritura.write(String.valueOf(SerieFibonacci.sumatoriaDeLaSerieDeFibonacci(resultado)));
    				
    			} else {
    				escritura.write(String.valueOf(SerieFibonacci.sumatoriaDeLaSerieDeFibonacci(resultado)));
    			}
    		}
    		escritura.close();
        } catch (Exception e) {
        		
        }
    }
}
