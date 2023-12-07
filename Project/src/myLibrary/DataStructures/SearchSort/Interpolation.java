package myLibrary.DataStructures.SearchSort;


public class Interpolation {
	
	// Apply interpolation search
	
	
	// Add sorting algo in this class
	void sortArr(int[] array){
		for (int i = 1, j; i < array.length;i++) {
			int temp = array[i];
			for( j = i-1; j>= 0 && temp < array[j]; j--) {
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
	}
	
	
	int interpolationSearchIterative(int[] array, int key)
	{
		
		//Need to call a sort algo for the array 
		sortArr(array);
	
		int n = array.length;
		int low = 0; 
		
		int index = interpolationSearch(array, low, n-1, key);
		
		return index;
	}
	
	
	
	// Add any other parts needed
	public static int interpolationSearch(int array[], int low, int high, int key) {
		
		if (low <= high) {
			
			int pos = (key - array[low]) / (array[high]-array[low]);
			
			int mid = (low + ((high - low) * pos));
			
			if (key == array[mid])
					return mid;
			else if (key < array[mid])
					return interpolationSearch(array, low, mid-1,key);
			else if(key > array[mid])
				return interpolationSearch(array, mid+1, high,key);
			
			
		}
		return -1;
	}
	
}
