package sorting.divideAndConquer;

import java.util.Arrays;

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

	public static void main(String[] args) {
		Integer[] arr = { 3, 8, 7, 10, 23, 2, 1, 77, 8};
		AbstractSorting<Integer> s = new QuickSort<>();
		s.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
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
			if(arr[i].compareTo(arr[j]) > 0) {
				i++;
				Util.swap(arr, i, j);
			}
			j++;
		}
		Util.swap(arr, left, i);
		return i;
	}
/*	partition(v, left, right)
		pivot = v[left]
		
		# position to place the pivot
		i = left
		
		for j = left+ 1 to right{
			if (v[j] <= pivot){
				i += 1
				v[i],v[j] = v[j],v[i]
			}
		}
		v[left],v[i] = v[i],v[left]
		return i*/
}

/*
void quicksort (int[] a, int l, int r) {
if (l>=r) return;
int m = partition(a, l, r);
quicksort(a,l,m-1);
quicksort(a,m+1,r);
}
*/