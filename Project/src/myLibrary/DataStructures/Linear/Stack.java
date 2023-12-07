package myLibrary.DataStructures.Linear;

public class Stack {
	public int[] stack;
	int top = -1;
	
	// Define stack
	Stack(int size){
		stack = new int [size];	
		
	}
	
	// Push 
	public void push(int data)
	{
		int size = stack.length;
		if(top == size-1) {
			//System.out.println("Stack is Full");
			return;
		}
		else {
			top = top + 1;
			stack[top] = data;
		}
	}
	
	// Pop
	public int pop()
	{
		int data;
		if(top < 0 ) {
			return -1;
		}
		else
		{
			data = stack[top];
			stack[top] = 0;
			top = top - 1; 
		}
		
		return data;	
	}
	
	// Display stack
	public void display()
	{
		for(int i = 0; i <= stack.length -1;i++) {
			System.out.print(stack[i] + " ");	
		}	
	}
	
	// Add any other parts needed

}
