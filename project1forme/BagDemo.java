package project1forme;

import java.util.Arrays;

public class BagDemo 
{
    public static void main(String[] args) 
    {
        BagInterface<String> bag = new ResizableArrayBag<>();

        bag.add("lions");
        bag.add("elephants");
        bag.add("otters");
        bag.add("bears");
        bag.add("tigers");
        bag.add("lemurs");
        print(bag);
        bag.remove("bears");
        print(bag);
    }

    private static void print(BagInterface<String> abag)
    {
        System.out.println(Arrays.toString(abag.toArray()));
    }


    /*private static  BagInterface<String> toList(String[] content)
    {
        
         //@return aList turns items to a linked list if needed
        
        BagInterface<String> aList = new LinkedBag<>();
        for (int i=0; i < content.length;i++)
        {   
            aList.add(content[i]);
        }
        return aList;
    }  */

    
}
