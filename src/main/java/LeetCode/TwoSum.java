package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the
 * same element twice.
 */
public class TwoSum {

  public static void main(String[] args) {
    int targetSum = 14;
    int[] dataArr = new int[] {2, 11, 15, 7};
    int[] result = indexFinder(targetSum, dataArr);
    System.out.println(result[0] + ", " + result[1]);
  }

  public static int[] indexFinder(int targetSum, int[] dataArr) {
    Map<Integer, Integer> tracker = new HashMap<>();

    for (int i = 0; i < dataArr.length; i++) {
      if (tracker.containsKey(targetSum - dataArr[i])) {
        return new int[]{tracker.get(targetSum - dataArr[i]), i};
      }
      tracker.put(dataArr[i], i);
    }
    return new int[]{-1, -1};
  }
}
