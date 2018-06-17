package StacksQueues;

public class QueueDriver {
  public static void main(String[] args) {
    QueueImpl<String> queue = new QueueImpl();
    queue.add("my fav movie");
    queue.add("my 2nd fav movie");
    queue.add("my 3rd fav movie");

    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
  }
}
