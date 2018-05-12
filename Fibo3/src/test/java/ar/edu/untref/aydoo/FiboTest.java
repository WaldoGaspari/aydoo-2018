package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class FiboTest {
	
	@Test
	public void calcularSerieFibonacci2() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(2);
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci8() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(8);
		
		Assert.assertEquals(21, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci0() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(0);
		
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci1() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(1);
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci17() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(17);
		
		Assert.assertEquals(1597, resultado);
	}
	
	@Test
	public void calcularSerieDeFibonacciDeUnNumeroNegativoDeberiaDarCero() {
		int resultado = SerieFibonacci.calcularElementoEnLaSerieDeFibonacci(-1);
		
		Assert.assertEquals(0, resultado);
	}
}
