//this class can be used to generate a file of random values

import java.util.Random;
import java.io.*;
public class testNumbers
{
    public static void main(String[] args)
    {
        try{
        Random random = new Random();
        Writer FR = new FileWriter("testnums2.txt");

         for(int i=0; i<=500; i++)
         {
            int randomNumber=(random.nextInt(198)-99);
            System.out.println(randomNumber);
            FR.write((Integer.toString(randomNumber) + " "));
         }
         FR.close();
        }
        catch(IOException e)
        {

        }
    }
}