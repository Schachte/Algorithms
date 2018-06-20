package TreesAndGraphs;
import java.security.KeyException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RouteBetweenTwoNodes {

  static HashMap<Integer, Node> dataList = new HashMap<>();

  private static class Node {
    private int id;
    public LinkedList<Node> adjList = new LinkedList<>();

    public Node(int id) {
      this.id = id;
      dataList.put(id, this);
    }
    public void addEdge(Node node){
      adjList.add(node);
    }

    public int getId() {
      return this.id;
    }
  }

  public static void main(String[] args) throws KeyException {
    Graph g = new Graph();
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.addEdge(n2);
    n1.addEdge(n3);

    n2.addEdge(n4);
    n2.addEdge(n1);
    n2.addEdge(n3);

    n4.addEdge(n2);

    System.out.println(hasPathDFS(3, 1));
  }

  public static Node getNode(int nodeVal) throws KeyException {
    if (dataList.containsKey(nodeVal)) {
      return dataList.get(nodeVal);
    }
    throw new KeyException("Key is missing");
  }

  public static boolean hasPathDFS(int source, int destination) throws KeyException {
    Node n1 = getNode(source);
    Node n2 = getNode(destination);
    Set<Integer> visited = new HashSet<>();
    return hasPathDFS(n1, n2, visited);
  }

  public static boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
    if (visited.contains(source.getId()))
      return false;

    visited.add(source.getId());

    if (source == destination)
      return true;

    for (Node node : source.adjList) {
      if (hasPathDFS(node, destination, visited)) {
        return true;
      }
    }
    return false;
  }
}
