public class Node
{
        private Object item;
        private Node next;
        public Node (Object newItem)
        {
                item = newItem;
                next = null;
        }
        public Node(Object newItem, Node newNode)
        {
                item = newItem;
                next = newNode;
        }
        public Object getItem()
        {
                return item;
        }
        public Node getNext()
        {
                return next;
        }
        public void setItem(Object newItem)
        {
                item = newItem;
        }
        public void setNext(Node newNode)
        {
                next = newNode;
        }
}