package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			try {
				int min = leftIndex;
				for(int i = leftIndex+1; i <= rightIndex; i++)
					if(array[i].compareTo(array[min]) < 0)
						min = i;
				Util.swap(array, leftIndex, min);
				sort(array, leftIndex+1, rightIndex);
			}catch(IndexOutOfBoundsException e) {}
		}
	}
}
