package base;

public class TestSuperAndThis {
	public static void main(String args[]) 
	{
		Dog littleDog= new Dog();
		littleDog.eatTest();
	}
}

class Animal {
	void eat() {
		System.out.println("animal eat");
	}
}

class Dog extends Animal {
	void eat() {
		System.out.println("dog eat");
	}

	void eatTest() {
		this.eat(); // "dog eat"
		super.eat(); // "animal eat"
	}
}
