/**
    @author Matthew Yeung, Casey Wong
    the program is run using linked bags.
 */

package project1forme;

public class Node<T>
{
    /**
     * @param data any type of data
     * @param next a new node of anytpe of data
     */
    private T data;
    private Node<T> next;

    /**@param data the creation of a new node makes a refrene to a dataset and a refrence to another node. 
     * the contents of data avaliable and  the contents of next to null. */
  public Node(T data) 
    {
        this.data = data;
        next = null;
    }

    /**@return gets stuff*/
    public T getData() 
    {
        return data;
    }

    /** @return  sets stuff to data*/
    public void setData(T firstNode) 
    {
        firstNode = this.data;
    }

    /** @return gets the data stored in the node after the first */
    public Node<T> getNext() 
    {
        return next;
    }

    /** @return sets the data stored in the node after the first */
    public void setNext(Node<T> next) 
    {
        this.next = next;
    }

    @SuppressWarnings("unused")
    private Node <T> getNextNode() 
    {
        return next;
    }


   
    
}
