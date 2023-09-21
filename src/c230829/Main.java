package c230829;

interface InterfaceTest{
	 /* public static final */ int NUMBER = 1;
	//정적인 상수는 인터페이스에서 ㅇㅇ이 가능하다.
	 
	// 얘는 왜 다중 상속이 가능할까? << 이름밖에 없으니까
	/* public 과 abstract 가 생략되어있다 */void methodTest();
	
	static void staticMethodTest() {
		System.out.println("정적 메서드 가능?!");
		// private 메서드 호출 가능? 불가능?
		privateStaticMethodTest();
	}
	private static void privateStaticMethodTest() {
		System.out.println("private 정적 메서드 가능?!");
	}
	
	private void privateMethodTest() {
		System.out.println("정적 메서드 가능?!");
	}
	default void defaultMethodTest() {
		privateMethodTest();
	}
}


class ClassTest implements InterfaceTest{
	@Override
	public void methodTest() {}
	
//	@Override
//	public void defaultMethodTest() {
//		InterfaceTest.super.defaultMethodTest();
//	}
}


//맥도날드를 갔어
//빅맥 주세요 햄버거를 주지
//빅맥이라는 단어는 뭐야 (굳이 따지자면 클래스)
//찍어서 나오는 제품은 인스턴스



public class Main {
	public static void main(String[] args) {
		InterfaceTest.staticMethodTest();
		YellowRace JKH = new YellowRace();
		JKH.move();
//		JKH.skinColor
		Person[] people = new Person[] {JKH,  new WhiteRace()}; // <= 이걸 진짜 많이 사용할거임
//		people[0].skin
//		people[0].move
		
	}

}
