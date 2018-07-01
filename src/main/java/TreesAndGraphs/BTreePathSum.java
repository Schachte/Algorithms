package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.LinkedList;

/**
 * Check if a path sums to a particular value
 */
public class BTreePathSum {


  public static void main(String[] args) {
    Graph bTree = new GraphImpl();
    Node n1 = new NodeImpl(10);
    Node n2 = new NodeImpl(16);
    Node n3 = new NodeImpl(-3);
    Node n4 = new NodeImpl(5);
    Node n5 = new NodeImpl(6);
    Node n6 = new NodeImpl(11);

    n1.addLeftChild(n2);
    n1.addRightChild(n4);

    n2.addRightChild(n3);

    n4.addLeftChild(n5);
    n4.addRightChild(n6);

    bTree.addNodes(n1,n2,n3,n4,n5,n6);
    System.out.println(rootToLeafSum(n1, 23));
  }

  static boolean rootToLeafSum(Node<String, Integer> root, int target) {
    if (root == null) return false;

    if (root.getLeft() == null && root.getRight() == null) {
      if (root.getNodeData().equals(target)) return true;
      return false;
    }

    if (rootToLeafSum(root.getLeft(), target - root.getNodeData())) {
      return true;
    }

    if (rootToLeafSum(root.getRight(), target - root.getNodeData())) {
      return true;
    }

    return false;
  }

}
