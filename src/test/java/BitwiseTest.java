import static org.junit.Assert.*;

import Bitwise.Bitwise;
import org.junit.Test;

public class BitwiseTest {

  Bitwise bitwise = new Bitwise();

  @Test
  public void countSetBits() {
    assertEquals(2, bitwise.countSetBits(6));
  }

  @Test
  public void countSetBitsRecursive() {
    assertEquals(2, bitwise.countSetBitsRecursive(6));
  }
}
