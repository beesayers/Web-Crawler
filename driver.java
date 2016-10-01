import java.io.IOException;
import java.util.Scanner;

public class driver {
	public static void main(String[] args) throws IOException
	{
		Scanner inputscanner = new Scanner(System.in);
		boolean done = false;
		String inputstring;
		int inputlimit;
		
		while (!done)												// Loop for user input
		{
			boolean isinputvalid = false;
			Crawler crawl = new Crawler();
			System.out.println("Please enter the number of webpages you would like to limit the webcrawler to:");
			inputlimit = inputscanner.nextInt();
			
			while (!isinputvalid)
			{
				System.out.println("How would you like to crawl the web?\nIf you would like to crawl using a queue, enter \"q\"\nIf you would like to crawl using a stack, enter \"s\"");
				inputstring = inputscanner.next();
				
				if (inputstring.toLowerCase().equals("q"))
				{
					crawl.goQ("http://www.cse.uaa.alaska.edu/~mcenek/csce311/", inputlimit);
					isinputvalid = true;
				}

				else if (inputstring.toLowerCase().equals("s"))
				{
					crawl.goS("http://www.cse.uaa.alaska.edu/~mcenek/csce311/", inputlimit);
					isinputvalid = true;
				}
				
				else 
				{
					isinputvalid = false;
				}
			}
			System.out.println("Would you like to continue?\nPlease enter yes or no");
			inputstring = inputscanner.next();
			
			if (inputstring.toLowerCase().equals("no"))
			{
				done = true;
			}
		}
	}
}
