package ArraysAndStrings;

import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Overall goal is to be able to check if all characters within a given string are unique
 */
public class IsUnique {
  private static Set<Character> charSet = new HashSet<>();

  public static void main(String[] args) {
    ImmutableList.of(
        "unique",
        "aaa",
        "ana",
        "this is a test",
        "ryan",
        "zmxnjdu",
        "zxcvbnmz",
        "asddfghk"
    )
       .stream()
       .filter(IsUnique::isUnique)
       .forEach(System.out::println);
  }

  /**
   * Determines if an input string is unique or not
   * @return true if the input string is unique
   */
  public static boolean isUnique(String input) {

    for (char x : input.toCharArray()) {
      if (charSet.contains(x)) {
        return false;
      }
      charSet.add(x);
    }
    return true;
  }
}
