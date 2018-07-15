package EPI.Strings;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert roman numeral into associated integer form
 * Must handle the 6 exception cases
 **/
public class RomanNumeral {
  static Map<Integer, List<Integer>> romanNumerals = new HashMap<>();
  static Map<Character, Integer> romanVals = new HashMap<>();

  /** Accounts for exception clauses and valdiation */
  public static int convertBruteForce(String romanInput) {
    int total = 0;
    int prev = 0;
    for (int i = romanInput.length()-1; i >= 0; i--) {
      char currentNumeral = romanInput.charAt(i);
      int currentNumeralValue = romanVals.get(currentNumeral);

      if (prev == 0) {
        total = currentNumeralValue;
        prev = currentNumeralValue;
      }
      // We have encountered a possible invalid
      else if (romanVals.get(currentNumeral) < prev) {
        if (romanNumerals.get(currentNumeralValue).contains(prev)) {
          total -= romanVals.get(currentNumeral);
          prev = romanVals.get(currentNumeral);
        } else {
          System.out.println("error");
        }
      } else {
        total += romanVals.get(currentNumeral);
        prev = romanVals.get(currentNumeral);
      }
    }
    return total;
  }

  public static int convertOptimized(String roman) {
    int total = romanVals.get(roman.charAt(roman.length()-1));
    for (int i = roman.length()-2; i >= 0; i--) {
      if (romanVals.get(roman.charAt(i)) < romanVals.get(roman.charAt(i + 1))) {
        total -= romanVals.get(roman.charAt(i));
      } else {
        total += romanVals.get(roman.charAt(i));
      }
    }
    return total;
  }

  /** Helper utility function */
  public static void fillData() {
    romanNumerals.put(1, ImmutableList.of(5, 10));
    romanNumerals.put(5, ImmutableList.of());
    romanNumerals.put(10, ImmutableList.of(50, 100));
    romanNumerals.put(50, ImmutableList.of());
    romanNumerals.put(100, ImmutableList.of(500, 1000));
    romanNumerals.put(500, ImmutableList.of());
    romanNumerals.put(1000, ImmutableList.of());

    romanVals.put('I', 1);
    romanVals.put('V', 5);
    romanVals.put('X', 10);
    romanVals.put('L', 50);
    romanVals.put('C', 100);
    romanVals.put('D', 500);
    romanVals.put('M', 1000);
  }
}
