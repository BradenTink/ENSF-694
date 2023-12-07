package WordChar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * User Input Calss 
 * @author Braden
 *
 */
public class UserInput {

	/**
	 * Class objects declared 
	 */
	public String newWord;
	Scanner scannerObj = new Scanner(System.in);
	AnagramClass anagram = new AnagramClass();
	
	public void run() {
		
		/**
		 * Starting the Run 
		 */
		System.out.println("*** Word Characteristics ***");
		
		//Grab user input for the amount of words to be entered in an integer
		System.out.print(" Enter the number of Words: ");
		String arrayLengthInput = scannerObj.nextLine();
		
		/*
		 * Try Catch statement looking to see if the user 
		 * Entered a int 
		 */
		try 
		{
			Integer.parseInt(arrayLengthInput);
		}
		catch(NumberFormatException e)
		{
			System.out.println(arrayLengthInput + " Is not a valid integer");
		}
		
		//Grab user input to build array length
		int wordCount = Integer.parseInt(arrayLengthInput);
		String[] wordArray = new String[wordCount];
		
		//Grab user input for words
		System.out.println(" Enter input Words: ");
		for(int i = 0; i < wordArray.length;i++) {
			String newWord = scannerObj.nextLine();
			wordArray[i] = newWord;	
		}
		
		//Print out the list of words
		System.out.print("The input words are: ");
		System.out.println(Arrays.toString(wordArray));
		
		//Create a result array to check if 
		String[] anaResultArray = new String[wordCount];
		anaResultArray	= anagram.convertCharacter(wordArray, wordCount);
		
		//Anagrams print 
		System.out.println("Anagrams are as follows");
		for(int i=0;i<=anaResultArray.length - 1;i++) {
			System.out.println(wordArray[i] + "-" + anaResultArray[i]);
		}
		
		//palidrome result array
		String[] paliResultArray = new String[wordCount];
				
		//loop will go through all the words
		for(int i = 0; i<wordArray.length;i++) {
			String queueTempStr = "";
			String stackTempStr = "";
			String tempString = wordArray[i];
			
			tempString = tempString.toLowerCase();
			
			//Using a linked list to check for a palindrome
			//StackList StackNodeObj = new StackList();
			//QueueList QueueNodeObj = new QueueList();
			//Using an array to check for a palindrome 
			Stack stackObj = new Stack();
			Queue queueObj = new Queue();
			
			//Break out word to char
			//Input char into stack and queue using the push and enqueu
			for (int j = 0; j<tempString.length();j++) {
				stackObj.push(String.valueOf(tempString.charAt(j)));
				queueObj.enqueue(String.valueOf(tempString.charAt(j)));	
			}
		
			//Using the pop and dequeue pull the characters out of the array and find 
			for (int j = 0; j<tempString.length();j++) {
				stackTempStr = stackTempStr + stackObj.pop();
				queueTempStr = queueTempStr + queueObj.dequeue();
			}

			if (stackTempStr.equals(queueTempStr)) {
				// found Palindrome
				paliResultArray[i] = "Yes";
			} 
			else {
				// Not a palindrome 
				paliResultArray[i] = "No";
			}
		
		}
		
		//Print out the results for the palindrome test
		System.out.println();
		System.out.println("Palindrome are as follows");
		for(int i=0;i<=wordArray.length - 1;i++) {
			System.out.println(wordArray[i] + "-" + paliResultArray[i]);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInput app = new UserInput();
		app.run();
		
				
	}

}
