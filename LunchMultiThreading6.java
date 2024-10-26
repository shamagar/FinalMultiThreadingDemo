//Demonstration on using synchronization on method level
package multiThreadingDemo;

class Bathroom implements Runnable
{

	@Override
	synchronized public void run() 
	{
		try
		{
			System.out.println(Thread.currentThread().getName()+" has entered the bathroom.");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" has entered the bathroom.");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" has entered the bathroom.");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
}

public class LunchMultiThreading6 
{

	public static void main(String[] args) 
	{
		Bathroom bt = new Bathroom();
		
		Thread t1 = new Thread(bt);
		Thread t2 = new Thread(bt);
		Thread t3 = new Thread(bt);
		
		System.out.println(t1.isAlive());//False
		System.out.println(t2.isAlive());//False
		System.out.println(t3.isAlive());//False
		
		t1.setName("BOYS");
		t2.setName("GIRL");
		t3.setName("TIKTOKER");
		
		System.out.println("*************************");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(t1.isAlive());//True
		System.out.println(t2.isAlive());//True
		System.out.println(t3.isAlive());//True

	}

}
