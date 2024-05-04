package project3queue;

public class demoQueue 
{
    public static void main(String[] args) 
    {
       /*  QueueInterface<String> myQueue = new TwoPartCircularLinkedQueue<String>();
        myQueue.enqueue("Jim");
        myQueue.enqueue("Jess");
        myQueue.enqueue("Jill");
        myQueue.enqueue("Jane");
        myQueue.enqueue("Joe");
        
        String front = myQueue.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue.dequeue();
        front = myQueue.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue.dequeue();
        front = myQueue.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue.clear();
        front = myQueue.getFront();
        System.out.println(front + " is at the front of the queue.");

        //===============
        System.out.println();
        //===============
        QueueInterface<String> myQueue2 = new ArrayQueue<String>();
        myQueue2.enqueue("Jim");
        myQueue2.enqueue("Jess");
        myQueue2.enqueue("Jill");
        myQueue2.enqueue("Jane");
        myQueue2.enqueue("Joe");
        
        front = myQueue2.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue2.dequeue();
        front = myQueue2.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue2.dequeue();
        front = myQueue2.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue2.clear();
        front = myQueue2.getFront();
        System.out.println(front + " is at the front of the queue.");

        myQueue2.enqueue("bob");
        front = myQueue2.getFront();
        System.out.println(front + " is at the front of the queue.");*/

        //===============
        QueueInterface<String> zooDelivery = new circularArrayQueue<>(); //LinkedQueue.java

        zooDelivery.enqueue("lion");printQueue(zooDelivery);
        zooDelivery.enqueue("tiger");printQueue(zooDelivery);
        zooDelivery.enqueue("cheetah");printQueue(zooDelivery);
        zooDelivery.dequeue();printQueue(zooDelivery);
        zooDelivery.enqueue("tiger");printQueue(zooDelivery);
        zooDelivery.dequeue();printQueue(zooDelivery);
        zooDelivery.enqueue("jaguar");printQueue(zooDelivery);
        

        





    }
    


    //helper
    private static void printQueue(QueueInterface<String> queue) {
        QueueInterface<String> tempQueue = new LinkedQueue<>();
        System.out.println("============");
        System.out.println("Queue contents from front to rear: (chronological order)");
        // Transfer from original queue to temporary queue to preserve order
        while (!queue.isEmpty()) {
            String item = queue.dequeue();
            System.out.print(item + ", ");
            tempQueue.enqueue(item);
        }
        // Restore the original queue from the temporary queue
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
        System.out.println();
    }
}
