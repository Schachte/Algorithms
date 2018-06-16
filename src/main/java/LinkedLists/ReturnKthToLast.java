package LinkedLists;

/**
 * Overall goal is to return the Kth to last node in a LL sequence
 */
public class ReturnKthToLast {

  public static void main(String[] args){
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);

    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;
    n5.nextNode = n6;
    n6.nextNode = n7;

    System.out.println(getKthToLast(n1, 7));
    System.out.println(getKthToLast(n1, 2));
    System.out.println(getKthToLast(n1, 3));
    System.out.println(getKthToLast(n1, 4));
    System.out.println(getKthToLast(n1, 8));
    System.out.println(getKthToLast(n1, 9));
    System.out.println(getKthToLast(n1, 2));

  }
  /**
   * Finds the overall size of a linkedlist
   * @param headNode
   * @return the total number of nodes in the list
   */
  public static Node getKthToLast(Node headNode, int k) {

    int nodeCount = 0;
    Node traversalNode = headNode;

    while (traversalNode.nextNode != null) {
      nodeCount+=1;
      traversalNode = traversalNode.nextNode;
    }
    nodeCount += 1;


    if (isWithinBounds(nodeCount, k)) {
      for (int i = 0; i < nodeCount - k; i++) {
        headNode = headNode.nextNode;
      }
      return headNode;
    }
    return null;
  }

  /**
   * Ensures that the kth node to find is within the bounds of allocated nodes
   * @param count
   * @param k
   * @return
   */
  public static boolean isWithinBounds(int count, int k) {
    return k <= count;
  }
}
