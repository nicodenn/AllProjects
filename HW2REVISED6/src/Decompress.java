import java.io.*;
import java.util.Scanner;

public class Decompress {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean check = true;

        while (check) {
            BufferedReader BR;
            String fileIn = "test.txt.zzz";
            boolean x = false; 

            try {
                DataInputStream input = new DataInputStream(new FileInputStream(fileIn));
                BufferedWriter bwo = new BufferedWriter(new FileWriter("testResults.txt"));
                LinkedList dictionary = new LinkedList();
                for(int z =32;z<128;z++)
                {
                    String s = Character.toString(z);
                    Node newNode = new Node(z,s);
                    dictionary.nodeInsert(newNode);
                }

                String s=Character.toString((char) 9);
                Node newNode = new Node(9,s);
                dictionary.nodeInsert(newNode);

                s=Character.toString((char)10);
                newNode = new Node(10,s);
                dictionary.nodeInsert(newNode);

                s=Character.toString((char)13);
                newNode = new Node(13,s);
                dictionary.nodeInsert(newNode);

                decompress(dictionary,input, bwo);
                return;

            }

            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                System.out.println("There exists an IOException here");
            }
        }
    }

    static void decompress (LinkedList dict, DataInputStream dis, BufferedWriter bw)
            throws IOException
    {
        int Q = dis.readInt();
        bw.write(dict.findNode(Q).getTextString());
        System.out.print(dict.findNode(Q).getTextString());

        bw.flush();

        int P = 0;
        try
        {
            int dicIndex = 128;

            while (dis.available() > 0)
            {
                P = dis.readInt();
                if(dict.ContainsCode(P))
                {
                    bw.write(dict.findNode(P).getTextString());
                    System.out.print(dict.findNode(P).getTextString());
                    String s = dict.findNode(Q).getTextString() + dict.findNode(P).getTextString().charAt(0);
                    Node newNode = new Node(dicIndex,s);
                    dicIndex++;
                    dict.nodeInsert(newNode);
                }
                else
                {
                    bw.write(dict.findNode(Q).getTextString() + dict.findNode(Q).getTextString().charAt(0));
                    System.out.print(dict.findNode(Q).getTextString() + dict.findNode(Q).getTextString().charAt(0));
                    String s = dict.findNode(Q).getTextString() + dict.findNode(Q).getTextString().charAt(0);
                    Node newNode = new Node(dicIndex,s);
                    dicIndex++;
                    dict.nodeInsert(newNode);
                }
                bw.flush();

                Q = P;
            }
            bw.flush();
        } catch (EOFException e)
        {
            bw.flush();
            System.out.print("EOF exception seen here");
            return;
        }
        bw.flush();
    }

}

