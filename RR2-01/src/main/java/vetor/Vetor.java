package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> {

	// O array interno onde os objetos manipulados são guardados
	private T[] array;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	@SuppressWarnings("unchecked")
	public Vetor() {
		array = (T[]) new Object[1];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T t) {
		resize(array.length+1);
		
		array[array.length-1] = t;
	}

	// Remove um objeto do vetor
	public T remover(int indice) {
		if(indice >= array.length)
			throw new IndexOutOfBoundsException();
		if(indice < 0)
			throw new IllegalArgumentException();
		
		T result = array[indice];
		
		if(indice < array.length-1)
			for (int i = indice; i < array.length-1; i++)
				array[i] = array[i+1];
		resize(array.length-1);
		
		return result;
	}

	// Procura um elemento no vetor
	public T procurar(int indice) {
		if(indice >= array.length)
			throw new IndexOutOfBoundsException();
		if(indice < 0)
			throw new IllegalArgumentException();
		
		return array[indice];
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return array.length == 0;
	}

	@SuppressWarnings("unchecked")
	private void resize(int novoTamanho) {
		T[] novaArray = (T[]) new Object[novoTamanho];
		
		int percorrer = 0;
		if(array.length < novaArray.length)
			percorrer = array.length;
		else
			percorrer = novaArray.length;
		
		for (int i = 0; i < percorrer; i++) {
			novaArray[i] = array[i];
		}
		array = novaArray;
	}
	
}
