package automateOfficeWork;

public class PrimeNumber {

	public static void main(String[] args) {

	int num=12;
	boolean bool=false;
	
	for(int i=2;i<num/2;i++)
	{
		if(num%i==0)
		{
			bool=true;
			break;
		}
	}
	if(!bool)
		System.out.println("Prime");
	else
		System.out.println("Non prime");
	}

}
