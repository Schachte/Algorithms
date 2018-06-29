package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.exceptions.NodeException;
import graph.exceptions.NodeException.NodeAlreadyExistsException;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** The goal is to essentially validate a dependency output graph */
public class BuildOrder {

  private static Map<Node, List<Node>> dependentRefSet = new HashMap<>();

  public static void main(String[] args) {
    Graph graph = new GraphImpl();
    constructGraph(graph, getGraphInput());
    executeBuildOrder(graph);
  }

  /** Outputs the final build order */
  public static void executeBuildOrder(Graph graph) {
    while (graph.getAllNodes().size() > 0) {
      Node leastDependentNode = getLeastDependentNode(graph);
      if (leastDependentNode == null) {
        throw new IllegalArgumentException(
            "Impossible build order request. Circular dependencies are present.");
      }
      graph.removeNode(leastDependentNode);
      removeChildrenFromRefSet(leastDependentNode);
      System.out.print(leastDependentNode.getNodeName() + ", ");
    }
  }

  public static void removeChildrenFromRefSet(Node<String, Integer> node) {
    for (Node child : node.getAdjacentNodes()) {
      if (dependentRefSet.containsKey(child)) {
        dependentRefSet.get(child).remove(node);
      }
    }
  }

  /** Grabs node with least number of dependencies */
  public static Node getLeastDependentNode(Graph graph) {
    Node smallestDependentNode = null;
    for (Node node : graph.getAllNodes()) {
      if (dependentRefSet.getOrDefault(node, new ArrayList<>()).size() == 0) {
        smallestDependentNode = node;
        break;
      }
    }
    return smallestDependentNode;
  }

  /**
   * Converts the user input into an actual {@link Graph} object
   *
   * @param graph
   * @param serializedUserGraph
   */
  public static void constructGraph(Graph graph, List<String> serializedUserGraph) {
    for (String nodePair : serializedUserGraph) {
      String[] nodes = nodePair.split(",");

      Node parent = getOrCreateNode(graph, nodes[0]);
      Node child = getOrCreateNode(graph, nodes[1]);

      parent.addConnection(child);
      graph.addNode(parent);
      updateReferenceSet(parent, child);
    }

    String nodeVal;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Add More Non-Connected Nodes?");

    while ((nodeVal = scanner.nextLine()).length() > 0) {
      addSingularNode(graph, nodeVal);
    }
  }

  /** Tracks dependencies */
  public static void updateReferenceSet(Node parent, Node child) {
    List<Node> currentNodesChild = dependentRefSet.getOrDefault(child, new ArrayList<>());
    currentNodesChild.add(parent);
    dependentRefSet.put(child, currentNodesChild);
  }

  /** Attempts to retrieve an already existent node based on value or creates a new one */
  public static Node getOrCreateNode(Graph graph, String nodeVal) {
    List<Node> nodes = graph.getAllNodes();
    for (Node node : nodes) {
      if (node.getNodeName().equals(nodeVal)) return node;
    }
    return new NodeImpl(nodeVal);
  }

  /** Get the graph input from the user. Follows the structure: (a, b), (c, d).... b depends on a */
  private static List<String> getGraphInput() {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String[] userGraph = input.split("\\),");
    return Stream.of(userGraph)
        .map(item -> item.replace("(", ""))
        .map(item -> item.replace(")", ""))
        .map(item -> item.replace(" ", ""))
        .collect(Collectors.toList());
  }

  /** Enables adding just one node to the graph */
  private static void addSingularNode(Graph g, String val) {
    if (!g.getAllNodes().contains(getOrCreateNode(g, val))) {
      g.addNode(new NodeImpl(val));
    } else {
      throw new NodeAlreadyExistsException("Can't add duplicate node into graph");
    }
  }
}
