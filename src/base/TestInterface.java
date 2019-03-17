package base;

public class TestInterface
{
	public static void main(String[] args)
	{
		ImpInterfaceOne one = new ImpInterfaceOne();
		String thisName = ImpInterfaceOne.Name;
		String oneStr = one.getOneString();
	}
}

class BaseClassOne
{
	public String Name;
}

interface BaseInterfaceOne
{
	public static final String Name = "BaseInterfaceOne";
}

 interface InterfaceOne extends BaseInterfaceOne {
	public abstract String getOneString();
}
 
 class ImpInterfaceTwo implements InterfaceOne
 {
	 @Override
	 public String getOneString()
	 {
		 String name = Name;
		 return "this is a string";
	 }
 }
 
 class ImpInterfaceOne implements InterfaceOne
 {
	 @Override
	 public String getOneString()
	 {
		 String name = this.Name;
		 return "this is a string";
	 }
 }
 
 
