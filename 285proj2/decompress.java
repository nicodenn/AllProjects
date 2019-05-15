import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.*;

//having issues organizing the integers for decompression
    //put into array of bytes and then into integers??

public class decompress
{   
    //private static int TABLESIZE = 311;
    private static int primeCounter = 0;
    private static int[] primeValues = new int[]{499,1013,2069,5011,10061,20047,40039,80021,160651,321143,611939};
    public static void main(String[] args)
    throws FileNotFoundException, IOException
    {
        //System.out.println("first line prints");
        String[] dictionary = makeDict();
        //makeDict();
        try{
        File file = new File(args[0]);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = 0;
        /*int[] intArray = new int[fileData.length()/4];
        while(dis.available() > 0)
        {
        intArray[i] = dis.readInt();
        i++;
        }*/
        
        int maxInitIndex = '~';
        int maxCode = 0;
        int[] intArray = new int[(int) (fileData.length() / 4)];
             for (int j = getInt(dis), i = 0; j != -1; j = getInt(dis), i++) 
            {
                 int jAdjusted = j - maxInitIndex;
                 intArray[i] = j;
                 if (maxCode < jAdjusted) {
                     maxCode = jAdjusted;
                }
            }
                 dis.close();

        // this goes in the first parameter of fileDecompress
        
        //int[] codeArray = {0,0,1,2,2,5,0,7,6,1,1,3,4,7,15};
        fileDecompress(intArray, maxCode);
        
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e)
        {
            System.out.println("File input error");
        }
        //take in compressed file
        //while reading by integer with readInt() function, append to array of ints
        //convert it to an array of integers
    }
    public static void fileDecompress(int[] ints, int maxCode)
    throws IOException
    {
        String[] a = new String[maxCode];
        StringBuilder output = new StringBuilder();
        //first check char
        //a[0] = a[0] + a[0];
        //output.append(a[ints[f]]);
        
        for(int i = 1; i<ints.length; i++)
                {
                    if(ints[i] <= 0)
                    {    
                            //fw.write(a[p]);
                            //System.out.println("we are at line 63");
                            System.out.println((char) (ints[i]+ (int)'~'));
                            output.append((char) (ints[i]+ (int)'~'));
                            //System.out.println("we are at line 65");
                            //TABLESIZE++;
                            
                            a[i] = a[i-1] + (char) (ints[i]+ (int)'~');
                            //System.out.println("we are at line 67");
            
                        
                        /*
                        else{
                            a[ints[i]] = a[ints[i-1]] + FirstChar(a[ints[i-1]]);
                            System.out.println("we are at line 71");
                            //fw.write(a[p]);
                            output = output + a[ints[i]];
                            System.out.println("we are at line 73");
                            //TABLESIZE++;
                            
                            a[altArrayLength] = a[ints[i-1]] + FirstChar(a[ints[i-1]]);
                            altArrayLength++;
                            System.out.println("we are at line 75");
                            
                        }*/
                    }
                    else if(ints[i] > 0)
                    {  
                        if(a[i] != null)
                        {
                            
                            //fw.write(a[p]);
                            //System.out.println("we are at line 63");
                            //System.out.println(a[ints[i]]);
                            output.append(a[ints[i]]);
                            a[i] = a[i-1] + FirstChar(a[ints[i]]);
                            //System.out.println("we are at line 67");
            
                        }
                        else{
                            a[i] = a[i-1] + FirstChar(a[i-1]);
                            System.out.println("we are at line 71");
                            //fw.write(a[p]);
                            output.append(a[i]);
                            System.out.println("we are at line 73");
                            //TABLESIZE++;
                            a[i] = a[i-1] + FirstChar(a[i-1]);
                            System.out.println("we are at line 75");
                            
                        }
                    }
                    }
                }
                System.out.println(output);
                for(int j = 0; j<a.length; j++)
                {
                    System.out.println(a[j]);
                }
                //fw.close();
            
            //return outFile;
            System.out.println(ints.length);
        }
    /*public static int[] binaryToArray(byte[] f)
    throws ArrayIndexOutOfBoundsException
    {
        int[] intArray = new int[f.length];
        int arrayCounter = 0;
        for(int i = 0; i<f.length; i++)
        {
            intArray[i] = f[i].readInt();
        }
        return intArray;
    }  */ 
             
    public static int nextPrime(int primeIndex)
    {
        //primeCounter++;
        System.out.println("we got a prime!");
        //System.out.println(asciiStrings);
        return primeValues[primeIndex];
    }
    public static char FirstChar(String str)
    {
        return str.charAt(0);
    }
    public static String[] makeDict()
    {
        //String INITIALIZER = "\n\r\t !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

        String[] asciiStrings = new String[3];
        
        asciiStrings[0] = "a";
        asciiStrings[1] = "b";
        asciiStrings[2] = "c";
        //int indexCounter = 0;
        //String INITIALIZER = "\n\r\t !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        /*for(int i = 32; i<127; i++)
        {
            char inChar = (char)(i);
            asciiStrings[indexCounter] = Character.toString(inChar);
            indexCounter++;
            //System.out.println(Character.toString(inChar));
        }
        System.out.println(asciiStrings.length);*/
        return asciiStrings;
    }

}