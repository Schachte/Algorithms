package TreesAndGraphs;

import TreesAndGraphs.LLDepths.TreeNode;

/**
 * The goal is to validate a binary search tree
 * All sub-trees need to follow the definition of x.left <= x < x.right
 */
public class BSTValidation {

  public static void main(String[] args) {
    TreeNode n5 = new TreeNode(11, null, null, "n5");
    TreeNode n4 = new TreeNode(14, n5, null, "n4");
    TreeNode n3 = new TreeNode(30, null, null, "n3");
    TreeNode n2 = new TreeNode(16, n4, null, "n2");
    TreeNode n1 = new TreeNode(20, n2, n3, "root");

    System.out.println(bstHelper(n1));
  }

  /** Simple helper to kick off the function */
  public static boolean bstHelper(TreeNode rootNode) {
    return validate(rootNode, null, null);
  }

  /** Recursive BST validation */
  public static boolean validate(TreeNode node, Integer minVal, Integer maxVal) {
    if (node == null) return true;
    if (minVal != null && node.val <= minVal || maxVal != null && node.val > maxVal) return false;
    if (!validate(node.left, minVal, node.val) || !validate(node.right, node.val, maxVal)) return false;
    return true;
  }
}
