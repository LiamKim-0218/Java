package c230904;


class Apple{}
//class Goods1{
//   private Apple apple = new Apple();
//   
//   public Apple GetApple() {
//      return apple;
//   }
//   public void SetApple(Apple apple) {
//      this.apple = apple;
//   }
//}

//위 코드를 봤을때 새로운 상품이 추가 될때마다 새롭게 클래스를 만들어야 되냐?
//귀찮잖아....
//첫번째 해결 방법은 최상위 클래스인 Object타입으로 선언하는것.
//Object 객체를 저장하고 관리하는 클래스를 생성하면 과일이든, 학용품이든 저장하거나 읽어들일 수 있음

class Goods3{
   private Object object = new Object();
   public Object Get() {
      return object;
   }
   public void Set(Object object) {
      this.object = object;
   }
}


class Pencil{}
//class Goods2{
//   private Pencil pencil = new Pencil();
//   public Pencil GetPencil() {
//      return pencil;
//   }
//   public void SetApple(Pencil pencil) {
//      this.pencil = pencil;
//   }
//}

// 모든타입에 데이터를 저장할 수 있고 잘못된 캐스팅을 했을때 사전에 오류를 차단할 수 있다.
//
// 제네릭 클래스와 제네릭 인터페이스
//제네릭 클래스

/*
 접근 지정자 - class - 클래스명<T>{
 
 }
 접근 지정자 - class - 클래스명<K,T>{
 
 }
 접근 지정자 - interface - 클래스명<T>{
 
 } 
 접근 지정자 - interface - 클래스명<K,T>{
 
 }   
 */
//제네릭 클래스의 객체생성
//객체생성 과정은 일반 클래스의 객체 생성과 비슷
//단, 클래스명 다음에<실제 제네릭 타입>을 삽입한다.
//즉 객체를 생ㅅ어할때 제네릭 타입 변수에 실제 타입을 대입한다.
//
//클래스명<실제 제네릭타입> 참조변수 명 = new 클래스명<실제 제네릭 타입>();
//클래스명<실제 제네릭타입> 참조변수 명 = new 클래스명<>();

//함 만들어봄?
class MyClass<T>{
   
   private T t;
   public T Get() {
      return t;
   }
   public void Set(T t) {
      this.t = t;
   }
}

class KeyValue<K,V>{
   private K key;
   private V value;
   
   public K getKey() {
      return key;
   }
   public void SetKey(K key) {
      this.key = key;
   }
   public V getVlaue() {
      return value;
   }
   public void SetValue(V value) {
      this.value = value;
   }   
}

class CharacterFactory<T>{
   
   private T character;
   
   public CharacterFactory(T character) {
      this.character = character;
   }
   public void Introduce() {
      System.out.println(" 나는 " + character.getClass().getSimpleName()+"character");
      //getClass() object에 포함되어있는 애, 객체의 유형을 파악할 때 씀 
      //getSimpleName() 문자열로 리턴해주는 애
      //getClass().getSimpleName() 메서드 체이닝, 객체지향에서 많이 쓰임, 한줄로 표현해서
   }
   public T getCharacter() {
      return character;
   }
   
   //(trim)문자열 앞뒤공백제거 -> (toUpperCase)대문자로 변환 -> (substring)처음 5글자만 추출
   //한번에 처리한다.
//   String reString = inputString.trim().toUpperCase().substring(0,5);
   
}

class Knight{
   private String name;
   
   public Knight(String name) {
      this.name = name;
   }
   public void Attack() {
      System.out.println(name + "칼을 휘두룸!!!");
   }
}
class Wizard{
   private String name;
   public Wizard(String name) {
      this.name = name;
   }
   public void Skill() {
      System.out.println(name + "파이어 볼 발사");
   }
}


public class Generic {
   
   public static void main(String[] args) {
      
      Goods3 goods3 = new Goods3();
      goods3.Set(new Apple());
      
      //타입으로 꺼내오기 위해서는 저장된 형태로 타입 캐스팅을 해야한다.
      //필드 자체가 Object 타입이라 Get으로 가져오는 탑입 또한 항상 Object타입이기 때문임.
      //그래서 Get을 할 때는 Set을 한 타입으로 형변환 해야한다.
      
//      Apple apple = (Apple)goods3.Get();
      
      //제네릭 클래스인  MyClass를 써볼꽈??
      
      //String 타입을 저장하거나 꺼내 올 수 있는 객체지정
      MyClass<String> mc1 = new MyClass<String>();
      mc1.Set("안녕");
      System.out.println(mc1.Get());
      
      //Integer 타입 저장하거나 꺼내 올 수 있는 객체지정
      MyClass<Integer> mc2 = new MyClass<Integer>();
      mc2.Set(12345);
      System.out.println(mc2.Get());
      
      
      //제네릭 타입 변수가 2개인 경우!
      KeyValue<String, Integer> kv1 = new KeyValue<>();
      
      kv1.SetKey("원숭이");
      kv1.SetValue(12345);
      String key1 = kv1.getKey();
      int value1=kv1.getVlaue();
      System.out.println("key : "+key1+" value : "+value1);
      
      KeyValue<String, Void> kv2 = new KeyValue<>();
      
      kv2.SetKey("키값만 사용하겠음");
//      kv2.SetValue(12345);
      
      
      /////////////////////////////////////////////////////////
      CharacterFactory<Knight> knightFactory = new CharacterFactory<>(new Knight("홍길동"));
      CharacterFactory<Wizard> WizardFactory = new CharacterFactory<>(new Wizard("ooo"));
      
      knightFactory.Introduce();
      Knight knight = knightFactory.getCharacter();
      knight.Attack();
      
      
      
   }

}