package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validate(array, leftIndex, rightIndex)) {
			
			int size = (rightIndex-leftIndex)+1;
			int gap = (int) (size / 1.25);
			boolean swaps = true;
			
			while(gap > 1 && swaps) {
				
				gap /= 1.25;
				if(gap < 1) gap = 1;
				swaps = false;
				
				for(int i = leftIndex; i < size-gap; i++) {
					if(array[i].compareTo(array[i+gap]) > 0) {
						Util.swap(array, i, i+gap);
						swaps = true;
					}
				}
				
				/*while(i+gap < (rightIndex-leftIndex)+1) {
					if(array[i].compareTo(array[i+gap]) > 0) {
						Util.swap(array, i, i+gap);
						swaps = true;
					}
					i++;
				}*/
				
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
