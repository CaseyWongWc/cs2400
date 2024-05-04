package project5Recursion;

public class a5timeefficency 
{
    public static void main(String[] args) 
    {
        countdownrecursive(5);
        System.out.println();
        countdowniterative(5);
    }

    public static void countdownrecursive(int integer)
    {
        System.out.print(integer);
        if (integer >1)
        {
            System.out.print(",");
            countdownrecursive(integer-1);
        }
    }

    public static void countdowniterative(int integer)
    {
        while (integer >= 1)
        {
            System.out.print(integer);
            if (integer >1)
            {
                System.out.print(",");
            }
            integer = integer-1;
        }
    }

}
