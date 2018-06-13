package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.List;
import util.Util;

/**
 * Goal is to take a string like aabbccccaa and turn it into a2b2c3a2
 * If the output string is longer than the input string then return the original string
 */
public class StringCompression {
  public static void main(String[] args) {
    ImmutableList<String> testData = ImmutableList.of(
        "aabbccddddaa",
        "abc",
        "aaaaaaabb"
    );

    testData
        .stream()
        .map(StringCompression::compressInput)
        .forEach(System.out::println);
  }

  /** BRUTE FORCE SOLUTION */
  /** Compress the string to contains char counts */
  public static String compressInput(String input) {
    Character prevChar = null;
    StringBuilder outputString = new StringBuilder();
    int counter = 0;

    prevChar = input.toCharArray()[0];

    for (Character inputChar : input.toCharArray()) {
      if (inputChar != prevChar) {
        outputString.append(prevChar);
        outputString.append(counter);
        counter = 0;
        prevChar = inputChar;
      }
      counter+=1;
    }

    outputString.append(prevChar);
    outputString.append(counter);

    // How to we pre-optimize this?
    if (outputString.toString().length() > input.length()) {
      return input;
    }
    return outputString.toString();
  }
}
