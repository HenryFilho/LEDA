package forma;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		// Coleção de formas
		Map<String,Forma> formas = new HashMap<>();
		
		// Inicializando algumas formas de exemplo
		formas.put("Triangulo", new Triangulo(100, 50)); // 2500,00
		formas.put("Retangulo", new Retangulo(100, 50)); // 5000,00
		formas.put("Quadrado", new Quadrado(100)); // 10000,00
		formas.put("Circulo", new Circulo(50)); // 7853,98
		for (String forma : formas.keySet()) {
			System.out.println(String.format("%s: %.2f", forma, formas.get(forma).calcArea()));
		}
	}

}
