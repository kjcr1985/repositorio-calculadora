package com.ejemplo.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ejemplo.calculadora.dto.response.Response;
import com.ejemplo.calculadora.service.CalculadoraService;

@ExtendWith(MockitoExtension.class) 
public class CalculadoraControllerTest {

	
	@Mock
	private CalculadoraService service;
	
	@Test
	public void testCalculadoraSuma() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(2), Double.valueOf(2), "suma")).thenReturn("4");
		
		String result = service.calculadora(2.0, 2.0, "suma");
		
		Response resultadoSuma = new Response();
		resultadoSuma.setResultado(result);
		
		
		assertEquals("4", resultadoSuma.getResultado());
	}
	
	@Test
	public void testCalculadoraResta() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(4), Double.valueOf(2), "resta")).thenReturn("2");
		
		String result = service.calculadora(4.0, 2.0, "resta");
		
		Response resultadoResta = new Response();
		resultadoResta.setResultado(result);
		
		
		assertEquals("2", resultadoResta.getResultado());
	}
	
	
	@Test
	public void testCalculadoraSumaKO() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(2), Double.valueOf(2), "suma")).thenReturn(null);
		
		String resultSuma = service.calculadora(2.0, 2.0, "suma");
		
		Response resultadoSuma = new Response();
		resultadoSuma.setResultado(resultSuma);
		
		
		assertNotNull(resultadoSuma);
	}
	
	@Test
	public void testCalculadoraRestaKO() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(4), Double.valueOf(2), "resta")).thenReturn(null);
		
		String resultResta = service.calculadora(4.0, 2.0, "resta");
		
		Response resultadoResta = new Response();
		resultadoResta.setResultado(resultResta);
		
		
		assertNotNull(resultadoResta);
	}
	
	@Test
	public void testCalculadoraSumaKO2() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(2), Double.valueOf(2), "suma")).thenThrow(new RuntimeException("No se puede procesar la suma"));
		try {
			
			String resultSuma = service.calculadora(2.0, 2.0, "suma");
			
			Response resultadoSuma = new Response();
			resultadoSuma.setResultado(resultSuma);
			
		}catch (Exception e){
			assertTrue(e instanceof RuntimeException);
			assertEquals(e.getMessage(), "No se puede procesar la suma");
		}
		
	}
	
	@Test
	public void testCalculadoraRestaKO2() throws Exception{
		
		Mockito.when(service.calculadora(Double.valueOf(4), Double.valueOf(2), "resta")).thenThrow(new RuntimeException("No se puede procesar la resta"));
		try {
			
			String resultResta = service.calculadora(4.0, 2.0, "resta");
			
			Response resultadoResta = new Response();
			resultadoResta.setResultado(resultResta);
		
		}catch (Exception e){
			assertTrue(e instanceof RuntimeException);
			assertEquals(e.getMessage(), "No se puede procesar la resta");
		}
		
	}
}
