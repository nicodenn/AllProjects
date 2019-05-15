public class LList
{	private Node head;
        private int numDates;

        public LList()
        {
                Node head=null;
                int numDates=0;
        }

	public boolean ListIsEmpty()
        {
                return numDates==0;
        }

	public int ListLength()
        {
                return numDates;
        }
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

	public void DisplayAll()
        {
                for(Node curr = head; curr !=null; curr = curr.getNext())
                {
                        System.out.println("Date: " + curr.getDate() + ". Description: " + curr.getInfo() + ".");
                }
        }
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

                else
                {
                        Node curr = head;

                        while(curr.getNext() != null && curr.getNext().getDate() < newDate)
                        {
                            System.out.println("we in this");
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


public void RemoveAssignment(int position)
                throws IndexOutOfBoundsException
        {
                if(position >=1 && position <= numDates)
                {
                    System.out.println("position is within parameters of if statement");
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
                            System.out.println("we made it to else");
                            Node prev = locate(position - 1);
                            curr = prev.getNext();
                            prev.setNext(curr.getNext());
                            numDates--;
                        }
                        
                //	curr.getNext().setNext(null);
                }

                else
                {
                        throw new IndexOutOfBoundsException("Assignment of your indicated position does not exist.");
                }
        }
}
