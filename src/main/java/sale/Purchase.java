package sale;

import static com.google.common.base.Preconditions.checkArgument;
import item.Item;
import java.math.BigDecimal;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Purchase {

   int quantity;

   Item item;

   BigDecimal unitPrice;

   Purchase(int quantity, Item item, BigDecimal unitPrice) {

      checkArgument(item != null, "Item must be provided");
      checkArgument(unitPrice != null, "Unit price must be provided");
      this.quantity = quantity;
      this.item = item;
      this.unitPrice = unitPrice;
   }
}
