//Demonstration on using synchronization in block level
package multiThreadingDemo;

class  car implements Runnable
{

	@Override
	public void run() 
	{
		//System.out.println(Thread.currentThread().getName());//Print the current thread name
		//System.out.println(Thread.currentThread().getPriority());//Get the current thread's priority
		
		try
		{
			System.out.println(Thread.currentThread().getName()+ " has entered the parking lot.");
			Thread.sleep(3000);
			
			synchronized (this)
			{
				System.out.println(Thread.currentThread().getName()+" got into car to drive.");
				Thread.sleep(3000);
				
				System.out.println(Thread.currentThread().getName()+" started the driving.");
				Thread.sleep(3000);
				
				System.out.println(Thread.currentThread().getName()+" came back and parked the car.");
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
				
	}
}

public class LunchMultiThreading8 
{

	public static void main(String[] args) 
	{
		car c = new car();
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		
		t1.setName("Frizzel");
		t2.setName("Shamina");
		t3.setName("Shayan");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
