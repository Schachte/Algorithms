package LinkedLists;

/** The goal is to determine if there is a loop that exists within a linkedlist */
public class loopDetection {
  public static void main(String[] args) {
    // Cyclic List
    Node n0 = new Node(0);
    Node n1 = new Node(1);
    Node n2 = new Node(3);
    Node n3 = new Node(8);
    Node n4 = new Node(3);
    Node n5 = new Node(1);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;
    n5.nextNode = n2;

    System.out.println(isCyclic(n0));
  }

  public static boolean isCyclic(Node node) {
    Node fast = node;
    Node slow = node;

    while (fast != null && fast.nextNode != null) {
      slow = slow.nextNode;
      fast = fast.nextNode.nextNode;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
