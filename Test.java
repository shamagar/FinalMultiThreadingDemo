//Demonstration on MultiThreading
package multiThreadingDemo;

class MyThread extends Thread
{
	@Override
	public void run()
	{
		int i = 1;
		while(true)
		{
			System.out.println(i+" Hello");
			i++;
		}
	}
}

class MyRunnable implements Runnable 
{

	@Override
	public void run() 
	{
		int i = 1;
		while(true)
		{
			System.out.println(i+" Hello");
			i++;
		}
		
	}
	
}
//OR we can able to create thread in main application class

public class Test
{

	public static void main(String[] args) 
	{
		//TEst my = new TEst(); //For Main application class
		
		//Thread creation from Thread class
		MyThread my = new MyThread();
		my.start();
		
		//For Runnable interface we should create thread
		MyRunnable myrn = new MyRunnable();
		Thread rn = new Thread(myrn);
		rn.start();
		 
		 int i = 1;
			while(true)
			{
				System.out.println(i+" World");
				i++;
			}
	}

}
