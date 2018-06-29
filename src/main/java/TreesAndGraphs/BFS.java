package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static void main(String[] args) {

    Graph graph = new GraphImpl();

    Node<String, Integer> n1 = new NodeImpl("node1");
    Node<String, Integer> n2 = new NodeImpl("node2");
    Node<String, Integer> n3 = new NodeImpl("node3");
    Node<String, Integer> n4 = new NodeImpl("node4");
    Node<String, Integer> n5 = new NodeImpl("node5");

    n1.bulkAddConnections(n2, n3);
    n2.bulkAddConnections(n4, n5);
    n3.bulkAddConnections(n1);
    n4.bulkAddConnections(n2);

    graph.setRootNode(n1);
    graph.addNodes(n1, n2, n3, n4, n5);

    Queue<Node<String, Integer>> nodeQueue = new LinkedList<>();

    nodeQueue.add(n1);

    while (!nodeQueue.isEmpty()) {
      Node<String, Integer> tempNode = nodeQueue.remove();
      System.out.println(tempNode.getNodeName());
      for (Node<String, Integer> node : tempNode.getAdjacentNodes()) {
        nodeQueue.add(node);
      }
    }
  }
}
