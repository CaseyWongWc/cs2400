package project3queue;
//import Aexceptions.EmptyQueueException;
public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node firstNode; // refrences node at front of the queue
    private Node lastNode; //refrences node at back of queue

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    }

    //*  */
    public void enqueue(T newEntry)
    {
        Node newNode = new Node(newEntry, null);
        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
    }

    public T dequeue()
    {
        T front = getFront();

        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
        lastNode = null;

        return front;
    }

    public T getFront()
    {
        if (isEmpty())
        {
            return null; //cannot make empty exception thingy
        }
        else
        {
            return firstNode.getData();
        }
    }


    public Boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    }





    private class Node
    {
        private T data; //entry in queue
        private Node next; // link to next node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end consttructor

        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        }
        public T getData() 
        {
            return data;
        }
        public void setData(T newData) 
        {
            data = newData;
        }
        public Node getNextNode() 
        {
            return next;
        }
        public void setNextNode(Node nextNode) 
        {
            next = nextNode;
        }
        
    }





    @Override
    public void printQueue() 
    {
        QueueInterface<T> tempQueue = new LinkedQueue<>();

        // Transfer from original queue to temporary queue to preserve order
        while (!isEmpty()) 
        {
            T item = dequeue();
            System.out.print(item + " ");
            tempQueue.enqueue(item);
        }
        // Restore the original queue from the temporary queue
        while (!tempQueue.isEmpty()) 
        {
            enqueue(tempQueue.dequeue());
        }
        System.out.println();
    }

    
}