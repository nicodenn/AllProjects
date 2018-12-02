/*Nico Dennis and Scott Spinali
 *Last Modified: October 1, 2018
 Takes in an input file of integers in ascending order, outputs a file of integers in ascending order to a different file without any duplicates.
*/
import java.io.*;
import java.util.Scanner;

public class testNumbers
{	
	public static void main(String args[]) 
	{

		try
		{

			Scanner s = new Scanner(System.in);
			boolean loop = true;
			//outer while loop is used to allow the method to repeat 
			while(loop)
			{
				//User input is taken for file input and output
				System.out.println("Please enter name of input file ");
				String inFile = s.nextLine();
				System.out.println("Please enter name of output file ");
				String outFile = s.nextLine();
				// reader for input file is initialized and writer for output file
				BufferedReader BR = new BufferedReader(new FileReader(inFile));
				PrintWriter PW = new PrintWriter(new FileOutputStream(outFile));		

				int nextNumber;
				String tempString;
				int currentNumber;
				//tests if there are remaining elements to be sorted
				if((tempString = BR.readLine()) != null)
				{
					currentNumber = Integer.parseInt(tempString);
					PW.println(currentNumber + " ");
					//loop to test for repeats, current number is compared to
					//the next number in the file
					while((tempString = BR.readLine()) != null)
					{
						if(currentNumber == Integer.parseInt(tempString))
						{
							continue;
						}

						else
						{
							nextNumber = Integer.parseInt(tempString);
							PW.println(nextNumber + " ");
							currentNumber = nextNumber;
						}
					}

				}
				//close stream for writer and reader
				BR.close();
				PW.close();
				//user input for re run of program
				System.out.println("Would you like to continue? (yes/no)");
				String answer = s.nextLine();

				if(answer.contains("n") ||answer.contains("N"))
				{
					loop = false;
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("e");
		}
	}
}
