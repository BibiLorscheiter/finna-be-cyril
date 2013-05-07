package br.com.industrb;

import java.lang.Math;

public class Quadrado extends Shape {
	
	double lado;
	double area;

	public Quadrado(double Lado){
		this.lado = Lado;
		this.area = Math.pow(this.lado, 2);
	}
	
	public double getLado(){
		return lado;
	}
	
	@Override
	public double getArea() {
		return area;
	}

}
