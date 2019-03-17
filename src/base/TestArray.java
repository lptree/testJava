package base;

public class TestArray {
	//public static void main(String args[])
	public static void main(String[] args)//和上面注释的一行同样有效
	{
		//String arrayTest[];
		String arrayTest[];//和上面注释的一行同样有效
		
		arrayTest= new  String[2];
		arrayTest[0] = "Test";
		arrayTest[1] = " array!";
		
		System.out.println(arrayTest[0]+arrayTest[1]);
		
		
		String arr[] = { "aa", "bb", "cc", "dd" };
	    for (String x : arr) {
	        System.out.println(x);
	    }
	}
	
}
