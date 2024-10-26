//Demonstrating on the basis of Priority

package multiThreadingDemo;

class MSWord extends Thread
{
	@Override
	public void run()
	{
		String methodName = Thread.currentThread().getName();
		
		if(methodName.equals("TYPING"))
		{
			typing();
		}
		else if(methodName.equals("SPELLCHECK"))
		{
			spellcheck();
		}
		else
		{
			autoSave();
		}
	}
	
	private void typing() 
	{
		try
		{
			for(int i = 0; i < 4; i++)
			{
				System.out.println("Hi, my method's name is Typing.");
				Thread.sleep(3000);	
			}	
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		
	}
	
	private void spellcheck() 
	{
		try
		{
			for(;;)
			{
				System.out.println("Hi, my method's name is Spell Checking.....");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		
	}

	private void autoSave() 
	{
		try
		{
			for(;;)
			{
				System.out.println("Hi, my method's name is Auto saving.....");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.println(e);
		}
		
	}	
}

public class LunchMultiThreading10 
{

	public static void main(String[] args) 
	{
		MSWord ms1 = new MSWord();
		MSWord ms2 = new MSWord();
		MSWord ms3 = new MSWord();
		
		ms1.setName("TYPING");
		ms2.setName("SPELLCHECK");
		ms3.setName("AUTOSAVING");
		
		ms2.setDaemon(true);
		ms3.setDaemon(true);
		
		ms2.setPriority(3);
		ms3.setPriority(4);
		
		ms1.start();
		ms2.start();
		ms3.start();

	}

}
