package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
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
      new Pair("sup", "qua")
    );
  }

  /** Checks to see if input1/input2 is a subset of the */
  public static boolean checkPermutation(String input1, String input2) {

    // Initial edge case of inputting the string
    if (input1.length() == input1.length() && input1.equalsIgnoreCase(input2)) {
      return true;
    }
    

  }
}


