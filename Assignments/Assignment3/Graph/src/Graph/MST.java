package Graph;


public class MST {
	
	 // Number of vertices in the graph
	int vCount;
	
	MST(int x){
		vCount = x;
	}
	
	//Method to find the vertice with the minimuim key value 
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < vCount; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed MST
    // stored in parent[]
    int printMST(int parent[], int graph[][])
    {	
    	int total = 0;
    	System.out.println("Node : Degree");
        for (int i = 1; i < vCount; i++) {
        	
        	System.out.println(getLetter(parent[i]) + " - " + getLetter(i) + "\t"
                                    + graph[i][parent[i]]);
        	
        	total = total + graph[i][parent[i]];
        	
        }
        return total;
    }
 
    // Method to create and print MST for a graph
    int primMST(int graph[][])
    {
        // Array to store MST
        int parent[] = new int[vCount];
 
        // Key values used to pick minimum weight edge
        int key[] = new int[vCount];
 
        //represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[vCount];
 
        // Initialize all keys as INFINITE
        for (int i = 0; i < vCount; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        // Always include first vertex in MST.
        // Make key 0 so that this vertex is
        // picked first
        key[0] = 0;
       
        // First node is always the root of MST
        parent[0] = -1;
 
        // The MST will have vCount vertices
        for (int count = 0; count < vCount-1; count++) {
             
            // Pick the minimum key vertex from the set of
            // vertices not yet included in the MST
            int u = minKey(key, mstSet);
 
            // Add picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the
            // adjacent vertices of the picked vertex.
            // only select the vertices which are not
            // yet included in MST
            for (int v = 0; v < vCount; v++)
                // graph[u][v] is non zero only for adjacent
                // vertices of mstSet[v] is false for
                // vertices not yet included in MST 
            	//Update key if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
 
        // Print the constructed MST
        int total = printMST(parent, graph);
        return total;
        
    }
    
    //Method to change int repersentation of vertex to 
    //a char repersentation
    char getLetter(int x) {
		if (x == 0) {
			return 'a';
		}
		if (x == 1) {
			return 'b';
		}
		if (x == 2) {
			return 'c';
		}
		if (x == 3) {
			return 'd';
		}
		if (x == 4) {
			return 'e';
		}
		if (x == 5) {
			return 'f';
		}
		if (x == 6) {
			return 'g';
		}
		if (x == 7) {
			return 'h';
		}
		if (x == 8) {
			return 'i';
		}
		
		return 0;
    	

    }
	

}
