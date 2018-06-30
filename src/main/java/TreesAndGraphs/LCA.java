package TreesAndGraphs;

import graph.api.Graph;
import graph.api.Node;
import graph.impl.GraphImpl;
import graph.impl.NodeImpl;

/**
 * Goal : Find the lowest common ancestor between two nodes in a binary tree
 */
public class LCA {

  public static void main(String[] args) {
    Graph graph = new GraphImpl();
    Node a = new NodeImpl("a");
    Node b = new NodeImpl("b");
    Node c = new NodeImpl("c");
    Node d = new NodeImpl("d");
    Node e = new NodeImpl("e");
    Node f = new NodeImpl("f");
    Node g = new NodeImpl("g");
    Node h = new NodeImpl("h");
    Node i = new NodeImpl("i");
    Node j = new NodeImpl("j");
    Node k = new NodeImpl("k");
    Node l = new NodeImpl("l");

    a.addLeftChild(b);
    a.addRightChild(e);

    b.addLeftChild(c);
    b.addRightChild(f);

    c.addLeftChild(d);

    e.addRightChild(l);

    f.addLeftChild(g);
    f.addRightChild(h);

    g.addLeftChild(i);
    g.addRightChild(j);

    j.addRightChild(k);

    graph.addNodes(a,b,c,d,e,f,g,h,i,j,k,l);
    graph.setRootNode(a);
    System.out.println(findLCA(a, d, k).getNodeName());
  }

  /**
   * Finds the lowest common ancestor between two nodes
   * @param root
   * @param n1
   * @param n2
   * @return Node corresponding to the ancestor
   */
  public static Node findLCA(Node root, Node n1, Node n2) {
    if (root == null) return null;
    if (root == n1 || root == n2) return root;

    Node left = findLCA(root.getLeft(), n1, n2);
    Node right = findLCA(root.getRight(), n1, n2);

    if (left != null && right != null) return root;
    if (left == null && right == null) return null;

    return left != null ? left : right;
  }
}
