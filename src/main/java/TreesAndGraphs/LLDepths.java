package TreesAndGraphs;
import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The goal is to create a list of linkedlists for D depths of a given tree
 */
public class LLDepths {

  static TreeNode root;

  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    String name;

    public TreeNode(int val, String name) {
      this.val = val;
      this.name = name;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, String name) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.name = name;
    }
  }

  public static void main(String[] args) {
    // Simple Tree Construction
    TreeNode n3 = new TreeNode(200, "n3");
    TreeNode n4 = new TreeNode(40, "n4");
    TreeNode n5 = new TreeNode(10, "n5");
    TreeNode n6 = new TreeNode(490, "n6");
    TreeNode n1 = new TreeNode(34, n3, n4, "n1");
    TreeNode n2 = new TreeNode(100, n5, n6, "n2");
    root = new TreeNode(100, n1, n2, "root");

    List<LinkedList<TreeNode>> depthList = printTreeDepths();
    for (int i = 0; i < depthList.size(); i++) {
      printLevel(depthList.get(i), i);
    }
  }

  private static void printLevel(LinkedList<TreeNode> levelList, int level) {
    System.out.println("Level: " + level);
    while (levelList.peek() != null) {
      System.out.print(levelList.pop().name + " -> ");
    }
    System.out.println("");
  }

  /**
   * Validation to output levels to depth D of a given tree
   * The trick to track the number of null encounters to determine depth in real-time
   * */

  public static List<LinkedList<TreeNode>> printTreeDepths() {
    // Going to create a new list of nodes for each depth that we encounter
    List<LinkedList<TreeNode>> depthList = new ArrayList<>();
    Queue<TreeNode> adjTracker = new LinkedList();

    adjTracker.add(root);
    depthList.add(createDepthList(adjTracker));
    adjTracker.add(null);
    int currentDepth = 0;

    while (!adjTracker.isEmpty()) {
      TreeNode tmpNode = adjTracker.poll();
      if (tmpNode == null){
        currentDepth++;
        depthList.add(createDepthList(adjTracker));
        adjTracker.add(null);
        if (adjTracker.peek() == null) break; // avoid infinite loop on double null vals
        else continue;
      }
      if (tmpNode.left != null) {
        adjTracker.add(tmpNode.left);
      }
      if (tmpNode.right != null) {
        adjTracker.add(tmpNode.right);
      }
    }
    System.out.println("The depth of the tree is " + --currentDepth);
    return depthList;
  }

  /** Get an LL representation of the current depth */
  private static LinkedList<TreeNode> createDepthList(Queue<TreeNode> currentDepthNodes) {
    Queue<TreeNode> nodeCopy = new LinkedList<>(currentDepthNodes);
    LinkedList<TreeNode> depthList = new LinkedList<>();
    while (!nodeCopy.isEmpty()) {
      depthList.add(nodeCopy.poll());
    }
    return depthList;
  }
}
