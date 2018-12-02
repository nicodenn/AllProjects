/*Nico Dennis and Scott Spinali
 *November 12, 2018
 Uses reference based stack to first compute the postfix of a scanned in infix expression. Proceeds to second method where the postfix expression is solved and returns an integer value.
 */

import java.util.Scanner;

public class proj3 {
	String input;

	// Main method, scans in infix expressions and then puts into two methods to produce integer solution
	public static void main(String[] args) {
		int t = 1;
		Scanner s = new Scanner(System.in);
		while (t == 1) {
			System.out.println("Welcome to my simple calculator!\nPlease enter an infix expression: ");
			String input = s.nextLine();
			String postfix = infixConversion(input);
			int x = solvePostfix(postfix);
			System.out.println("Evaluated expression: " + x);
			System.out.println("Would you like to run the program again? (y/n)");
			String option = s.nextLine();
			if (option.equals("n")) {
				t = -1;
			}
		}
	}

	//Uses a stack to convert infix to a postfix expression
	static String infixConversion(String infix) {
		StackRefBased stack = new StackRefBased();
		String postfix = "";
		String r = "";
		int i;
		for (i = 0; i < infix.length(); i++) 
		{
			char x = infix.charAt(i);
			if (Character.isDigit(x)) {
				r = r + x;
			} else if (!r.equals("")) {
				postfix += r + " ";
				r = "";
			}

			if (x == '(') {
				stack.push(x);
			}

			else if (x == ')') {
				while ((char) stack.peek() != '(') {
					postfix = postfix + stack.pop() + " ";
				}
				stack.pop();
			}

			else if (x == '+' || x == '-' || x == '*' || x == '/') {
				while (!stack.StackIsEmpty() && (char) stack.peek() != '('
						&& precedence(x) <= precedence((char)stack.peek())) {
					postfix = postfix + stack.pop() + " ";
				}
				stack.push(x);
			}
		}
		if (!r.equals("")) postfix += r + " ";
		while (!stack.StackIsEmpty()) {
			postfix = postfix + stack.pop() + " ";
		}
		return postfix.trim();
	}

	//Finds the precedence of varying operations
	static int precedence(char x) {
		if (x == '+' || x == '-') {
			return 1;
		}
		if (x == '*' || x == '/') {
			return 2;
		} 
		else {
			return 1;
		}
	}

	//Computes the integer  answer to the inputed postfix string
	public static int solvePostfix(String post) {
		StackRefBased stack = new StackRefBased();
		int i = 0;
		String[] d = post.split(" ");
		for (i = 0; i < d.length; i++) {
			if (Character.isDigit(d[i].charAt(0))) {
				int t = Integer.parseInt(d[i]);
				stack.push(t);
			}

			else {
				if (d[i].equals("+")) {
					int num2 = (int) stack.pop();
					int num1 = (int) stack.pop();
					int result = num1 + num2;
					stack.push(result);
				}

				if (d[i].equals("-")) {
					int num2 = (int) stack.pop();
					int num1 = (int) stack.pop();
					int result = num1 - num2;
					stack.push(result);
				}

				if (d[i].equals("*")) {
					int num2 = (int) stack.pop();
					int num1 = (int) stack.pop();
					int result = num1 * num2;
					stack.push(result);
				}

				if (d[i].equals("/")) {
					int num2 = (int) stack.pop();
					int num1 = (int) stack.pop();
					int result = num1 / num2;
					stack.push(result);
				}
			}
		}
		int output = (int) stack.pop();
		return output;
	}
}
