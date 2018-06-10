package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;

/**
 * Idea is to check if one string is a permutation of another.. In other words.. Check if a given
 * string is a subset of another string
 */
public class CheckPermutation {
  public static void main(String[] args) {
    List<Pair<String, String>> testData = ImmutableList.of(
      new Pair("ryan", "an"),
      new Pair("hello", "ell"),
      new Pair("sup", "qua"),
      new Pair("yellow", "wolley"),
      new Pair("schachte", "schachte")
    );

    testData
        .stream()
        .filter(pair -> CheckPermutation.checkPermutation(pair.getKey(), pair.getValue()))
        .forEach(pair -> System.out.println(pair.getKey() + " " + pair.getValue()));
  }

  /** Checks to see if input1/input2 is a subset of the */
  public static boolean checkSubset(String input1, String input2) {

    // Initial edge case of inputting the string
    if (input1.length() == input1.length() && input1.equalsIgnoreCase(input2)) {
      return true;
    }

    if (input1.length() > input2.length()) {
      return input1.contains(input2);
    }
    return input2.contains(input1);
  }

  public static boolean checkPermutation(String input1, String input2) {
    char[] input1Char = input1.toCharArray();
    char[] input2Char = input2.toCharArray();

    Arrays.sort(input1Char);
    Arrays.sort(input2Char);

    return Arrays.toString(input1Char).equals(Arrays.toString(input2Char));
  }
}


