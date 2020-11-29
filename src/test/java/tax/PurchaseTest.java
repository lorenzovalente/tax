package tax;

import static java.math.BigDecimal.ZERO;
import static org.junit.Assert.assertEquals;
import item.Item;
import java.math.BigDecimal;
import lombok.val;
import org.junit.Test;
import sale.TaxedPurchase;

public class PurchaseTest {

  @Test
  public void testPurchase() {

    val purchase = TaxedPurchase.builder().item(Item.of("Iris", "PAINTING", false)).quantity(4).unitPrice(new BigDecimal("5.15")).build();
    assertEquals(new BigDecimal("5.70"), purchase.getTaxedPrice());
  }

  @Test
  public void testPurchaseTaxExemptItems() {

    val bookPurchase = TaxedPurchase.builder().item(Item.of("book", "BOOK", false)).quantity(1).unitPrice(new BigDecimal("1.50")).build();
    val foodPurchase = TaxedPurchase.builder().item(Item.of("food", "FOOD", false)).quantity(2).unitPrice(new BigDecimal("2.50")).build();
    val medicalPurchase = TaxedPurchase.builder().item(Item.of("medical", "MEDICAL", false)).quantity(3).unitPrice(new BigDecimal("3.50")).build();

    assertEquals(new BigDecimal("1.50"), bookPurchase.getTaxedPrice());
    assertEquals(ZERO, bookPurchase.getAppliedTax());

    assertEquals(new BigDecimal("2.50"), foodPurchase.getTaxedPrice());
    assertEquals(ZERO, foodPurchase.getAppliedTax());

    assertEquals(new BigDecimal("3.50"), medicalPurchase.getTaxedPrice());
    assertEquals(ZERO, medicalPurchase.getAppliedTax());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPurchaseIsUninstantiableWhenItemNotPresent() {

    TaxedPurchase.builder().item(null).quantity(1).unitPrice(new BigDecimal("10.56")).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPurchaseIsUninstantiableWhenUnitPriceNotPresent() {

    TaxedPurchase.builder().item(Item.of("book", "BOOK", false)).quantity(1).unitPrice(null).build();
  }
}
