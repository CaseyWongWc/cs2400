package project2stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ArrayStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  } // end constructor
  
//  < Implementations of the stack operations go here. >
//  < Implementations of the private methods go here; checkCapacity and checkIntegrity
//    are analogous to those in Chapter 2. >
//  . . .

public void push(T newEntry)
{
   checkIntegrity();
   ensureCapacity();
   stack[topIndex + 1] = newEntry;
   topIndex++;
} // end push

private void ensureCapacity()
{
   if (topIndex >= stack.length - 1) // If array is full, double its size
   {
      int newLength = 2 * stack.length;
      checkCapacity(newLength);
      stack = Arrays.copyOf(stack, newLength);
   } // end if
} // end ensureCapacity

public T peek()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
      return stack[topIndex];
} // end peek

public T pop()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
   {
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
   } // end if
} // end pop

public boolean isEmpty()
{
   return topIndex < 0;
} // end isEmpty

public void clear()
	{
      while (!isEmpty())
      {   
        pop();
      }
	} // end clear
// Throws an exception if the client requests a capacity that is too large.
private void checkCapacity(int capacity)
{
   if (capacity > MAX_CAPACITY)
      throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
                                      "allowed maximum of " + MAX_CAPACITY);
} // end checkCapacity

// Throws an exception if receiving object is not initialized.
private void checkIntegrity()
{
   if (!integrityOK)
      throw new SecurityException ("ArrayBag object is corrupt.");
} // end checkintegrity
} // end ArrayStack
