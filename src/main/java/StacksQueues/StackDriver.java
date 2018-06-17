package StacksQueues;

public class StackDriver {
  public static void main(String[] args) {
    StackImpl stack = new StackImpl();
    System.out.println(stack.isEmpty());
    stack.push("ryan");
    System.out.println(stack.isEmpty());
    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.isEmpty());
    stack.push("1");
    stack.push("2");
    stack.push("3");
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}
