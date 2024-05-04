package project5Recursion;

public class a2summationofn 
{
    public static void main(String[] args) 
    {
        int x = sumOf(3);
        System.out.println(x);
    }

    public static int sumOf(int n)
    {
        int sum;
        if (n==1)
        {
            sum=1;
        }
        else
        {
            sum = sumOf(n-1)+n;
        }
        return sum;
    }
    
}
