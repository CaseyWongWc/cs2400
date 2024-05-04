package project5Recursion;

public class a6fibonacci 
{
    public static void main(String[] args) 
    {
        int n=3;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n)
    {
        int sum=0;
        if (n<1)
        {
            n = -1;
        }
        else if (n<3)
        {
            return  n=1;
        }
        else
        {
            sum=fibonacci(n-1)+fibonacci(n-2);
        }
        return sum;
    }
}
