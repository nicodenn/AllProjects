import java.util.Scanner;
import java.util.StringTokenizer;

public class proj4
{


    public static void main(String[] args)
    {
        //take in user input for string
        System.out.println("Please enter the string you would like to encrypt");
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
       
        System.out.println("Please enter the individual key values (positive or negative integers, one after another in the same line with a space in between each value");
        Scanner keySc = new Scanner(System.in);
        String delims = " ";
        String key = keySc.nextLine();
        Queue refQueue = new Queue();
        StringTokenizer st = new StringTokenizer(key,delims);

        int curr = 0;
        Character oldLetter;
        Character newLetter;
        int ascii;
        int queueKey = 0;
        String newString = "";
        int lastQueue;
        keySc.close();
        s.close();

        while(st.hasMoreElements())
        {
            curr = Integer.parseInt(st.nextToken());
            refQueue.enqueue(curr);
        }

        for(int i = 0; i < inputString.length(); i++)
        {
            queueKey = (int)refQueue.getNext();
            oldLetter = inputString.charAt(i);
            ascii = (int) oldLetter;
            ascii = ascii + (queueKey % 94);
            newLetter = (char) ascii;
            newString = newString + newLetter;
        }

        lastQueue = curr;
        System.out.println(newString);
        String decryptedString = "";

        while((int)refQueue.getNext() != lastQueue)
        {
            queueKey = (int)refQueue.getNext();
        }
        
        for(int i = 0; i < newString.length(); i++)
        {
            queueKey = (int)refQueue.getNext();
            oldLetter = newString.charAt(i);
            ascii = (int) oldLetter;
            ascii = ascii - (queueKey % 94);
            newLetter = (char) ascii;
            decryptedString = decryptedString + newLetter;
        }
        System.out.println("Your decrypted message is: " + decryptedString);
    }
}