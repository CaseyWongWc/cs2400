package project5Recursion;

public class a3recursivelyprocessinganarray 
{
    public static void main(String[] args) 
    {
        String [] hello = {"apples","bannana","pear","peach","orange"};
        int last = hello.length-1;
        displayArray(hello, 0, last);      e();
        displayArrayBack(hello, 0, last);  e();
        displayArrayHalf(hello, 0, last);  e();
    }

    public static void displayArray(String [] array, int first, int last)
    {
        System.out.print(array[first]+" ");
        if (first < last)
        {
            displayArray(array, first+1, last);
        }
        
    }

    public static void displayArrayBack(String [] array, int first, int last)
    {
        if (first <= last)
        {
            displayArray(array, first, last-1);//goes all the way down to index zero and counts back up to 2
            System.out.print(array[last]+ " ");
        }
    
    }

    public static void displayArrayHalf(String array[], int first, int last)
    {
        if (first == last)
        {
            System.out.print(array[first]+" ");
        }
        else
        {
            int mid = first + (last - first) /2;
            displayArrayHalf(array,first,mid);
            displayArrayHalf(array,mid+1,last);
        }
    }

    public static void e() //newline
    {
        System.out.println();
    }

}
