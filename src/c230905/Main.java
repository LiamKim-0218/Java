package c230905;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("IntStack Top 값: " + intStack.peek());

        Stack<String> stringStack = new Stack<>(3);
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("StringStack Top 값: " + stringStack.peek());
    }
}
