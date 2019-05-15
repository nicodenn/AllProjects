public class Node
{
    private int code;
    private String textString;
    private Node next;

    public Node(int c)
    {
        code = c;
        textString = "";
        next = null;
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


