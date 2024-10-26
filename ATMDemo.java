package multiThreadingDemo;

class ATM 
{
	int Amount;
	synchronized public void CheckBalance(String name, int amount)
	{
		Amount = amount + 5000;
		System.out.print(name + ", Your current balance is $ "+ Amount);
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println(", Good Luck!!!!");
		
	}
	
	synchronized public void WithDraw(String name, int amount)
	{
		int RemainingAmount = Amount - amount;
		System.out.print(name + ", You have withdraw $ "+ amount);
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println(" Here is your withdrawal amount. Thank you");
		System.out.println("Ramaining Balance is "+RemainingAmount);
		
	}
	
	synchronized public void Deposite(String name, int amount)
	{
		System.out.print(name + ", You have deposited $ "+ amount);
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println(" Now your total balance is "+amount);
		
	}
	
}

class Customer extends Thread
{
	ATM atm;
	String name;
	int amount;
	
	public Customer(String name, int amount, ATM atm)
	{
		this.atm = atm;
		this.name = name;
		this.amount = amount;
	}
	
	public void UseATM()
	{
		atm.CheckBalance(name, amount);
		atm.Deposite(name,amount);
		atm.WithDraw(name, amount);
	}
	
	public void run()
	{
		UseATM();
	}
}

public class ATMDemo 
{

	public static void main(String[] args) 
	{
		ATM atm = new ATM();
		Customer c1 = new Customer("Meena",400,atm);
		Customer c2 = new Customer("Frizzel",200,atm);
		Customer c3 = new Customer("Shayan",55,atm);
		
		c1.start();
		c2.start();
		c3.start();
	}

}
