package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && array != null && leftIndex >= 0 && rightIndex >= 0) {
			int middleIndex = (leftIndex+rightIndex)/2;
			sort(array, leftIndex, middleIndex);
			sort(array, middleIndex+1, rightIndex);
			merge(array, leftIndex, middleIndex, rightIndex);
		}
		
	}
	
	private void merge(T[] arr, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int k = left;
		
		T[] temp = Arrays.copyOf(arr, arr.length);
		
		while(i <= mid && j <= right) {
			if(temp[i].compareTo(temp[j]) < 0) {
				arr[k] = temp[i];
				i++;
			}else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}while(i <= mid) {
			arr[k] = temp[i];
			i++; k++;
		}while(j <= right) {
			arr[k] = temp[j];
			j++; k++;
		}
	}
	
}