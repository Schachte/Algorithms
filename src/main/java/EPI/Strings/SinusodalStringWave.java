package EPI.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Output string sinusodially in snake form
 */
public class SinusodalStringWave {

  public static void main(String[] args) {

  }

  public void sine(String input) {
    List<List<Character>> sineData = new ArrayList<>();
    sineData.add(0, new ArrayList<>());
    sineData.add(1, new ArrayList<>());
    sineData.add(2, new ArrayList<>());
    sineData.get(2).add(input.charAt(0));

    for (int i = 1; i < input.length(); i++) {
      if (i % 3 == 0) {
        sineData.get(0).add(input.charAt(i));
      }

      if (i % 2 == 0) {
        sineData.get(1).add(input.charAt(i));
      }

      if (i % 1 == 1) {
        sineData.get(1).add(input.charAt(i));
      }
    }
  }
}
