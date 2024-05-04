package project7Heap;
import java.util.Arrays;
public final class MaxHeap <T extends Comparable<? super T>> implements MaxHeapInterface<T>
{
    private T[] heap;
    private int lastIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

    
    public MaxHeap() 
    {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity)
    {
        if (initialCapacity < DEFAULT_CAPACITY)
        {
            initialCapacity = DEFAULT_CAPACITY;
        }
        else
        {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity+1];
        heap = tempHeap;
        lastIndex =0;
        integrityOK = true;
    }

    public MaxHeap(T[] entries)
    {
        this(entries.length); //calls second constructor
        assert integrityOK = true;

        for (int i=0; i < entries.length; i++)
        {
            heap[i + 1] = entries[i];
        }

        for ( int rootIndex = lastIndex/2; rootIndex>0; rootIndex--)
        {
            reheap(rootIndex);
        }
    }

    @Override
    public void add(T newEntry) //adding to the max-heap
    {
        checkIntegrity();
        int newIndex = lastIndex+1;
        int parentIndex = newIndex/2;
        while ((parentIndex >0) && newEntry.compareTo(heap[parentIndex])>0)
        {
            heap[newIndex]= heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    @Override
    public T removeMax() 
    {
        checkIntegrity();
        T root = null;

        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    private void reheap(int rootIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while (!done  && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex; //assume larger
            int rightChildIndex = leftChildIndex +1;

            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex])>0)
            {
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex])<0 )
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
            {
                done = true;
            }

            heap[rootIndex]=orphan;
        }
    }

    void reheap(T[] heap, int rootIndex, int lastIndex)
    {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex + 1;

        while (!done && (leftChildIndex <= lastIndex))
        {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ( (rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
            {
                largerChildIndex = rightChildIndex;
            } // end if

            if (orphan.compareTo(heap[largerChildIndex]) < 0)
            {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex + 1;
            }
            else
                done = true;
        } // end while

        heap[rootIndex] = orphan;
    } // end reheap

    void heapSort(T[] array, int n)
    {
       // Create first heap
       for (int rootIndex = n / 2 - 1; rootIndex >= 0; rootIndex--)
          reheap(array, rootIndex, n - 1);
    
       swap(array, 0, n - 1);
    
       for (int lastIndex = n - 2; lastIndex > 0; lastIndex--)
       {
          reheap(array, 0, lastIndex);
          swap(array, 0, lastIndex);
       } // end for
    } // end heapSort
    
    private static void swap(Object[] a, int i, int j)
    {
       Object temp = a[i];
       a[i] = a[j];
       a[j] = temp; 
    } // end swap

    @Override
    public T getMax() 
    {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
        {
            root = heap[1]; //first element is the max
        }
        return root;
    }

    @Override
    public boolean isEmpty() 
    {
        return lastIndex <1;
    }

    @Override
    public int getSize() 
    {
    return lastIndex;
    }

    @Override
    public void clear() 
    {
        checkIntegrity();
        while (lastIndex > -1)
        {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }
    

    private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a bag whose " +
                                         "capacity exeeds allowed " +
                                         "maximum of " + MAX_CAPACITY);
   } // end checkCapacity



   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("Heap object is corrupt.");
   } // end checkIntegrity

   private void ensureCapacity()
   {
      if (lastIndex >= heap.length - 1) // If array is full, double its size
      {
         int newLength = 2 * heap.length;
         checkCapacity(newLength);
         heap = Arrays.copyOf(heap, newLength);
      } // end if
   } // end ensureCapacity
   
   public void printArray()
   {
    for (int i=1; i < lastIndex;i++)
    {
        System.out.println(heap[i] + " ");
    }
   }
}