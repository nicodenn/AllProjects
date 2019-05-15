import java.io.*;
import java.math.*;
import java.lang.*;
public class testCompress
{
    public static void main(String[] args)
    {
    try {
        int currentIndex = 0;
        String[] compressString = {"a","a","b","c","c","b","c","a","c","b","c","c","b","b","a","a","a","b","c","b","a","b","c"};
        HashTable hashTable = new HashTable(151);
        //getNextPrimeValue(currentIndex)
        currentIndex++;
        LinkedList ll = new LinkedList();
        hashTable.initializeTable();
        int text = 0;
        int temp = 0;
        int code = 0;
        int j = 0;
        //int i = 0;
        int intcount = 0;
        String outputString = "";
        String prefix = "";

        for(int i = 0; i<compressString.length;i++)
        {
            while(entryExist((int)compressString[i]) != true)
            {
                prefix = compressString[i+j];
                j++;
            }
            
            prefix = "";

        }

            /*
            if(i==0){
                temp = text;
                code = temp;
                i++;
            }
            else if(i>=1)
            {
                temp = temp + (text)*(int)(Math.pow(7,i));
                if(hashTable.entryExist(temp))
                {
                    code = temp;
                    i++;
                }
                else
                {
                    ll.ListInsert(code);
                    hashTable.insert(temp);
                    i=1;
                    temp = text;
                    code = text;
                }*/
            
          
            /*if(sizeCheck(hashTable))
            {
               //hashTable.rehash(getNextPrimeValue(currentIndex));
                hashTable = hashTable.rehash(getNextPrimeValue(currentIndex));
                System.out.println(hashTable.getTableLength());
                currentIndex++;
            }*/
        
        System.out.println(intcount);
        //return ll;
    }

    catch(IOException e)
    {
        System.out.println("IOException found here.");
        LinkedList ll = new LinkedList();
        //return ll;
    }
}
}

