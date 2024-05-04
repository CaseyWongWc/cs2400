package project9graphs;
import java.util.Iterator;
import java.util.NoSuchElementException;

import project0semisterlongproject.Node;
import project0semisterlongproject.*;

public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    private Node firstNode;
    private int  numberOfEntries;

    public LinkedListWithIterator()
    {
        initializeDataFields();
    } // end default constructor
    
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries =0;
    }
    
    //Implementations of the methods of the ADT list go here
    private Node getNodeAt(int givenPosition)
    {
        Node currentNode = firstNode;

        for (int counter = 1; counter < givenPosition; counter++)
        {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }
    

    
    
    @Override
    public Iterator<T> iterator()
    {
        return new IteratorForLinkedList();
    } // end iterator

    @Override
	public Iterator<T> getIterator()
	{
	   return iterator();
	} // end getIterator

    private class IteratorForLinkedList<T> implements Iterator<T>
	{
      private Node nextNode;

		public IteratorForLinkedList()
		{
			nextNode = firstNode;
		} //defult constructor

        public boolean hasNext()
		{
			return nextNode != null;
		}

        public T next()
		{
			if (hasNext())
	    		{
				Node returnNode = nextNode; // get next node
				nextNode = nextNode.getNextNode();   // advance iterator
				return (T) returnNode.getData();     // return next entry in iteration
			}
			else
				throw new NoSuchElementException("Illegal call to next();" + "iterator is after end of list.");
		}

        // Implementations of the methods in the interface Iterator go here.
        
    }

    @Override
    public int getCurrentSize() 
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty()
    {
        boolean result;
           
         if (numberOfEntries == 0) // or getLength() == 0
         {
             assert firstNode == null;
             result = true;
         }
         else
         {
             assert firstNode != null;
             result = false;
         } // end if
         
         return result;
    }

    @Override
    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);

        if (isEmpty()==true) //if nothing is here than make newNode the private firstNode
        {
            this.firstNode = newNode;
        }
        else
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }

        numberOfEntries++;
    }    


    @Override
    public void add (int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries +1))
        {
            Node newNode = new Node(newEntry);
            if (givenPosition ==1)
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);

            }
            numberOfEntries++;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    @Override
    public T remove (int givenPosition)
    {
        T result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {

            if (givenPosition ==1)
            {
                result = firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;
            return result;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    }

    @Override
    public T replace(int givenPosition, T newEntry) 
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {

            Node  desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
        {
            //throw new IndexOutofBoundsException("Illegal position given to replace operation.");
            return null;
        }
    }

    @Override
    public void clear()
    {
        initializeDataFields();
    }

    @Override
    public T getEntry(int givenPosition) 
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            return getNodeAt(givenPosition).getData();
        }
        else
        {
            return null;
            //throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }
    @Override
    public boolean contains(T anEntry) 
    {
        boolean found = false;
        Node  currentNode = firstNode;

        while ((currentNode != null) && !found)
        {
            if (anEntry.equals(currentNode.getData()))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public T[] toArray() 
    {
        @SuppressWarnings ("unchecked")
        T[] array = (T[])new Object[numberOfEntries];

        int index =0;
        Node counterNode = firstNode;
        while ((index < numberOfEntries) && (counterNode != null))
        {

            array[index] = (T) counterNode.getData();
            index++;
            counterNode = counterNode.getNextNode();
        }

        return array;
    }



    public class Node
    {
        private T data;
        private Node next;

        public Node (T dataPortion)
        {
            this.data= dataPortion;
            this.next = null;
        }
        
        @SuppressWarnings("unused")
        private Node(T dataPortion, Node nextNode)
        {
            this.data = dataPortion;
            this.next = nextNode;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T newData)
        {
            this.data = newData;
        }

        public Node getNextNode()
        {
            return this.next;
        }

        void setNextNode(Node nextNode)
        {
            this.next = nextNode;
        }

        

    }
}