package TreesAndGraphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree Impl
 * Current Operations Handled:
 * - Delete
 */
public class BinarySearchTree {

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    // Simple B-Tree Structure
    Node root = new Node(100);
    Node n90 = new Node(90);
    Node n80 = new Node(80);
    Node n60 = new Node(60);
    Node n70 = new Node(70);
    Node n95 = new Node(95);
    Node n200 = new Node(200);
    Node n300 = new Node(300);
    Node n250 = new Node(250);
    Node n400 = new Node(400);

    root.left = n90;
    root.right = n200;
    n90.left = n80;
    n90.right = n95;
    n80.left = n60;
    n60.right = n70;
    n200.right = n300;
    n300.left = n250;
    n300.right = n400;
    n400.left = new Node(380);

    insertNode(root, new Node(45));
    insertNode(root, new Node(99));
    insertNode(root, new Node(5));
    infixEval(root);

    System.out.println(getDepthLevel(root, 5));
  }

  /** Checks existence of node and outputs the depth if exists (-1 if it doesn't) */
  private static int getDepthLevel(Node root, int val) {
    int depth = -1;
    Queue<Node> treeNodes = new LinkedList<>();
    treeNodes.add(root);
    treeNodes.add(null);
    while (!treeNodes.isEmpty()) {
      Node tmp = treeNodes.poll();
      if (tmp == null) {
        depth++;
        treeNodes.add(null);
        if (treeNodes.peek() == null) return -1;
        continue;
      }
      if (tmp.val == val) return ++depth;
      if (tmp.left != null)
        treeNodes.add(tmp.left);

      if (tmp.right != null)
        treeNodes.add(tmp.right);
    }
    return -1;
  }

  private static Node insertNode(Node root, Node node) {
    if (root == null) root = node;
    if (node.val < root.val) root.left = insertNode(root.left, node);
    if (node.val > root.val) root.right = insertNode(root.right, node);
    return root;
  }

  /** Removes a requested node from the input tree */
  private static Node deleteNode(Node root, int data) {
    if (root == null) return null;
    if (root.val > data) root.left = deleteNode(root.left, data);       // Recurse down left sub-tree for removal
    else if(root.val < data) root.right = deleteNode(root.right, data); // Recurse down right sub-tree for removal
    else {

      // Case 1: No children
      if (root.left == null && root.right == null) return null;

      // Case 2: 1 child
      if (root.left == null && root.right != null) return root.right;
      if (root.right == null && root.left != null) return root.left;

      // Case 3: 2 children
      Node tmp = findMin(root.right); // Find min in right sub-tree for replacement
      root.right = deleteNode(root.right, tmp.val);
      root.val = tmp.val;
    }
    return root;
  }

  /** Gets the minimum value of a particular node */
  private static Node findMin(Node root) {
    if (root == null) return null;
    if (root.left != null) return findMin(root.left);
    return root;
  }

  /** In order eval of the B-tree data */
  private static void infixEval(Node root) {
    if (root != null) {
      infixEval(root.left);
      System.out.println(root.val);
      infixEval(root.right);
    }
  }
}
