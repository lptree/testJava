package base;

import java.util.*;

public class TestGenerics {

	public static <T extends Animal> void printArray(T[] inputArray) {
		// 输出数组元素
		for (T element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		List<String> name = new ArrayList<String>();
		List<Integer> age = new ArrayList<Integer>();
		List<Number> number = new ArrayList<Number>();

		name.add("icon");
		age.add(18);
		number.add(314);

		getData(name);
		getData(age);
		getData(number);
		
		getData2(name);
		getData2(age);
		getData2(number);
	}

	public static void getData(List<?> data) {
		System.out.println("data :" + data.get(0));
	}
	
	public static<E> void getData2(List<E> data) {
		System.out.println("data :" + data.get(0));
	}
}
