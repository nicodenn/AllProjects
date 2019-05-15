import java.util.*;
public class StackRefBased
{
        public Node top;
        public StackRefBased()
        {
                top = null;
        }
        public boolean stackIsEmpty()
        {
                return (top == null);
        }
        public void push(Object newItem)
        {
                Node newNode = new Node(newItem);
                top = new Node(newItem,top);
        }
        public Object pop()
        throws EmptyStackException
        {
                if(!stackIsEmpty())
                {
                        Object r = top.getItem();
                        Node curr = top;
                        top = top.getNext();
                        curr = null;
                        return r;
                }
                else
                {
                        throw new EmptyStackException();
                }
        }
        public Object peek()
        throws EmptyStackException
        {
                if(!stackIsEmpty())
                {
                        return top.getItem();
                }
                else
                {
                        throw new EmptyStackException();
                }
        }
}