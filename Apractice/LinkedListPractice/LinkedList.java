package Apractice.LinkedListPractice;

public class LinkedList 
{
    Node firstNode;
    
    public void insert(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(firstNode==null)
        {
            firstNode = node;
        }
        else
        {
            Node n = firstNode;
            while(n.next != null)
            {
                n = n.next;
            }
            n.next = node;
        }

    }

    public void insertAtStart(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        node.next = firstNode;
        firstNode = node;
    }

    public void insertAt(int index, int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (index==0)
        {
            insertAtStart(data);
        }
        else 
        {
            Node n = firstNode;
            for (int i=0; i < index-1;i++)
                {
                    n = n.next;
                }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteAt(int index)
    {
        if (index==0)   
        {
            firstNode=firstNode.next;
        }
        else
        {
            Node n = firstNode;
            Node n1 = null;
            for (int i=0; i < index-1;i++)
            {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            System.out.println("n1 " + n1.data);
            n1= null;

        }
    }
    public void show()
    {
        Node node = firstNode;

        while(node !=null)
        {
            System.out.println(node.data);
            node = node.next;
        }
        
    }


}
