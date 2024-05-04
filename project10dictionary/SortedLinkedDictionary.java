package project10dictionary;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   A class that implements the ADT dictionary by using a chain of linked nodes.
   The dictionary is sorted and has distinct search keys.
   Search keys and associated values are not null.
  
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class SortedLinkedDictionary<K extends Comparable<? super K>, V> 
             implements DictionaryInterface<K, V>
{
	private Node firstNode; // Reference to first node of chain
	private int  numberOfEntries; 
	
	public SortedLinkedDictionary()
	{
      initializeDataFields();
	} // end default constructor
	
   private void initializeDataFields()
   {
      firstNode = null;
      numberOfEntries =0;
   }
   public V add(K key, V value)
	{
		V result = null;
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         // Search chain until you either find a node containing key
         // or locate where it should be
         Node currentNode = firstNode;
         Node nodeBefore = null;
         
         while ( (currentNode != null) && (key.compareTo(currentNode.getKey()) > 0) )
         {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
         } // end while
         
         if ( (currentNode != null) && key.equals(currentNode.getKey()) )
         {
            // Key in dictionary; replace corresponding value
            result = currentNode.getValue(); // Get old value
            currentNode.setValue(value);     // Replace value
         }
         else // Key not in dictionary; add new node in proper order
         {
            // Assertion: key and value are not null
            Node newNode = new Node(key, value); // Create new node
            
            if (nodeBefore == null)
            {                                    // Add at beginning (includes empty chain)
               newNode.setNextNode(firstNode);
               firstNode = newNode;
            }
            else                                 // Add elsewhere in non-empty chain
            {
               newNode.setNextNode(currentNode); // currentNode is after new node
               nodeBefore.setNextNode(newNode);  // nodeBefore is before new node
            } // end if

            numberOfEntries++;                   // Increase length for both cases
         } // end if
      } // end if

		return result;
	} // end add

   
/* Implementations of other methods in DictionaryInterface.
   . . .
   Private classes KeyIterator and ValueIterator (see Segment 21.20). >
   . . . */
   public V remove(K key)
	{
   	V result = null;  // return value
   	
		if (!isEmpty())
		{	
    	// search chain for a node containing key;
	    // save reference to preceding node
			Node currentNode = firstNode;
			Node nodeBefore = null;
			
    	while ( (currentNode != null) && !key.equals(currentNode.getKey()) )
			{
				nodeBefore = currentNode;
				currentNode = currentNode.getNextNode();
			} // end while
			
			if (currentNode != null)
			{
				// node found; remove it
				Node nodeAfter = currentNode.getNextNode(); // node after the one to be removed

				if (nodeBefore == null)
					firstNode = nodeAfter;
				else
					nodeBefore.setNextNode(nodeAfter);        // disconnect the node to be removed

				result = currentNode.getValue();            // get ready to return removed entry
			  numberOfEntries--;                              // decrease length for both cases
			} // end if
		} // end if
			
    return result;  
  } // end remove

  public V getValue(K key)
  {
  	V result = null;

    // find node before the one that contains or could contain key
		Node currentNode = firstNode;
		
    while ( (currentNode != null) && !key.equals(currentNode.getKey()) )
		{
			currentNode = currentNode.getNextNode();
		} // end while

		if (currentNode != null)
		{
			result = currentNode.getValue();
		} // end if
		
		return result;
  } // end getValue

	public boolean contains(K key)
  {
   	return getValue(key) != null; 
  } // end contains

  public boolean isEmpty()
  {
    return numberOfEntries == 0;
  } // end isEmpty
	
  public boolean isFull()
  {
    return false;
  } // end isFull

  public int getSize()
  {
    return numberOfEntries;
  } // end getSize

	public final void clear()
	{ 
		firstNode = null;		
    numberOfEntries = 0;
  } // end clear

	public Iterator<K> getKeyIterator()
	{
		return new KeyIterator();
	} // end getKeyIterator
	
	public Iterator<V> getValueIterator()
	{
		return new ValueIterator();
	} // end getValueIterator

  // 18.26
	private class KeyIterator implements Iterator<K>
	{
		private Node nextNode;
		
		private KeyIterator()
		{
			nextNode = firstNode;
		} // end default constructor
		
		public boolean hasNext() 
		{
			return nextNode != null;
		} // end hasNext
		
		public K next()
		{
			K result;// = null; // null not used or needed here
			
			if (hasNext())
			{
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			} // end if
		
			return result;
		} // end next
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		} // end remove
	} // end KeyIterator 
	
	private class ValueIterator implements Iterator<V>
	{
		private Node nextNode;
		
		private ValueIterator()
		{
			nextNode = firstNode;
		} // end default constructor
		
		public boolean hasNext() 
		{
			return nextNode != null;
		} // end hasNext
		
		public V next()
		{
			V result;
			
			if (hasNext())
			{
				result = nextNode.getValue();
				nextNode = nextNode.getNextNode();
			}
			else
			{
				throw new NoSuchElementException();
			} // end if
		
			return result;
		} // end next
		
		public void remove()
		{
			throw new java.lang.UnsupportedOperationException();
		} // end remove
	} // end getValueIterator

	private class Node implements Serializable
	{
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
			next = null;	
		} // end constructor
		
		private Node(K searchKey, V dataValue, Node nextNode)
		{
			key = searchKey;
			value = dataValue;
			next = nextNode;	
		} // end constructor
		
		private K getKey()
		{
			return key;
		} // end getKey
		
		private V getValue()
		{
			return value;
		} // end getValue

		private void setValue(V newValue)
		{
			value = newValue;
		} // end setValue

		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node








   public static void main(String[] args)
    {
        SortedLinkedDictionary <String, String> addressBook = new SortedLinkedDictionary<>();

        addressBook.add("555-1264", "150 Main Street");
        addressBook.add("555-8132", "75 Center Court");
        addressBook.add("555-4294", "205 Ocean Road");
        addressBook.add("555-2072", "82 Campus Way");

        System.out.println("Initial phone book entries:");
        displayAll(addressBook);

        // get a value from key
        getavalue(addressBook,"555-2072");

        //removing an entry and print
        removebykey(addressBook, "555-8132");
        removebykey(addressBook, "555-4294");

        //checksif key exists
        checkifkeyexists(addressBook,"555-1264");
        checkifkeyexists(addressBook,"000-0000");
        
        // Clear the dictionary
        addressBook.clear();
        System.out.println("\nDictionary cleared");
        
    }

    //helper
    private static void displayAll(DictionaryInterface<String, String> dictionary) 
    {
        Iterator<String> keyIterator = dictionary.getKeyIterator();
        Iterator<String> valueIterator = dictionary.getValueIterator();
        while (keyIterator.hasNext() && valueIterator.hasNext()) 
        {
            System.out.println("Key: " + keyIterator.next() + ", Value: " + valueIterator.next());
        }
    }
    
    private static void removebykey (DictionaryInterface<String, String> dictionary, String key)
    {
        System.out.println("\nRemoving " + key +":");
        dictionary.remove(key);
        displayAll(dictionary);
    }
    private static void getavalue (DictionaryInterface<String, String> dictionary, String key)
    {
        String value = dictionary.getValue(key);
        System.out.println("\nthe key:  ["+ key + "] gives us the value: [" + value + " ]");
    }
    private static void checkifkeyexists (DictionaryInterface<String, String> dictionary, String key)
    {
        System.out.println("\nDoes "+ key +" exist in the phone book? " + dictionary.contains(key));   
    }
} // end SortedLinkedDictionary
		
