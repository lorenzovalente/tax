package tax;

import java.math.BigDecimal;
import lombok.Value;

@Value
public class SalesTaxPolicy implements TaxPolicy {

  private static final BigDecimal RATE = new BigDecimal("0.10");

  public BigDecimal applyTo(BigDecimal unitPrice) {
    return unitPrice.multiply(RATE);
  }
}
