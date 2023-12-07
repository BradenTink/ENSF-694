package myLibrary.DataStructures.Linear;

public class SLL {
	
	public Node head = null;
	public Node tail = null;
	// Define node
	class Node{
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	
	// Create node
	
	// Add node to SLL
    public void addNode(int data) 
    {   
    	Node newNode = new Node(data);
    	
    	if (head == null) {
    		head = newNode;
    		tail = newNode;
    	}
    	else {
    		tail.next = newNode;
    		tail = newNode;
    		
    	}
    }   
    
    // Search node in SLL
    public int searchNode(int key)
    {
    	Node current = head;
    	if (current == null) {
    		return -1;
    	}
    	else {
    		while(current != null) {
    			if (current.data == key) {
    				break;
    			}
    			else {
    				current = current.next;
    			}
    		}
    	}
		return key;
    }
    
    // Delete node form SLL
    public void deleteNode(int key) 
    {
    	System.out.println("\nDeleting Node with value " + key);
    	Node current = head;
    	if (current == null) {
    		return;
    	}
    	if(current.data == key ) {
    		current = current.next;
    		head = current; 
    		return;
    	}
    	
    	Node previous = head;
    	while(current != null) {
    		if(current.data == key) {
    			current = current.next;
    			previous.next = current;
    		}
    		else {
    			previous = current;
    			current = current.next;
    		}	
    	}
    }
    
    // Display SLL
    public void display(){  
    	
    	System.out.println("\nCurrent nodes of the singly linked list:");
    	Node current = head;
    	
    	if (current == null) {
    		return;
    	}
    	while(current != null) {
    		System.out.print(current.data + " ");
    		current = current.next;
    	}
    	System.out.println();
    } 
    // Add any other parts needed
}
