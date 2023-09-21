package c230907;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class TodoList<T> {
    private Set<T> doList;

    public TodoList() {
        doList = new HashSet<>();
    }

    
    public void Push(T task) {
        if (doList.contains(task)) {
            System.out.println("이미 같은 항목이 TodoList에 있습니다.");
        } else {
            doList.add(task);
            updatingMessage();
        }
    }
    
    public void Pop(int index) {
        if (index >= 1 && index <= doList.size()) {
            T itemToRemove = null;
            int currentIndex = 1;
            for (T item : doList) {
                if (currentIndex == index) {
                    itemToRemove = item;
                    break;
                }
                currentIndex++;
            }
            doList.remove(itemToRemove);
            updatingMessage();
        } else {
            System.out.println("리스트가 비어있거나 올바르지 않은 인덱스입니다.");
        }
    }

    public void clear() {
        doList.clear();
        updatingMessage();
    }

    public void replace(int index1, int index2) {
        if (index1 >= 1 && index1 <= doList.size() && index2 >= 1 && index2 <= doList.size()) {
            @SuppressWarnings("unchecked") // 경고 제외
         T[] array = (T[]) doList.toArray();
            T temp = array[index1 - 1];
            array[index1 - 1] = array[index2 - 1];
            array[index2 - 1] = temp;

            doList.clear();
            doList.addAll(Arrays.asList(array));
            updatingMessage();
        } else {
            System.out.println("Invalid indices");
        }
    }

    public void display() {
        if (doList.isEmpty()) {
            System.out.println("TodoList가 비어 있습니다.");
        } else {
            System.out.println("--------- 나의 TodoList ---------");
            int index = 1;
            for (T task : doList) {
                System.out.println(index + ". " + task);
                index++;
            }
            System.out.println();
        }
    }

    private void updatingMessage() {
        System.out.println("업데이트했습니다.");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int select = 0;
        String doing;
        int num1, num2;
        TodoList<String> myList = new TodoList<>();

        System.out.println("----------TodoList-----------");

        while (select != 5) {
            System.out.println("TodoList에 뭘 할지 선택하세요.");
            System.out.println("1: TodoList에 추가하기");
            System.out.println("2: TodoList에 삭제하기");
            System.out.println("3: TodoList 순서바꾸기");
            System.out.println("4: TodoList 초기화");
            System.out.println("5: TodoList 나가기");

            select = scanner.nextInt();
            scanner.nextLine(); 

            switch (select) {
                case 1:
                    System.out.println("해야 할 일을 적어주세요.");
                    doing = scanner.nextLine();
                    myList.Push(doing);
                    myList.display();
                    break;

                case 2:
                    System.out.println("지우고싶은 목록을 선택하세요.");
                    myList.display();
                    num1 = scanner.nextInt();
                    scanner.nextLine(); 
                    myList.Pop(num1);
                    myList.display();
                    break;

                case 3:
                    System.out.println("교체할 항목의 인덱스를 입력하세요.");
                    num1 = scanner.nextInt();
                    num2 = scanner.nextInt();
                    scanner.nextLine(); 
                    myList.replace(num1, num2);
                    myList.display();
                    break;

                case 4:
                    System.out.println("TodoList를 초기화했습니다.");
                    myList.clear();
                    break;

                case 5:
                    System.out.println("종료.");
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 1~5까지 중 하나를 선택하세요.");
                    break;
            }
        }
    }
}




//------------------------------------------------------------------------밑에는 링크드리스트

//package TodoList;
//
//import java.util.InputMismatchException;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//
//
//public class TodoList<T>{
//   
//    private LinkedList<T> doList;
//
//    public TodoList() {
//        doList = new LinkedList<>();
//    }
//
//   public void Push(T task) {
//       if (!doList.contains(task)) { // 중복 여부 확인
//           doList.add(task);
//           updatingMessage();
//       } else {
//           System.out.println("이미 같은 항목이 TodoList에 있습니다.");
//       }
//   }
//
//    public void Pop(int index) {
//        if (index >= 1 && index <= doList.size()) {
//            doList.remove(index - 1);
//            updatingMessage();
//        } else {
//            System.out.println("리스트가 비어있습니다.");
//        }
//    }
//
//    public void clear() {
//        doList.clear();
//        updatingMessage();
//    }
//
//    public void replace(int index1, int index2) {
//        if (index1 >= 1 && index1 <= doList.size() && index2 >= 1 && index2 <= doList.size()) {
//            T temp = doList.get(index1 - 1);
//            doList.set(index1 - 1, doList.get(index2 - 1));
//            doList.set(index2 - 1, temp);
//            updatingMessage();
//        } else {
//            System.out.println("Invalid indices");
//        }
//    }
//    
//    public void display() {
//        if (doList.isEmpty()) {
//            System.out.println("TodoList가 없습니다.");
//        } else {
//            System.out.println("--------- 나의 TodoList ---------");
//            int index = 1;
//            for (T task : doList) {
//                System.out.println(index + ". " + task);
//                index++;
//            }
//            System.out.println();
//        }
//    }
//
//    private void updatingMessage() {
//        System.out.println("업데이트했습니다.");
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int select = 0;
//        String doing;
//        int num1, num2;
//        TodoList<String> myList = new TodoList<>();
//
//        System.out.println("----------TodoList-----------");
//
//        while (select != 6) {
//            System.out.println("TodoList에 뭘 할지 선택하세요.");
//            System.out.println("1: TodoList에 추가하기");
//            System.out.println("2: TodoList에 삭제하기");
//            System.out.println("3: TodoList 순서바꾸기");
//            System.out.println("4: TodoList 초기화");
//            System.out.println("5: TodoList 나가기");
//
//
//            select = scanner.nextInt();
//            scanner.nextLine(); 
//            
//            switch (select) {
//                case 1:
//                    System.out.println("해야 할 일을 적어주세요.");
//                    doing = scanner.nextLine();
//                    myList.Push(doing);
//                    myList.display();
//                    break;
//
//                case 2:
//                    System.out.println("지우고싶은 목록을 눌러주세요.");
//                    System.out.println();
//                    myList.display();
//                    num1 = scanner.nextInt();
//                    myList.Pop(num1);
//                    myList.display();
//                    break;
//
//                case 3:
//                    System.out.println();
//                    myList.display();
//                    System.out.println("바꾸고싶은 순서를 눌러주세요.");
//                    num1 = scanner.nextInt();
//                    num2 = scanner.nextInt();
//                    myList.replace(num1, num2);
//                    myList.display();
//                    break;
//
//                case 4:
//                    System.out.println();
//                    myList.clear();
//                    System.out.println("초기화했습니다.");
//                    break;
//
//                case 5:
//                    System.out.println("종료.");
//                    System.exit(0);
//                    break;
//
//                default:
//                    System.out.println("잘못누르셨습니다. 1~5까지 중 하나를 눌러주세요.");
//                    break;
//            }
//        }
//    }
//}
