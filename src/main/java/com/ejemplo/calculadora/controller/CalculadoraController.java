package com.ejemplo.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.calculadora.dto.response.Response;
import com.ejemplo.calculadora.service.CalculadoraService;


@RestController
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;
	
	@GetMapping
	public Response calculadoraSuma(@PathVariable Double numero1, @PathVariable Double numero2, @PathVariable String operacion) {
		try {
			Response resultado = new Response();
		
			resultado.setResultado(calculadoraService.calculadora(numero1, numero2, operacion));
				
			return resultado;
		}catch (Exception e){
			new Exception(e.getMessage());
			return null;
		}
	}
	
}
