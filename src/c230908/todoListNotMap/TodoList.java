package c230908.todoListNotMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TodoList {
	private Set<TodoItem> list = new HashSet<>();
	private Scanner scaner;

	public void add() {
		scaner = new Scanner(System.in);
		System.out.print("제목을 입력해 주세요. ");
		String title = scaner.nextLine();

		System.out.print("내용을 입력해 주세요. ");
		String text = scaner.nextLine();

		int rank;
		System.out.print("우선순위를 정수로 입력해 주세요. ");

		while (true) {
			if (scaner.hasNextInt()) {
				rank = scaner.nextInt();
				break;
			} else {
				scaner.next();
				System.out.print("우선순위를 정수로만 입력해 주세요. ");
			}
		}
		list.add(new TodoItem(title, text, rank));
	}

//	public void test() {
//		list.add(new TodoItem("a", "b", 1));
//		list.add(new TodoItem("b", "b", 5));
//		list.add(new TodoItem("c", "b", 4));
//		list.add(new TodoItem("d", "b", 3));
//		list.add(new TodoItem("a", "b", 2));
//		System.out.println(list);
//
//		TodoItem[] temp = list.toArray(new TodoItem[0]);
//		Arrays.sort(temp);
//		System.out.println(Arrays.toString(temp));
//		System.out.println(toString());
//	}

	private TodoItem[] sort() {
		TodoItem[] temp = list.toArray(new TodoItem[0]);
		Arrays.sort(temp);

		return temp;
	}

	public TodoItem getItem(String title) {
		Iterator<TodoItem> it = list.iterator();
		while (it.hasNext()) {
			TodoItem temp = it.next();
			if (temp.isThis(title))
				return temp;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for (TodoItem item : sort()) {
			sb.append("\n");
			sb.append(++num + ". ");
			sb.append(item.toList());
		}
		return sb.toString();
	}
}