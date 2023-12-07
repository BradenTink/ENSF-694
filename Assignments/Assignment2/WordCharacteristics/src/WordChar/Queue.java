package WordChar;

public class Queue {
	
	//Queue class variables
	int max_size = 50;; 
	int head = -1;
	int tail = -1;
	
	String queue[] = new String[max_size];
	
	//Enqueue method 
	public void enqueue(String data) {
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
	//Dequeue method 
	public String dequeue() {
		String data = "";
		if(head<0 || head > tail) {
			return "null";
		}
		else {
			data = queue[head];
			queue[head] = "";
			head = head + 1;	
		}
		return data;
	}
	
	//Display method 
	public void display() {
		for(int i=0;i<=queue.length - 1;i++) {
			//System.out.println(queue[i] + " ");
		}	
	}
}
