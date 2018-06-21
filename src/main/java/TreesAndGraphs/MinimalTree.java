package TreesAndGraphs;

/** The goal is to create a b-tree from a sorted array with minimal height */
public class MinimalTree {

  /** Going to use to construct the tree data structure */
  private static class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    private int nodeVal;

    public TreeNode(int nodeVal) {
      this.nodeVal = nodeVal;
    }
  }

  public static void main(String[] args) {
    /**
     * We want to recrusively reconstruct the tree based on sub-arrays about the
     * continuously calculated middle element.
     * The mid element of each subarray will represent the sub-tree root in an attempt to keep
     * the tree as balanced as possible
     */
    int[] dataArry = new int[]{1,2,3,4,5,6,7,8,9,10,11};
    TreeNode minBST = minBST(dataArry, 0, dataArry.length-1);
    System.out.println("");
  }

  /**
   * Constructs a BST of minimal height that is balanced
   *
   * @param dataArr sorted list of integer node vals
   * @param start index of the subarray
   * @param end index of the subarray
   * @return root of the entire balanced BST
   */
  public static TreeNode minBST(int[] dataArr, int start, int end) {

    if (end < start) {
      return null;
    }

    int mid = start + end / 2;

    TreeNode rootNode = new TreeNode(dataArr[mid]);

    rootNode.left = minBST(dataArr, start, mid-1);
    rootNode.right = minBST(dataArr, mid + 1, end);

    return rootNode;
  }
}
