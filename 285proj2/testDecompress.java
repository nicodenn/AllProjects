public class testDecompress
{
    public static void main(String[] args)
    throws IndexOutOfBoundsException
    {
    int[] codeArray = {0,0,1,2,2,5,0,7,6,1,1,3,4,7,15}; //97,97,98,99,99,187,97,181,188,98,98,172,179,181,198;
    int codeArrayCounter = 0;
    int f = 0;
    for(int i = 0;i<=codeArray.length;i++)
    {
        codeArrayCounter++;
    }
    int TABLESIZE = codeArrayCounter;
    String[] a = new String[TABLESIZE];
    String [] altArray = {"a","b","c"};
    int altArrayLength = altArray.length;
    for(int i = 0; i < altArrayLength; i++ )
    {
        a[i] = altArray[i];
    }
    String output = null;
    //first check char
    
     
    System.out.println("first iteration lol");
    System.out.println(a[codeArray[f]]);
    //ystem.out.println("we are at line 65");
    //TABLESIZE++;
    a[altArrayLength] = a[codeArray[f]] + a[codeArray[f]];
    System.out.println("first iteration complete");
    output = output + a[codeArray[f]];
    
    for(int i = 1; i<codeArray.length; i++)
            {
                try{   
                    System.out.println("we are at the fileDecompress method inside the while loop.");
                    if(a[codeArray[i]] != null)
                    {
                        
                        //fw.write(a[p]);
                        System.out.println("we are at line 63");
                        System.out.println(a[codeArray[i]]);
                        output = output + a[codeArray[i]];
                        System.out.println("we are at line 65");
                        //TABLESIZE++;
                        
                        a[altArrayLength] = a[codeArray[i-1]] + FirstChar(a[codeArray[i]]);
                        altArrayLength++;
                        System.out.println("we are at line 67");
        
                    }
                    else{
                        a[codeArray[i]] = a[codeArray[i-1]] + FirstChar(a[codeArray[i-1]]);
                        System.out.println("we are at line 71");
                        //fw.write(a[p]);
                        output = output + a[codeArray[i]];
                        System.out.println("we are at line 73");
                        //TABLESIZE++;
                        
                        a[altArrayLength] = a[codeArray[i-1]] + FirstChar(a[codeArray[i-1]]);
                        altArrayLength++;
                        System.out.println("we are at line 75");
                        
                    }
                    //i++;
                    //q = ints[i-1];
                    //lastIndex++;
                    //System.out.println(i);
                    //System.out.println(a[p]);
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //primeCounter++;
                    //TABLESIZE = nextPrime(primeCounter);
                    //System.out.println(TABLESIZE);
                }
            }
            System.out.println(output);
            for(int j = 0; j<a.length; j++)
            {
                System.out.println(a[j]);
            }
            //fw.close();
        
        /*catch(IOException e)
        {
            System.out.println("file write error");
        }*/
        
        //return outFile;
    }
    public static String FirstChar(String str)
    {
        String temp = str.substring(0, 1);
        return temp;
    }
}
