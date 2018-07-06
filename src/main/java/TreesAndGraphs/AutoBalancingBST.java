package TreesAndGraphs;

/**
 * Given a valid BST, write an algorithm to auto-balance the tree
 * such that Dmax - Dmin <= 1
 */
public class AutoBalancingBST {

  public static class Node {
    Node right;
    Node left;
    int val;
    public Node(int val) { this.val = val; }
  }

  public static void main(String[] args) {
    Node n6 = new Node(6);
    Node n4 = new Node(4);
    Node n2 = new Node(2);
    Node n1 = new Node(1);
    Node n5 = new Node(5);
    Node n7 = new Node(7);
    Node n3 = new Node(3);

    n6.left = n4;
    n6.right = n7;

    n4.left = n2;
    n4.right = n5;

    n2.left = n1;
    n2.right = n3;

    System.out.println(checkBalanced(n6));
    n6 = rightRotation(n6);
    System.out.println(checkBalanced(n6));
  }

  public static void inOrderEval(Node root) {
    if (root == null) return;
    System.out.println(root.val);
    inOrderEval(root.left);
    inOrderEval(root.right);
  }

  public static Node rightRotation(Node root) {
    Node newRoot = root.left;
    root.left = newRoot.right;
    newRoot.right = root;
    return newRoot;
  }

  public static boolean checkBalanced(Node root) {
    return Math.abs(minDepth(root) - maxDepth(root)) <= 1;
  }

  public static int minDepth(Node root) {
    if (root == null) return -1;
    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }

  public static int maxDepth(Node root) {
    if (root == null) return -1;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

}
