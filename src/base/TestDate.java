package base;
import java.util.*;
import java.text.*;
 

public class TestDate {
	public static void main(String args[]) {
		 
	      Date now = new Date();   
	      	      
	      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	      String dateStr = ft.format(now);
	      
	      System.out.println(now.toString());
	      System.out.println(ft.format(now));
	      
	      
	      Calendar c = Calendar.getInstance();//Ĭ���ǵ�ǰ���ڡ�����һ��Ĭ���õ�ǰ�����Ի�����ʱ����ʼ����GregorianCalendar����
	   }
}
