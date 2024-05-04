package project10dictionary;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** A class that implements the ADT dictionary by using a resizable array.
   The dictionary is unsorted and has distinct search keys.
   Search keys and associated values are not null.  */
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V>
{
    private Entry<K, V>[] dictionary; // Array of unsorted entries
    private int numberOfEntries;
    private boolean integrityOK = false;
    private final static int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrayDictionary() 
    {
        this(DEFAULT_CAPACITY);      
    } // end default constructor

    public ArrayDictionary(int initialCapacity)
    {
        checkCapacity(initialCapacity);

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
        dictionary = tempDictionary;
        numberOfEntries = 0;
        integrityOK = true;
    } // end constructor

    private void checkCapacity(int capacity) 
    {
        if (capacity > MAX_CAPACITY) 
        {
            throw new IllegalStateException
            ("Attempt to create a dictionary whose " + "capacity exeeds allowed " + "maximum of " + MAX_CAPACITY);
        }
    }

    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("dictionary object is corrupt.");
    } // end checkIntegrity

    private void ensureCapacity() //fix later
    {
        if (numberOfEntries >= dictionary.length - 1) // If array is full, double its size
        {
            int newLength = 2 * dictionary.length;
            checkCapacity(newLength);
            dictionary = Arrays.copyOf(dictionary, newLength);
        } // end if
    } // end ensureCapacity


/* < Implementations of methods in DictionaryInterface. >  . . . */

 

@Override
public V add(K key, V value)
{
    checkIntegrity();
    if ((key == null) || (value == null))
        throw new IllegalArgumentException("Cannot add null to this dictionary.");
    else
    {
        V result = null;
        int keyIndex = locateIndex(key);
        if (keyIndex < numberOfEntries)
        {
            // Key found, return and replace entry's value
            result = dictionary[keyIndex].getValue(); // Get old value
            dictionary[keyIndex].setValue(value);     // Replace value
        }
        else // Key not found; add new entry to dictionary
        {
            // Add at end of array
            dictionary[numberOfEntries] = new Entry<>(key, value);
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
        } // end if
        return result;
    } // end if
} // end add

    private int locateIndex(K key)
{
    // Sequential search
    int index = 0;
    while ( (index < numberOfEntries) &&
            !key.equals(dictionary[index].getKey()) )
        index++;
    return index;
}

@Override
public V remove(K key)
{
    checkIntegrity();
    V result = null;
    int keyIndex = locateIndex(key);

    if (keyIndex < numberOfEntries)
    {
    // Key found; remove entry and return its value
    result = dictionary[keyIndex].getValue();
    // Replace removed entry with last entry
    dictionary[keyIndex] = dictionary[numberOfEntries - 1];
    dictionary[numberOfEntries - 1] = null;
    numberOfEntries--;
    } // end if
    // Else result is null

    return result;
} // end remove

@Override
public V getValue(K key) {
    checkIntegrity();
    for (int i = 0; i < numberOfEntries; i++) {
        if (key.equals(dictionary[i].getKey())) {
            return dictionary[i].getValue();
        }
    }
    return null; // Key not found
}

@Override
public boolean contains(K key) {
    checkIntegrity();
    for (int i = 0; i < numberOfEntries; i++) {
        if (key.equals(dictionary[i].getKey())) {
            return true;
        }
    }
    return false;
}

@Override
public Iterator<K> getKeyIterator() {
  return new KeyIterator();
}

@Override
public Iterator<V> getValueIterator() {
    return new ValueIterator();
}



private class KeyIterator implements Iterator<K> 
{
  private int currentIndex;  // Current position in the dictionary array

  public KeyIterator() 
  {
      currentIndex = 0;
  }

  @Override
  public boolean hasNext() {
      // Check if the current index is within the number of entries
      return currentIndex < numberOfEntries;
  }

  @Override
  public K next() 
  {
      if (!hasNext()) 
      {
          throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
      // Access the key at the current index and increment the index
      K key = dictionary[currentIndex].getKey();
      currentIndex++;
      return key;
  }

  @Override
  public void remove() {
      // Optionally, you can implement this method if needed
      throw new UnsupportedOperationException("Remove not supported by this iterator");
  }
}

  private class ValueIterator implements Iterator<V> 
  {
    private int currentIndex;  // Current position in the dictionary array

    public ValueIterator() {
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        // Check if the current index is within the number of entries
        return currentIndex < numberOfEntries;
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
        }
        // Access the value at the current index and increment the index
        V value = dictionary[currentIndex].getValue();
        currentIndex++;
        return value;
    }

    @Override
    public void remove() {
        // Optionally, you can implement this method if needed
        throw new UnsupportedOperationException("Remove not supported by this iterator");
    }
}

@Override
public boolean isEmpty() {
    return numberOfEntries == 0;
}

@Override
public int getSize() {
    return numberOfEntries;
}

@Override
public void clear() 
{
    while (!isEmpty()) 
    {
        remove(dictionary[0].getKey());
    }
}

@SuppressWarnings("hiding")
private class Entry<K, V>
 {
    private K key;
    private V value;

    private Entry(K searchKey, V dataValue)
    {
        key = searchKey;
        value = dataValue;
    } // end constructor

    private K getKey()
    {
        return key;
    } // end getKey

    private V getValue()
    {
        return value;
    } // end getValue

    private void setValue(V dataValue)
    {
        value = dataValue;
    } // end setValue
} // end Entry


////////////////////////////////////////////////////////////
public static void main(String[] args)
{
    ArrayDictionary <String, String> addressBook = new ArrayDictionary<>();

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

///////////////////////////////////////////////////////////

} // end ArrayDictionary