package Bitwise;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitSwapTest {

  @Test
  public void bitSwap() {
    assertTrue(BitSwap.bitSwap(0b1001010, 3, 4) == 82);
    assertTrue(BitSwap.bitSwap(0b10, 0, 1) == 1);
    assertTrue(BitSwap.bitSwap(0b01, 0, 1) == 2);
    assertTrue(BitSwap.bitSwap(0b1111111, 3, 4) == 127);
    assertTrue(BitSwap.bitSwap(0b1010101, 1, 2) == 83);
    assertTrue(BitSwap.bitSwap(0b11, 0, 1) == 3);
  }
}
