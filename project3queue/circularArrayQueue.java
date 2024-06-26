package project3queue;


public final class circularArrayQueue <T> implements QueueInterface <T> 
{
    private T queue[];
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK;
    private static final int DEFUALT_CAPACITY=3;
    private static final int MAX_CAPACITY=10000;
    
    public circularArrayQueue (int initialCapacity)
    {
       integrityOK = false;
       checkCapacity(initialCapacity);

       @SuppressWarnings("unchecked")
       T[] tempQueue = (T[]) new Object[initialCapacity+1];
       queue = tempQueue;
       frontIndex =0;
       backIndex = initialCapacity;
       integrityOK = true;
    }

    public circularArrayQueue()
    {
        this(DEFUALT_CAPACITY);
    }
    
    //* */
    private void checkCapacity(int capacity)
    {
       if (capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a bag whose " +"capacity exeeds allowed " +"maximum of " + MAX_CAPACITY);
        }
    }

    @Override
    public void enqueue(T newEntry) 
    {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex+1) % queue.length;
        queue[backIndex]= newEntry;
    }

    
    @Override
    public T dequeue() 
    {
        checkIntegrity();
        if (isEmpty())
        {
            throw new UnsupportedOperationException();
        }
        else
        {
            T front = queue[frontIndex];
            queue[frontIndex]=null;
            frontIndex = (frontIndex+1)% queue.length;
            return front;
        }
    }
    @Override
    public T getFront() 
    {
        checkIntegrity();
        if (isEmpty())
        {
            //throw new UnsupportedOperationException("empty");
            return null;
        }
        else
        {
            return queue[frontIndex];
        }
    }
    @Override
    public Boolean isEmpty() 
    {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear() 
    {
        checkIntegrity();
        if (!isEmpty())
        {
            for (int index = frontIndex; index != backIndex;index = (index+1)%queue.length)
            {
                queue[index] = null;
            }
            queue[backIndex]=null;
        }
       frontIndex =0;
       backIndex = queue.length -1;
    }

    //* */
    private void checkIntegrity()
    {
        if (!integrityOK)
        {
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    } 
    
    private void ensureCapacity()
    {
        if (frontIndex == ((backIndex+2) % queue.length))
        {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);
            integrityOK=false;

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;

            for (int index=0; index < oldSize-1; index++)
            {
                queue[index]= oldQueue[frontIndex];
                frontIndex =(frontIndex+1) % oldSize;
            } 

            frontIndex =0;
            backIndex = oldSize-2;
            integrityOK = true;   
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
