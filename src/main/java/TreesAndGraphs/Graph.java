package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graph {

  Map<Node, Node> adjacencyList = new HashMap<>();

  public static class Node {
    private int val;
    private Node next;
    public Node(int val) { this.val = val; }
  }

  public static void main(String[] args) {
    Graph g = new Graph();
    List<Node> nodes = g.autoCreateNodes(4);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    g.addEdge(n1, n2);
    g.addEdge(n3, n1);
    g.addEdge(n2, n4);
    g.addEdge(n2, n1);


    g.prettyPrintGraph();
  }

  public void prettyPrintGraph() {
    Iterator iter = adjacencyList.entrySet().iterator();
    while (iter.hasNext()) {
      Entry node = (Entry) iter.next();
      System.out.print(Node.class.cast(node.getKey()).val + ": ");
      Node tempIter = Node.class.cast(node.getValue());
      while (tempIter != null) {
        System.out.print(Node.class.cast(tempIter).val + " -> ");
        tempIter = tempIter.next;
      }
      System.out.print(tempIter);
      System.out.println("");
    }
  }

  public List<Node> autoCreateNodes(int nodeCount) {
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < nodeCount; i++) {
      nodes.add(new Node(i));
    }
    return nodes;
  }

  /** Adds a bidirectional edge between two nodes */
  public void addBidirectionalEdge(Node n1, Node n2) {
    if (adjacencyList.containsKey(n1)) {
      Node head = adjacencyList.get(n1);
      while (head.next != null) {
        head = head.next;
      }
      head.next = n2;
    } else {
      adjacencyList.put(n1, n2);
    }

    if (adjacencyList.containsKey(n2)) {
      Node head = adjacencyList.get(n2);
      while (head.next != null) {
        head = head.next;
      }
      head.next = n1;
    } else {
      adjacencyList.put(n2, n1);
    }
  }

  /** Adds list of nodes to a singular parent node to quickly define connections */
  public void bulkAddConnections(Node parent, List<Node> children) {
    if (adjacencyList.containsKey(parent)) {
      Node head = adjacencyList.get(parent);
      while (head.next != null) {
        head = head.next;
      }
      for (Node child : children) {
        head.next = child;
        head = head.next;
      }
    } else {
      adjacencyList.put(parent, children.get(0));
      Node head = adjacencyList.get(parent);
      for (Node child : children) {
        head.next = child;
        head = head.next;
      }
    }
  }

  /** Add a uni-directional edge between two nodes in the graph */
  public void addEdge(Node n1, Node n2) {
    if (adjacencyList.containsKey(n1)) {
      Node head = adjacencyList.get(n1);
      while (head.next != null) {
        head = head.next;
      }
      head.next = n2;
    } else {
      adjacencyList.put(n1, n2);
    }
  }
}
