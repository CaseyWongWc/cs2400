package project8binarysearchtree;
//import java.util.Iterator;

import project6tree.BinaryNode;
import project6tree.BinaryTree;
import project6tree.BinaryTreeInterface;
public class BinarySearchTree<T extends Comparable<? super T>>  extends BinaryTree<T> implements SearchTreeInterface<T> 
{
    public BinarySearchTree()
    {
       super();
    } // end default constructor
    
    public BinarySearchTree(T rootEntry)
    {
       super();
       setRootNode(new BinaryNode<T>(rootEntry));
    } // end constructor
    
    // Disable setTree (see Segment 26.6)
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
       throw new UnsupportedOperationException();
    } // end setTree

    @Override
    public boolean contains(T anEntry) 
    {
        return getEntry(anEntry) != null;
    }

    @Override
    public T getEntry(T anEntry) 
    {
        return findEntry(getRootNode(), anEntry);
    }

    private T findEntry(BinaryNode<T> rootNode, T anEntry)
    {
        T result = null;

        if ( rootNode != null)
        {
            T rootEntry = rootNode.getData();

            if (anEntry.equals(rootEntry))
            {
                result = rootEntry;
            }
            else if (anEntry.compareTo(rootEntry)<0)
            {
                result = findEntry(rootNode.getLeftChild(),anEntry);
            }
            else
            {
                result = findEntry(rootNode.getRightChild(),anEntry);
            }
        }
        return result;
    }


    public T add(T newEntry)
    {
        T result = null;
        if (isEmpty())
        {
            setRootNode(new BinaryNode<T>(newEntry));
        }
        else
        {
            result = addEntry(getRootNode(), newEntry);
        }
        return result;
    }

    private T addEntry(BinaryNode<T> rootNode, T newEntry) 
    {
        assert rootNode!= null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        if (comparison ==0)
        {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        }
        else if (comparison <0)
        {
            if (rootNode.hasLeftChild())
            {
                result = addEntry(rootNode.getLeftChild(), newEntry);
            }
            else
            {
                rootNode.setLeftChild(new BinaryNode<T>(newEntry));
            }
        }
        else 
        {
            assert comparison >0;
            if (rootNode.hasRightChild())
            {
                result = addEntry(rootNode.getRightChild(), newEntry);
            }
            else
            {
                rootNode.setRightChild(new BinaryNode<T>(newEntry));
            }
        }
        return result;
    }

    @Override
    public T remove(T anEntry) 
    {
        ReturnObject oldEntry = new ReturnObject();
        BinaryNode<T> newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
        setRootNode(newRoot);
     
        return oldEntry.get();
    }

    class ReturnObject  extends java.lang.Object 
    { 
        T data; 
        public void set(T newData) 
        { 
            data = newData; 
        } 
        public T get() 
        { 
            return data;
        } 
    } 

    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T anEntry,ReturnObject  oldEntry)
    {
        
        if (rootNode != null)
        {
           T rootData = rootNode.getData();
           int comparison = anEntry.compareTo(rootData);
     
           if (comparison == 0)       // anEntry == root entry
           {
              oldEntry.set(rootData);
              rootNode = removeFromRoot(rootNode);
           }
           else if (comparison < 0)   // anEntry < root entry
           {
              BinaryNode<T> leftChild = rootNode.getLeftChild();
              BinaryNode<T> subtreeRoot = removeEntry(leftChild, anEntry, oldEntry);
              rootNode.setLeftChild(subtreeRoot);
           }
           else                       // anEntry > root entry
           {
              BinaryNode<T> rightChild = rootNode.getRightChild();
              // A different way of coding than for left child:
              rootNode.setRightChild(removeEntry(rightChild, anEntry, oldEntry));
           } // end if
        } // end if
     
        return rootNode;
    }
 
    private BinaryNode <T> removeFromRoot(BinaryNode<T> rootNode)
    {
        //case1 rootNode has two children
        if (rootNode.hasLeftChild() && rootNode.hasRightChild())
        {
            //find node with largest entry in left subtree
            BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
            BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);

            //replace entry in root
            rootNode.setData(largestNode.getData());
            //remove node with largest entry in left subtree
            rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
        }
        //case2 rootnode has at most one child
        else if (rootNode.hasRightChild())
        {
            rootNode = rootNode.getRightChild();
        }
        else
        {
            rootNode = rootNode.getLeftChild();
        }

        return rootNode;
    }

    private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
        {
            rootNode = findLargest(rootNode.getRightChild());
        }
        return rootNode;
    }

    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
    {
        if (rootNode.hasRightChild())
        {
            BinaryNode<T> rightChild = rootNode.getRightChild();
            rightChild = removeLargest(rightChild);
            rootNode.setRightChild(rightChild);
        }
        else
        {
            rootNode = rootNode.getLeftChild();
        }
        return rootNode;
    }
 /* Implementations of contains, getEntry, add, and remove are here.
    . . .
    Other methods in SearchTreeInterface are inherited from BinaryTree.  */
 
} // end BinarySearchTree
 
