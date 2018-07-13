package Bitwise;

public class BitSwap {
  public static long bitSwap(long input, int swp1, int swp2) {
    if ((input >> swp1 & 1) != (input >> swp2 & 1)) {
      long bitmask = (1L << swp1) | (1L << swp2);
      return bitmask ^ input;
    }
    return input;
  }
}
