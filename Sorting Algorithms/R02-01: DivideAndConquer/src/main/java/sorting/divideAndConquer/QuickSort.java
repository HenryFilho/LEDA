package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int middleIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, middleIndex-1);
			sort(array, middleIndex+1, rightIndex);
		}
	}

	private int partition(T[] arr, int left, int right) {
		int i = left, j = left+1;
		while(j<=right) {
			if(arr[left].compareTo(arr[j]) > 0) {
				i++;
				Util.swap(arr, i, j);
			}
			j++;
		}
		Util.swap(arr, left, i);
		return i;
	}
}