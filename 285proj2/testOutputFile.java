import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class testOutputFile
{
    public static void main(String[] args)
    {
        //String[] dictionary = makeDict();
        try{
        File file = new File(args[0]);
        //FileWriter fw = new FileWriter(outFile);
        byte[] fileData = new byte[(int) file.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        dis.readFully(fileData);
        dis.close();
        for(int i = 0; i < fileData.length; i++)
        {
            System.out.println(fileData[i]);
        }
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
       // catch(FileNotFoundException e){}
    }
}