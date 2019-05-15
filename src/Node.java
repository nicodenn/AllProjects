public class Node
{
    // private String stringEntry;
    //private char charEntry;
    private int code;
    private String textString;
    private Node next;

    public Node(int c)
    {
        code = c;
        textString = "";
        next = null;
        //charEntry = 0;
        //stringEntry = "";
    }

    public Node(int newEntry, String in)
    {
        code=newEntry;
        textString = in;
        next = null;
    }

    public Node (int newEntry, Node nextNode)
    {
        code = newEntry;
        next = nextNode;
    }

    public String getTextString() {
        return textString;
    }

    /* public short getCode()
    {
        return entry.getCodeEntry();
    }

    public short getKeyPrefix()
    {
        return entry.getKeyPrefixEntry();
    }

    public char getKeyChar()
    {
        return entry.getKeyCharEntry();
    }*/

    public int getCode()
    {
        return code;
    }


    public Node getNext()
    {
        return next;
    }

    public void setNext(Node nextNode)
    {
        next = nextNode;
    }
}


