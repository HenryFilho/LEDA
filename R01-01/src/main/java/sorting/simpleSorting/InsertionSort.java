package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		leftIndex++;
		if(leftIndex <= rightIndex) {
			try {
				T aux = array[leftIndex];

                int i = leftIndex-1;
                while(i >= 0 && array[i].compareTo(aux) > 0) {
                        array[i+1] = array[i];
                        array[i] = aux;
                        i--;
                }
                sort(array, leftIndex, rightIndex);
			}catch(IndexOutOfBoundsException e) {}
		}
	}
}
