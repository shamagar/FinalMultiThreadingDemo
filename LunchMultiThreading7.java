package multiThreadingDemo;

class Resource implements Runnable
{

	@Override
	public void run() 
	{
		try
		{
			for(int i = 65; i < 71; i++)
			{
				System.out.println((char)i);
				Thread.sleep(3000);
			}
			
			synchronized(this)
			{
				for(int i = 65; i < 71; i++)
				{
					System.out.println((char)i);
					Thread.sleep(3000);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

public class LunchMultiThreading7 
{

	public static void main(String[] args) 
	{
		Resource re = new Resource();
		
		Thread r1 = new Thread(re);
		Thread r2 = new Thread(re);
		
		r1.start();
		r2.start();

	}

}
