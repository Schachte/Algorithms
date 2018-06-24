package TreesAndGraphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import TreesAndGraphs.LLDepths.TreeNode;
import org.junit.Test;

public class CheckBalancedBSTTest {

  @Test
  public void checkBalancedIsTrue() {
    TreeNode n7 = new TreeNode(7, null, null, "n7");
    TreeNode n6 = new TreeNode(6, null, null, "n6");
    TreeNode n5 = new TreeNode(5, null, null, "n5");
    TreeNode n4 = new TreeNode(4, null, null, "n4");
    TreeNode n3 = new TreeNode(3, n6, n7, "n3");
    TreeNode n2 = new TreeNode(2, n4, n5, "n2");
    TreeNode n1 = new TreeNode(1, n2, n3, "root");

    CheckBalancedBST bst = new CheckBalancedBST();
    bst.setRootNode(n1);
    assertThat(bst.isBalanced(bst.getRootNode()), equalTo(true));
 }

  @Test
  public void checkBalancedIsTrueDifferByOne() {
    TreeNode n6 = new TreeNode(6, null, null, "n6");
    TreeNode n5 = new TreeNode(5, null, null, "n5");
    TreeNode n4 = new TreeNode(4, null, null, "n4");
    TreeNode n3 = new TreeNode(3, n6, null, "n3");
    TreeNode n2 = new TreeNode(2, n4, n5, "n2");
    TreeNode n1 = new TreeNode(1, n2, n3, "root");

    CheckBalancedBST bst = new CheckBalancedBST();
    bst.setRootNode(n1);
    assertThat(bst.isBalanced(bst.getRootNode()), equalTo(true));
  }

  @Test
  public void checkBalancedIsFalseDifferByTwo() {
    TreeNode n5 = new TreeNode(5, null, null, "n5");
    TreeNode n4 = new TreeNode(4, null, null, "n4");
    TreeNode n3 = new TreeNode(3, n5, null, "n3");
    TreeNode n2 = new TreeNode(2, n3, n4, "n2");
    TreeNode n1 = new TreeNode(1, n2, null, "root");

    CheckBalancedBST bst = new CheckBalancedBST();
    bst.setRootNode(n1);
    assertThat(bst.isBalanced(bst.getRootNode()), equalTo(false));
  }
}
