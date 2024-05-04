package project4deque;

public class driverDeque 
{
    public static void main(String[] args) 
    {
        // 1. Instantiate a linkedDeque object for Integer type
        linkedDeque<Integer> myDeque = new linkedDeque<>();
        
        // 2. Add elements to the deque
        myDeque.addToFront(10); // Add to front
        myDeque.addToBack(20);  // Add to back
        myDeque.addToFront(5);  // Add another element to front
        myDeque.addToBack(25);  // Add another element to back
        
        // 3. Display the first and last elements
        System.out.println("Front element: " + myDeque.getFront()); // Should display 5
        System.out.println("Back element: " + myDeque.getBack());   // Should display 25
        
        // 4. Remove elements from the deque
        System.out.println("Removed from front: " + myDeque.removeFront()); // Should remove 5
        System.out.println("Removed from back: " + myDeque.removeBack());   // Should remove 25
        
        // 5. Check if the deque is empty
        System.out.println("Is the deque empty? " + myDeque.isEmpty()); // Should display false
        
        // 6. Clear the deque
        myDeque.clear();
        System.out.println("Is the deque empty after clearing? " + myDeque.isEmpty()); // Should display true
    }
}