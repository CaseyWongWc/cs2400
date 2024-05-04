package project10dictionary;

import java.io.Serializable;

public class Node<K, V> implements Serializable 
{
  private K key;
  private V value;
  private Node<K, V> next;

  public Node(K searchKey, V dataValue) 
  {
    key = searchKey;
    value = dataValue;
    next = null;	
  } // end constructor

  public Node(K searchKey, V dataValue, Node<K, V> nextNode) 
  {
    key = searchKey;
    value = dataValue;
    next = nextNode;	
  } // end constructor

  public K getKey() 
  {
    return key;
  } // end getKey

  public V getValue() 
  {
    return value;
  } // end getValue

  public void setValue(V newValue) 
  {
    value = newValue;
  } // end setValue

  public Node<K, V> getNextNode() 
  {
    return next;
  } // end getNextNode

  public void setNextNode(Node<K, V> nextNode) 
  {
    next = nextNode;
  } // end setNextNode
} // end Node

