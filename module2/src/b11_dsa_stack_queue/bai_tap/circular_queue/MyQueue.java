package b11_dsa_stack_queue.bai_tap.circular_queue;

// Java program for insertion and
// deletion in Circular Queue

public class MyQueue {
    private Node front;
    private Node rear;


    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Function to create Circular queue
    public void enQueue(int value) {
        Node temp = new Node(value);
        if (this.front == null) {
            this.front = temp;
            this.rear = temp;
            this.front.link = rear;
            this.rear.link = front;
        } else {
            this.rear.link = temp;
            this.rear = temp;
            this.rear.link = this.front;
        }
    }

    // Function to delete element from Circular Queue
    public Node deQueue() {
        if (front == null) {
            return null;
        } else if (front == rear) {
            Node temp = front;
            front = null;
            rear = null;
            return temp;
        } else {
            Node temp = front;
            front = front.link;
            rear.link = front;
            return temp;
        }
    }

    // Function displaying the elements of Circular Queue
    public void displayQueue() {
        Node temp = front;
        if (front == null) {
            System.out.println("null");
        } else {
            while (temp.link != front) {
                System.out.println(temp.data);
                temp = temp.link;
            }
            System.out.println(rear.data);
        }
    }
}

