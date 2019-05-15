public class Queue 
{
    private Node b;

    public Queue()
    {
        Node b = null;
    }

    public boolean queueIsEmpty()
    {
        return (b==null);
    }

    public void enqueue(Object newItem)
    {
        Node newNode = new Node(newItem);
        if(queueIsEmpty())
        {
            newNode.setNext(newNode);
            b = newNode;
        }
        else
        {
            newNode.setNext(b.getNext());
            b.setNext(newNode);
            b = newNode;
        }
    }

    public Object dequeue()
    throws RuntimeException
    {
        if(!queueIsEmpty())
        {
            Node front = b.getNext();
            if(front == b)
            {
                b = null;
            }
            else
            {
                b.setNext(front.getNext());
                front.setNext(null);
            }
            return front.getItem();
        }
        else
        {
            throw new RuntimeException();
        }
        
    }

    public Object peek()
    throws RuntimeException
    {
        if(!queueIsEmpty())
        {
            return(b.getNext().getItem());
        }
        else
        {
            throw new RuntimeException();
        }
    }
    public Object getNext()
    {
        b = b.getNext();
        return b.getItem();
    }

    
}