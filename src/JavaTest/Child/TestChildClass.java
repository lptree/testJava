package JavaTest.Child;

class Animal{
   public void move(){
      System.out.println("��������ƶ�");
   }
}
 
class Dog extends Animal{
   public void move(){
      super.move(); // Ӧ��super��ķ���
      System.out.println("�������ܺ���");
   }
}
 
public class TestChildClass{
   public static void main(String args[]){
 
      Animal b = new Dog(); // Dog ����
      b.move(); //ִ�� Dog��ķ���
 
   }
}
