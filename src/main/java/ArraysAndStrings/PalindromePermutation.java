package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

    for (String testItem : testData) {
      permute(testItem);
      if (palindromeTracker.size() > 0) {
        System.out.println(testItem + " is true");
      } else {
        System.out.println(testItem + " is false");
      }
      palindromeTracker = new HashSet<>();
    }
  }

  public static void permute(String inputString) {
    permuteHelper(inputString, "");
  }

  public static void permuteHelper(String inputString, String chosen) {
    if (inputString.isEmpty()) {
      if (isPalindrome(chosen)) {
        palindromeTracker.add(chosen);
      }
    } else {
      for (int i = 0; i < inputString.length(); i++) {
        String rem = inputString.substring(0, i) + inputString.substring(i+1);
        permuteHelper(rem, chosen + inputString.charAt(i));
      }
    }
  }

  /** Checks if the input string is a palindrome */
  private static boolean isPalindrome(String potentialPalindrome) {
    potentialPalindrome = potentialPalindrome.replace(" ", "");
    return potentialPalindrome.equals(new StringBuilder(potentialPalindrome).reverse().toString());
  }
}
