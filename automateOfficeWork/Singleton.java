package automateOfficeWork;

public class Singleton 
{

int a;
private static Singleton obj=null;

private Singleton()
{
	System.out.println("constructor");
	a=10;
}

public static Singleton getvalue() {
	if(obj==null)
	{
    obj = new Singleton();
	}
	return obj;

}


	
	
}
