package project8binarysearchtree;
import java.util.Iterator;

import project6tree.TreeInterface;
//import project6tree.*;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>
{
    public boolean contains(T anEntry);
    public T getEntry(T anEntry);
    public T add(T anEntry);
    public T remove(T anEntry);
    public Iterator<T> getInorderIterator();
    public Iterator<T> getPostorderIterator();
    public Iterator<T> getPreorderIterator();
    public Iterator<T> getLevelOrderIterator();

}
