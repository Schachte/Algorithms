package StacksQueues;
import java.util.EmptyStackException;

public class StackImpl<T> {

  private StackNode<T> top;

  /** Wrapper class for the nodes we push to the stack */
  private static class StackNode<T> {
    private T data;
    private StackNode next;

    public StackNode(T data) {
      this.data = data;
    }

    public T getData() {
      return data;
    }
  }

  /** Returns the top of the stack and shrinks by N-1 */
  public T pop() {
    if (top == null) throw new EmptyStackException();
    StackNode tmp = top;
    top = top.next;
    return (T) tmp.getData();
  }

  /** Pushes item to the top of the stack */
  public void push(T data) {
    StackNode newNode = new StackNode(data);
    newNode.next = top;
    top = newNode;
  }

  /** Get the data present at the top of the stack */
  public T peek() {
    return top.data;
  }

  /** Checks if the stack is empty */
  public boolean isEmpty() {
    return top == null;
  }
}
