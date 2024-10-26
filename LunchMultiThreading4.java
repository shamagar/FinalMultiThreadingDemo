//Demonstration
package multiThreadingDemo;

import java.util.Scanner;

class Alpha2 implements Runnable
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

class Beta2 implements Runnable
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

 class Gamma2 implements Runnable
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

public class LunchMultiThreading4
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("Main Thread started the execution.");
		
		Alpha2 alpha = new Alpha2();
		Beta2 beta = new Beta2();
		Gamma2 gama = new Gamma2();
		
		Thread thread1 = new Thread(alpha);
		Thread thread2 = new Thread(beta);
		Thread thread3 = new Thread(gama);
		
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
		System.out.println(thread3.isAlive());
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println(thread1.isAlive());
		System.out.println(thread2.isAlive());
		System.out.println(thread3.isAlive());
		
		System.out.println("Main thread finished the execution.");
	}

}
