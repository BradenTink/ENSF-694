package myLibrary.DataStructures.Linear;



public class Queue {
	int max_size;; 
	int head = -1;
	int tail = -1;
	int queue[];
	
	public Queue(int x){ 
		max_size = x;
		queue = new int[max_size];
	}
	
	// Enqueue
	public void enqueue(int data)
	{	
     
		if(tail == max_size-1) {
			return;
		}
		else {
			if(head==-1&& tail==-1) {
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
		if(head<0 || head > tail) {
			return 0;
		}
		else {
			data = queue[head];
			queue[head] = 0;
			head = head + 1;	
		}
		return data;
	
	}
	
	// Display queue
	public void display()
	{	
		if (head == -1 ) {
			System.out.println("Queue is empty");
			
		}
		else {
			for(int i=0;i<=queue.length - 1;i++) {
				System.out.print(queue[i] + " ");
			}	
		}
		
		
	}

	// Add any other parts needed
}
