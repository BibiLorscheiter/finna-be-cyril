package br.com.industrb;

public class Retangulo extends Shape {
	
	private double area;
	private double base;
	private double altura;

	public Retangulo(double Base, double Altura) {
		this.base = Base;
		this.altura = Altura;
		this.area = this.base * this.altura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getBase() {
		return base;
	}
	
	@Override
	public double getArea() {
		return area;
	}
}
