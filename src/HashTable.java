import java.util.*;
import java.lang.*;
import java.io.*;

/* This is a hash table*/

public class HashTable {

   /* public static void main(String[] args)
    {
        HashTable ht = new HashTable(13);
        ht.insert(33);
        ht.insert(353);
        ht.insert(95);

        for(int i =2000; i<3000;i++)
        {
            ht.insert(i);
        }
        ht = ht.rehash(4123);
        System.out.println(ht.getTableLength());

    }*/

    private LinkedList[] mainTable;
    private int itemCount;

    public HashTable(LinkedList[] hTable)
    {
        mainTable = hTable;
        itemCount = 0;
    }

    public HashTable(int size)
    {
        mainTable = new LinkedList[size];
        itemCount = 0;
    }

    public void insert(Integer hash,int code)
    {
        if(mainTable[(hash % mainTable.length)] == null)
        {
            mainTable[(hash%mainTable.length)] = new LinkedList();
            mainTable[(hash%mainTable.length)].ListInsert(code);
            itemCount++;
        }
        else
        {
            mainTable[(hash%mainTable.length)].ListInsert(code);
            itemCount++;
        }
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getItemCount()
    {
        return this.itemCount;
    }

    public LinkedList[] getMainTable() {
        return mainTable;
    }

    public int getTableLength()
    {
        return mainTable.length;
    }

    public boolean entryExist(Integer hash, int code)
    {
        LinkedList temp = mainTable[(hash%mainTable.length)];
        if(temp == null)
        {
            return false;
        }

        else
        {
            if(temp.ContainsCode(code))
            {
                return true;
            }

            else
            {
                return false;
            }
        }
    }



    public boolean stringExist(Integer hash, String input)
    {
        LinkedList temp = mainTable[(hash%mainTable.length)];
        if(temp == null)
        {
            return false;
        }

        else
        {
            if(temp.ContainsString(input))
            {
                return true;
            }

            else
            {
                return false;
            }
        }
    }

    public HashTable rehash(int newSize)
    {
        LinkedList[] newTable = new LinkedList[newSize];
        int tableIndex = 0;
        int lengthLinkedList = 0;
        int count = 0;

        for(int i = 0; i < mainTable.length ; i++)
        {
            if(mainTable[i] == null)
            {
                lengthLinkedList = 0;
            }
            else
            {
                lengthLinkedList = mainTable[i].ListLength();
            }

            if(lengthLinkedList > 0  )
            {
                for(int j = 1; j <= mainTable[i].ListLength(); j++)
                {
                    int newInsert = mainTable[i].RetrieveCodeAt(j);
                    if(newTable[(newInsert)%(newTable.length)] == null)
                    {
                        newTable[(newInsert)%(newTable.length)] = new LinkedList();
                        newTable[(newInsert)%(newTable.length)].ListInsert(newInsert);
                        count++;
                    }
                    else
                    {
                        newTable[(newInsert)%(newTable.length)].ListInsert(newInsert);
                        count++;
                    }
                }
            }
        }
        HashTable cleanTable = new HashTable(newTable);
        cleanTable.setItemCount(count);
        System.out.println("length of rehash table is" + cleanTable.getTableLength());
        return cleanTable;
    }

    public void initializeTable()
    {
        String INITIALIZER = "\n\r\t !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        //String INITIALIZER = "AB";
        for (char c : INITIALIZER.toCharArray()) {
            this.insert((int) c,(int) c);
        }
    }

}
