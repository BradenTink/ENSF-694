package characterAnaylsis;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * 
 * @author Braden
 * fileInput class
 * Three class variables 
 * public string inputFile 
 * public int key 
 * private InteractiveCli object cli  
 */
public class fileInput {
	
	public String inputFile;
	public static int key;
	
	private InteractiveCLI cli;
	
	
	/**
	 * fileInput constructor 
	 */
	public fileInput() {
		cli = new InteractiveCLI();
	}
	
	/**
	 * run method 
	 * Asks user for the file as well as a key in the array 
	 * 
	 * @return
	 * Return the contents of the file to string then return the string 
	 */
	public String run(){
		cli.display("*** Basic statistics of Text File ***");
		cli.prompt("  Enter a filename, e.g test.txt: ");
		String filename = cli.getKeyboardString();
		File file = new File (System.getProperty("user.dir") + "\\" + filename);
		
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content  = scanner.nextLine();
		
		
		cli.prompt("  Enter a Search key: ");
		key = cli.getKeyboardInteger();		
		
		return(content);
	}
	
	
	/**
	 * getKey method 
	 * Allows access to the key in the main loop
	 * @return
	 * Return int key 
	 */
	static int getKey() {
		return key;
	}
	
	/**
	 * Main method 
	 * Creates a new fileInput 
	 * 
	 * Calls textBreakdown taking in a string.
	 * Method then returns a int array of count of characters
	 * 
	 * Calls MergeSort taking in a Array, first position, last position 
	 * 
	 * Output array to string 
	 * 
	 * Calls binaryKeySearch taking in the sorted array
	 * as well as the user entered key
	 * 
	 * Outputs userKey and index if found from the search
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileInput app = new fileInput();
		String fileContent = app.run();
		
		
		int[] countArray = textAnalyzer.textBreakdown(fileContent);

		MergeSort mergeSort = new MergeSort();
		int[] sortedArray = mergeSort.sort(countArray, 0, countArray.length -1);
		
		System.out.println();
		System.out.println("Sorted Frequency Array");
		System.out.println(Arrays.toString(sortedArray));
		
		
		int userKey = getKey();
		
		
		int index = Search.binarySearchIterative(sortedArray, userKey);
		
		if (index != -1 ) {
			System.out.println("Serach key " + userKey + "Found");
			System.out.println();
			System.out.println("Search key " + userKey + " is at index " + index); 
		}
		
	
	}

}
