//Demonstrating about MultiThreading concept
package multiThreadingDemo;

public class LunchMultiThreading1 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("Application Started.");
		
		//Thread.sleep(5000);
		//Thread thread = new Thread();
		
		Thread thread = Thread.currentThread();
		//System.out.println(thread);
		System.out.println(thread.getName());//Display the Default name of the thread
		System.out.println(thread.getPriority());//Returns the thread Priority 
		
		System.out.println("****************");
		
		thread.setName("Khapangi");//Thread name change
		thread.setPriority(3);

		System.out.println(thread.getName());//Display the name of the current thread
		System.out.println(thread.getPriority());//Returns the thread Priority 
		System.out.println(thread.getClass());
		//System.out.println(thread.getId());
		
		System.out.println("Appplication Ended.");

	}

}
