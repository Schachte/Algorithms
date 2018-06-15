package LinkedLists;

public class BasicLLConstruction {
  public static void main(String[] args) {
    Node node1 = new Node("node1");
    Node node2 = new Node("node2");
    Node node3 = new Node("node3");
    Node node4 = new Node("node4");

    node1.nextNode = node2;
    node2.nextNode = node3;
    node3.nextNode = node4;

    node2.prevNode = node1;
    node3.prevNode = node2;
    node4.prevNode = node3;

    printLinkList(node1);
  }

  // Print Link List
  public static void printLinkList(Node headNode) {
    System.out.println(headNode.nodeType);
    while (headNode.nextNode != null) {
      headNode = headNode.nextNode;
      System.out.println(headNode.nodeType);
    }
  }
}
