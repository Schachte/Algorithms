package TreesAndGraphs;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Goal is to output a valid dependency order given a list of projects and their dependencies */
public class NodeBuilder {

  /**
   * The children will have dependencies on their parents
   */
  private static class Node {
    private String val;
    private Set<Node> children = new HashSet<>();
    private Set<Node> parents = new HashSet<>();

    public Node(String val) { this.val = val; }

    private void addChild(Node childNode) {
      this.children.add(childNode);
    }

    private void addParent(Node parentNode) {
      this.parents.add(parentNode);
    }

    private void printChildren() {
      for (Node child : this.children) {
        System.out.print(child.val + " ");
      }
      System.out.println("");
    }

  }

  /** Adds a directed edge betweeen two nodes in a graph */
  public static void addEdge(Node n1, Node n2) {
    n1.addChild(n2);
    n2.addParent(n1);
  }

  public static void printGraph(List<Node> graph) {
    for (Node node : graph) {
      System.out.print("Dependency graph for " + node.val + " | ");
      node.printChildren();
    }
  }

  /** Test bed for graph construction */
  public static void main(String[] args) {
    NodeBuilder builder = new NodeBuilder();
    Node f = new Node("f");
    Node a = new Node("a");
    Node b = new Node("b");
    Node d = new Node("d");
    Node c = new Node("c");

    addEdge(f, a);
    addEdge(f, b);
    addEdge(a, d);
    addEdge(b, d);
    addEdge(d, c);

    List<Node> nodeList = ImmutableList.of(f, a, b, d, c);
    printGraph(nodeList);

    /**
     * The goal is to process the nodes that have the least number of dependnecies and place them in the
     * build order to be processed.
     */
  }
}
