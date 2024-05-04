package project5Recursion;

public class a1countDown 
{
    public static void main(String[] args) 
    {
        countdown(3);
    }
    
    public static void countdown(int integer)
    {
        System.out.print(integer);
        if (integer >1)
        {
            System.out.print(",");
            countdown(integer-1);
        }
    }
}
