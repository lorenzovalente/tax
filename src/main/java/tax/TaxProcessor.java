package tax;

import static item.ItemCategory.BOOK;
import static item.ItemCategory.FOOD;
import static item.ItemCategory.MEDICAL;
import item.Item;
import item.ItemCategory;
import java.util.Collection;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaxProcessor {

  public static Collection<TaxPolicy> policiesFrom(Item item) {

    Collection<TaxPolicy> policies = new HashSet<>();
    if (!isTaxExempt(item.getCategory())) {
      policies.add(new SalesTaxPolicy());
    }
    if (item.isImported()) {
      policies.add(new ImportDutyTaxPolicy());
    }
    return policies;
  }

  private static boolean isTaxExempt(ItemCategory category) {
    return BOOK == category || FOOD == category || MEDICAL == category;
  }

}
