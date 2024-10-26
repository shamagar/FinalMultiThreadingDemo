package multiThreadingDemo;

class SharedData
{
	int value;
	boolean flag=true;
	
	synchronized public void set(int value)
	{
		while(flag != true)
			try
			{
				wait();
			} 
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			this.value = value;
			flag = false;
			notify();
		
	}
	
	synchronized public int get()
	{
		int x = 0;
        while(flag != false)
        	try
			{
        		wait();
			} 
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
        
        x = value;
        flag = true;
        notify();
        
		return x;
	}
}

class Producer extends Thread
{
	SharedData da;
	
	public Producer(SharedData data)
	{
		this.da = data;
	}
	
	public void run()
	{
		int count = 1;
		
		while(true)
		{
			da.set(count);
			System.out.println("Producer "+count);
			count++;
		}
	}

}

class Consumer extends Thread
{
	SharedData da;
	
	public Consumer(SharedData data)
	{
		this.da = data;
	}
	
	public void run()
	{
		int value;
		
		while(true)
		{
			value = da.get();
			System.out.println("Consumer "+value);
		}
	}

}

public class InterThreadDemo 
{

	public static void main(String[] args) 
	{
		SharedData dta = new SharedData();
		
		Producer p = new Producer(dta);
		Consumer c = new Consumer(dta);
		
		p.start();
		c.start();

	}

}
