package myLibrary.DataStructures.SearchSort;

public class Sort {
	
	// Apply one of the sorting algorithms
	int[] insertionSort(int[] array){
		for (int i = 1, j; i < array.length;i++) {
			int temp = array[i];
			for( j = i-1; j>= 0 && temp < array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
		return array;
	}
	
	// Add any other parts needed
}
