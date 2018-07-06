package TreesAndGraphs;

// The goal is to min-heapify || max-heapify a b-tree in nlogn complexity
public class BTreeMinHeapify {

  public static class Node {
    public Node left;
    public Node right;
    public int val;
    public Node(int val) {this.val=val;}
  }

  public static void main(String[] args) {
    Node root = new Node(100);
    root.left = new Node(20);
    root.left.left = new Node(12);
    root.left.right = new Node(11);
    root.left.right.left = new Node(15);
    root.left.right.right = new Node(40);
    root.right = new Node(100);
    root.right.right = new Node(7);

    // Self-Verifcation of Tree Structure In Console
    preOrderValidator(root);

    // O(N) for getting the count
    Node[] nodeList = new Node[getTreeCount(root)];
    fillArr(nodeList, root, 0);
  }

  /**
   * Given a unordered binary tree, we need to init. a static array of values/nodes
   */
  public static int getTreeCount(Node root) {
    if (root == null) return 0;
    return (getTreeCount(root.left) + 1 + getTreeCount(root.right));
  }

  /**
   * Convert B-Tree into Node Arr
   * @param nodeArr
   * @return
   */
  public static int fillArr(Node[] nodeArr, Node root, int count) {
    if (root == null) return count;
    if (root != null) {
      nodeArr[count] = root;
    }
    count++;
    count = fillArr(nodeArr, root.left, count);
    count = fillArr(nodeArr, root.right, count);
    return count;
  }

  private static void preOrderValidator(Node root) {
    if (root == null) return;
    System.out.println(root.val);
    preOrderValidator(root.left);
    preOrderValidator(root.right);
  }
}
