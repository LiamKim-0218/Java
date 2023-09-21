package c230905;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collection {
   
   public static void main(String[] args) {
      
//      컬렉션
//      동일한 데이터 타입을 묶어 관리하는 자료구조
//      데이터 저장 공간의 크기가 동적으로 변한다.
      
//      1.List
//      배열과 비슷하게 생겼지만, 가장 큰 차이점은 저장공간의 크기가 고정적이냐 동적으로 변하냐의 차이!
//      리스트 자체는 java에서 인터페이스로 구현되어있다.
//      ArrayList, Vector, LinkedList등과 같은 클래스가 List인터페이스를 구현한다.
      
      
//      1.1 ArrayList
//      List인터페이스를 구현한 클래스 중 하나.
//      동적배열로 구현되어 크기를 동적으로 조절가능
//      요소에 빠르게 접근가능, 추가하거나 제거할때 자동으로 크기를 조절한다.
//
//      List는 인터페이스로써 리스트 동작을 정의.
      
//      알아야 할 것 : ArrayList랑 Array 차이
      
      String[] arrStrings = new String[] {"가","나","다","라","마"};
      
      arrStrings[1]=null;
      arrStrings[2]=null;
      for(int i = 0; i < arrStrings.length; i++) {
         System.out.println(arrStrings[i]);
      }
      
      List<String> arrList = new ArrayList<>();
      
      System.out.println(arrList.size());
      
      arrList.add("가");
      arrList.add("나");
      arrList.add("다");
      arrList.add("라");
      arrList.add("마");
      arrList.add("바");
      arrList.add("사");
      arrList.add("아");
      
      System.out.println("데이터 추가후 : " +arrList.size());
      
      for(String string : arrList) {
         System.out.println(string);
      }
      arrList.remove("바");
      arrList.remove("다");
      
      System.out.println("===============================");
      
      for(String string : arrList) {
         System.out.println(string);
      }
      System.out.println("데이터 삭제후 : "+arrList.size());
      
      
      arrList.add("KIM");
      for(String string : arrList) {
         System.out.println(string);
      }
      
      int index = 2;
      
      String element = arrList.get(index);
      System.out.println("인덱스 : "+index+"요소 :"+element);
      
      String target = "KiM";
      boolean contains = arrList.contains(target);
      
      if(contains) {
         System.out.println(target+"을 찾았다");
      }
      else {
         System.out.println("없음");
      }
      
//      add : 요소추가->그냥 추가하면 뒤로 추가되고, 오버로딩되어있어서 인덱스로 추가할수도있다 
//      remove : 요소 삭제,오버로딩되어있어서 인덱스로 삭제할수도있다
//      clear : 모든 데이터 삭제
//      
//      get : 인덱스의 데이터를 리턴
//      indexOf : 첫번째 위치 리턴
//      lastIndexOf : 마지막 위치 리턴
//      contains : 있냐 없냐? 확인
//      
//      size : 길이 확인
//      isEmpty : 비어있냐 없냐?
//      trimToSize : 안쓰는 데이터 죽이기, 잘 쓴다면 최적화를 시킬수 있지않을까? 
//      
//      sort : 정렬
//      reverse : 반전
      
      List<String> myList = new ArrayList<>(); 
      //타입만 보자면 인터페이스 타입, List 인터페이스가 정의한 메서드만 사용가능
      
      List<String> myList2 = new LinkedList<>(); 
      //나중에 데이터를 바꿀 일이 있다면 이런식으로 바꾸면됨
      
      
      ArrayList<String>MyList1=new ArrayList<>();
      
//      사실 위에 두 코드는 똑같은데, 대략적인 차이점은 유연성이 살짝 다름
//      일반적으로 가능한 한 인터페이스를 사용해서 변수를 쓰는게 권장됨
//      정리를하자면 인터페이스를 사용한 List는 유연성이 있음
      
      
      
      
      
      
      
      
   }
}