package ar.edu.untref.aydoo;

public class FibonacciSumador {

    private String resultado;

    public String calcularFibonacci(final int numero, final String[] opciones) {

        int posicion = opciones.length - 2;
        String opcion = opciones[posicion].substring(0, 2);

        if (opciones[posicion].equals("-m=s")) {
        	if (opciones[0].equals("-n=p")) {
        		this.resultado = this.calcularSumatoriaDeNumerosPares(numero);
        	} else {
        		this.resultado = this.calcularSumaFibonacci(numero, opciones);
        	}
        } else if (opciones[posicion].equals("-m=l") || opcion.equals("-f")) {
            this.resultado = AnalizadorDeOpciones.calcularFibonacci(numero, opciones[0]);
        } else if (opciones[posicion].equals("-n=p")) {
        	this.resultado = this.calcularNumerosParesDeSerieDeFibonacci(numero, opciones);
        } else {
            this.resultado = "Opciones no validas";
        }
        return this.resultado;
    }

    public String calcularSumaFibonacci(final int numero, final String[] opciones) {
        this.resultado = "fibo<" + numero + ">s:";
        int total = 0;

        for (int i = 0; i < numero; i++) {
            total += Fibonacci.calcularFibonacci(i);
        }

        String orientacion = opciones[0].substring(0, 4);
        if (orientacion.equals("-o=h")) {
            this.resultado = this.resultado + " " + total;
        } else if (orientacion.equals("-o=v")) {
            this.resultado = this.resultado + "\n" + total;
        }
        return this.resultado;
    }

    public String calcularNumerosParesDeSerieDeFibonacci(final int numero, final String[] opciones) {
    	int numeroPar = 0;
    	char orientacion = opciones[0].charAt(3);
    	char direccion = opciones[0].charAt(4);
    	this.resultado = "fibo<" + numero + ">:";
    	if (direccion == 'd') {
    		for (int i = 1; i < numero; i++) {
        		numeroPar = Fibonacci.calcularFibonacci(i); 
        		if (numeroPar % 2 == 0) {
        			if (orientacion == 'h') {
        				this.resultado += " " + numeroPar;
        			} else {
        				this.resultado += "\n";
        				this.resultado += " " + numeroPar;
        			}   			
        		}
        	}
    	} else if (direccion == 'i') {
    		for (int i = numero; i > 0; i--) {
        		numeroPar = Fibonacci.calcularFibonacci(i); 
        		if (numeroPar % 2 == 0) {
        			if (orientacion == 'h') {
        				this.resultado += " " + numeroPar;
        			} else {
        				this.resultado += "\n";
        				this.resultado += " " + numeroPar;
        			}
        		}
        	}
    	}
    	return this.resultado;
    }
    
    public String calcularSumatoriaDeNumerosPares(final int numero) {
    	int numeroPar = 0;
    	int total = 0;
    	this.resultado = "fibo<" + numero + ">s:";
    	for (int i = 1; i < numero; i++) {
    		numeroPar = Fibonacci.calcularFibonacci(i);
    		if (numeroPar % 2 == 0) {
    			total += numeroPar;
    		}
    	}
    	this.resultado += " " + total;
    	return this.resultado;
    }
}
