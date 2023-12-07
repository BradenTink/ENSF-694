package WordChar;

public class Stack {
	
	int max_size = 1050;
	int top = -1;
	String stack[] = new String[max_size];
	
	//Push method takes on in one argument a string
	public void push(String d) {
		if (top == max_size-1) {
			return;
		}
		else {
			top = top + 1;
			stack[top] = d;
		}
		
	}
	
	//Pop method takes no arguments and returns the ddata
	public String pop() {
		String data;
		if(top < 0 ) {
			return "";
		}
		else
		{
			data = stack[top];
			stack[top] = "";
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
