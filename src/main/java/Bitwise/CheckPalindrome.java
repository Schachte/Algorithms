package Bitwise;

public class CheckPalindrome {

  /** Reverses the binary representation of an integer and checks if it equals
   * the input to validate whether or not it's a palindrome.
   * @param input
   * @return true if the input is a palindrome
   */
  public boolean checkPalindrome(int input) {
    int rev = 0;
    int inBk = input;
    while (input > 0) {
      rev <<= 1;
      if ((input & 1) == 1) {
        rev ^= 1;
      }
      input >>= 1;
    }
    return rev == inBk;
  }
}
