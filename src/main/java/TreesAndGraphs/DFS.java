package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.HashSet;
import java.util.Set;

public class DFS {
  public static void main(String[] args) {
    // Set up the graph and root
    Graph graph = new GraphImpl();

    Node a = new NodeImpl("A");
    Node b = new NodeImpl("B");
    Node c = new NodeImpl("C");
    Node d = new NodeImpl("D");
    Node e = new NodeImpl("E");
    Node f = new NodeImpl("F");
    Node g = new NodeImpl("G");
    Node h = new NodeImpl("H");
    Node j = new NodeImpl("J");

    a.addConnection(b);
    a.addConnection(f);
    b.addConnection(c);
    b.addConnection(e);
    c.addConnection(d);
    d.addConnection(j);
    f.addConnection(g);
    f.addConnection(h);

    graph.addNodes(a, b, c, d, e, f, g, h, j);
    System.out.println(hasPathDFS(a, j));
  }

  public static boolean hasPathDFS(Node root, Node destination) {
    Set<Node> visited = new HashSet<>();
    return hasPathDFS(root, destination, visited);
  }

  public static boolean hasPathDFS(
      Node<String, Integer> root, Node<String, Integer> destination, Set<Node> visited) {
    if (visited.contains(root)) return false;

    visited.add(root);

    if (root == destination) return true;

    for (Node adjNode : root.getAdjacentNodes()) {
      if (hasPathDFS(adjNode, destination, visited)) {
        return true;
      }
    }
    return false;
  }
}
