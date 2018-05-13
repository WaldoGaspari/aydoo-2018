package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
	
	@Test
	public void calcularSerieDeFibonacciDe5DeberiaDarme5() {
		Fibonacci fibo = new Fibonacci();
		
		int resultado = fibo.calcularFibonacci(5);
		
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcularSerieDeFibonacciDe1DeberiaDarme1() {
		Fibonacci fibo = new Fibonacci();
		
		int resultado = fibo.calcularFibonacci(1);
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieDeFibonacciDe0DeberiaDarme0() {
		Fibonacci fibo = new Fibonacci();
		
		int resultado = fibo.calcularFibonacci(0);
		
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcularSerieDeFibonacciDeUnNumeroNegativoDeberiaDarme0() {
		Fibonacci fibo = new Fibonacci();
		
		int resultado = fibo.calcularFibonacci(-3);
		
		Assert.assertEquals(0, resultado);
	}
}
