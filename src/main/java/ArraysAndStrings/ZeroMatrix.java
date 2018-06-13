package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */
public class ZeroMatrix {
  public static void main(String[] args) {

    int testMatrix[][] =
        {
          { 1, 2, 3, 4 },
          { 5, 0, 7, 8 },
          { 9, 10, 11, 12 }
        };

    List<List<Integer>> pairs = new ArrayList<>();

    for (int row = 0; row < testMatrix.length; row++) {
      for (int col = 0; col < testMatrix[0].length; col++) {
        if (testMatrix[row][col] == 0) {
          pairs.add(ImmutableList.of(row, col));
        }
      }
    }

    for (List<Integer> item : pairs) {
      zeroOutRowCol(testMatrix, item.get(0), item.get(1));
    }

    System.out.println("analyze");
  }

  public static int[][] zeroOutRowCol(int[][] matrix, int row, int col) {
    //zero out each item in the row
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }

    //zero out each item in the col
    for (int i = 0; i < matrix[0].length; i++) {
      matrix[row][i] = 0;
    }
    return matrix;
  }

}
