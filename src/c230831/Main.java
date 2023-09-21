package c230831;

public class Main extends Object {
	public static void main(String[] args) throws Exception {
	
//		 클래스는 무조건 인스턴스를 만들어야 한다? Y / N
//		 클래스는 우리가 이름을 지을 때, 명명할 때 어떻게 한다?
//		 => 첫 char가 대문자다.
//		 String, System, Math
//		 위에처럼 알아서 가져다 사용하는 것들을 기본 모듈이라고 얘기할 수 있다.
//		 java.lang에서 가져온다.
//		 Scanner << java.util에 포함되어있다.
//		 위와 같이 다운받거나 설피하지 않은 모듈들을 표준모듈이라고 한다.
//		 java.lang << 어떤 것들이 포함되어 있을까?
//		 Object, System, String, StringBuilder, Math, Class
//		
//		 우리는 항상 object를 써왔다.
//		 Object는 최상위 클래스이다. 뭘 상속받았니 - 또 뭘 상속받았니 - 제일 끝에는 Object가 있다
//		 public class Main extends Object << 이렇게!
//		
//		Object obj = new Object();
//		Main main = new Main();
//		main.
		
		EqualsTest et1 = new EqualsTest(1,"test");
		EqualsTest et2 = new EqualsTest(2,"test");
		EqualsTest et3 = et1;
//		EqualsTest et4 = new EqualsTest("test");
		System.out.println(et1.equals(et2));
		System.out.println(et1.equals(et3));
//		System.out.println(et1.equals(et4));
		
		String temp1 = new String("aaa");
		String temp2 = new String("aaa");
		String temp3 = "aaa";
		String temp4 = "aaa";
		System.out.println(temp4 == temp3);
		
		System.out.println("aaa" == "aaa");
		
		System.out.println(et1.hashCode());
		System.out.println(et2.hashCode());
		System.out.println(et1.name.hashCode());
		System.out.println(et2.name.hashCode());
		
		System.out.println(et1.toString());
		System.out.println(et2.toString());
		
		
		
		RecordTest recordTest = new RecordTest(1,"test");
		RecordTest recordTest2 = new RecordTest(1,"test");
		
		System.out.println(recordTest.num());
		System.out.println(recordTest2.name());
		System.out.println(recordTest.toString());
		System.out.println(recordTest2.toString());
		System.out.println(recordTest.equals(recordTest2));
//		System.out.println(recordTest2.equals(recordTest2));
		
		
		// 위가 전부 Object
		
		// System
		System.out.print(""); // out은 콘솔창에 출력한다.
		System.out.println(""); //
		
		//System.in; // 키보드를 입력받는다.
//		int keyInput = 0;
//		while(true) {
//			keyInput = System.in.read();
//			System.out.println(keyInput);
//			// 7 => 55, 13, 10
//			// 8 => 56, 13, 10
//			// a => 97, 13, 10
//			// ASCII CODE + \r \n
//			break;
//		}
		
		//System.currentTimeMillis() 현재 시간을 ms 단위로 받아온다.
//		System.nanoTime(); // 나노 단위의 현재 시간을 받아온다.
		// 나노머신, 나노미터
		System.out.println(System.currentTimeMillis());
		// 1693449477.674 s
		// 28,224,157 m
		// 470,402 h + 37 m
		// 19,600 d + 2 h
		// 53 y 255d
		// 2023y 8 m 31 d
		// 0년이 아니라 1970년을 기준으로 시간을 체크한다.
		// GMT 그리니치 시간 : 영국이 GMT + 0 / 한국 GMT + 9
		// UTC, ms 단위
		// Date type
		
		
//		System.exit(0);
		
		//getProperty 현재 실행되고 있는 정보를 받을 수 있다. (사용할 곳은 딱 한군데정도! 앱일때)
		System.out.println("Java Version : " + System.getProperty("java.specification.version"));
		System.out.println("JDK Directory : " + System.getProperty("java.home"));
		System.out.println("OS : " + System.getProperty("os.name"));
		System.out.println("user : " + System.getProperty("user.name"));
		System.out.println("user Directory : " + System.getProperty("user.home"));
		System.out.println("directory : " + System.getProperty("user.dir"));
		
		
		
	}
}

//class EqualsTest2{
//	String name;
//	
//	EqualsTest2(String name){
//		this.name = name;
//	}
//	
//}







