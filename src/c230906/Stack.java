package c230906;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class Node<T>{
   T data;
   Node<T> next;
   
   public Node(T data) {
      this.data = data;
      this.next=null;
   }
}
class SLLStack<T>{
   private Node<T> top;
   public SLLStack() {
      this.top=null;
   }
}




class Stack <T>{
   private List<T> elemList;
   public Stack() {
      elemList = new ArrayList<>();
   }
   public void push(T item) {
      elemList.add(item);
   }
   public T pop() {
      if(isEmpty()) {
         throw new EmptyStackException();
      }
      int top = elemList.size()-1;
      
      T item = elemList.get(top);
      elemList.remove(top);
      
      return item;
   }
   public boolean isEmpty() {
      return elemList.isEmpty();
   }
   public int size() {
      return elemList.size();
   }
}
