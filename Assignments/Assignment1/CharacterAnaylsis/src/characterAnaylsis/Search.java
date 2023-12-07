package characterAnaylsis;

/**
 * Search Class
 * 
 * @author Braden
 *
 */
public class Search {
	
	/**
	 * binarySearchIterative method 
	 * @param int[] array 
	 * @param int key
	 * @return int being the index of the array 
	 * else return -1 if not found
	 */
	static int binarySearchIterative(int[] array, int key){
		int low = 0, mid, high = array.length-1;
		while (low <= high){
			mid = (low + high)/2;
			
			if(key < array[mid])
				high = mid - 1;
			else if(array[mid] < key)
				low = mid + 1;
			else
				return mid; //key FOUND and index returned
		}
	return -1; //key NOT FOUND and -1 returned
	}
}
