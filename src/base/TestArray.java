package base;

public class TestArray {
	//public static void main(String args[])
	public static void main(String[] args)//������ע�͵�һ��ͬ����Ч
	{
		//String arrayTest[];
		String arrayTest[];//������ע�͵�һ��ͬ����Ч
		
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
