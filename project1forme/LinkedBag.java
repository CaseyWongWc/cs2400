/**
    @author Matthew Yeung, Casey Wong
    @param <T> The type of elements stored in this bag, is generic data type.
    This class implements a bag data structure using a linked list to store its elements.
 */

package project1forme;
public final class LinkedBag<T> implements BagInterface<T>
{
    private Node <T> firstNode; //Reference to the first node in the chain of node 
    private int numberOfEntries; //The total number of entries in the bag

    /**
     * creates empty linked bag
     */
    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    
    /** 
     * finds the number of entries in a bag
     * @return an integer containing the number of items in a bag
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    /**
     * checks if bag is zero
     * @return if number of Entries isnt zero, then bag is not empty
     */
    public boolean isEmpty()
    {
    if (numberOfEntries ==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   /** 
     * @param newEntry thing to be added
     * @return checks to see if newEntry is added
     * The methods below get the current size and adds new entries to the bagArray.
     * 
     *  
     * 
     */
    @Override
    public boolean add(T newEntry) 
    {
        Node<T> newNode = new Node<>(newEntry); // Create a new node with the contents of newEntry at the begining of the chain
        newNode.setNext(firstNode); // sets the pointer of newNode to firstNode
        firstNode = newNode; //the new firstNode will now contain the contents of newEntry
        numberOfEntries++;  //increment the number of entries
        return true; 
    }


     /**
     * @return True if the removal was successful, or false if not.
     * 
     * The remove method does the opposite and removes an entry by subtracting from the index.
     */
    @Override
    public T remove() 
    {
        T result = null; //a generic datatype of null
        if (firstNode != null)  //if the node contains something run the loop
        {
            result = firstNode.getData(); //the contents of firstNode will be stored into result
            firstNode = firstNode.getNext(); // Remove the first node from the chain by setting the firstNode's pointer to the next one
            numberOfEntries--; //the number of entries will be decreased
        }
        return result; //this will return us the value removed 
    }

     /**
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     * 
     * The remove method finds the index of anEntry in the Bag and removes that specific entry by replacing the entry with the first one and deleting the first index
     */
    @Override
    public boolean remove(T anEntry) 
    {
    boolean result = false; //a boolean tells us if the remove is successful or not
    Node <T> nodeNumber = getRefrenceTo(anEntry); // the index of the node(generic data type) is determined by the method getRefrenceTo

    if (nodeNumber != null) //if datatype in nodeNumber isnt nothing
    {
        nodeNumber.setData(firstNode.getData()); //the contents of nodeNumber will be set to with the firstNode's data
        firstNode = firstNode.getNext(); //the firstnode will become the next node after first node, removing the contents of first node
        numberOfEntries--; //number of entries are decreased
        result = true; //sets result to true
    }
    return result;
}
/** 
 * getRefrenceto returns an entry's location.
 * using pointers, this methods iterates through a bags and returns the item in the bad if its equal to a certain entry
 * @return integer
*/
private Node <T> getRefrenceTo(T anEntry)
{
    boolean found =false;
    Node <T> currentNode = firstNode;
    while (!found && (currentNode != null))
      {
        if (anEntry.equals(currentNode.getData()))
        {
          found = true;
        }
        else
        {
          currentNode = currentNode.getNext();
        }
      }
    return currentNode;
}

/**
 * removes all entries in the bag
 */
@Override
public void clear() 
{
    while (firstNode != null) 
    {
        Node<T> temp = firstNode;
        firstNode = firstNode.getNext(); // Remove the first node
        temp.setData(null); // Help with garbage collection
        temp.setNext(null);
    }
    numberOfEntries = 0;
}

/**
 * Frequecy returns the number of times a certain object has appeared
 * @return int
 */
@Override
public int getFrequencyOf(T anEntry) 
{
    int frequency = 0; //counter starts at 0
    Node<T> currentNode = firstNode;

    while (currentNode != null) //keeps on iterating until the currentnode is nothing
    {
        if (currentNode.getData().equals(anEntry))  //if the item in the currentnode is the same as the entry,frequency will be increased
        {
            frequency++;
        }
        currentNode = currentNode.getNext(); //currentnode will become the next node
    }
    return frequency;
}

/**
     * Tests whether this bag contains a given entry.
     * 
     * @param anEntry The entry to find.
     * @return True if the bag contains the entry, or false otherwise.
     */
@Override
public boolean contains(T anEntry) 
{
    boolean result = false;
    Node <T> currentNode = firstNode;
    while (currentNode != null) 
    {
        if (currentNode.getData() == anEntry)
        {
            result = true;
        }
        currentNode = currentNode.getNext();
    }
    return result;
}


  /**
 * Retrieves all entries that are in this bag.
 * 
 * @return A newly allocated array of all the entries in the bag.
 *         Note: If the bag is empty, the returned array is empty.
 */
@Override
public T[] toArray() 
{
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[numberOfEntries];

    int index =0;
    Node <T> currentNode = firstNode;
    while ((index < numberOfEntries) && (currentNode != null))
    {
        result[index] = currentNode.getData();
        index++;
        currentNode = currentNode.getNext();
    }
    return result;
}


/** 
 * @param anotherBag this is the bag to be compared with
 * @return BagInterface<T>
 * The union, difference, and intersection perform the same way they did
 * in their individual form. The union combines the arrays while the difference
 * removes duplicates from the chosen array. Intersection locates the first identical
 * entry in an array and returns the entry.
 */
@Override
public BagInterface<T> union(BagInterface<T> anotherBag) 
{
    LinkedBag<T> unionBag = new LinkedBag<>();

    Node<T> currentNode = firstNode;
    while (currentNode != null)
    {
     unionBag.add(currentNode.getData()); 
     currentNode = currentNode.getNext();   
    }

    T[] anotherBagArray = anotherBag.toArray(); // Use toArray() to access elements of anotherBag
    for (T item : anotherBagArray) 
    {
        unionBag.add(item);
    }
    return unionBag;
}

@Override
public BagInterface<T> intersection(BagInterface<T> anotherBag) 
{
    LinkedBag<T> intersectionBag = new LinkedBag<>(); //create the return bag
    T[] temp = this.toArray();
    for (T item: temp)
    {
        if (anotherBag.contains(item) && !intersectionBag.contains(item))
        {
            intersectionBag.add(item);
        }
    } 
    return intersectionBag;
}


@Override
public BagInterface<T> difference(BagInterface<T> anotherBag) 
{
    LinkedBag <T> diffBag = new LinkedBag<>();
    Node<T> currentNode = firstNode;
    T [] temp = anotherBag.toArray();

   for ( int i=0; i < this.getCurrentSize();i++)
    {
        T item = currentNode.getData();
        boolean found = false;

        for ( int j=0; j < temp.length;j++)
        {
            if (item.equals(temp[j]))
            {
                temp[j] = null;
                found = true;
                break;    
            }   
        }
        
        if (!found)
        {
            diffBag.add(item); 
        }
        currentNode = currentNode.getNext(); 
    }
    return diffBag;

    //======================
    /*LinkedBag<T> diffBag = new LinkedBag<>();
    Node<T> currentNode = firstNode;

    while (currentNode != null) 
    {
        T item = currentNode.getData();
        
        diffBag.add(item);

        if (anotherBag.contains(item) && anotherBag.getFrequencyOf(item) >= 1) 
        {
            diffBag.remove(item);
            anotherBag.remove(item);
        }

        currentNode = currentNode.getNext();
    }

    return diffBag;*/

    //===============================================
    /*LinkedBag <T> diffBag = new LinkedBag<>();
    LinkedBag <T> tempBag = new LinkedBag<>();

    //Node<T> tempNode = firstNode;
    //while (tempNode != null)
    //{
    //    tempBag.add(tempNode.getData()); 
    //    tempNode = tempNode.getNext();  
    //}

    Node<T> currentNode = firstNode;
    while (currentNode != null)
    {
        diffBag.add(currentNode.getData()); 
        currentNode = currentNode.getNext();  
    }

    T [] temp1 = anotherBag.toArray();
    for (T item : temp1)
    {
        if (tempBag.contains(item))
        {
            anotherBag.remove(item);
        }
    }

    T [] temp2 = this.toArray();
    for (T item : temp2)
    {
        if (anotherBag.contains(item) && tempBag.getFrequencyOf(item) != 1)
        {
            tempBag.add(item);
        }
    }
    
    

    return tempBag;*/


    //===============================================
    /*LinkedBag <T> diffBag = new LinkedBag<>();
    Node<T> currentNode = firstNode;
    T item = currentNode.getData();

    while (currentNode != null)
    {
        diffBag.add(currentNode.getData()); 
        currentNode = currentNode.getNext();  
    }


    T [] temp = anotherBag.toArray();
    for (T item : temp)
    {
        if (this.contains(item) && anotherBag.contains(item))
        {
            diffBag.remove(item);
        }
    }

    return diffBag;*/


}
}