package project1;

// LinkedBag.java
public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    // LinkedBag Node inner class
    private class Node<N> {
        private N data;
        private Node<N> next;

        Node(N dataPortion) {
            this(dataPortion, null);
        }

        Node(N dataPortion, Node<N> nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        LinkedBag<T> resultBag = new LinkedBag<>();
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
        LinkedBag<T> resultBag = new LinkedBag<>();
        T[] arr1 = this.toArray();
        for (T elem : arr1) {
            if (anotherBag.contains(elem) && !resultBag.contains(elem)) {
                resultBag.add(elem);
                anotherBag.remove(elem);
            }
        }
        return resultBag;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        LinkedBag<T> resultBag = new LinkedBag<>();
        T[] arr1 = this.toArray();
        for (T elem : arr1) {
            if (!anotherBag.contains(elem)) {
                resultBag.add(elem);
            } else {
                anotherBag.remove(elem);
            }
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
        // Create a new node at the beginning of the chain
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = firstNode; // Make new node point to the chain's first node
        firstNode = newNode; // New node becomes the first node
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove the first node from the chain
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        Node<T> currentNode = firstNode;
        Node<T> nodeBefore = null;
    
        while (currentNode != null && !anEntry.equals(currentNode.data)) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }
    
        if (currentNode != null) {
            if (nodeBefore == null) { // If it's the first node
                firstNode = currentNode.next;
            } else {
                nodeBefore.next = currentNode.next;
            }
            numberOfEntries--;
            return true;
        }
    
        return false;
    }
    

    @Override
public void clear() {
    // Just nullify the firstNode and reset numberOfEntries
    while (firstNode != null) {
        Node<T> temp = firstNode;
        firstNode = firstNode.next; // Remove the first node
        temp.data = null; // Help with garbage collection
        temp.next = null;
    }
    numberOfEntries = 0;
}


@Override
public int getFrequencyOf(T anEntry) {
    int frequency = 0;
    Node<T> currentNode = firstNode;
    while (currentNode != null) {
        if (currentNode.data.equals(anEntry)) {
            frequency++;
        }
        currentNode = currentNode.next;
    }
    return frequency;
}


@Override
public boolean contains(T anEntry) {
    Node<T> currentNode = firstNode;
    while (currentNode != null) {
        if (currentNode.data.equals(anEntry)) {
            return true;
        }
        currentNode = currentNode.next;
    }
    return false;
}


    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }
    
}

