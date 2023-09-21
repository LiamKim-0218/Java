package c230908.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void test() {
		Set<String> set = new HashSet<String>();
		set.add("권원준");
		set.add("임현규");
		set.add("김동선");
		set.add("이민규");
		set.add("김남균");
		set.add("송성민");
		set.add("박정완");
		set.add("한상윤");
		set.add("임주한");


		Stream<String> stream = set.stream();
		stream.forEach(item->System.out.println(item));

		List<String> list = new ArrayList<String>();

		list.add("권원준");
		list.add("임현규");
		list.add("김동선");
		list.add("이민규");
		list.add("김남균");
		list.add("송성민");
		list.add("박정완");
		list.add("한상윤");
		list.add("임주한");

		Stream<String> stream1 = list.stream();
		stream1.forEach(item->System.out.println(item));

//		for(String temp : arr) {}

		Set<Student> students = new HashSet<Student>();
		students.add(new Student("권원준", 85));
		students.add(new Student("임현규", 98)); // 주관식 틀렸나?
		students.add(new Student("김동선", 90));
		students.add(new Student("이민규", 80));
		students.add(new Student("김남균", 90));
		students.add(new Student("송성민", 70));
		students.add(new Student("박정완", 75));
		students.add(new Student("한상윤", 100));
		students.add(new Student("임주한", 80));
		students.add(new Student("한상윤", 90));

		Stream<Student> stream2 = students.stream();
		IntStream scores = stream2.mapToInt(item->item.getScore());//.map(i->-i).sorted().map(i->-i);
		// stream2.forEach(item->System.out.println(item));
		// 학생이름 : 점수 => 권원준 : 85
		double avg = scores.average().getAsDouble();
//		scores.forEach(item->System.out.println(item));
		System.out.println("avg : " + avg);

		IntStream scoresDis = students.stream().mapToInt(item->item.getScore()).distinct();
//		int[] temp = scoresDis.toArray();
		scoresDis.forEach(item->System.out.print(item + ", "));
		System.out.println();

		Stream<Student> stream3 = students.stream().sorted(Comparator.reverseOrder());
		stream3.forEach(item->System.out.println(item));

		System.out.println();
		Stream<Student> stream4 = students.stream().filter(item->{
			return item.getScore() > avg;
		});
		stream4.forEach(item->System.out.println(item));

	}
}