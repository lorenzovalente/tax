import static org.junit.Assert.assertEquals;
import item.Item;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.Test;
import sale.TaxedPurchase;

public class ReceiptTest {

  @Test
  public void test() {

    Receipt receipt = Receipt.from(purchases());

    assertEquals(new BigDecimal("169.66"), receipt.getTotal());
    assertEquals(new BigDecimal("15.85"), receipt.getTaxTotal());

    Collection<TaxedPurchase> taxedPurchases = receipt.getPurchases();

    assertEquals(9, taxedPurchases.size());

    Iterator<TaxedPurchase> iterator = taxedPurchases.iterator();

    assertEquals(new BigDecimal("12.49"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("16.49"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("0.85"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("10.50"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("54.65"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("32.19"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("20.89"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("9.75"), iterator.next().getTaxedPrice());
    assertEquals(new BigDecimal("11.85"), iterator.next().getTaxedPrice());
  }

  private Collection<TaxedPurchase> purchases() {
    Collection<TaxedPurchase> purchases = new LinkedHashSet<>();

    TaxedPurchase book = TaxedPurchase.builder().item(Item.of("book", "BOOK", false)).quantity(1).unitPrice(new BigDecimal("12.49")).build();
    TaxedPurchase musicCd = TaxedPurchase.builder().item(Item.of("music CD", "MUSIC", false)).quantity(1).unitPrice(new BigDecimal("14.99")).build();
    TaxedPurchase chocolateBar = TaxedPurchase.builder().item(Item.of("chocolate bar", "FOOD", false)).quantity(1).unitPrice(new BigDecimal("0.85")).build();
    TaxedPurchase importedBoxOfChocolates = TaxedPurchase.builder().item(Item.of("imported box of chocolates", "FOOD", true)).quantity(1).unitPrice(new BigDecimal("10.00")).build();
    TaxedPurchase importedBottleOfPerfume = TaxedPurchase.builder().item(Item.of("imported bottle of perfume", "COSMETICS", true)).quantity(1).unitPrice(new BigDecimal("47.50")).build();
    TaxedPurchase importedBottleOfPerfume2 = TaxedPurchase.builder().item(Item.of("imported bottle of perfume", "COSMETICS", true)).quantity(1).unitPrice(new BigDecimal("27.99")).build();
    TaxedPurchase bottleOfPerfume = TaxedPurchase.builder().item(Item.of("bottle of perfume", "COSMETICS", false)).quantity(1).unitPrice(new BigDecimal("18.99")).build();
    TaxedPurchase packedOfHeadachePills = TaxedPurchase.builder().item(Item.of("packet of headache pills", "MEDICAL", false)).quantity(1).unitPrice(new BigDecimal("9.75")).build();
    TaxedPurchase boxOfImportedChocolates = TaxedPurchase.builder().item(Item.of("box of imported chocolates", "FOOD", true)).quantity(1).unitPrice(new BigDecimal("11.25")).build();

    purchases.add(book);
    purchases.add(musicCd);
    purchases.add(chocolateBar);
    purchases.add(importedBoxOfChocolates);
    purchases.add(importedBottleOfPerfume);
    purchases.add(importedBottleOfPerfume2);
    purchases.add(bottleOfPerfume);
    purchases.add(packedOfHeadachePills);
    purchases.add(boxOfImportedChocolates);

    return purchases;
  }
}
