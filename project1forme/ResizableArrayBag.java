/**
    @author Matthew Yeung, Casey Wong
    the program is run using linked bags.
 */
package project1forme;

//import java.util.ArrayList;

public final class ResizableArrayBag<T> implements BagInterface<T>
{
    
    private T[] bagArray; //makes life easier
    private int numberOfEntries; //counts for stuff in bag
    private static final int DEFAULT_CAPACITY = 25; //initial capacity

    /**makes new bag with the defualt size */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**creates an array named tempBag  with a length of desiredCapacity,  temobagwillthen be copied to barArray*/
    public ResizableArrayBag(int desiredCapacity) 
    {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[desiredCapacity];
        bagArray=tempBag;
        numberOfEntries =0;
    }

    
    
    /** 
     * @return int
     * The methods below get the current size and adds new entries to the bagArray.
     * The remove array function does the opposite and removes an entry by subtracting
     * from the index. Frequecy returns the number of times a certain object has appeared
     * while getindex returns an entry's location.
     */
    @Override
    public int getCurrentSize() 
    {
        //return bagArray.length;
        return numberOfEntries;
    }

    
    /** 
     * @return true if number of entries is zero
     */
    @Override
    public boolean isEmpty() 
    {
        return numberOfEntries==0;
    }
    /**@return true if new entries is added to the resizable bag array */
    @Override
    public boolean add(T newEntry) 
    {
        bagArray[numberOfEntries] = newEntry; //the size of the abg will scale according to the number of entries, newentry will be added to end of the array with new size
        numberOfEntries++;
        return true;
    }

    /**
     * does the reverse by setting the last element of bag array to nothing and decrementing the number of entries 
     * @return this is saved in result and reutrns the object removed */
    @Override
    public T remove() 
    {
        T result = bagArray[numberOfEntries - 1];
        bagArray[numberOfEntries - 1] = null;
        numberOfEntries--;
        return result;
    }

    /** removes specific entry from an arrayBag.
     * @return true if entry has been found and removed
     * @return false if entry has not been found and removed
     */
    @Override
    public boolean remove(T anEntry) 
    {
        int index = getIndexOf(anEntry);
        if (index >= 0) 
        {
            bagArray[index] = bagArray[numberOfEntries - 1];
            bagArray[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

    private int getIndexOf(T anEntry) 
    {
        int where = -1;
		boolean found = false;      
		int index = 0;
      
      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bagArray[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
        }
        return where;
    }

    @Override
    public void clear() 
    {
       remove();
    }

    @Override
    public int getFrequencyOf(T anEntry) 
    {
        int counter =0;
        for (int index=0; index < numberOfEntries;index++)
        {
            counter++;
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) 
    {
        return getIndexOf(anEntry) > -1;
    }


    
    /** 
     * @return T[]
     * Converts our Bag to an array
     */
    @Override
    public T[] toArray() 
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        for (int index = 0; index < numberOfEntries; index++) 
        {
            result[index] = bagArray[index];
        }
      return result;
    }

    
    /** 
     * @param anotherBag
     * @return BagInterface<T>
     * The union, difference, and intersection perform the same way they did
     * in their individual form. The union combines the arrays while the difference
     * removes duplicates from the chosen array. Intersection locates the first identical
     * entry in an array and returns the entry.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) 
    {
        ResizableArrayBag <T> unionBag = new ResizableArrayBag<>();

        T [] array1 = this.toArray();
        T [] array2 = anotherBag.toArray();


        for (int i = 0; i < array1.length; i++) 
        {
            unionBag.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) 
        {
            unionBag.add(array2[i]);
        }

        return unionBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) 
    {
        ResizableArrayBag <T> intersectionBag = new ResizableArrayBag<>();

        T [] array1 = this.toArray();
        T [] array2 = anotherBag.toArray();

        for (int i=0; i <array1.length; i++)
        {
          for (int j=0; j <array2.length; j++)
          {
            if (array1[i] == array2[j])
            {
              if (!intersectionBag.contains(array1[i])) 
              {
                intersectionBag.add(array1[i]);
              }
              break;
            }
          }
        }
    
        return intersectionBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) 
    {
        ResizableArrayBag <T> listDif = new ResizableArrayBag<>();
 
        T [] array1 = this.toArray();
        T [] array2 = anotherBag.toArray();

        for (int i=0; i < array1.length;i++)
        {
            listDif.add(array1[i]);
        }

        for (int i=0; i< array2.length;i++)
        {
            if (listDif.contains(array2[i]))
            {
                listDif.remove(array2[i]);
            }
        }


        return listDif;
    }

}