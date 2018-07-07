package Bitwise;


/**
 * Count number of bits to convert one letter to another (ASCII)
 */
public class NumBitFlipsConversion {

  public static int countReqBitFlips(int input1, int input2) {
    int flips = 0;
    int result = input1 ^ input2;
    System.out.println("The value of the result is " + Integer.toBinaryString(result));
    while (result > 0) {
      int tempComputation = result >>= 1;
      flips += tempComputation;
      System.out.println("Flips is " + Integer.toBinaryString(result));
    }
    return flips;
  }
}

