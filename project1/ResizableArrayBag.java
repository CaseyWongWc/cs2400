package project1;

// ResizableArrayBag.java
public class ResizableArrayBag<T> implements BagInterface<T> {
    private T[] bagArray;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArrayBag(int desiredCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[desiredCapacity]; // Unchecked cast
        bagArray = tempBag;
        numberOfEntries = 0;
    }



    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        ResizableArrayBag<T> resultBag = new ResizableArrayBag<>();
        T[] arr1 = this.toArray();
        T[] arr2 = anotherBag.toArray();
        for (T elem : arr1) {
            resultBag.add(elem);
        }
        for (T elem : arr2) {
            resultBag.add(elem);
        }
        return resultBag;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        ResizableArrayBag<T> resultBag = new ResizableArrayBag<>();
        T[] arr1 = this.toArray();
        for (T elem : arr1) {
            if (anotherBag.contains(elem) && resultBag.getFrequencyOf(elem) < anotherBag.getFrequencyOf(elem)) {
                resultBag.add(elem);
            }
        }
        return resultBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        ResizableArrayBag<T> resultBag = new ResizableArrayBag<>();
        T[] arr1 = this.toArray();
        T[] arr2 = anotherBag.toArray();
        for (T elem : arr1) {
            resultBag.add(elem);
        }
        for (T elem : arr2) {
            resultBag.remove(elem);
        }
        return resultBag;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }
    

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            doubleCapacity();
        }
        bagArray[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }
    
    private boolean isFull() {
        return numberOfEntries == bagArray.length;
    }
    
    private void doubleCapacity() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[bagArray.length * 2];
        System.arraycopy(bagArray, 0, newArray, 0, bagArray.length);
        bagArray = newArray;
    }
    

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T result = bagArray[numberOfEntries - 1];
        bagArray[numberOfEntries - 1] = null;
        numberOfEntries--;
        return result;
    }
    

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index >= 0) {
            bagArray[index] = bagArray[numberOfEntries - 1];
            bagArray[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }
    
    private int getIndexOf(T anEntry) {
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bagArray[index])) {
                return index;
            }
        }
        return -1;
    }
    

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }
    

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bagArray[index])) {
                frequency++;
            }
        }
        return frequency;
    }
    

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) >= 0;
    }
    

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        System.arraycopy(bagArray, 0, result, 0, numberOfEntries);
        return result;
    }
    
}