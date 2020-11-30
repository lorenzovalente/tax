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
      total = total.add(quantity.multiply(purchase.getTaxedPrice()));
      taxTotal = taxTotal.add(quantity.multiply(purchase.getAppliedTax()));
    }

    return Receipt.of(purchases, total, taxTotal);
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    getPurchases().forEach(purchase -> {
      Item item = purchase.getItem();
      int quantity = purchase.getQuantity();
      stringBuilder.append(on(SPACE).join(
        quantity,
        item.getName(),
        "at",
        purchase.getTaxedPrice().multiply(new BigDecimal(quantity)), "\n"));
    });
    stringBuilder.append("Sales Taxes:").append(SPACE).append(getTaxTotal()).append("\n");
    stringBuilder.append("Total:").append(SPACE).append(getTotal());
    return stringBuilder.toString();
  }
}
