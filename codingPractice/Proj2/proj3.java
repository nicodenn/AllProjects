import java.util.Scanner;

public class proj3
{
    public static void main(String[] args)
    {
    StackRefBased stack = new StackRefBased();
    boolean check = true;
    Scanner j = new Scanner(system.in);
    String output;
    String finalOutput;
    while(check == true)
    {
    System.print.ln("please enter an Infix expression");
    String input = j.nextLine();
    int n = 0;

        while(j.nextLine() != null)
        {
            if(isDigit(input.charAt(n)))
            {
                output = output + input.charAt(n);
                n++;
            }
            else if(isLetter(input.charAt(n)))
            {
                output = output + input.charAt(n);
                n++;
            }
            else if(input.charAt(n) == "(")
            {
                stack.push(input.charAt(n));
                n++;
            }
            else if(input.charAt(n) == ")")
            {
                while(top != "(")
                {
                    output = output + stack.pop();
                }
            stack.pop();
            n++;
            }
            /*else if(char == operator)
                while(!stack.stackIsEmpty() && top != "(" && stack.precede(char) <= stack.precede(top of stack)
                    {
                        output = output + stack.pop();
                    }
                stack.push(char);
                while(!stack.stackIsEmpty())
                    {
                        output = ouput + stack.pop();
                    }
            */

        }
    while(output)
    Systme.out.println("Would you like to evaluate another expression? (Y/N)");
    String exit = j.nextLine();
    if(exit.contains("n"))
        {
            check = false;
        }

    }   

    }
}