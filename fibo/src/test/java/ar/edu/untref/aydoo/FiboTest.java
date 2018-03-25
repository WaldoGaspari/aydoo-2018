package ar.edu.untref.aydoo;

import org.junit.Test;
import junit.framework.Assert;

public class FiboTest {
	
	@Test
	public void calcularSerieFibonacci2(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(2);
		Assert.assertEquals(1, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci3(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(3);
		Assert.assertEquals(2, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci5(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(5);
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci8(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(8);
		Assert.assertEquals(21, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci0(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(0);
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcularSerieFibonacci1(){
		
		SerieFibonacci serie = new SerieFibonacci();
		int resultado = serie.calcularSerieDeFibonacci(1);
		Assert.assertEquals(1, resultado);
	}
}
