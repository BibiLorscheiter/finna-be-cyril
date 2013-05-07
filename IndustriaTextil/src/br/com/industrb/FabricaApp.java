package br.com.industrb;

import java.util.Scanner;

public class FabricaApp {
	public static void main(String[] args) {
		String material = "";

		int opcao = 0;
		double base = 0.0, altura = 0.0;
		
		Scanner in = new Scanner(System.in);
		Fabrica fabrica = null;
		
		System.out.println("Digite o nome do material: ");
		material = in.next();
		
		System.out.println("Digite as dimensões da matéria prima: ");
		System.out.println("Altura: ");
		altura = in.nextDouble();
		
		System.out.println("Base: ");
		base = in.nextDouble();
		
		try {
			fabrica = new Fabrica(material, base, altura);
			
		} catch(NullPointerException npE) {
			System.out.println("Fabrica não pode ser criada. ERRO");
			System.out.println(npE.toString());
			in.close();
		}
		
		while (opcao != 6) {
			System.out.println(getMenu().toString());
			opcao = in.nextInt();
			
			switch (opcao) {				
				case 1:
					criaRetangulo(in, fabrica);
					break;
					
				case 2:
					criaQuadrado(in, fabrica);
					break;
					
				case 3:
					criaCirculo(in, fabrica);
					break;
					
				case 4:
					mostraRetalho(fabrica);
					break;
					
				case 5:
					mostraResultadoArea(fabrica);
					break;
			}
		}
	}

	/**
	 * Retorna o resultado da área da matéria prima em metros e porcentagem
	 * @param fabrica
	 */
	private static void mostraResultadoArea(Fabrica fabrica) {
		System.out.println("Area da materia prima restante: " + fabrica.getAreaRestante() + " metros quadrados");
		System.out.println("Porcentagem da materia prima restante: " + fabrica.PorcentagemRestante() * 100 + "%");
	}

	/**
	 * Retorna as formas ja recortadas e suas areas
	 * @param fabrica
	 */
	private static void mostraRetalho(Fabrica fabrica) {
		System.out.println("Retalhos:");
		
		for (Shape recorte : fabrica.cortesFeitos()) {
			System.out.println("Area: " + recorte.getArea());
			System.out.println("Forma: " + recorte.toString()); 
		}
	}

	/**
	 * Método que recorta um circulo
	 * @param in
	 * @param fabrica
	 */
	private static void criaCirculo(Scanner in, Fabrica fabrica) {
		System.out.println("Digite o raio do circulo a ser recortado");
		double raio = in.nextDouble();
		
		Circulo corteCirculo = new Circulo(raio);
		
		try {
			fabrica.corta(corteCirculo);
		
		} catch(RuntimeException e) {
			System.out.println(getErroCorte());
			System.out.println(e.toString());
		}
	}

	/**
	 * Método que recorta um quadrado
	 * @param in
	 * @param fabrica
	 */
	private static void criaQuadrado(Scanner in, Fabrica fabrica) {
		System.out.println("Digite o lado do quadrado a ser recortado: ");
		double ladoQuad = in.nextDouble();
		
		Quadrado corteQuadradado = new Quadrado(ladoQuad);
		
		try {
			fabrica.corta(corteQuadradado);
		
		} catch(RuntimeException e) {
			System.out.println(getErroCorte());
			System.out.println(e.toString());
		}
	}

	/**
	 * Método que recorta um retangulo
	 * @param in
	 * @param fabrica
	 */
	private static void criaRetangulo(Scanner in, Fabrica fabrica) {
		System.out.println("Digite a base do retangulo a ser recortado: ");
		double baseRet = in.nextDouble();
		
		System.out.println("Digite a altura do retangulo a ser recortado: ");
		double alturaRet = in.nextDouble();
		
		Retangulo corteRetangulo = new Retangulo(baseRet, alturaRet);
		
		try {
			fabrica.corta(corteRetangulo);
			
		} catch(RuntimeException e) {
			System.out.println(getErroCorte());
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Retorna a string do menu
	 * @return
	 */
	private static StringBuilder getMenu() {
		StringBuilder menu = new StringBuilder();
		menu.append("\nDigite: ");
		menu.append("\n1 para recortar retangulo");
		menu.append("\n2 para recortar quadrado");
		menu.append("\n3 para recortar circulo");
		menu.append("\n4 para exibir recortes");
		menu.append("\n5 para exibir materia prima restante");
		menu.append("\n6 Sair");
		menu.append("\n\nOpcao: ");
		
		return menu;
	}
	
	/**
	 * Mensagem de erro do corte
	 * @return
	 */
	private static String getErroCorte() {
		return "Nao foi possível recortar!";
	}
}
