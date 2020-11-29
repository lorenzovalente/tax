package tax;

import item.Item;
import java.util.Collection;
import java.util.HashSet;

public class TaxPolicySupplier {

  public static Collection<TaxPolicy> supplyFor(Item item) {

    Collection<TaxPolicy> policies = new HashSet<>();
    if (!isTaxExempt(item.getCategory())) {
      policies.add(new SalesTaxPolicy());
    }
    if (item.isImported()) {
      policies.add(new ImportDutyTaxPolicy());
    }
    return policies;
  }

  private static boolean isTaxExempt(String category) {
    return category.equalsIgnoreCase("book") || category.equalsIgnoreCase("food") || category.equalsIgnoreCase("medical");
  }

}
