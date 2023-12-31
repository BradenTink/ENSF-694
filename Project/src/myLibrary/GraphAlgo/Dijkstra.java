package myLibrary.GraphAlgo;

public class Dijkstra {
	int V = 0;
	// Apply Dijkstras algorithm
	public void Dijkstra_Algo(int[][] graph, int source) 
	{	
		 V = graph.length;
		 // The output array will hold distance from source to i 
		 int dist[] = new int[V]; 
		
		// keep track is the current vertex i is included in the 
		 
		// sptSet[i] will true if vertex i is included in
		// shortest path tree or shortest distance from src
		// to i is finalized
		Boolean sptSet[] = new Boolean[V];
		
		// Initialize all distances as INFINITE and stpSet[]
		// as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		// Distance of source vertex from itself is always 0
		dist[source] = 0;
		
		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set
			// of vertices not yet processed. u is always
			// equal to src in first iteration.
			int u = minDistance(dist, sptSet);
		
			// Mark the picked vertex as processed
			sptSet[u] = true;
		
			// Update dist value of the adjacent vertices of
			// the picked vertex.
			for (int v = 0; v < V; v++) {
		
				// Update dist[v] only if is not in sptSet,
				// there is an edge from u to v, and total
				// weight of path from src to v through u is
				// smaller than current value of dist[v]
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		printSolution(dist);
		
	}
	void printSolution(int dist[]){
		for (int i = 0; i < V; i++) {
			System.out.println("Distance from 0 " + "to " + i + " is " + dist[i]);
		}
			
	}
    int minDistance(int dist[], Boolean sptSet[]){
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
	

}
