package EPI.Strings;

import com.google.common.collect.ImmutableList;
import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Programatically convert roman numeral into associated integer form
 * Must handle the 6 exception cases
 *
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 */
public class RomanNumeral {
  static Map<Integer, List<Integer>> romanNumerals = new HashMap<>();
  static Map<Character, Integer> romanVals = new HashMap<>();

  public static void main(String[] args) throws InvalidArgumentException {
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

    System.out.println(convertBruteForce("IV"));
    System.out.println(convertBruteForce("MCMLXXXIV"));
    System.out.println(convertBruteForce("MCMXLIV"));
  }

  /**
   * We must note the following:
   * I may precede V and X
   * V may precede X and L
   * X may precede L and M
   *
   * In the case that the values hit one of the exceptions, the program must
   * take the difference of the larger and smaller values
   *
   * IE (IV represents 1 and 5). Since V > I, val = 5 - 1 = 4
   * @param romanInput
   * @return
   */
  public static int convertBruteForce(String romanInput) throws InvalidArgumentException {
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
          throw new InvalidArgumentException(new String[]{"The input roman numeral is invalid"});
        }
      } else {
        total += romanVals.get(currentNumeral);
        prev = romanVals.get(currentNumeral);
      }
    }
    return total;
  }
}
