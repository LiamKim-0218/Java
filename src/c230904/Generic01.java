package c230904;




//제네릭 메서드는 호출되는 시점에 실제 제네릭 타입을 지정한다
//1. 제네릭 타입변수명이 1개일때
//접근 지정자 <T> T 메서드 이름(T t)
//2. 두개일 경우
//접근 지정자 <T, V> T 메서드 이름(T t, V v)

//3.매개변수에만 제네릭이 사용된 경우
// 접근 지정자<T> void 메서드 이름(T t){}

//4.리턴타입에만 사용된 경우!
//접근 지정자 <T> T 메서드 이름(int a){}


class GenericMethod{
   public <T> T method(T t) {
      return t;
   }
   public <T> boolean method2(T t1, T t2) {
      return t1.equals(t2);
   }
   public <K, V> void method3(K k, V v) {
      System.out.println(k+ " : "+ v);
   }
}

class A{
   public <T> void method(T t) {
      System.out.println(t.equals("안녕"));
//      System.out.println(t.length()); //불가능 . length는 String 내장메서드여서 안됌. 정의 시점에 어떤타입인지 모름
                              //object class가 최상위에 있음.
   }
}


public class Generic01 {
   
   
   public static <T> void Swap(T[] array,int index1, int index2) {
      T temp = array[index1];
      array[index1] = temp;
   }
   
   public static void main(String[] args) {
      GenericMethod gm = new GenericMethod();
      
      String str1 = gm.<String>method("안녕");
      
      //제네릭 타입 자체를 유추할 수 있다면<String>을 빼도 됌
      String str2 = gm.method("안녕2");
      
      
      System.out.println(str1);
      System.out.println(str2);
      
      boolean b1 = gm.method2(2.5, 2.5);
      System.out.println(b1);
      
      gm.<String, Integer> method3("국어",10);
      gm.method3("수학",20);
      
      
      
   
   }

}