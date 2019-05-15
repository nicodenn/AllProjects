//The Compress method uses this class and methods to implement a hash table as an array of LinkedLists
public class LinkedList
{

    private Node head;
    private int numItems;

    public LinkedList()
    {
        head = null;
        numItems = 0;
    }

    public Node getHead() {
        return this.head;
    }

    public boolean ListIsEmpty()
    {
        return this.numItems == 0;
    }

    public int ListLength()
    {
        return this.numItems;
    }

    private Node Locate(int position)
    {
        Node curr = head;
        while (position > 1)
        {
            curr = curr.getNext();
            position--;
        }
        return curr;
    }

    public boolean ContainsCode(int code)
    {
        for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveCodeAt(i) == code)
                return true;
        }
        return false;
    }

    public int RetrieveCodeAt(int position) throws IndexOutOfBoundsException
    {
        if (position >= 1 && position <= numItems)
        {
            Node curr = Locate(position);
            return curr.getCode();
        }
        else
        {
            throw new IndexOutOfBoundsException("Error. Attempted to retrieve at an invalid index in RetrieveCodeAt");
        }
    }

    public void ListInsert(int code)
    {
        Node newNode = new Node(code);
        if(head == null)
        {
            head = newNode;
            numItems++;
        }
        else
        {
            Node curr = head;
            while(curr.getNext()!=null)
            {
                curr = curr.getNext();
            }
            curr.setNext(newNode);
            numItems++;
        }
    }

    /*public boolean ContainsKey(short keyPrefix, char keyChar)
    {
        for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveKeyPrefixAt(i) == keyPrefix && RetrieveKeyCharAt(i) == keyChar)
                return true;
        }
        return false;
    }*/



    /*public short RetrieveKeyPrefixAt(int position) throws IndexOutOfBoundsException
    {
        if (position >= 1 && position <= numItems)
        {
            Node curr = Locate(position);
            return curr.getKeyPrefix();
        }
        else
        {
            throw new IndexOutOfBoundsException("Error.  Attempted to retrieve at an invalid index in RetrieveKeyAt()");
        }
    }

    public char RetrieveKeyCharAt(int position) throws IndexOutOfBoundsException
    {
        if (position >= 1 && position <= numItems)
        {
            Node curr = Locate(position);
            return curr.getKeyChar();
        }
        else
        {
            throw new IndexOutOfBoundsException("Error.  Attempted to retrieve at an invalid index in RetrieveKeyAt()");
        }
    }

    public short getCode(short keyPrefix, char keyChar)
    {
        for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveKeyPrefixAt(i) == keyPrefix && RetrieveKeyCharAt(i) == keyChar)
                return RetrieveCodeAt(i);
        }
        return -1;
    }

    public short getKeyPrefix(short code)
    {
        for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveCodeAt(i) == code)
                return RetrieveKeyPrefixAt(i);
        }
        return -1;
    }

    public char getKeyChar(short code)
    {
        for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveCodeAt(i) == code)
                return RetrieveKeyCharAt(i);
        }
        return '\0';
    }*/

   /* public void PrintList()
    {
        Node curr = head;

        for(int i = 0; i < numItems; i++)
        {
            System.out.println("Key: " + curr.getKeyPrefix()  + curr.getKeyChar() + " Code: " + curr.getCode());
            curr = curr.getNext();
        }
    }

    public int countList()
    {
        Node curr = head;
        int count;

        for(count = 0; count < numItems; count++)
            curr = curr.getNext();
        return count;
    }*/
}
