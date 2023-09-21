package c230831;

public class EqualsTest {
	String name;
	int num;
	
	EqualsTest(int num, String name){
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
//		if(obj instanceof EqualsTest){  //앞에 붙은게 뒤의 타입을 가졌냐
//			
//			//강제 형변환 obj를 EqualsTest로
//			//String이 참조형이지만 오버라이딩 되어 있기때문에 비교가 가능하다.
//			if(num == ((EqualsTest)obj).num && 
//					((EqualsTest)obj).name.equals(name)) {
//				return true;
//			}
//		}

//		if(obj instanceof EqualsTest && ((EqualsTest)obj).name.equals(name)) {
//				return true;
//			}
		
//		if(obj instanceof EqualsTest && ((EqualsTest)obj).name.equals(name)) {
//			return true;
//		}
//		
//		
//		return false;
		
		
		if(!(obj instanceof EqualsTest)) return false;
		if(!((EqualsTest)obj).name.equals(name)) return false;
		if(num != ((EqualsTest)obj).num) return false;
		return true;
	}

	@Override
	public int hashCode() {
		return num + name.hashCode();
	}
	
	
	@Override
	public String toString() { // 문자열로 바꿔주는걸 toString이라고 한다.
		return "제 이름은 " + name + "입니다. 나이는 " + num + "살 입니다.";
	}
	
}











