package b11_dsa_stack_queue.bai_tap.circular_queue;

public class Main {
    /*  Driver of the program  */
    public static void main(String args[]) {
        // Create a queue and initialize front and rear
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.deQueue()); //null
        myQueue.enQueue(1);
        System.out.println(myQueue.deQueue().data); //node1.data = 1
        myQueue.displayQueue(); //null
        myQueue.enQueue(1);
        myQueue.displayQueue(); // 1
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.displayQueue(); // 3 4 5

    }
}
