package project5Recursion;

public class a7unknown 
{
    public static void main(String[] args) 
    {
        unknown(4);
    }
    
    private static void unknown(int n)
    {
        if (n > 0)
        unknown(n-1);
     System.out.print("?");
    } 
}

