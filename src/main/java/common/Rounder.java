package common;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.UP;
import java.math.BigDecimal;

public abstract class Rounder {

  private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
  private static final BigDecimal FIVE = new BigDecimal("5");

  public static BigDecimal round(BigDecimal value) {

    if (null == value) {
      return ZERO;
    }

    value = value.multiply(ONE_HUNDRED);

    BigDecimal remainder = value.remainder(FIVE).setScale(2, UP);

    if (remainder.compareTo(ZERO) != 0) {
      return value.subtract(remainder).add(FIVE).setScale(2, UP).divide(ONE_HUNDRED, UP);
    }

    return value.divide(ONE_HUNDRED, CEILING).setScale(2, UP);
  }
}
