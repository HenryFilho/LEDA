package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {
	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex && array != null && leftIndex >= 0) {
		
			int maxValue = array[leftIndex];
			int minValue = array[leftIndex];
			Integer[] resultArray = Arrays.copyOf(array, array.length);
			
			for(int i = leftIndex+1; i <= rightIndex; i++)
				if(array[i] > maxValue)
					maxValue = array[i];
				else if(array[i] < minValue)
					minValue = array[i];
			
			int[] mapArray = new int[maxValue-minValue+1];
			
			for(int i = leftIndex; i <= rightIndex; i++)
				mapArray[array[i]-minValue]++;
			
			for(int i = 1; i < mapArray.length; i++)
				mapArray[i] += mapArray[i-1];
			
			for(int i = rightIndex; i >= leftIndex; i--)
				if(mapArray[array[i]-minValue] > 0) {
					mapArray[array[i]-minValue]--;
					resultArray[mapArray[array[i]-minValue]] = array[i];
				}
			
			for(int i = leftIndex; i <= rightIndex; i++)
				array[i] = resultArray[i];
		
		}
	}

}
