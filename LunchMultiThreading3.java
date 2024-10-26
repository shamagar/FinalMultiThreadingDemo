//Demonstration
package multiThreadingDemo;

import java.util.Scanner;

class Alpha1 extends Thread
{
	@Override
	public void run()
	{
		Banking();
	}
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

class Beta1 extends Thread
{
	@Override
	public void run()
	{
		printstar();
	}
	
	public void printstar() 
	{
		System.out.println("Printing Activity Started.");
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println("*");
			
			try
			{
				Thread.sleep(3000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Printing Activity Ended.");
	}
}

 class Gamma1 extends Thread
 {
	 @Override
	 public void run() 
	 {
		 message();
	 }
	 
	 public void message() 
	 {
		 System.out.println("Displaying important message started.");
		 
		 for(int i = 0; i < 4; i++)
		 {
			 System.out.println("Focus is the key to success.");
			 try
			 {
				 Thread.sleep(3000);
			 }
			 catch(InterruptedException e)
			 {
				 e.printStackTrace();
			 }
			 
		 }
		 
		 System.out.println("Displaying important message ended");
	 }
 }

public class LunchMultiThreading3
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("Main Thread started the execution.");
		
		Alpha1 thread1 = new Alpha1();
		Beta1 thread2 = new Beta1();
		Gamma1 thread3 = new Gamma1();
		
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		thread3.start();
		
		//Join Method 
		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println("Main thread finished the execution.");
	}

}
