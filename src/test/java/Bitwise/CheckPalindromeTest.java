package Bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckPalindromeTest {
  CheckPalindrome palindrome = new CheckPalindrome();

  @Test
  public void checkPalindrome() {
    assertTrue(palindrome.checkPalindrome(0b1000000001));
    assertTrue(palindrome.checkPalindrome(0b1001));
    assertFalse(palindrome.checkPalindrome(0b01011));
    assertFalse(palindrome.checkPalindrome(0b100001000001));
    assertTrue(palindrome.checkPalindrome(0b100000010000001));
//    assertTrue(palindrome.checkPalindrome(0));
//    assertTrue(palindrome.checkPalindrome(1));
//    assertTrue(palindrome.checkPalindrome(7));
//    assertTrue(palindrome.checkPalindrome(11));
//    assertTrue(palindrome.checkPalindrome(121));
//    assertTrue(palindrome.checkPalindrome(333));
//    assertTrue(palindrome.checkPalindrome(2147447412));
    // 0,1,7,11,121,333, and 2147447412, and false for the inputs -1,12,100, and 2147483647.
  }

}
