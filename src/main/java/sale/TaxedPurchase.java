package sale;

import static java.math.BigDecimal.ZERO;
import static tax.TaxPolicySupplier.policiesFrom;
import item.Item;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import tax.TaxPolicy;

@Value
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TaxedPurchase extends Purchase {

  BigDecimal taxedPrice;

  BigDecimal appliedTax;

  @Builder
  private TaxedPurchase(Item item, int quantity, BigDecimal unitPrice) {
    super(quantity, item, unitPrice);

    BigDecimal taxedPrice = unitPrice;
    BigDecimal appliedTax = ZERO;

    for (TaxPolicy policy : policiesFrom(item)) {
      BigDecimal unitPriceAfterTax = policy.applyTo(unitPrice);
      appliedTax = appliedTax.add(unitPriceAfterTax);
      taxedPrice = taxedPrice.add(unitPriceAfterTax);
    }

    this.taxedPrice = taxedPrice;
    this.appliedTax = appliedTax;
  }
}
