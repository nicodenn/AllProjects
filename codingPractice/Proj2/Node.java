public class Node
{
        private int date;
        private String info;
        private Node next;

        public Node(int newDate, String description)
        {
                date=newDate;
                info=description;
                next=null;;
        }

	public Node(int newDate, String description, Node newer)
        {
                date=newDate;
                info=description;
                next=newer;
        }

	public int getDate()
        {
                return date;
        }

	public String getInfo()
        {
                return info;
        }

	public Node getNext()
        {
                return next;
        }

	public void setInput(int newDate, String description)
        {
                date=newDate;
                info=description;
        }

	public void setNext(Node newNode)
        {
                next=newNode;
        }
}