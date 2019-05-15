import java.io.*;
import java.math.*;
import java.lang.*;
import java.nio.Buffer;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class Compress {

 
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        boolean check = true;
        LinkedList compressedCode = new LinkedList();
        //int codeIndex = 129;

        while(check)
        {
            BufferedReader BR;
            String fileIn;
            boolean x = false;

            //if(args[0] != null)
            if(x)
            {
                fileIn = args[0];
            }

            else
            {
                System.out.println("Please enter name of text file to be compressed.");
                fileIn = scan.nextLine();

                if(! new File(fileIn).exists())
                {
                    System.out.println("You have entered a non-existant file, please enter a file name again.");
                    continue;
                }
            }

            //HashTable ht = new HashTable(71);
            //ht.initializeTable();
            try {
                long startTime = System.currentTimeMillis();
                BR = new BufferedReader(new FileReader(fileIn));
                compressedCode = compressFunction(BR);
                Node curr = compressedCode.getHead();
                long endTime = System.currentTimeMillis();
                DataOutputStream output = new DataOutputStream(new FileOutputStream(fileIn + ".zzz"));
                while(curr != null)
                {
                    int temp = curr.getCode();
                    System.out.print(temp + " ");
                    output.writeInt(temp);
                    curr = curr.getNext();
                }
                System.out.println("The file " + fileIn + " has been compressed!");
                output.close();
                BR.close();

            }
            catch (FileNotFoundException e) {
                System.out.println("The file you have entered does not exist!");
            }

            catch (IOException e){
                System.out.println("IOException occurs here.");
            }

            System.out.println("Would you like to run again?(y/n)");
            char c = scan.next().charAt(0);
            if(c== 'n' || c== 'N') {
                check = false;
            }

        }

    }

    public static LinkedList compressFunction(BufferedReader b)
    {
        try {
            int currentIndex = 0;
            HashTable hashTable = new HashTable(getNextPrimeValue(currentIndex));
            currentIndex++;
            LinkedList ll = new LinkedList();
            LinkedList dictionary = new LinkedList();
            for(int j =32;j<128;j++)
            {
                Node newNode = new Node(j,Integer.toString(j));
                dictionary.nodeInsert(newNode);
            }

            Node newNode = new Node(9,Integer.toString(9));
            dictionary.nodeInsert(newNode);

            newNode = new Node(10,Integer.toString(10));
            dictionary.nodeInsert(newNode);

            newNode = new Node(13,Integer.toString(13));
            dictionary.nodeInsert(newNode);

            hashTable.initializeTable();
            int text = 0;
            int temp = 0;
            int code = 0;
            int i = 0;
            int x = 128;
            String s = "";

            for(text = b.read() ; text != -1; text = b.read())
            {
                if(i==0){
                    temp = text;
                    code = temp;
                    s = s + (char)text;
                    i++;
                }
                else if(i>=1)
                {
                    s= s+(char)temp;
                    System.out.println(s);
                    temp = temp + (text)*(int)(Math.pow(17,i));
                    if(hashTable.entryExist(temp,x) || dictionary.ContainsString(s))
                    {
                        code = temp;
                        i++;
                    }
                    else
                    {
                        if(code<128)
                        {
                            ll.ListInsert(code);
                            dictionary.ListInsert(code);
                        }
                        else{
                            ll.ListInsert(x);
                            dictionary.ListInsert(x);
                            x++;
                        }
                        hashTable.insert(temp,x);
                        i=1;
                        temp = text;
                        code = text;
                        s="";
                    }
                }
                if(sizeCheck(hashTable))
                {
                   //hashTable.rehash(getNextPrimeValue(currentIndex));
                    hashTable = hashTable.rehash(getNextPrimeValue(currentIndex));
                    System.out.println(hashTable.getTableLength());
                    currentIndex++;
                }
            }
            return ll;
        }

        catch(IOException e)
        {
            System.out.println("IOException found here.");
            LinkedList ll = new LinkedList();
            return ll;
        }
    }

    public static int getNextPrimeValue(int primeIndex)
    {
        int[] primeValues = new int[]{151,499,1013,2069,5011,10061,20047,40039,80021,160651,321143,611939};
        System.out.println(primeValues[primeIndex]);
        System.out.println("Rehashing!");
        return primeValues[primeIndex];
    }

    public static boolean sizeCheck(HashTable hashTable)
    {
        int size = hashTable.getTableLength();
        int items = hashTable.getItemCount();
        if((double)(items/size) > .67)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
