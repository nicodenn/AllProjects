/*
* This program takes a user inputted file and finds the maximum subsequence 
* sum using 4 different algorithms that vary in efficiency.
* Author is Nico Dennis
* Last Edited 2/25
*/

import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class algorithms
{
    public static void main(String args[])
    {
    try{
        boolean check = true;
        boolean newCheck = true;
        
        //newCheck loop allows for repition of program with alternate files
        while(newCheck)
        {
            //Takes user file input and converts into array
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter the name of the file for Subsequence Sum");
            String inFile = s.nextLine();
            int[] newArray = getInts(inFile);
             while(check)
            {
                //user menu
                System.out.println("To run algorithm 1 press \"a\"");
                System.out.println("To run algorithm 2 press \"b\"");
                System.out.println("To run algorithm 3 press \"c\"");
                System.out.println("To run algorithm 4 press \"d\"");
                System.out.println("To run all algorithms press \"r\"");
                System.out.println("To quit program press \"q\"");
                char compare = s.next().charAt(0);
                //switch manages all menu outcomes
                switch(compare)
                {
                    case 'a':
                    {
                        //first algorithm
                        System.out.println(alg1(newArray));
                        break;
                    }
                    case 'b':
                    {
                        //second algorithm
                        System.out.println(alg2(newArray));
                        break;
                    }
                    case 'c':
                    {
                        //third algorithm
                        System.out.println(alg3(newArray));
                        break;
                    }
                    case 'd':
                    {
                        //fourth algorithm
                        System.out.println(alg4(newArray));
                        break;
                    }
                    case 'r':
                    {
                        //Execute all algorithms at once
                        System.out.println(alg1(newArray));
                        System.out.println(alg2(newArray));
                        System.out.println(alg3(newArray));
                        System.out.println(alg4(newArray));
                        break;
                    }
                    case 'q':
                    {
                        //exits to outer loop to check if user wants to use alternate input
                        check = false;
                        break;
                    }
                    default:
                    {
                        //Reply when no operation is called
                        System.out.println ("Operation not found.");
                        break;
                    }

                }
            
        }
        //manages alternate user input
        System.out.println("Would you like to run again with a new file? (y/n)");
            Scanner q = new Scanner(System.in);
            char quit = q.nextLine().charAt(0);
            if(quit=='n')
            {
                q.close();
                newCheck = false;
                s.close();
                break;
            }
            else if(quit != 'y' && quit != 'n')
            {
                System.out.println("invalid input");
                break;
            }
            check = true;
            
    }
            
        }
        catch(StringIndexOutOfBoundsException s)
        {
            System.out.println("invalid input, quitting");
            System.exit(0);
        }
        catch(FileNotFoundException f){
            System.out.println("file not found");
            System.exit(0);
        }
        catch(IOException e){
            System.out.println("error");
            System.exit(0);
        }
        
    }
    //method to turn user input into array of integers
    public static int[] getInts(String a)
    throws IOException
    {
        File f = new File(a);
        BufferedReader n = new BufferedReader(new FileReader(f));
        String input = n.readLine();
        String tempStr = input;
        char[] c = tempStr.toCharArray();
        int fileLength = 0;
        for(int i = 0; i<tempStr.length();i++)
        {
            if(Character.isSpaceChar(c[i]))
            {
                fileLength++;
            }
        }
        int[] valueArray = new int[fileLength];
        StringTokenizer strk = new StringTokenizer(input);
        for(int i = 0; i < fileLength; i++)
        {
            valueArray[i]=Integer.parseInt(strk.nextToken());
        }
        n.close();
        return valueArray;
    }

    //first algorithm uses 3 for loops to iterate through all possible combinations to find MSS O(n^3)
    public static int alg1(int[] a)
    {
        long curr = System.currentTimeMillis();
        long current = System.nanoTime();
        int n = a.length, maxSum = 0;
        for(int i=0; i<n; i++)
        {
            for(int j = i; j < n; j++)
            {
                int sum = 0;
                for(int k=i; k<=j; k++)
                {
                    sum+=a[k];
                }
                if(sum>maxSum)
                {
                    maxSum=sum;
                }
            }
        }
        System.out.println(System.currentTimeMillis()-curr);
        System.out.println(System.nanoTime()-current);
        return maxSum;
    }

    //algorithm 2 combines the second and third for loops from above and creates a more efficient approach O(n^2)
    public static int alg2(int[] a)
    {
        long curr = System.currentTimeMillis();
        long current = System.nanoTime();
        int n = a.length, maxSum = 0;
        for(int i=0; i<n; i++)
        {
            int sum = 0;
            for(int j=i; j<n; j++)
            {
                sum+=a[j];
                if(sum > maxSum)
                {
                    maxSum = sum;
                }
            }
        }
        System.out.println(System.currentTimeMillis()-curr);
        System.out.println(System.nanoTime()-current);
        return maxSum;
    }
    /*Algorithm 3 is a recursive approach that finds the left and right side max values.
    *then it compares those two values to the max value of the sum of the middle values 
    summating away from the centerpoint*/
    public static int alg3(int [] a)
    {
        long curr = System.currentTimeMillis();
        long current = System.nanoTime();
        int testAlg = maxSumRec(a,0,a.length-1);
        System.out.println(System.currentTimeMillis()-curr);
        System.out.println(System.nanoTime()-current);
        return maxSumRec(a, 0, a.length-1);
    }
    public static int maxSumRec(int[] a, int low, int high)
    {
        if(low == high)
        {
            if(a[low] > 0)
            {
                return a[low];
            }
            else return 0;
        }
        int middle = (low + high)/2;
        int maxLeftSum = maxSumRec(a,low,middle);
        int maxRightSum = maxSumRec(a,middle + 1,high);
        int maxLeftBoundSum=0,maxRightBoundSum=0,sum=0;
        for(int i = middle; i>=low;i--)
        {
            sum+=a[i];
            if(sum > maxLeftBoundSum)
            {
                maxLeftBoundSum = sum;
            }
        }
        sum = 0;
        for(int j=middle+1; j<=high; j++)
        {
            sum+=a[j];
            if(sum > maxRightBoundSum)
            {
                maxRightBoundSum = sum;
            }
        }
        return max3(maxLeftSum, maxRightSum,(maxLeftBoundSum+maxRightBoundSum));
    }

    public static int max3(int left, int right, int middle)
    {
        int[] nums = {left,right,middle};
        int max = left;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
            }
        }
        return max;
    }
    // linear and most efficient approach. continuously sums values,
    //iterating through entire array until it finds greatest subsequence sum
    public static int alg4(int[] a)
    {
        long curr = System.currentTimeMillis();
        long current = System.nanoTime();
        int maxSum = 0, sum = 0;
        for(int j=0; j< a.length; j++)
        {
            sum += a[j];
            if (sum > maxSum)
            {
                maxSum = sum;
            }
            else if (sum < 0)
            sum = 0;
        }
        System.out.println(System.currentTimeMillis()-curr);
        System.out.println(System.nanoTime()-current);
        return maxSum;
    }

}