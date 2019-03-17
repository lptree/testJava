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
	      
	      
	      Calendar c = Calendar.getInstance();//默认是当前日期。返回一个默认用当前的语言环境和时区初始化的GregorianCalendar对象
	   }
}
