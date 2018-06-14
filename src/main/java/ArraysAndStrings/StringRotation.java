package ArraysAndStrings;

/**
 * Goal is to see if a string is a rotation of another string
 * racecar and rraceca for example. The second input is a singular right rotation of the input
 */
public class StringRotation {

  public static void main(String[] args) {
    System.out.println(isRotation("racecar", "rraceca"));
    System.out.println(isRotation("racecar", "rraaeca"));
    System.out.println(isRotation("waterbottle", "erbottlewat"));
    System.out.println(isRotation("hello", "llohe"));
    System.out.println(isRotation("ryan", "anry"));
    System.out.println(isRotation("raan", "anry"));
  }

  public static boolean isSubstring(String input1, String input2) {
    return input1.toLowerCase().contains(input2.toLowerCase());
  }

  public static boolean isRotation(String input1, String input2) {
    if (input1.length() != input2.length()) {
      return false;
    }
    String modifiedInput1 = new StringBuilder().append(input1).append(input1).toString();
    return isSubstring(modifiedInput1, input2);
  }
}
