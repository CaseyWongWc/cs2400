package project5Recursion;

public class a4recursivelinkedchain {
    private Node firstNode; // Reference to the first node in the chain

    public static void main(String[] args) 
    {
        a4recursivelinkedchain list = new a4recursivelinkedchain();
        
        // Adding sample nodes to the chain for demonstration
        list.addFirst("Apple");
        list.addFirst("Banana");
        list.addFirst("Cherry");
        
        // Displaying the chain
        list.display();
        list.displayBackward();
    }

    public void display() 
    {
        displayChain(firstNode);
    }

    private void displayChain(Node nodeOne) {
        if (nodeOne != null) 
        {
            System.out.println(nodeOne.getData());
            displayChain(nodeOne.getNextNode());
        }
    }
    
    public void displayBackward()
    {
       displayChainBackward(firstNode);
    } 

    public void displayChainBackward(Node nodeOne)
    {
        if (nodeOne != null)
        {
            displayChainBackward(nodeOne.getNextNode());
            System.out.println(nodeOne.getData());
        }
    }


    // Method to add a node at the beginning of the chain
    public void addFirst(String data) 
    {
        Node newNode = new Node(data, firstNode);
        firstNode = newNode;
    }

    private class Node 
    {
        private String data; // Data stored in the node
        private Node next; // Reference to the next node

        private Node(String dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        private String getData() {
            return data;
        }

        private Node getNextNode() {
            return next;
        }
    }
}
