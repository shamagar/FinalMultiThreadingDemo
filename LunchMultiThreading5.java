package multiThreadingDemo;

import java.util.Scanner;

class Demo implements Runnable
{

	@Override
	public void run() 
	{
		String tName = Thread.currentThread().getName();
		if(tName.equals("BANK"))
		{
			banking();
		}
		else if(tName.equals("PRINT"))
		{
			PrintStar();
		}
		else
		{
			impMessage();
		}
		
	}
	
	public void banking()
	{
		System.out.println("Banking Application started.");
		
		Scanner sb = new Scanner(System.in);
		System.out.println("Enter the Accout number.");
		int acnum = sb.nextInt();
		System.out.println("Enter password.");
		int passCode = sb.nextInt();
		System.out.println("Collect the cash.");
		
		System.out.println("Banking Application Ended.");
	}
	
	public void PrintStar()
	{
		System.out.println("Print application started.");
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
		System.out.println("Print application Ended.");
	}
	
	public void impMessage()
	{
		System.out.println("Printing important message started.");
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
		System.out.println("Printing important message ended.");
	}
}

public class LunchMultiThreading5 
{

	public static void main(String[] args) 
	{
		System.out.println("Main thread started.");
		
		 Demo demo = new Demo();
		 
		 // CREATING THREADS
		 Thread t1 = new Thread(demo);
		 Thread t2 = new Thread(demo);
		 Thread t3 = new Thread(demo);
		 
		 t1.setName("BANK");
		 t2.setName("PRINT");
		 t3.setName("FOCUS");
		 
		 t1.start();
		 t2.start();
		 t3.start();
		
		System.out.println("Main thread ended.");

	}

}
