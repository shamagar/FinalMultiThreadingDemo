//Demonstration on using same resources by multiple threads
package multiThreadingDemo;

class SchoolLibrary implements Runnable
{
	String textBook1 = new String("JAVA");
	String textBook2 = new String("Python");
	String textBook3 = new String("C++");
	String textBook4 = new String("C#");
	
	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
		
		if(name.equals("STUDENT1"))
		{
			try
			{
				Thread.sleep(3000);
				
				synchronized(this)
				{
					System.out.println("Student 1 has acquired "+textBook1+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 1 has acquired "+textBook2+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 1 has acquired "+textBook3+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 1 has acquired "+textBook4+".");
					Thread.sleep(3000);
				}
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			
		}
		else
		{
			try
			{
				Thread.sleep(3000);
				
				synchronized(this)
				{
					System.out.println("Student 2 has acquired "+textBook1+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 2 has acquired "+textBook2+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 2 has acquired "+textBook3+".");
					Thread.sleep(3000);
				}
				
				synchronized(this)
				{
					System.out.println("Student 2 has acquired "+textBook4+".");
					Thread.sleep(3000);
				}
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		
	}
	
}


public class LunchMultiThreading9 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		SchoolLibrary library = new SchoolLibrary();
		
		Thread t1 = new Thread(library);
		Thread t2 = new Thread(library);
		
		t1.setName("STUDENT1");
		t2.setName("STUDENT2");
		
		t1.start();
		t2.start();

	}

}
