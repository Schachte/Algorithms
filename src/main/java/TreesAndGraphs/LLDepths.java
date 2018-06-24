package TreesAndGraphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The goal is to create a list of linkedlists for D depths of a given tree
 */
public class LLDepths {
  private TreeNode root;

  /** Node structure within the tree */
  static class TreeNode {
    int val;
    String name;
    TreeNode left;
    TreeNode right;

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

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
  }

  /** Simple level printer when traversing through all the depths of the tree */
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

  public List<LinkedList<TreeNode>> generateDepthList() {
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
        LinkedList<TreeNode> tmpList = createDepthList(adjTracker);
        if (tmpList.size() > 0)
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
  private LinkedList<TreeNode> createDepthList(Queue<TreeNode> currentDepthNodes) {
    // Store copy to not override original reference
    Queue<TreeNode> nodeCopy = new LinkedList<>(currentDepthNodes);
    LinkedList<TreeNode> depthList = new LinkedList<>();
    while (!nodeCopy.isEmpty()) {
      depthList.add(nodeCopy.poll());
    }
    return depthList;
  }
}
