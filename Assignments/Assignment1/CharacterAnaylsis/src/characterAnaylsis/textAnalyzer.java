package characterAnaylsis;

import java.util.Arrays;

//import java.io.*;
//import java.util.Map;
//import java.util.TreeMap;

/**
 * 
 * Text Analyzer Class 
 * 
 * @author Braden
 *
 */
public class textAnalyzer {
	
	/**
	 * 
	 * Text Breakdown method 
	 * Takes in one argument being a string 
	 * @return an int [] 
	 */
	public static int[] textBreakdown(String file) {
		System.out.println("Entered Text BreakDown");
		
		//Create two arrays that will hold the characters found and the count of each 
		//Character. 
		int[] countArray = new int[128];
		char[] charArray = new char[128];
		
		int count = 0;
		/*
		 * Double for loop that goes through the file 
		 * then check if the character is in the array.
		 * 		 
		 */
		for(int j = 0; j < file.length(); j++) {
			
			for(int i = 0; i < charArray.length; i++) {
				if(charArray[i] == file.charAt(j)) {
					countArray[i] = countArray[i] + 1;
					break;
				}
				if (i == count){
					charArray[count] = file.charAt(j);
					countArray[count] = 1;
					count++;
					break;
				}	
			}		
		}
		/*
		 * Trim array so its the correct size and no empty spaces 
		 */
		int[] copyCount = new int[count];
		copyCount = Arrays.copyOf(countArray,count);
		char[] copyChar = new char[count];
		copyChar = Arrays.copyOf(charArray,count);
		
		for (int i = 0; i<copyChar.length;i++) {
			if (String.valueOf(copyChar[i]).isBlank()) {
				System.out.println("space - "+ copyCount[i]);
			}
			else {
				System.out.println(copyChar[i] +" - "+ copyCount[i]);
			}	
		}
			
		return copyCount;
	}

}	
/**
 * Tree map option instead of using double for loop
 */
//TREE MAP
// Sorting the array
//		int value = 0;
//		Map<String, Integer> treeMap = new TreeMap<>();
//		for(int j = 0; j < file.length(); j++) {
//			if (treeMap.containsKey(file.charAt(j))) {
//				value = treeMap.get(String.valueOf(file.charAt(j)));
//				treeMap.replace(String.valueOf(file.charAt(j)),value + 1);
//			}else {
//			
//				treeMap.put(String.valueOf(file.charAt(j)), 1);
//			}	
//		}
//		for (int i = 0; i < treeMap.size(); i++)
//		     System.out.println("Key: " + treeMap.getKey() + ". Value: " + entry.getValue());
//		}
//        // Adding elements to the tree map
//        treeMap.put("A", 1);
//        treeMap.put("C", 3);
//        treeMap.put("B", 2);
//        // Getting values from the tree map
//        System.out.println("Value of A: " + valueA);
//        // Iterating over the elements of the tree map
//        for (String key : treeMap.keySet()) {
//            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
//	    }
		
	

