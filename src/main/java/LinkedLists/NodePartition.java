package LinkedLists;

/**
 * The goal is to partition around a Node X such that all values that are less than or =
 * to x come before X and the node X comes directly after all nodes that preceed it.
 */
public class NodePartition {

  public static void main(String[] args) {
    Node n0 = new Node(3);
    Node n1 = new Node(5);
    Node n2 = new Node(8);
    Node n3 = new Node(5);
    Node n4 = new Node(10);
    Node n5 = new Node(2);
    Node n6 = new Node(1);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;
    n5.nextNode = n6;

    Node newNode = partitionAroundNode(n0, 5);
    listEval(newNode);
  }

  public static Node partitionAroundNode(Node x, int val) {
    /**
     * 1) iterate through each node in the linkedlist
     * 2) if the node value is <= x, then append it to the head of the linkedlist
     * 3) if it is greater than x, it need to be appended to the end
     */

    Node headNode = x;
    Node tailNode = x;

    // Continue traversal through the list
    while (x != null) {
      Node next = x.nextNode;
      if (x.nodeVal < val) {
        // Insert at the beginning of the list
        x.nextNode = headNode;
        headNode = x;
      } else {
        // Insert at the end of the list
        tailNode.nextNode = x;
        tailNode = x;
      }
      x = next;
    }
    tailNode.nextNode = null;
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
