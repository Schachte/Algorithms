package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Goal: Output all possible arrays that could possibly form the input binary search tree
 * TODO: Do this problem...
 */
public class INCOMPLETE_BSTSequences {
  public static void main(String[] args) {

    Graph tree = new GraphImpl();

    Node node10 = new NodeImpl(10);
    Node node8 = new NodeImpl(8);
    Node node55 = new NodeImpl(55);
    Node node2 = new NodeImpl(2);
    Node node9 = new NodeImpl(9);
    Node node0 = new NodeImpl(0);
    Node node3 = new NodeImpl(3);

    node10.addLeftChild(node8);
    node10.addRightChild(node55);

    node8.addLeftChild(node2);
    node8.addRightChild(node9);

    node2.addLeftChild(node0);
    node2.addRightChild(node3);
    tree.setRootNode(node10);
  }
}
