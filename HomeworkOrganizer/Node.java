/*Nico Dennis and Scott Spinali
 * Last modified October 23, 2018
 * Defines basic node functions for LinkedList.*/

public class Node
{
	private int date;
	private String info;
	private Node next;

	//creating new node that consist of a date and a description
	public Node(int newDate, String description)
	{	
		date=newDate;
		info=description;
		next=null;
	}

	public Node(int newDate, String description, Node newer)
	{
		date=newDate;
		info=description;
		next=newer;
	}

	//gets date value of node
	public int getDate()
	{	
		return date;
	}

	//gets description value of node
	public String getInfo()
	{
		return info;
	}

	//gets next value of node
	public Node getNext()
	{
		return next;
	}
	
	//sets next value of node
	public void setNext(Node newNode)
	{	
		next=newNode;
	}
}


