package project4deque;

public class demoDeque 
{
    public static void main(String[] args) 
    {
        linkedDeque<String> deque = new linkedDeque<>();
        deque.addToFront("Jack");deque.printDeque();
        deque.addToFront("Rudy");deque.printDeque();
        deque.addToBack("Larry");deque.printDeque();
        
        deque.addToBack("Sam");deque.printDeque();
        //deque.removeFront();deque.printDeque();
        //deque.removeBack();deque.printDeque();


        deque.clear();deque.printDeque();
        //System.out.println("Is the deque empty? " +deque.isEmpty());

        

        
    }
}


