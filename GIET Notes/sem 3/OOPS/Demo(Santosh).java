class Minimumbalance extends RuntimeException
{
	public Minimumbalance(String str)
	{
		System.out.println(str);
	}
}
public class Demo
{
	int accno,balance;
	void input(int a,int b)
	{
		accno=a;
		if(b<3000)
		{
			throw new Minimumbalance("Balance is below AMB");
		}
		else
		{
			balance=b;
		}
	}
	void print()
	{
		System.out.println("The account no"+accno);
		System.out.println("The balance"+balance);
	}
	public static void main(String args[])
	{
		Demo b1=new Demo();
		b1.input(1010,25000);
		b1.print();
	}
}