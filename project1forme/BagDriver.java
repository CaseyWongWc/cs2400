/**
    @author Matthew Yeung, Casey Wong
 */
package project1forme;
import java.util.Arrays;
public class BagDriver 
{
    
    /** 
     * @param args
     * Creates and bags the new string arrays.
     * Afterwards, uses the methods union, intersection, and difference
     * on the arrays and returns their outputs. Unlike the original difference program,
     * this one prints out both string array entries after the they have been modified.
     */


    public static void main(String[] args) 
    {
        /**
         * @param bag1 tests using a resizable array bag
         * @param bag2 tests using a linked bag
         */
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();


        bag2.add("b"); 
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        String[] array1 = { "a", "b", "c"};
  

        bag1 = toList(array1);

        

        BagInterface<String> everything = bag1.union(bag2);
        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        print(everything);
        print(commonItems);
        print(leftOver1);
        print(leftOver2);


    }
    
    private static  BagInterface<String> toList(String[] content)
    {
        /**
         * @return aList turns items to a linked list if needed
         */
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