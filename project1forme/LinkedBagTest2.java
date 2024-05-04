/**
    @author Matthew Yeung, Casey Wong
    the program is run using linked bags.
 */

package project1forme;
import java.util.Arrays;

public class LinkedBagTest2 
{
    

    public static void main(String[] args) 
    {

        BagInterface<String> bag1 = new LinkedBag<>(); //makes two bags of linked list strings
        BagInterface<String> bag2 = new LinkedBag<>();

        bag1.add("a"); //each element added using  java.util.arrays
        bag1.add("b");
        bag1.add("c");

        bag2.add("b"); 
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
   

        BagInterface<String> everything = bag1.union(bag2);
        BagInterface<String> commonItems = bag1.intersection(bag2);
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);

        print(everything);
        print(commonItems);
        print(leftOver1);
        print(leftOver2);


    }
    /**
     * turns to array and prints stuff
     * @param abag array
     */
    private static void print(BagInterface<String> abag)
    {
        System.out.println(Arrays.toString(abag.toArray()));
    }
}