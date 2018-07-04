package TreesAndGraphs;

import graph.api.Node;
import graph.impl.NodeImpl;

public class BSTValidation2 {
  public static void main(String[] args) {
    Node node1 = new NodeImpl(500);
    Node node2 = new NodeImpl(400);
    Node node3 = new NodeImpl(450);
    Node node4 = new NodeImpl(600);
    node1.addLeftChild(node2);
    node2.addRightChild(node3);
    node1.addRightChild(node4);
    System.out.println(isValidBST(node1, null, null));
  }

  public static boolean isValidBST(
      Node<String, Integer> root, Node<String, Integer> min, Node<String, Integer> max) {
    if (root == null) return true;

    if (min != null && root.getNodeData() < min.getNodeData()) return false;
    if (max != null && root.getNodeData() > max.getNodeData()) return false;

    return isValidBST(root.getLeft(), min, root) &&
        isValidBST(root.getRight(), root, max);
  }
}
