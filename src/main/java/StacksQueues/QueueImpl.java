package StacksQueues;

public class QueueImpl<T> {

  private Item head;

  private static class Item<T> {
    private T dat;
    private Item next;

    public Item(T dat) {
      this.dat = dat;
    }
  }

  public void add(T item) {
    if (head == null) {
      head = new Item(item);
    } else {
      Item iter = head;
      while (iter.next != null) {
        iter = iter.next;
      }
      iter.next = new Item(item);
    }
  }

  public T peek() {
    return (T) head.dat;
  }

  public T pop() {
    Item tmp = head;
    head = tmp.next;
    return (T) tmp.dat;
  }

  public boolean isEmpty() {
    return head == null;
  }

}
