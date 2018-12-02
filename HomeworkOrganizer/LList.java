/*Nice Dennis and Scott Spinali
 * Last modified October 24, 2018
 * Uses node class to define basic methods like adding, removing and displaying nodes of a linkedlist*/

public class LList
{	private Node head;
	private int numDates;

	//LinkedList constructor
	public LList()
	{
		Node head=null;
		int numDates=0;
	}

	//returns whether or not list is empty
	public boolean ListIsEmpty()
	{	
		return numDates==0;
	}

	//Returns number of elements in linked list
	public int ListLength()
	{
		return numDates;
	}

	//Locates node based on position in list
	public Node locate(int posi)
	{
		Node curr = head;
		while(posi>1)
		{
			curr = curr.getNext();
			posi--;
		}
		return curr;
	}	

	//Prints out first assighnment(s) that exists in the linked list
	public void FirstDue()
	{
		if(numDates !=0)
		{
			Node curr = head;
			Node prev;
			System.out.println("Date: " + curr.getDate() + ". Assignent description: " + curr.getInfo() + ".");
			int x = 1;
			while(x ==  1)
			{
				prev = curr;
				curr = curr.getNext();

				if(curr == null)
				{
					x = -1;
				}

				if(curr.getDate() == prev.getDate())
				{	
					System.out.println("Date: " + curr.getDate() + ". Assignment description: " + curr.getInfo() + ".");
				}

				else
				{
					x = -1;	
				}
			}
		}
		else
		{	
			System.out.println("No assignments have been added.");
		}
	}

	//Prints out all elements in linked list
	public void DisplayAll()
	{
		for(Node curr = head; curr !=null; curr = curr.getNext())
		{
			System.out.println("Date: " + curr.getDate() + ". Description: " + curr.getInfo() + ".");
		}
	}

	//Adds and sorts new assignment into linked list based on date of assignment
	public void AddAssignment(int newDate, String description)
		throws IndexOutOfBoundsException
	{
		if(newDate>=1 && newDate<=31)
		{
			if(numDates==0)
			{
				Node newNode = new Node(newDate, description);
				head = newNode;
				numDates++;
			}

			else if(newDate < head.getDate())
			{
				Node newNode = new Node(newDate, description);
				newNode.setNext(head);
				head = newNode;
				numDates++;
			}

			else
			{
				Node curr = head;

				while(curr.getNext() != null && curr.getNext().getDate() < newDate)
				{
					curr = curr.getNext();
				}

				Node newNode = new Node(newDate, description);
				newNode.setNext(curr.getNext());
				curr.setNext(newNode);
				numDates++;
			}
		}

		else
		{
			throw new IndexOutOfBoundsException("Please try again.");
		}
	}

	//Removes assignment based on the position of assignment that needs to be taken out
	public void RemoveAssignment(int position)
		throws IndexOutOfBoundsException
	{
		if(position >=1 && position <= numDates)
		{
			Node curr = head;
			if(head == null)
			{
				System.out.println("There are no items in this list.");
			}

			if(position == 1)
			{
				head = head.getNext();
				numDates--;
			}
			else
			{
				Node prev = locate(position - 1);
				curr = prev.getNext();
				prev.setNext(curr.getNext());
				numDates--;
			}
		}

		else
		{
			throw new IndexOutOfBoundsException("Assignment of your indicated position does not exist.");
		}            
	}
}
