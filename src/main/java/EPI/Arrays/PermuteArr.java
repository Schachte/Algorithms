package EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Permute an array or string
 * ----------------------------
 * The idea is:
 * Choose
 * Permute
 * Unchoose
 */
public class PermuteArr {
  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    List<Integer> output = new ArrayList<>();

    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
//    permute(input, output);
    permuteString("hello", "");

  }

  public static void permuteString(String input, String permutation) {
    if (input.isEmpty()) {
      System.out.println(permutation);
    }

    for (int i = 0; i < input.length(); i++) {
      char chosen = input.charAt(i);
      input = input.substring(0, i) + input.substring(i+1, input.length());
      permutation += chosen;

      permuteString(input, permutation);

      input = chosen + input;
      permutation = permutation.substring(0, permutation.length()-1);
    }

  }

  /** Permute arr with N! combos */
  public static void permute(List<Integer> input, List<Integer> output) {
    if (input.isEmpty()) {
      for (int item : output) {
        System.out.print(item + ", ");
      }
      System.out.println("");
    }

    for (int i = 0; i < input.size(); i++) {
      output.add(input.get(i));
      input.remove(i);

      permute(input, output);

      input.add(i, output.get(output.size()-1));
      output.remove(output.size()-1);
    }
  }
}
