package multiThreadingDemo;

//Shared Data OR Object
class MyData
{
	//synchronized public void display(String str) //Method Level synchronization
	public void display(String str)  
	{
		synchronized(this)//Block Level Synchronization
		{
			
		for(int i = 0; i < str.length(); i++)
		{
			System.out.print(str.charAt(i));
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			
		}
		System.out.print(" ");
		
		}
	}
}


class MyThreadA extends Thread
{
	MyData d;
	public MyThreadA(MyData d)
	{
		this.d = d;
	}
	
	public void run()
	{
		d.display("Hello World");
		
	}
}

class MyThreadB extends Thread
{
	MyData d;
	public MyThreadB(MyData d)
	{
		this.d = d;
	}
	
	public void run()
	{
		d.display("Well Come All");
		
	}
}


public class SynchronizedDemo 
{

	public static void main(String[] args) 
	{
		MyData data = new MyData();
		
		MyThreadA t1 = new MyThreadA(data);
		MyThreadB t2 = new MyThreadB(data);
		
		t1.start();
		t2.start();

	}

}
