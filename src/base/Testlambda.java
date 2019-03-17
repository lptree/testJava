package base;

import java.io.IOException;

public class Testlambda {
	public static void main(String[] args) {
		// Java 8֮ǰ��
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();

		// Java 8��ʽ��
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
			
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
