//Demonstration
package multiThreadingDemo;

import java.util.Scanner;

class Alpha
{
	public void Banking()
	{
		System.out.println("Banking Activity Started...");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account number.");
		int ac = sc.nextInt();
		System.out.println("Enter the password.");
		int pw = sc.nextInt();
		System.out.println("Collect the Cash.");
		System.out.println("Banking Activity Ended.");
		
	}	
}

class Beta
{
	public void printstar() throws InterruptedException
	{
		System.out.println("Printing Activity Started.");
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println("*");
			Thread.sleep(3000);
		}
		
		System.out.println("Printing Activity Ended.");
	}
}
 class Gamma
 {
	 public void message() throws InterruptedException
	 {
		 System.out.println("Displaying important message started.");
		 
		 for(int i = 0; i < 4; i++)
		 {
			 System.out.println("Focus is the key to success.");
			 Thread.sleep(3000);
		 }
		 
		 System.out.println("Displaying important message ended");
	 }
 }

public class LunchMultiThreading2
{

	public static void main(String[] args) throws InterruptedException 
	{
		Alpha a = new Alpha();
		Beta b = new Beta();
		Gamma g = new Gamma();
		
		a.Banking();
		b.printstar();
		g.message();

	}

}
