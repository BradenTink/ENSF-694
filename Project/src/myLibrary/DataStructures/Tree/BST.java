package myLibrary.DataStructures.Tree;

public class BST {

	// Create node
	public Node createNode(int data) {
		Node node = new Node(data);
		
		node.data = data;
		node.left = null;
		node.right = null;
		
		return node;
		
	}
	// Insert new node in BST - you can use recursive or iterative method
	public Node insert(int data, Node root) 
	{
		if (root == null) {
			return createNode(data);
		}
		if( data <= root.data) {
			root.left = insert(data, root.left);
		}
		else if(data  > root.data) {
			root.right = insert(data, root.right);
		}
		return root;
	
	}
	
	// Inorder traversal - recursive OR iterative
	public void inOrder(Node node) 
	{
		if (node == null) {
			return;
		}
		inOrder(node.left);
		
		System.out.print(node.data + " ");
		
		inOrder(node.right);
	}

	// Preorder traversal - recursive OR iterative
	public void preOrder(Node node) 
	{
		if (node == null){
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// Postorder traversal - recursive OR iterative
	public void postOrder(Node node) 
	{
		if (node == null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	// Breadth first traversal - recrsive OR iterative
	public void breadthFirstTraversal(Node root) 
	{
		if (root == null) {
            return;
        }

		CustomQueue queue = new CustomQueue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.enqueue(node.left);
            }

            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
	}
	
	// Search in BST
	public Node searchBinarySearchTree(Node node, int key)
	{
		while( node != null) {
				if (key == node.data) {
					return node;
				}
				else if (key < node.data) {
					node = node.left;
				}
				else {
					node = node.right;
				}
		}
		return null;
	}
	
	// Delete from BST
	public Node deleteNode(Node root, int key) 
	{
		if (root == null) {
			return root;
		}

		// Search for the node to delete
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} 
		else if (key > root.data) {
		    root.right = deleteNode(root.right, key);
		}
		else {
		    // Node with only one child or no child
		if (root.left == null) {
		    return root.right;
		} else if (root.right == null) {
		    return root.left;
		}
		// Node with two children: Get the inorder successor (smallest in the right subtree)
		root.data = minValue(root.right);
		
		// Delete the inorder successor
		    root.right = deleteNode(root.right, root.data);
		 }
		return root;
	}
	
	private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
	
	// Add any other parts needed

}


class QueueNode {
    Node data;
    QueueNode next;

    QueueNode(Node data) {
        this.data = data;
        this.next = null;
    }
}

class CustomQueue {
    private QueueNode front;
    private QueueNode rear;

    public void enqueue(Node data) {
        QueueNode newNode = new QueueNode(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}




