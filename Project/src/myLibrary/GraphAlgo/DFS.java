package myLibrary.GraphAlgo;

import java.util.Arrays;

public class DFS {
	
	public int[][] Graph;
	private int V;
	
	
	
	// Define BFS 
	public DFS(int v) {
		V = v;
		Graph = new int[v][v];
	
	}
	// You can use either adjacency matrix or adjacency list to keep track of the graph
		
	// Add edge to graph
    void addEdge(int v, int w)
    {
    	Graph[v][w] = 1;
    	Graph[w][v] = 1;

    }
 
    // Apply DFS algorithm and display the nodes visited and the visit array values
    // See the sample output to create a proper format
    void DFS_Algo(int v)
    {
    	Stack stack = new Stack(V);
    	String[] visitedNode = new String[V];
    	for(int i = 0; i < visitedNode.length; i++) {
    		visitedNode[i] = "False";
    	}
    	int[] nodePath =  new int[V];
    	
    	int count = 0;
    	
    	stack.push(count);
    	while(count < V) {
			//Dequeue
			
			int dequeueNode = stack.pop();
			visitedNode[0] = "True";
			nodePath[count] = dequeueNode;
			if(dequeueNode != -1) {
				//For loop that will check each column of the 2d matrix 
				for(int i = 0;i<V;i++) {
					
					//if node is not visited and has an edge then enqueue it 
					if((Graph[dequeueNode][i]) == 1 && (visitedNode[i]) == "False" ) {
						
						stack.push(i);
						visitedNode[i] = "True";
						
						Graph[i][dequeueNode] = 0;
						
					}
						
				}
			}
			else {
				System.out.println("Found a disjointed Graph");
			}
	
			count += 1;
		}
		//Print out the path of the BFS
    	for(int i = 0;i<nodePath.length;i++) {
    		System.out.print(nodePath[i] + " - ");
    	}
		
		System.out.println("\nVisited Nodes: " + (Arrays.toString(visitedNode)));
    	
    }
    
    // Add any other parts needed
  //Push method takes on in one argument a string
}
class Stack {
	public int[] stack;
	int top = -1;
	int max_size = -1;
	
	Stack(int size){
		stack = new int[size]; 
	}
	
    public void push(int d) {
  		if (top == max_size-1) {
  			return;
  		}
  		else {
  			top = top + 1;
  			stack[top] = d;
  		}
  		
  	}
  	
  	//Pop method takes no arguments and returns the ddata
  	public int pop() {
  		int data;
  		if(top < 0 ) {
  			return -1;
  		}
  		else
  		{
  			data = stack[top];
  			stack[top] = -1;
  			top = top - 1; 
  		}
  		return data;
  	}
  	
  	//Display method
  	public void display() {
  		for(int i=0;i<=stack.length - 1;i++) {
  			System.out.println(stack[i] + " ");
  		}
  	}
}
