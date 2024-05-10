package project7Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapDemo 
{
    public static void main(String[] args) 
    {
        
        MaxHeapInterface<Integer> heap1 = new MaxHeap<>();
        //MaxHeapInterface<Integer> heap2 = new MaxHeap<>();
        
        int array[] = {40, 10, 25, 5, 60, 30};
        for (int item : array)
        {
            heap1.add(item);
            printMaxHeap(heap1);
        }
        System.out.println("Current Max: " + heap1.getMax());
        //heap1.removeMax();


        
    }
    
    //helper
    private static void printMaxHeap(MaxHeapInterface<Integer> heap1) 
    {
        List<Integer> temp = new ArrayList<>();
        while (!heap1.isEmpty()) {
            Integer max = heap1.removeMax();
            System.out.print(max + ", ");
            temp.add(max);
        }
        // Re-adding elements to the MaxHeap to restore original state
        for (Integer element : temp) 
        {
            heap1.add(element);
        }
        System.out.println();
    }
}
