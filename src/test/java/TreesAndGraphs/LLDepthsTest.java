package TreesAndGraphs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import TreesAndGraphs.LLDepths.TreeNode;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class LLDepthsTest {

  @Test
  public void testVerificationOfListBalancedTree() {
    LLDepths depthAlgo = new LLDepths();

    // D2
    TreeNode n3 = new TreeNode(200, "n3");
    TreeNode n4 = new TreeNode(40, "n4");
    TreeNode n5 = new TreeNode(10, "n5");
    TreeNode n6 = new TreeNode(490, "n6");

    // D1
    TreeNode n1 = new TreeNode(34, n3, n4, "n1");
    TreeNode n2 = new TreeNode(100, n5, n6, "n2");

    //ROOT
    depthAlgo.setRoot(new TreeNode(100, n1, n2, "root"));

    List<LinkedList<TreeNode>> depthList = depthAlgo.generateDepthList();

    assertThat(depthList.size(), equalTo(3));

    // Test depth sizes for a balanced binary tree
    assertThat(depthList.get(0).size(), equalTo(1));
    assertThat(depthList.get(1).size(), equalTo(2));
    assertThat(depthList.get(2).size(), equalTo(4));

    // Test depth node values at each level
    assertThat(depthList.get(0).get(0).name, equalTo("root"));

    assertThat(depthList.get(1).get(0).name, equalTo("n1"));
    assertThat(depthList.get(1).get(1).name, equalTo("n2"));

    assertThat(depthList.get(2).get(0).name, equalTo("n3"));
    assertThat(depthList.get(2).get(1).name, equalTo("n4"));
    assertThat(depthList.get(2).get(2).name, equalTo("n5"));
    assertThat(depthList.get(2).get(3).name, equalTo("n6"));
  }

  @Test
  public void testVerificationSingleNode() {
    LLDepths depthAlgo = new LLDepths();

    //ROOT
    depthAlgo.setRoot(new TreeNode(100, null, null, "root"));
    List<LinkedList<TreeNode>> depthList = depthAlgo.generateDepthList();

    // Test depth sizes for a balanced binary tree
    assertThat(depthList.get(0).size(), equalTo(1));

    // Test depth node values at each level
    assertThat(depthList.get(0).get(0).name, equalTo("root"));
  }

  @Test
  public void testVerificationLinkedListShort() {
    LLDepths depthAlgo = new LLDepths();

    TreeNode tNode = new TreeNode(1000, null, null, "n1");
    depthAlgo.setRoot(new TreeNode(100, tNode, null, "root"));

    List<LinkedList<TreeNode>> depthList = depthAlgo.generateDepthList();

    assertThat(depthList.size(), equalTo(2));

    // Test depth sizes for a balanced binary tree
    assertThat(depthList.get(0).size(), equalTo(1));
    assertThat(depthList.get(1).size(), equalTo(1));

    // Test depth node values at each level
    assertThat(depthList.get(0).get(0).name, equalTo("root"));
    assertThat(depthList.get(1).get(0).name, equalTo("n1"));
  }

  @Test
  public void testVerificationLinkedListLong() {
    LLDepths depthAlgo = new LLDepths();

    TreeNode tNode5 = new TreeNode(5000, null, null, "n5");
    TreeNode tNode4 = new TreeNode(4000, tNode5, null, "n4");
    TreeNode tNode3 = new TreeNode(3000, tNode4, null, "n3");
    TreeNode tNode2 = new TreeNode(2000, tNode3, null, "n2");
    TreeNode tNode1 = new TreeNode(1000, tNode2, null, "n1");

    depthAlgo.setRoot(new TreeNode(100, tNode1, null, "root"));
    List<LinkedList<TreeNode>> depthList = depthAlgo.generateDepthList();

    assertThat(depthList.size(), equalTo(6));

    // Test depth sizes for a balanced binary tree
    assertThat(depthList.get(0).size(), equalTo(1));
    assertThat(depthList.get(1).size(), equalTo(1));
    assertThat(depthList.get(2).size(), equalTo(1));
    assertThat(depthList.get(3).size(), equalTo(1));
    assertThat(depthList.get(4).size(), equalTo(1));
    assertThat(depthList.get(5).size(), equalTo(1));

    // Test depth node values at each level
    assertThat(depthList.get(0).get(0).name, equalTo("root"));
    assertThat(depthList.get(1).get(0).name, equalTo("n1"));
    assertThat(depthList.get(2).get(0).name, equalTo("n2"));
    assertThat(depthList.get(3).get(0).name, equalTo("n3"));
    assertThat(depthList.get(4).get(0).name, equalTo("n4"));
    assertThat(depthList.get(5).get(0).name, equalTo("n5"));
  }

  @Test
  public void testVerificationScatteredTree() {
    LLDepths depthAlgo = new LLDepths();

    TreeNode tNode5 = new TreeNode(5000, null, null, "n5");
    TreeNode tNode4 = new TreeNode(4000, null, null, "n4");
    TreeNode tNode3 = new TreeNode(3000, null, tNode5, "n3");
    TreeNode tNode2 = new TreeNode(2000, tNode4, null, "n2");
    TreeNode tNode1 = new TreeNode(1000, tNode3, null, "n1");

    depthAlgo.setRoot(new TreeNode(100, tNode1, tNode2, "root"));
    List<LinkedList<TreeNode>> depthList = depthAlgo.generateDepthList();

    assertThat(depthList.size(), equalTo(4));

    // Test depth sizes for a balanced binary tree
    assertThat(depthList.get(0).size(), equalTo(1));
    assertThat(depthList.get(1).size(), equalTo(2));
    assertThat(depthList.get(2).size(), equalTo(2));
    assertThat(depthList.get(3).size(), equalTo(1));

    // Test depth node values at each level
    assertThat(depthList.get(0).get(0).name, equalTo("root"));
    assertThat(depthList.get(1).get(0).name, equalTo("n1"));
    assertThat(depthList.get(1).get(1).name, equalTo("n2"));
    assertThat(depthList.get(2).get(0).name, equalTo("n3"));
    assertThat(depthList.get(2).get(1).name, equalTo("n4"));
    assertThat(depthList.get(3).get(0).name, equalTo("n5"));
  }
}
