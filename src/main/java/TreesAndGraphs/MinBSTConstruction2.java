package TreesAndGraphs;

import graph.api.Node;
import graph.impl.NodeImpl;
import java.util.ArrayList;
import java.util.List;

public class MinBSTConstruction2 {
  public static void main(String[] args) throws IllegalArgumentException{
    testValid();
  }

  private static Node createMinBST(int[] input, int start, int end) {
    if (end < start) return null;

    int midPoint = (start + end)/2;
    Node root = new NodeImpl(input[midPoint]);
    root.addLeftChild(createMinBST(input, start, midPoint-1));
    root.addRightChild(createMinBST(input, midPoint+1, end));

    return root;
  }

  private static List<Integer> inOrder(Node<String, Integer> root, List<Integer> vals) {
    if (root != null) {
      inOrder(root.getLeft(), vals);
      vals.add(root.getNodeData());
      inOrder(root.getRight(), vals);
    }
    return vals;
  }

  public static void testValid() {
    int[] inputArr = new int[]{1,5,12,17,21,38,52};
    Node root = createMinBST(inputArr, 0, inputArr.length-1);
    List<Integer> sortedArr = inOrder(root, new ArrayList<>());
    if (inputArr.length == sortedArr.size()) {
      for (int i = 0; i < inputArr.length; i++) {
        if (inputArr[i] != sortedArr.get(i)) {
            throw new IllegalArgumentException("Error");
        }
      }
    } else {
      throw new IllegalArgumentException("Error");
    }
  }
}
