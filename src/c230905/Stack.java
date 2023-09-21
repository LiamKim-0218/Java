package c230905;

import java.util.EmptyStackException;

public class Stack<T> {
    private int maxSize;
    private Object[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다. 더 이상 값을 추가할 수 없습니다.");
        } else {
            stackArray[++top] = value;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            @SuppressWarnings("unchecked")
            T value = (T) stackArray[top];
            stackArray[top--] = null; // 값 제거
            return value;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            @SuppressWarnings("unchecked")
            T value = (T) stackArray[top];
            return value;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}