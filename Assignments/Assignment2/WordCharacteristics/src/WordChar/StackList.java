package WordChar;

public class StackList {
	
	
	static class StackNode{
		int data;
		StackNode last;
		
	}
	
	StackNode head; 
	
	StackList() { 
		this.head = null; 
	}
	
	public void push(int data) {
		
		StackNode newNode = new StackNode();
		
		newNode.data = data;	 
		newNode.last = head;

	    head = newNode;
	}
	
	public int pop(){
		int data;
		if (head == null) {
            //System.out.print("\nStack Underflow");
            return -1;
        }
		data = head.data;
		head = (head).last;
		return data;
		
	}
	
	 public void display(){
        // check for stack underflow
        if (head == null) {
           // System.out.printf("\nStack Underflow");
           
        }
        else 
        {
        	StackNode temp = head;
            while (temp != null) {
 
                System.out.print(temp.data);
 
                // assign temp link to temp
                temp = temp.last;
//                if(temp != null) {
//                    System.out.print(" -> ");
//                }
            }
        }
        
	 }
		
}

