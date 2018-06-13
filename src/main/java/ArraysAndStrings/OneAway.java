package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class OneAway {
  public static void main(String[] args) {
    List<List<String>> inputList = new ArrayList<>();

    inputList.add(ImmutableList.of("ac", "acd"));
    inputList.add(ImmutableList.of("ryn", "ryan"));

    for (int i = 0; i < inputList.size(); i++) {
      System.out.println(checkInsert(inputList.get(i).get(0), inputList.get(i).get(1)));
    }
  }

  /** Checks that input is one insert away from the output */
  public static boolean checkInsert(String input, String output) {

    // Ensure that the length differs by exactly one character
    if (input.length() != output.length() - 1 && !input.equals(output)) {
      return false;
    }

    char[] inputArr = input.toCharArray();
    char[] outputArr = output.toCharArray();
    int missteps = 0;

    for (int i = 0; i < inputArr.length; i++) {
      if (missteps > 1) {
        return false;
      }
      if (inputArr[i + missteps] != outputArr[i]) {
        missteps += 1;
      }
    }

    return missteps <= 1;
  }

  /** Checks that the input is one replacement away from the output */
  public static boolean checkReplace(String input, String output) {

    if (input.length() != output.length()) {
      return false;
    }

    char[] inputArr = input.toCharArray();
    char[] outputArr = output.toCharArray();

    int missteps = 0;

    for (int i = 0; i < inputArr.length; i++) {
      if (inputArr[i] != outputArr[i]) {
        missteps += 1;
      }
    }
    return missteps == 1;
  }
}
