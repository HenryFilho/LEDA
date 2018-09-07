package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if(n > 2) {
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		
		return result;
		
		// cf(3) + cf(2)
		// (
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}
	
	
}
