package tax;

import java.math.BigDecimal;

public interface TaxPolicy {

  BigDecimal applyTo(BigDecimal price);
}
