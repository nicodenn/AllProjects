import java.util.Scanner;
import java.util.*;

public class proj3
{
    public static void main(String[] args)
    {
        System.out.println("welcome to my simple calculator");
        //method tests
        System.out.println(isOperator('j'));
        System.out.println(IsOperand('h'));
        System.out.println(infixToPostfix("(4+3)*2-4/2"));

    }
    
    public static String infixToPostfix(String input)
    {
    StackRefBased stack = new StackRefBased();
    Scanner j = new Scanner(System.in);
    String postfixEx = "";
    String S = j.nextLine();
    char[] infixEx = S.toCharArray();
        for(int i=0; i < input.length(); i++)
        {
            if(IsOperand(infixEx[i]));
            {
                System.out.println("is an operand");
                //postfixEx.toString(charAt(i));
            }
            if(isOperator(infixEx[i]))
            {
                while(!stack.stackIsEmpty() && (char)stack.top.getItem() != '(' && Precedence((char)stack.top.getItem(),infixEx[i]))
                {
                    postfixEx += (char)stack.top.getItem();
                    stack.pop();
                }
                stack.push(infixEx[i]);
            }
            if(infixEx[i] == '(')
            {
                System.out.println("is an (");
                stack.push(infixEx[i]);
            }
            else if(infixEx[i] == ')')
            {
                System.out.println("is an )");
                while(!stack.stackIsEmpty() && (char)stack.top.getItem() !=  '(') {
                    postfixEx += (char)stack.top.getItem();
                    stack.pop();
                }
                stack.pop();
            }

        }
        while(!stack.stackIsEmpty()) {
            postfixEx += stack.top;
            stack.pop();
        }
        return postfixEx;
    }
    public static boolean IsOperand(char C) 
    {
        if(C >= '0' && C <= '9') return true;
        
        return false;
    }
    public static boolean isOperator(char C)
    {
        switch(C){
            case '+':
                    return true;
            case '-':
                    return true;
            case '/':
                    return true;
            case '*':
                    return true;
            default:
                    return false;
    }

    }

    public static int getOpWeight(char op)
    {
            int weight = -1; 
            switch(op)
            {
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
            }
            return weight;
    }
    public static boolean Precedence(char op1, char op2)
    {
        
        int op1weight = getOpWeight(op1);
        int op2weight = getOpWeight(op2);
        if(op1weight > op2weight) return false;
        return true;

        
    }



}