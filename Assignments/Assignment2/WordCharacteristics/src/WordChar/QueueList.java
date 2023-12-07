package WordChar;

class QNode {
    int data;
    QNode next;
 
    //Constructor Node for QNode
    public QNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}
 
/**
 * QueueList Class
 * @author Braden
 *
 */
class QueueList {
    QNode front, rear;
 
    public QueueList() { this.front = this.rear = null; }
 
    // Method to add an key to the queue.
    void enqueue(int data)
    {
 
       
        QNode temp = new QNode(data);
 
        // If queue is empty, then new node is front and
        // rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
 
        // Add the new node at the end of queue and change
        // rear
        this.rear.next = temp;
        this.rear = temp;
    }
 
    // Method to remove an key from queue.
    int dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return 0;
 
        // Store previous front and move front one node
        QNode temp = this.front;
        int tempInt = temp.data;
        this.front = this.front.next;
 
        // If front becomes NULL, then change rear also as NULL
        if (this.front == null) {
            this.rear = null;
        }
		return tempInt;
		
    }
}
