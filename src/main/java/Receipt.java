import static com.google.common.base.Joiner.on;
import static java.math.BigDecimal.ZERO;
import static org.apache.commons.lang3.StringUtils.SPACE;
import item.Item;
import java.math.BigDecimal;
import java.util.Collection;
import lombok.Value;
import sale.TaxedPurchase;

@Value(staticConstructor = "of")
public class Receipt {

  Collection<TaxedPurchase> purchases;

  BigDecimal total;

  BigDecimal taxTotal;

  public static Receipt from(Collection<TaxedPurchase> purchases) {

    BigDecimal total = ZERO;
    BigDecimal taxTotal = ZERO;

    for (TaxedPurchase purchase : purchases) {
      BigDecimal quantity = new BigDecimal(purchase.getQuantity());
      total = quantity.multiply(total.add(purchase.getTaxedPrice()));
      taxTotal = quantity.multiply(taxTotal.add(purchase.getAppliedTax()));
    }

    return Receipt.of(purchases, total, taxTotal);
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    getPurchases().forEach(purchase -> {
      Item item = purchase.getItem();
      stringBuilder.append(on(SPACE).join(
        item.getName(),
        "at",
        purchase.getTaxedPrice(), "\n"));
    });
    return stringBuilder.toString();
  }
}
