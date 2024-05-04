/**
    @author Matthew Yeung, Casey Wong

    tests all the methods for the reziable array bag
 */
package project1forme;

import java.util.Arrays;

public class ResizableArrayBagTest 
{
    public static void main(String[] args)
    {
    
        ResizableArrayBag<String> bag = new ResizableArrayBag<>();

        bag.add("a");
        bag.add("b");
        bag.add("c");
        
        System.out.println(bag.getCurrentSize());

        System.out.println(Arrays.toString(bag.toArray()));

        for (int i = 0; i < 22; i++) 
        {
            bag.add("f" + i);
        }
        System.out.println(bag.getCurrentSize());
    }
}