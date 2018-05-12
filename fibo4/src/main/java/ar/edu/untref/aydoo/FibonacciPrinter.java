package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FibonacciPrinter {

    private int numero;

    public void imprimir(final String fibonacci, final String[] args) {
        this.numero = Integer.parseInt(args[args.length - 1]);
        String opcion = args[1].substring(0, 2);

        if (opcion.equals("-f")) {
            String nombreArchivo = args[1].substring(3);
            this.imprimirEnArchivo(fibonacci, nombreArchivo);
        } else {
            System.out.println(fibonacci);
        }
    }

    private void imprimirEnArchivo(final String fibonacci, final String nombreArchivo) {
        File archivo;
        PrintWriter escribir;
        archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            escribir = new PrintWriter(archivo, "utf-8");
            escribir.println(fibonacci);
            escribir.close();
            System.out.println("fibo<" + this.numero + "> guardado en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
