/**
    @author Matthew Yeung, Casey Wong

    runs the program using resizable array Bag
 */
package project1forme;

import java.util.Arrays;

public class ResizableArrayBagTest2 
{
    
    public static void main(String[] args) 
    {

        BagInterface<String> bag1 = new ResizableArrayBag<>();  //new bags of reziable array strings
        BagInterface<String> bag2 = new ResizableArrayBag<>(); 

        String[] array1 = { "a", "b", "c"};
        String[] array2 = { "b", "b", "d", "e" };   

        bag1 = toList(array1); //turns the bags to lists to be able to be used in the bag interface
        bag2 = toList(array2);
        
        BagInterface<String> everything = bag1.union(bag2);
        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        print(everything);  //prints out the four combinations
        print(commonItems);
        print(leftOver1);
        print(leftOver2);

    }
    
    private static  BagInterface<String> toList(String[] content)
    {
        BagInterface<String> aList = new LinkedBag<>();
        for (int i=0; i < content.length;i++)
        {   
            aList.add(content[i]);
        }
        return aList;
    }

    private static void print(BagInterface<String> abag)
    {
        System.out.println(Arrays.toString(abag.toArray()));
    }
}