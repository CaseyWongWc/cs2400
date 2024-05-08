package project3queue;

public final class TwoPartCircularLinkedQueue<T> implements QueueInterface<T>
{
    private Node queueNode;
    private Node freeNode;

    public TwoPartCircularLinkedQueue()
    {
        freeNode = new Node(null,null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    }



    
//* */


private boolean isNewNodeNeeded()
{
    return queueNode == freeNode.getNextNode();
}
public Boolean isEmpty()
{
    return queueNode == freeNode;
}

public T getFront()
{
    if (isEmpty())
    {
        return null;
    }
    else
    {
        return queueNode.getData();
    }
}

@Override
public void enqueue(T newEntry) 
{
    freeNode.setData(newEntry);
    if (isNewNodeNeeded())
    {
        //allocate a new node and insert it after the node that freeNode refrences
        Node newNode = new Node(null, freeNode.getNextNode());
        freeNode.setNextNode(newNode);
    }
    
    freeNode = freeNode.getNextNode();
}

public T dequeue()
{
    T front = getFront(); // Might throw EmptyQueueException
    // Assertion: Queue is not empty

    queueNode.setData(null);
    queueNode = queueNode.getNextNode();

    return front;
}

public void clear()
{
    queueNode = null;
    freeNode = null;
}


private class Node
{
    private T data; //Queue entry
    private Node next; //Link to next Node

    private Node(T dataPortion)
    {
        data = dataPortion;
        next = null;
    }

    private Node(T dataPortion, Node linkPortion)
    {
        data = dataPortion;
        next = linkPortion;
    }

    private T getData()
    {
        return data;
    }

    private void setData(T newData)
    {
        data= newData;
    }

    private Node getNextNode()
    {
        return next;
    }

    private void setNextNode(Node nextNode)
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

