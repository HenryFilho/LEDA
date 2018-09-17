package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validate(array, leftIndex, rightIndex)) {
			int i = leftIndex;
			while(i<rightIndex) {
				if(array[i].compareTo(array[i+1]) <= 0) {
					i++;
				}else {
					Util.swap(array, i, i+1);
					
					if(i>leftIndex) i--; else i++;
				}
			}
		}
	}
	
	private boolean validate(T[] arr, int left, int right) {
		boolean c1 = arr != null,
				c2 = left >= 0,
				c3 = right < arr.length,
				c4 = left <= right,
				c5 = arr.length > 0;
		return (c1 && c2 && c3 && c4 && c5);
	}
}
