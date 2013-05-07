package br.com.industrb;

import java.lang.Math;

public class Circulo extends Shape {
	
	private double area;
	private double raio;

	public Circulo (double Raio) {
		this.raio = Raio;
		
		// raio elevado ao quadrado vezes pi = area do circulo
		this.area = 3.14 * Math.pow(Raio, 2); 
	}

	public double getRaio() {
		return raio;
	}

	@Override
	public double getArea() {
		return area;
	}
}
