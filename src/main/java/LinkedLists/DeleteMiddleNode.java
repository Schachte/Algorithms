package LinkedLists;

/**
 * Goal is to delete the middle node of a singly linkedlist
 */
public class DeleteMiddleNode {
  public static void main(String[] args) {
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

    listEval(removingMiddleNode(n0));

    n0 = new Node(4);
    n1 = new Node(3);
    n2 = new Node(9);

    n0.nextNode = n1;
    n1.nextNode = n2;

    listEval(removingMiddleNode(n0));

    n0 = new Node(4);
    n1 = new Node(3);

    n0.nextNode = n1;

    listEval(removingMiddleNode(n0));
  }

  /**
   * The goal is to remove the middle node of the linkedlist in O(N) of a singly-based linkedlist
   * @param node
   */
  public static Node removingMiddleNode(Node node) {
    /**
     * We are going to be using the double-runner technique for this problem
     */
    Node headNode = node;

    if (node.nextNode == null) {
      return null;
    }

    Node t1Node = node;
    Node t2Node = node.nextNode;

    while (t2Node.nextNode != null && t2Node.nextNode.nextNode != null) {
      t1Node = t1Node.nextNode;
      t2Node = t2Node.nextNode.nextNode;
    }

    Node middleNode = t1Node;

    if (middleNode.nextNode != null && middleNode.nextNode.nextNode != null)
      middleNode.nextNode = middleNode.nextNode.nextNode;


    return headNode;
  }

  public static void listEval(Node node) {
    System.out.print(node.nodeVal + "->");
    node = node.nextNode;
    while (node != null) {
      if (node.nextNode != null)
        System.out.print(node.nodeVal + "->");
      else
        System.out.print(node.nodeVal);
      node = node.nextNode;
    }
    System.out.println("");
  }
}
