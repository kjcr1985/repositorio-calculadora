package com.ejemplo.calculadora.dao;

public class Resta {

	private Double numero1;
	private Double numero2;
	
	
	public Resta(Double numero1, Double numero2) {
		super();
		this.numero1 = numero1;
		this.numero2 = numero2;
	}


	public Double getNumero1() {
		return numero1;
	}


	public void setNumero1(Double numero1) {
		this.numero1 = numero1;
	}


	public Double getNumero2() {
		return numero2;
	}


	public void setNumero2(Double numero2) {
		this.numero2 = numero2;
	}


	@Override
	public String toString() {
		Double resultado = numero1 - numero2; 
		return "Resta [numero1=" + numero1 + ", numero2=" + numero2 + "]" + "= " + resultado;
	}
	
}
