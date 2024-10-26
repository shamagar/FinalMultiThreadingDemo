//Demonstration on Producer and Consumer 
package multiThreadingDemo;

//Shared object or Resources between Producer and Consumer
class Queue
{
	int value;
	boolean flag = false;
	
	synchronized public void produce(int value)
	{
		try
		{
			
			if(flag == true)
			{
				System.out.println("Production is in waiting state.");
				wait();
			}
			else
			{
				this.value = value;
				System.out.println("Produce method produce a value: "+value);
				flag = true;
				notify();
					
			}
			
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
	}
	
	synchronized public void consume()
	{
		try
		{
			if(flag == false)
			{
				System.out.println("Comsumer is in waiting state.");
				wait();
			}
			else
			{
				System.out.println("Consumer consume the value: "+value);
				flag = false;
				notify();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}

class Producer1 extends Thread
{
	Queue queue;
	int value = 0;
	
	public Producer1(Queue queue)
	{
		this.queue = queue;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			queue.produce(value++);
		}
	}
}

class Consumer1 extends Thread
{
	Queue queue;

	public Consumer1(Queue queue) 
	{
		super();
		this.queue = queue;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			queue.consume();
		}
	}	
}

public class LunchMeltithreading11 
{

	public static void main(String[] args) 
	{
		Queue q = new Queue();
		
		Producer1 p = new Producer1(q);
		Consumer1 c = new Consumer1(q);
		
		p.start();
		c.start();

	}

}
