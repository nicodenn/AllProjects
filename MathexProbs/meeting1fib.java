public class meeting1fib
{

    public static void main(String[] args)
    {
        other(34);
    }
    public static int other(int n)
    {
        if(n<=1)
        {
            return n;
        }

        int fibo = 1;
        int fiboprev = 1;
        int fart = 0;
        for(int i=2;i < n; i++)
        {
            int temp = fibo;
            fibo+= fiboprev;
            fiboprev = temp;
            if(fibo%2 == 0)
            {
                fart += fibo;
            }
            if(fibo > 4000000)
            {
                System.out.println(fart);
                //return fiboprev;
            }
            
        }
        return fibo;
        
    }
}