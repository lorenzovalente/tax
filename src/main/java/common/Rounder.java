package common;

import static java.math.BigDecimal.ZERO;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Rounder {

  private static final BigDecimal POINT_FIVE = new BigDecimal("0.05");

  public static BigDecimal round(BigDecimal value) {

    if (null == value) {
      return ZERO;
    }
    return value.setScale(2, RoundingMode.UP);
  }
}
