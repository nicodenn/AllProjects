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

    public Node findNode(int x)
    {
        Node curr = head;
        while(true)
        {
            if(curr.getCode()==x)
            {
                return curr;
            }
            else
            {
                curr = curr.getNext();
            }
        }
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
        Node curr = head;
        while(curr!=null){
            if(curr.getCode()==code)
            {
                return true;
            }
            else
            {
                curr = curr.getNext();
            }
        }
        return false;
        /*for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveCodeAt(i) == code)
                return true;
        }*/
    }

    public boolean ContainsString(String s)
    {
        Node curr = head;
        while(curr!=null){
            if(curr.getTextString()==s)
            {
                return true;
            }
            else
            {
                curr = curr.getNext();
            }
        }
        return false;
        /*for (int i = 1; i <= numItems; i++)
        {
            if (RetrieveCodeAt(i) == code)
                return true;
        }*/
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

    public void nodeInsert(Node n)
    {
        if(head ==null)
        {
            head = n;
        }
        else 
        {
            Node curr = head;
            while(curr.getNext()!=null)
            {
                curr = curr.getNext();
            }
            curr.setNext(n);
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
}
