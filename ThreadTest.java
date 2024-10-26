package multiThreadingDemo;


class MyRunnabletest implements Runnable
{

	@Override
	public void run() 
	{
		System.out.println("Run method from implement class that is MyRunnabletest.");
		
	}
	
}


class MyThreadtest extends Thread
{
	
	public MyThreadtest(String name)
	{
		super(name);
		
		//setPriority(Thread.MAX_PRIORITY);
		//setPriority(Thread.MIN_PRIORITY + 2);
			
	}
	
	@Override
	public void run()
	{
		int count = 1;
		while(true)   //Infinite loop it never ends
		{
			System.out.println(count++);
			try
			{
				Thread.sleep(4000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTest 
{

	public static void main(String[] args)
	{
		/*
		MyRunnabletest test = new MyRunnabletest();
		Thread th = new Thread(test);
		*/
		//OR 
		//Using thread class constructor //Thread(implements class, String name)
		Thread rt = new Thread(new MyRunnabletest(), "My Thread 1");
		//rt.start();
		
		System.out.println("*****************");
		
		MyThreadtest th = new MyThreadtest("MyExtends class 1");
		th.start();
		
		//System.out.println("ID "+rt.getId());//Print the current thread ID provided by JVM
        System.out.println("Name "+rt.getName());//Print name of the thread
        System.out.println("Priority "+rt.getPriority());//Print priority of the thread
        rt.start();
        System.out.println("State "+rt.getState());//Print the state 
        System.out.println("Alive "+rt.isAlive());//
        //rt.start();
	}

}
