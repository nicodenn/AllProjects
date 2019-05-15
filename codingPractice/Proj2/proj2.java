import java.util.Scanner;
public class proj2
{
    public static void main(String[] args)
    {
        LList homework = new LList();
        Node head;
        boolean check = true;
        Scanner s = new Scanner(System.in);
        Scanner j = new Scanner(System.in);
        while(check == true)
        {
                System.out.println("To add new assignment press \"a\"");
                System.out.println("To remove an assignment press \"r\"");
                System.out.println("To list assignments by order of due dates press \"l\"");
                System.out.println("To find assignment(s) with the earliest due dates press \"f\"");
                System.out.println("To quit program press \"q\"");
                //Scanner s = new Scanner(System.in);
                char compare = s.next().charAt(0);

                switch(compare)
                {	case 'a':
                        {
                                System.out.println("Please enter the due date for assignment (Between 1 and 31).");
                                int z = 1;
                                int date=s.nextInt();

                                if(date>=1 && date<=31)
                                {
                                        System.out.println("Please enter assignment description on the next line.");
                                }

                                else
                                {
                                        System.out.println("Please try again. Enter a date between 1 and 31.");
                                        continue;
                                }

                                String line = j.nextLine();
                                homework.AddAssignment(date,line);
                                break;
                        }

                        case 'r':
                        {
                                System.out.println("Please enter the position of the item that you wish to delete.");
                                int k = s.nextInt();
                                System.out.println("we have k" + k);
                                homework.RemoveAssignment(k);
                                break;
                        }

                        case 'l':
                        {
                                if(homework.ListLength() != 0)
                                {
                                        homework.DisplayAll();
                                        break;
                                }

                                else
                                {
                                        System.out.println("No assignments exist.");
                                        break;
                                }
                        }
                        case 'f':
                        {
                                if(homework.ListLength() != 0)
                                {
                                        homework.FirstDue();
                                        break;
                                }

                                else
                                {
                                        System.out.println("No assignments exist.");
                                        break;
                                }
                        }

                        case 'q':
                        {
                                check = false;
                                break;
                        }

                        default:
                        {
                                System.out.println ("Operation not found.");
                                break;
                        }
                }


        }

    }
}