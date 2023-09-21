package c230908.functional;

public class FuncTest {
	public static void test() {
//		PrintTest t = new PrintTest() {
//			@Override
//			public void print() {
//				System.out.println("인터페이스로 클래스를 바로 생성한다.");
//			}
//		};
//		
//		t.print();

		action(new FuncTest() :: print);
		action1((name)->{
			System.out.println("임현규");
		});
	}

	private static void action(PrintTest printTest) {
		printTest.print("권원준");
	}

	private static void action1(PrintTest printTest) {
		printTest.print("권원준");
	}

	private void print(String name) {
		System.out.println(name + "람다 테스트");
	}
}