package base;

import java.util.ArrayList;
import java.util.List;

public class TestLambdaVar {
	final static String salutation = "Hello! ";

	public static void main(String args[]) {
		
		//GreetingService greetService1 = message -> System.out.println(salutation + message);
		
		/*
		String exter= "sssss";
		GreetingService greetService1 = message -> System.out.println(exter + message);
		*/
		
//		String exter= "sssss";
//		GreetingService greetService1 = message -> exter = message;//final ����ᱨ��
		
		List<String> exterList=  new ArrayList<String>();
		GreetingService greetService1 = message -> exterList.add(message);//����ᱨ��
		
		greetService1.sayMessage("Runoob");
		greetService1.sayMessage("Robin");
	}

	interface GreetingService {
		void sayMessage(String message);
	}
}
