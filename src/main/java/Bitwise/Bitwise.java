package Bitwise;

public class Bitwise {
  public int countSetBits(int input) {
    int setBits = 0;
    while (input > 0) {
      setBits += input & 1;
      input >>= 1;
    }
    return setBits;
  }

  public int countSetBitsRecursive(int input) {
    if (input == 0) return 0;
    return (input & 1) + countSetBitsRecursive(input >> 1);
  }
}
