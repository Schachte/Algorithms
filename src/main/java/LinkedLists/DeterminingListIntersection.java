package LinkedLists;

public class DeterminingListIntersection {
  public static void main(String[] args) {
    // List 1
    Node n0 = new Node(4);
    Node n1 = new Node(3);
    Node n2 = new Node(9);
    Node n3 = new Node(1);
    Node n4 = new Node(7);
    Node n5 = new Node(8);
    Node n6 = new Node(0);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;
    n5.nextNode = n6;

    // List 2
    Node m0 = new Node(4);
    Node m1 = new Node(3);
    Node m2 = new Node(9);
    Node m3 = n4;

    m0.nextNode = m1;
    m1.nextNode = m2;
    m2.nextNode = m3;

    int l1 = getListCount(n0, 0);
    int l2 = getListCount(m0, 0);

    if (l1 > l2) {
      n0 = traverseUntilEqual(n0, Math.abs(l1 - l2));
    } else {
      m0 = traverseUntilEqual(m0, Math.abs(l1 - l2));
    }

    System.out.println(doesIntersect(n0, m0));
  }

  public static boolean doesIntersect(Node n1, Node n2) {
    while (n1 != null) {
      if (n1 == n2) {
        return true;
      }
      n1 = n1.nextNode;
      n2 = n2.nextNode;
    }
    return false;
  }

  public static int getListCount(Node node, int counter) {
    if (node == null) return counter;
    return getListCount(node.nextNode, counter+1);
  }

  public static Node traverseUntilEqual(Node node, int number) {
    if (number == 0) return node;
    return traverseUntilEqual(node.nextNode, number-1);

  }
}
