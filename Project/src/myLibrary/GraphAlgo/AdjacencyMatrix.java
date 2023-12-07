package myLibrary.GraphAlgo;

public class AdjacencyMatrix {
	public int[][] ajdMatrix;
	int nodeCount = -1;
	
	// Define adjacency matrix
	public AdjacencyMatrix(int numberNodes) {
		ajdMatrix = new int[numberNodes][numberNodes]; 
		nodeCount = numberNodes;
	}
	
	// Add new edges
    public void addEdge(int source, int destination, int cost) 
    {
    	ajdMatrix[source][destination] = cost;
    	ajdMatrix[destination][source] = cost;
    	
 
    }
    
    // return adjacency matrix
    public int[][] getAdjacencyMatrix() 
    {
		return ajdMatrix;
    }

    // Display adjacency matrix
    public void displayAdjacencyMatrix() 
    {	        
    	for(int i = 0; i<nodeCount;i++) {
    		
    		System.out.print("Node " + i +": ");
    		for(int j = 0;j<nodeCount;j++) {
    			
    			System.out.print(ajdMatrix[i][j]+ " ");
    		}
    		System.out.println();
    	}
    }
    
    // Add any other parts needed
    
}

