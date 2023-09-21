package c230908.todolist;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		TodoItem temp = new TodoItem(1, "리스트 작성", "입력을 받아서 아이템 작성");
//		System.out.println(temp);
//		
//		TodoItem[] arr = new TodoItem[] {
//			temp, 
//			new TodoItem(3, "테스트중", "테스트를 먼저하나?")
//		};
//		for(TodoItem item : arr) {
//			System.out.println(item.toList());
//		}

		TodoList list = new TodoList();
//		list.test();

		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(list);
			System.out.println("-------");
			System.out.println("1. 추가 | 2. 자세히 보기 | 이외. 종료");
			if (input.hasNextInt()) {
				int inputSel = input.nextInt();
				switch (inputSel) {
				case 1:
					input.nextLine();
					System.out.print("제목을 입력해 주세요. ");
					String title = input.nextLine();

					System.out.print("내용을 입력해 주세요. ");
					String text = input.nextLine();

					int rank;
					System.out.print("우선순위를 정수로 입력해 주세요. ");
					while (true) {
						if (input.hasNextInt()) {
							rank = input.nextInt();
							break;
						} else {
							input.next();
							System.out.print("우선순위를 정수로만 입력해 주세요. ");
						}
					}
					list.add(rank, title, text);
					break;
				case 2:
					input.nextLine();
					System.out.println("보고자 하는 제목을 입력해 주세요.");
					System.out.println(list.getItem(input.nextLine()));
					System.out.println("첫 화면으로 돌아가시려면 아무키나 입력해 주세요.");
					input.next();
					break;
				default:
					input.close();
					return;
				}
			} else {
				input.close();
				return;
			}
		}

	}
}