package myLibrary.GraphAlgo;

import java.util.Arrays;

public class BFS 
{
	public int[][] Graph;
	private int V;
	public BFS(int v) {
		V = v;
		
		Graph = new int[v][v];
		
	}

	// You can use either adjacency matrix or adjacency list to keep track of the graph
	
	// Add edge to graph
    public void addEdge(int v,int w)
    {
    	
    	Graph[v][w] = 1;
    	Graph[w][v] = 1;

  
    }
 
    // Apply BFS algorithm and display the nodes visited and the visit array values
    // See the sample output to create a proper format
    public void BFS_Algo(int n)
    {	
    	

     	Queue queue = new Queue(V);
    	
    	String[] visitedNode = new String[V];
    	for(int i = 0; i < visitedNode.length; i++) {
    		visitedNode[i] = "False";
    	}
    	int[] nodePath =  new int[V];
    	
    	int count = 0;
    	
    	queue.enqueue(count);
    	while(count < V) {
			//Dequeue
			
			int dequeueNode = queue.dequeue();
			visitedNode[0] = "True";
			nodePath[count] = dequeueNode;
			
			if(dequeueNode != -1) {
			//For loop that will check each column of the 2d matrix 
				for(int i = 0;i<V;i++) {
					
					
					//if node is not visited and has an edge then enqueue it 
					if((Graph[dequeueNode][i]) == 1 && (visitedNode[i]) == "False" ) {
						
						queue.enqueue(i);
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

}
class Queue {
	public int[] queue;
	int head = -1;
	int tail = -1;
	
	// Define Queue
	Queue(int size){
		queue = new int[size];
	}
	
	// Enqueue
	public void enqueue(int data)
	{	
		//System.out.println("Enqueued node: " + data);
		int size = queue.length;
		if (tail == size-1) {
			//System.out.println("Queue if Full");
		}
		else {
			if(head == -1 && tail == -1) {
				head = 0;
				tail = 0;
			}
			else {
				tail = tail + 1;
			}
			queue[tail] = data;
		}
	}
	
	// Dequeue
	public int dequeue()
	{
		
		int data;
		if(head < 0 || head > tail) {
			return -1;
		}
		else {
			data = queue[head];
			queue[head] = -1;
			head = head + 1;
			//System.out.println("Dequeued node: " + data);
		}
		
		return data;
	}
	
	// Display queue
	public void display()
	{
		for (int i = 0; i < queue.length; i++) {
			System.out.print(queue[i] + " ");
		}
	}
	
	public int size() {
		int size = 0;
		for (int i = 0; i < queue.length; i++) {
			size = size + 1;
		}
		return size;
	}

	// Add any other parts needed
}


