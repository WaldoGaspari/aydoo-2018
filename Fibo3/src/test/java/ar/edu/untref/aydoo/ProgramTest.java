package ar.edu.untref.aydoo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class ProgramTest {

	@Test
	public void probarSalidaDelMainEnFormaVerticalYDirectaDeCinco() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<5>: \r\n"
	    		+ "0 \r\n"
	    		+ "1 \r\n"
	    		+ "1 \r\n"
	    		+ "2 \r\n"
	    		+ "3 \r\n";
	    String[] argumentos = {"-o=vd", "5"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}
	
	@Test
	public void probarSalidaDelMainEnFormaHorizontalEInversaDeOcho() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<8>: 13 8 5 3 2 1 1 0 ";
	    String[] argumentos = {"-o=hi", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}

	@Test
	public void probarSalidaDelMainEnFormaVerticalEInversaDeOcho() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<8>: \r\n"
	    		+ "13 \r\n"
	    		+ "8 \r\n"
	    		+ "5 \r\n"
	    		+ "3 \r\n"
	    		+ "2 \r\n"
	    		+ "1 \r\n"
	    		+ "1 \r\n"
	    		+ "0 \r\n";
	    String[] argumentos = {"-o=vi", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}
	
	@Test
	public void probarSalidaDelMainConOpcionesInvalidas() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "Opciones no validas";
	    String[] argumentos = {"-o=xy", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}
	
	@Test
	public void probarSalidaDelMainEnFormaVerticalYFuncionamientoSumatoriaDeOchoDa33() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<8>s: \r\n"
	    		+ "33 ";
	    String[] argumentos = {"-o=vi", "-m=s", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}
	
	@Test
	public void probarSalidaDelMainEnFormaHorizontalYFuncionamientoSumatoriaDeOchoDa33() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<8>s: 33";
	    String[] argumentos = {"-o=hi", "-m=s", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}

	@Test
	public void probarSalidaDelMainEnFormaHorizontalYFuncionamientoListaDeOcho() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    String esperado = "fibo<8>: 13 8 5 3 2 1 1 0 ";
	    String[] argumentos = {"-o=hi", "-m=l", "8"};

	    Program.main(argumentos);
	    String salida = new String(baos.toByteArray());

	    Assert.assertEquals(esperado, salida);
	}
	
}