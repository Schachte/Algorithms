package EPI.Strings;

import static org.junit.Assert.*;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTest {

  @Before
  public void setup() {
    RomanNumeral.fillData();
  }

  @Test
  public void convertBruteForce() throws InvalidArgumentException {
    assertEquals(4, RomanNumeral.convertBruteForce("IV"));
    assertEquals(1984, RomanNumeral.convertBruteForce("MCMLXXXIV"));
    assertEquals(1944, RomanNumeral.convertBruteForce("MCMXLIV"));
  }

  @Test
  public void convertOptimized() {
    assertEquals(4, RomanNumeral.convertOptimized("IV"));
    assertEquals(1984, RomanNumeral.convertOptimized("MCMLXXXIV"));
    assertEquals(1944, RomanNumeral.convertOptimized("MCMXLIV"));
  }
}
