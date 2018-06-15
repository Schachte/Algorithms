package LinkedLists;

public class Node {
  int nodeVal;
  String nodeType;
  Node prevNode;
  Node nextNode;

  public Node(Node prevNode, Node nextNode, int nodeVal) {
    this.prevNode = prevNode;
    this.nextNode = nextNode;
    this.nodeVal = nodeVal;
  }

  public Node(Node prevNode, Node nextNode, String nodeType) {
    this.prevNode = prevNode;
    this.nextNode = nextNode;
    this.nodeType = nodeType;
  }

  public Node(String nodeType) {
    this.nodeType = nodeType;
  }

  public Node (int nodeVal) {
    this.nodeVal = nodeVal;
  }

  @Override
  public String toString() {
     return "The Node is " + nodeVal;
  }
}
