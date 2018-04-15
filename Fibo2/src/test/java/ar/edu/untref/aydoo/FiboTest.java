package ar.edu.untref.aydoo;

import org.junit.Test;
import org.junit.Assert;

public class FiboTest {
	
	@Test
	public void calcularSerieFibonacci2() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(2);
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci3() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(3);
		
		Assert.assertEquals(2, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci5() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(5);
		
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci8() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(8);
		
		Assert.assertEquals(21, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci0() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(0);
		
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci1() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(1);
		
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci12() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(12);
		
		Assert.assertEquals(144, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci17() {
		int resultado = SerieFibonacci.calcularSerieDeFibonacci(17);
		
		Assert.assertEquals(1597, resultado);
	}
}
