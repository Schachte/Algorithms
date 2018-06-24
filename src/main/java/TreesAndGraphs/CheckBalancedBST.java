package TreesAndGraphs;

import TreesAndGraphs.LLDepths.TreeNode;

/**
 * Goal is to check if a binary tree is balanced and no sub-tree within the parent tree
 * differs by a height that is greater than 1.
 */
public class CheckBalancedBST {
  TreeNode rootNode;
  public TreeNode getRootNode() { return rootNode; }
  public void setRootNode(TreeNode tNode) { this.rootNode = tNode; }

  /** Gets the height of a tree sub-tree */
  public int getHeight(TreeNode node) {
    if (node == null) return -1;
    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }

  /** Checks if a b-tree is balanced (doesn't differ > 1 */
  public boolean isBalanced(TreeNode node) {
    if (node == null) return true;

    int heightDiff = Math.abs(getHeight(node.left) - getHeight(node.right));
    if (heightDiff > 1) return false;
    else {
      return isBalanced(node.left) && isBalanced(node.right);
    }
  }
}
