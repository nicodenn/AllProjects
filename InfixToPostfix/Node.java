/*Nico Dennis and Scott Spinali
 * November 12, 2018
 * Node class for a reference based stack*/

public class Node
{
	private Object item;
	private Node next;

	//Creates mew mpde object
	public Node(Object newItem)
	{
		item = newItem;
		next = null;
	}

	public Node(Object newItem, Node newNode)
	{
		item = newItem;
		next = newNode;
	}

	//Gets item in node
	public Object getItem()
	{
		return item;
	}

	//gets next node
	public Node getNext()
	{
		return next;
	}

	//sets item in the node
	public void setItem(Object newItem)
	{
		item = newItem;
	}

	//Sets next reference in node
	public void setNext(Node newNode)
	{
		next = newNode;
	}
}
