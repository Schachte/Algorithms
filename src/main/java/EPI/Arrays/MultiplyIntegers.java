package EPI.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** The goal is to take two lists and multiply the values together */
public class MultiplyIntegers {
  public static void main(String[] args) {
    // Int 1 = 7005
    List<Integer> l1 = new ArrayList<>();
    l1.add(7);
    l1.add(0);
    l1.add(0);
    l1.add(5);

    // Int 2 = 97
    List<Integer> l2 = new ArrayList<>();
    l2.add(9);
    l2.add(7);
    List<Integer> result = multiply(l2, l1);
  }

  /** Multiplies two lists together and returns the output in a ordinal list */
  public static List<Integer> multiply(List<Integer> numl, List<Integer> num2) {
    List<Integer> result = new ArrayList<>(Collections.nCopies(numl.size() + num2.size(), 9));
    for (int i = numl.size() - 1; i >= 0; --i) {
      for (int j = num2.size() - 1; j >= 0; --j) {
        result.set(i + j + 1, result.get(i + j + 1) + numl.get(i) * num2.get(j));
        result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
        result.set(i + j + 1, result.get(i + j + 1) % 10);
      }
    }
    return result;
  }

  /** Creates a list of size X that is zeroed out */
  public static int[] init0IndexList(int size) {
    int[] data = new int[size];
    for (int i = 0; i < size; i++) {
      data[i] = 0;
    }
    return data;
  }
}
