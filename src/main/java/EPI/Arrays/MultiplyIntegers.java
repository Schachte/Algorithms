package EPI.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * The goal is to take two lists and multiply the values together
 */
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
    int[] result = multiply(l2, l1);
  }

  /** Multiplies two lists together and returns the output in a ordinal list */
  public static int[] multiply(List<Integer> l1, List<Integer> l2) {

    // Give enough space to store the resultant operation into
    int[] result = init0IndexList(l1.size() * l2.size());

    for (int i = l1.size()-1; i >= 0; --i) {
      for (int j = l2.size()-1; j >= 0; --j) {
        result[i+j+1] = l1.get(i) * l2.get(j);
        result[i+j] += result[i+j+1] / 10;
        result[i+j+1] = result[i+j+1] % 10;
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
