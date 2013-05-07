package br.com.industrb;

import java.util.ArrayList;

public class Fabrica {

	private String material;
	private ArrayList<Shape> listaCortes;
	private Retangulo materiaPrima;
	
	public Fabrica(String Material, double Base, double Altura) throws NullPointerException  {
		this.listaCortes = new ArrayList<Shape>();
		this.materiaPrima = new Retangulo(Base, Altura);
		
		if (Material != null) 
			this.material = Material;
		else 
			throw new NullPointerException("Você precisa informar o nome do material.");
	}
	
	public String getMaterial() {
		return material;
	}
	
	public double getAreaRestante() {
		double areaRestante = 0.0;
		
		// Verifica a area restante do tamanho total do shape levando em consideração o que ja foi recortado
		areaRestante = this.materiaPrima.getArea() - getAreaRecortada();
		
		return areaRestante;
	}
	
	public ArrayList<Shape> cortesFeitos() {
		return listaCortes;
	}
	
	public double PorcentagemRestante() {
		double porcentagemRestante = getAreaRestante() / this.materiaPrima.getArea();
		
		return porcentagemRestante;
	}
	
	public double getAreaRecortada() {
		double areaRecortada = 0.0;
		
		// Percorre todos os recortes na lista de recortes e soma o valor da area total recortada
		for (Shape recorte : this.listaCortes) { 
			areaRecortada += recorte.getArea();
		}
		
		return areaRecortada;
	}
	
	public void corta(Shape forma) throws RuntimeException {
		// Exception que verifica se o tamanho de recortes feitos excede o tamanho restante do total do shape
		if (forma.getArea() > getAreaRestante())
			throw new RuntimeException("Area de corte superior ao disponível!");
		else 
			listaCortes.add(forma);
	}
}
