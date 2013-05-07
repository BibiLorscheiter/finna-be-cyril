package br.com.industrb;

public abstract class Shape {
	public abstract double getArea();
	
	@Override
	public String toString() {
		String nome = "";
		
		if (super.toString().substring(16, 19).equals("Ret")) 
			nome = "Retângulo";
		
		else if (super.toString().substring(16, 19).equals("Qua")) 
			nome =  "Quadrado";
		
		else if (super.toString().substring(16, 19).equals("Cir")) 
			nome = "Circulo";
		
		return nome;
	}
}
