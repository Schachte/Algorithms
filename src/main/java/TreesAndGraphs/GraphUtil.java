package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;

public class GraphUtil {
  static Graph getGraph()  {
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
    graph.setRootNode(a);
    return graph;
  }

  static Graph getBinaryTree() {
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

    a.addLeftChild(b);
    a.addRightChild(f);

    b.addLeftChild(c);
    b.addRightChild(e);

    c.addLeftChild(d);
    d.addRightChild(j);

    f.addLeftChild(g);
    f.addRightChild(h);

    graph.addNodes(a, b, c, d, e, f, g, h, j);
    graph.setRootNode(a);
    return graph;
  }
}
