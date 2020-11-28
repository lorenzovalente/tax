package common;

import static common.Rounder.round;
import static java.math.BigDecimal.ZERO;
import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class RounderTest {

  @Test
  public void test() {

    assertEquals(round(null), ZERO);
    assertEquals(round(new BigDecimal("1.30")), new BigDecimal("1.30"));
    assertEquals(round(new BigDecimal("1.4990")), new BigDecimal("1.50"));
    assertEquals(round(new BigDecimal("4.7500")), new BigDecimal("4.75"));
    assertEquals(round(new BigDecimal("2.3750")), new BigDecimal("2.40"));
    assertEquals(round(new BigDecimal("2.7990")), new BigDecimal("2.80"));
    assertEquals(round(new BigDecimal("1.3995")), new BigDecimal("1.40"));
    assertEquals(round(new BigDecimal("1.8990")), new BigDecimal("1.90"));
    assertEquals(round(new BigDecimal("0.5625")), new BigDecimal("0.60"));
  }
}
