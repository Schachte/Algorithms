package LinkedLists;

/**
 * The goal here is to sum the reverse of two input linkedlists
 */
public class ListSummation {
  public static void main(String[] args) {
    Node n0 = new Node(4);
    Node n1 = new Node(3);
    Node n2 = new Node(9);
    n0.nextNode = n1;
    n1.nextNode = n2;

    Node m0 = new Node(4);
    Node m1 = new Node(3);
    Node m2 = new Node(9);
    m0.nextNode = m1;
    m1.nextNode = m2;

    System.out.println(sumTwoLists(n0, m0));

    n0 = new Node(4);
    n1 = new Node(0);
    n0.nextNode = n1;
    n1.nextNode = n2;
    n1.nextNode = null;

    m0 = new Node(4);
    m1 = new Node(3);
    m2 = new Node(9);
    m0.nextNode = m1;
    m1.nextNode = m2;

    System.out.println(sumTwoLists(n0, m0));
  }

  /**
   * The goal is to get the real value represented by the input node
   * @param node
   * @return
   */
  public static int getReverseValue(Node node) {
    int currentFactor = 1;
    int currentSum = 0;

    while (node != null) {
      currentSum += currentFactor * node.nodeVal;
      currentFactor *= 10;
      node = node.nextNode;
    }

    return currentSum;
  }


  public static int sumTwoLists(Node l1, Node l2) {
    return getReverseValue(l1) + getReverseValue(l2);
  }
}
