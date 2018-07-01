package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;

/** Verify that, between two trees, one is a subtree of the other */
public class BTreeSubTrees {

  public static void main(String[] args) {
    Graph tree1 = new GraphImpl();
    Graph tree2 = new GraphImpl();

    Node node26 = new NodeImpl(26);
    Node node10 = new NodeImpl(10);
    Node node4 = new NodeImpl(4);
    Node node6 = new NodeImpl(6);
    Node node3 = new NodeImpl(3);
    Node node30 = new NodeImpl(30);
    Node node100 = new NodeImpl(100);

    node26.addLeftChild(node10);
    node26.addRightChild(node3);
    node10.addLeftChild(node4);
    node10.addRightChild(node6);
    node4.addRightChild(node30);
    node3.addRightChild(node100);

    tree1.setRootNode(node26);
    tree2.setRootNode(node10);

    if (getBiggerTree(tree1, tree2).equals(tree1.getRoot()))
      System.out.println(isSubtree(tree1.getRoot(), tree2.getRoot()));
    else
      System.out.println(isSubtree(tree2.getRoot(), tree1.getRoot()));
  }

  public static int getTreeSize(Node root) {
    if (root == null) return 0;
    return getTreeSize(root.getLeft()) + 1 + getTreeSize(root.getRight());
  }

  public static boolean isSubtree(Node root1, Node root2) {
    if (root1 == null) return true;
    if (root2 == null) return true;
    if (isIdentical(root1, root2)) return true;

    return isSubtree(root1.getLeft(), root2.getLeft())
        || isSubtree(root1.getRight(), root2.getRight());
  }

  public static boolean isIdentical(Node root1, Node root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;

    return (root1.getNodeData() == root2.getNodeData()
        && isIdentical(root1.getLeft(), root2.getLeft())
        && isIdentical(root1.getRight(), root1.getRight()));
  }

  public static Node getBiggerTree(Graph tree1, Graph tree2) {
    return getTreeSize(tree1.getRoot()) > getTreeSize(tree2.getRoot())
        ? tree1.getRoot()
        : tree2.getRoot();
  }
}
