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
  }

}
