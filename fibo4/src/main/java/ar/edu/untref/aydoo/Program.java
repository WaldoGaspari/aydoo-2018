package ar.edu.untref.aydoo;

public class Program {

    protected Program() {
    }

    public static final void main(final String[] arg) {
        FibonacciSumador sumador = new FibonacciSumador();
        FibonacciPrinter printer = new FibonacciPrinter();

        try {
            validar(arg);
        } catch (Exception IllegalArgumentException) {
            System.out.println("Opciones no validas");
            return;
        }

        int largo = arg.length;
        int numero = Integer.parseInt(arg[largo - 1]);
        String resultado;

        switch (largo) {
            case 1:
                resultado = Fibonacci.fibonacciNormal(numero);
                System.out.println(resultado);
                break;
            case 2:
                resultado = AnalizadorDeOpciones.calcularFibonacci(numero, arg[0]);
                System.out.println(resultado);
                break;
            case 3:
                resultado = sumador.calcularFibonacci(numero, arg);
                printer.imprimir(resultado, arg);
                break;
            case 4:
                resultado = sumador.calcularFibonacci(numero, arg);
                printer.imprimir(resultado, arg);
                break;
            default:
                System.out.println("Opciones no validas");
                break;
        }
    }

    private static void validar(final String[] args) {
        int posicion = args.length - 1;

        try {
            Integer.parseInt(args[posicion]);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }
}
