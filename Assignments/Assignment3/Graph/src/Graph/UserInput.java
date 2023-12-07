package Graph;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;


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
	public Scanner fileScanner; 
	public int[][] adjMatrix; 
	
	public void run() {
		
		/**
		 * Starting the Run 
		 */
		System.out.println("*** Graph Characteristics ***");
		
		//Grab user input for the input filename
		System.out.print("Enter the Input Filename: ");
		String fileName = scannerObj.nextLine();
		
		File file = new File(fileName);
		
		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String numberNodes = fileScanner.nextLine();
		try 
		{
			Integer.parseInt(numberNodes);
		}
		catch(NumberFormatException e)
		{
			System.out.println(numberNodes + " Is not a valid integer");
		}
		int nodeCount = Integer.parseInt(numberNodes);
		adjMatrix = new int [nodeCount][nodeCount];
		
		System.out.println("\nNumber of nodes in the graph: " + numberNodes);
		
		char nodeChar = 'a';
		System.out.print("\nNodes: ");
		for(int i = 0;i<nodeCount;i++) {
			System.out.print(nodeChar + " ");
			nodeChar += 1;
		}
		
		System.out.println("\n");
		int x = 0;
		while(fileScanner.hasNextLine()) {
			 
			
			String data = fileScanner.nextLine();
			System.out.println(data);
			String[] tempStr = data.split(" ");
			
			
			
			for(int j = 0; j< tempStr.length;j++) {
				//System.out.println(tempStr[j]);
				adjMatrix[x][j] = Integer.valueOf(tempStr[j]);
				
			}
			x++;
		}
		
		
		
		System.out.println("\nDegree of each node in the graph");
		System.out.println("Node : Degree");
		
		int totalEdges = 0;
		char currentChar = 'a';
		for(int i = 0; i< nodeCount;i++) {
			int nodeEdges = 0;
			
			for(int j = 0;j<nodeCount;j++) {
				//System.out.println(adjMatrix[i][j]);
				if(adjMatrix[i][j] >= 1) {
					nodeEdges =  nodeEdges + 1;
				}
				
			}
			System.out.println(currentChar + " : " + nodeEdges);
			
			totalEdges = totalEdges + nodeEdges;
			currentChar += 1;
		}
		
		System.out.println("\nTotal degree of the graph: " + totalEdges);
		
		System.out.println("\nMinimum Spanning Tree with Prim's Algorithm:");
		System.out.println("Edge: Min Cost/Distance/Weight");
		
		
		MST t = new MST(nodeCount);
		
		int total = t.primMST(adjMatrix);
		
		System.out.println("\nTotal cost of Minimum Spanning Tree with Prim's algorithmn: " + total);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInput app = new UserInput();
		app.run();
		
				
	}

}
