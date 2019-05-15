import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.*;

//having issues organizing the integers for decompression
    //put into array of bytes and then into integers??

public class decompress
{   
    //private static int TABLESIZE = 311;
    //private static int primeCounter = 0;
    //private static int[] primeValues = new int[]{499,1013,2069,5011,10061,20047,40039,80021,160651,321143,611939};
    public static void main(String[] args)
    throws FileNotFoundException, IOException
    {
        //System.out.println("first line prints");
        //String[] dictionary = makeDict();
        //makeDict();
        try{
        File file = new File(args[0]);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        
        /*int[] intArray = new int[fileData.length()/4];
        while(dis.available() > 0)
        {
        intArray[i] = dis.readInt();
        i++;
        }*/
        
        int maxInitIndex = '~';
        int maxCode = 0;
        int[] intArray = new int[(int) (fileData.length / 4)];
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
        System.out.println("about to decompress");
        fileDecompress(intArray, maxCode);
        
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e)
        {
            System.out.println("File input error");
        }
    }
    public static void fileDecompress(int[] ints, int maxCode)
    throws IOException
    {
        String[] a = new String[maxCode];
        int indexDict = 0;
        System.out.println(maxCode);
        StringBuilder output = new StringBuilder();
        //first check char
        char temp = (char) ints[0];
        String lastEntry = Character.toString(temp);
        for(int i = 1; i<ints.length; i++)
            {
                    if(ints[i] <= 0)
                    {    
                            //fw.write(a[p]);
                            //System.out.println("we are at line 63");
                            System.out.println("int is less than 0");
                            System.out.println((char) (ints[i]+ (int)'~'));
                            output.append((char) (ints[i]+ (int)'~'));
                            //System.out.println("we are at line 65");
                            //TABLESIZE++;
                            char tempe = (char) (ints[i]+ (int)'~');
                            a[indexDict] = lastEntry + Character.toString(tempe);
                            lastEntry = a[indexDict];
                            indexDict++;
                            //System.out.println("we are at line 67")
                }
                    if(ints[i] > 0)
                    {  
                            //fw.write(a[p]);
                            //System.out.println("we are at line 63");
                            //System.out.println(a[ints[i]]);
                            //System.out.println("int is greater than 0");
                            output.append(a[indexDict]);
                            lastEntry = a[indexDict];
                            if(a[indexDict] != null && indexDict < maxCode)
                            {
                                a[indexDict] = lastEntry + FirstChar(a[indexDict]); 
                                lastEntry = a[indexDict];
                                indexDict++;
                            }
                            //System.out.println("we are at line 67");
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
    public static String FirstChar(String str)
    {
        return str.substring(0,1);
    }
    private static int getInt(DataInputStream in) throws IOException {
        try {
            return in.readInt();
        } catch (EOFException e) {
            return -1;
        }
    }

}