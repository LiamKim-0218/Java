package c230908.todoListNotMap;

import java.util.Scanner;
//import java.util.TreeMap;

public class Main {
	// TreeMap과 HashMap
	public static void main(String[] args) {
		TodoList todoList = new TodoList();
//		todoList.test();
//		todoList.add();
//		todoList.add();
//		System.out.println(todoList);
		select(todoList);

	}

	private static void select(TodoList todoList) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(todoList);
			System.out.println("-------");
			System.out.println("1. 추가 | 2. 자세히 보기 | 이외. 종료");
			if (input.hasNextInt()) {
				int inputSel = input.nextInt();
				switch (inputSel) {
				case 1:
					todoList.add();
					break;
				case 2:
					input.nextLine();
					System.out.println("보고자 하는 제목을 입력해 주세요.");
					System.out.println(todoList.getItem(input.nextLine()));
					System.out.println("첫 화면으로 돌아가시려면 아무키나 입력해 주세요.");
					input.nextLine();
					break;
				default:
					return;
				}
			} else {
				return;
			}
		}
	}
}