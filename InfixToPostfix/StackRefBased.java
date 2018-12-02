/*Nico Dennis and Scott Spinali
 * November 12, 2018
 * creates a referenced based stack that is to be used in an infix calculator.*/
import java.util.EmptyStackException;

public class StackRefBased {
	private Node top;

	//Creates new reference based stack
	public StackRefBased() {
		top = null;
	}

	//Checks if stack is empty
	public boolean StackIsEmpty() {
		return (top == null);
	}

	//pushes and object into the stack
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}

	//returns top item in the stack, throws error if empty
	public Object pop() throws EmptyStackException {
		if (top != null) {
			Object r = top.getItem();
			Node curr = top;
			top = top.getNext();
			curr = null;
			return r;
		}

		else {
			throw new EmptyStackException();
		}
	}

	//Returns objext on top of stack without popping it, throws error if stack is empty
	public Object peek()
		throws EmptyStackException {
		if (!StackIsEmpty()) {
			return top.getItem();
		} else {
			throw new EmptyStackException();
		}
	}

}
