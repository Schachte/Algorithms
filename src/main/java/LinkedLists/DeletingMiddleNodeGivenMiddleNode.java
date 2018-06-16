package LinkedLists;

/**
 * The goal is to delete the middle node given only the middle node
 * OR delete any _given_ node, without given anything else (singlylink enforced)
 */
public class DeletingMiddleNodeGivenMiddleNode {

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

    deleteNode(n3);
    listEval(n0);

    n0 = new Node(4);
    n1 = new Node(3);
    n2 = new Node(9);
    n3 = new Node(1);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = null;

    deleteNode(n3);
    listEval(n0);
    n0 = new Node(4);
    n1 = new Node(3);
    n2 = new Node(9);
    n3 = new Node(1);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = null;

    deleteNode(n3);
    listEval(n0);

    n0 = new Node(4);
    n1 = new Node(3);
    n2 = new Node(9);
    n3 = new Node(1);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = null;

    deleteNode(n1);
    listEval(n0);
  }

  /**
   * Given the middle node, the goal is to delete yourself
   * @param middleNode
   * @return
   */
  public static void deleteNode(Node middleNode) {

    Node prevNode = null;

    while (middleNode.nextNode != null) {
      middleNode.nodeVal = middleNode.nextNode.nodeVal;
      prevNode = middleNode;
      middleNode = middleNode.nextNode;
    }

    if (prevNode != null)
      prevNode.nextNode = null;
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
