package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Check if a path sums to a particular value
 */
public class BTreePathSum {

  public static void main(String[] args) {
    Graph bTree = new GraphImpl();
    Node n1 = new NodeImpl(10);
    Node n2 = new NodeImpl(16);
    Node temp = new NodeImpl(-3);
    Node n3 = new NodeImpl(-3);
    Node n4 = new NodeImpl(5);
    Node n5 = new NodeImpl(6);
    Node n6 = new NodeImpl(11);

    n1.addLeftChild(n2);
    n1.addRightChild(n4);

    n2.addRightChild(n3);
    n2.addLeftChild(temp);

    n4.addLeftChild(n5);
    n4.addRightChild(n6);

    bTree.addNodes(n1,n2,n3,n4,n5,n6);
    List<Node> pathSum = new ArrayList<>();
    System.out.println(rootToLeafSum(n1, 23, pathSum));
    System.out.println("There are a total of: " + pathSum.size());
  }

  static boolean rootToLeafSum(Node<String, Integer> root, int target, List<Node> pathSum) {
    if (root == null) return false;

    if (root.getLeft() == null && root.getRight() == null) {
      if (root.getNodeData().equals(target)) {
        pathSum.add(root);
        return true;
      }
      return false;
    }

    if (rootToLeafSum(root.getLeft(), target - root.getNodeData(), pathSum)) {
      return true;
    }

    if (rootToLeafSum(root.getRight(), target - root.getNodeData(), pathSum)) {
      return true;
    }

    return false;
  }

}
