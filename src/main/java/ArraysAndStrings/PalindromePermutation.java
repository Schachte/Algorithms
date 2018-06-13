package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromePermutation {
  public static Set<String> palindromeTracker = new HashSet<>();

  public static void main(String[] args) {
    List<String> testData = ImmutableList.of(
        "test",
        "racecar",
        "tester",
        "sup",
        "cato tac"
    );

    for (String item : testData) {
      System.out.println(item + " is " + checkEvenNumberedCounts(item));
    }
  }

  public static boolean isEven(String input) {
    return input.length() % 2 == 0;
  }

  public static Map<Character, Integer> populateMap(String input)  {
    Map<Character, Integer> charCounts = new HashMap<>();
    for (Character c : input.toCharArray()) {
      charCounts.put(c, 0);
    }

    return charCounts;
  }

  public static boolean checkEvenNumberedCounts(String input) {
    Map<Character, Integer> charCounts = populateMap(input);
    int oddCount = 0;

    for (Character c : input.toCharArray()) {
      int currentVal = charCounts.get(c) + 1;
      charCounts.put(c, currentVal);
    }

    for (Character c : input.toCharArray()) {
      int currentVal = charCounts.get(c);
      if (currentVal % 2 != 0) {
        oddCount += 1;
      }
    }

    if (isEven(input) && oddCount != 0) {
      return false;
    } else if (isEven(input) && oddCount == 0) {
      return true;
    } else if (!isEven(input) && oddCount <= 1) {
      return true;
    } else {
      return false;
    }
  }

//  public static void permute(String inputString) {
//    permuteHelper(inputString, "");
//  }
//
//  public static void permuteHelper(String inputString, String chosen) {
//    if (inputString.isEmpty()) {
//      if (isPalindrome(chosen)) {
//        palindromeTracker.add(chosen);
//      }
//    } else {
//      for (int i = 0; i < inputString.length(); i++) {
//        String rem = inputString.substring(0, i) + inputString.substring(i+1);
//        permuteHelper(rem, chosen + inputString.charAt(i));
//      }
//    }
//  }
//
//  /** Checks if the input string is a palindrome */
//  private static boolean isPalindrome(String potentialPalindrome) {
//    potentialPalindrome = potentialPalindrome.replace(" ", "");
//    return potentialPalindrome.equals(new StringBuilder(potentialPalindrome).reverse().toString());
//  }
}
