package sale;

import static lombok.AccessLevel.PROTECTED;
import item.Item;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
@RequiredArgsConstructor(access = PROTECTED)
public class Purchase {

   protected int quantity;

   protected Item item;

   protected BigDecimal unitPrice;
}
