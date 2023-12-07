package WordChar;

import java.util.Arrays;

/**
 * Anagram Class check if any other words contain the same characters
 * @author Braden
 *
 */
public class AnagramClass {
	
	//ConvertCharacter Method takes an array in 
	//Changes them to lower case the orders the array.
	public String[] convertCharacter(String[] array, int size){
		
		String[] copyArray = new String[size];
		copyArray = Arrays.copyOf(array, size);
		
		for(int i = 0; i < copyArray.length; i ++) {
			String tempStr = copyArray[i];
			tempStr = tempStr.toLowerCase();
			char tempArray[] = tempStr.toCharArray();
			Arrays.sort(tempArray);	
			copyArray[i] = String.valueOf(tempArray);
		}
		
		String[] tempArray = checkAnagram(copyArray, size);
		return tempArray;
	}
	
	//Check Anagram loops through the array and finds any matches. 
	public String[] checkAnagram(String[] array, int size) {
		
		String[] checkArray = new String[size];
		
		//Grab the first entry of the array
		for(int i = 0; i< array.length; i++){
	
			for(int j = 0; j< array.length;j++) {
				if (i == j ){
					checkArray[i] = "No";
				}
				else 
				{
					//element i and j are different 
					if (array[i].equals(array[j])){
						// found a match add 
						checkArray[i] = "Yes";
						//System.out.println("found a match");
						break;
					}
					else if (j == array.length - 1)
					{
						checkArray[i] = "No";
					} 
				}
			}
		}
		return checkArray;
	}
}
