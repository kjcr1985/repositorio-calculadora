package com.ejemplo.calculadora.service;

import org.springframework.stereotype.Service;

import com.ejemplo.calculadora.dao.Resta;
import com.ejemplo.calculadora.dao.Suma;

@Service
public class CalculadoraService {

	
	
	public String calculadora(Double valor1, Double valor2, String operacion) {
		String result = "";
			
		if(operacion == "suma") {
			Suma s1 = new Suma(valor1, valor2);
			result = s1.toString();
		}
		else if(operacion == "resta"){
			Resta r1 = new Resta(valor1, valor2);
			result = r1.toString();
		}
		
		return result;
	}
	
}
