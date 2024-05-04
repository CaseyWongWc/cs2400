/**
    @author Matthew Yeung, Casey Wong

    uses all the methods in LinkedBag java
 */
package project1forme;
import java.util.Arrays;

public class LinkedBagTest 
{
    

    public static void main(String[] args) 
    {
      LinkedBag<String> bag = new LinkedBag<>(); //creates linked list called bag

      bag.add("a"); //adds elements
      bag.add("b");
      bag.add("c");

      System.out.println(bag.getCurrentSize()); //prints all the methods

      System.out.println(bag.isEmpty());

      System.out.println(Arrays.toString(bag.toArray()));

      System.out.println(bag.remove());

      System.out.println(bag.remove("b"));

      bag.clear();
      System.out.println(bag.getCurrentSize());
    }
}