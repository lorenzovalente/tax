import static org.junit.Assert.assertEquals;
import item.Book;
import item.Food;
import item.Medical;
import item.Other;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.Test;
import sale.TaxedPurchase;

public class TaxServiceTest {

  @Test
  public void testGetReceipt() {

    Collection<TaxedPurchase> purchases = new LinkedHashSet<>();

    TaxedPurchase book = TaxedPurchase.builder().item(new Book("book", false)).quantity(1).unitPrice(new BigDecimal("12.49")).build();
    TaxedPurchase musicCd = TaxedPurchase.builder().item(new Other("music CD", false)).quantity(1).unitPrice(new BigDecimal("14.99")).build();
    TaxedPurchase chocolateBar = TaxedPurchase.builder().item(new Food("chocolate bar", false)).quantity(1).unitPrice(new BigDecimal("0.85")).build();
    TaxedPurchase importedBoxOfChocolates = TaxedPurchase.builder().item(new Food("imported box of chocolates", true)).quantity(1).unitPrice(new BigDecimal("10.00")).build();
    TaxedPurchase importedBottleOfPerfume = TaxedPurchase.builder().item(new Other("imported bottle of perfume", true)).quantity(1).unitPrice(new BigDecimal("47.50")).build();
    TaxedPurchase importedBottleOfPerfume2 = TaxedPurchase.builder().item(new Other("imported bottle of perfume", true)).quantity(1).unitPrice(new BigDecimal("27.99")).build();
    TaxedPurchase bottleOfPerfume = TaxedPurchase.builder().item(new Other("bottle of perfume", false)).quantity(1).unitPrice(new BigDecimal("18.99")).build();
    TaxedPurchase packedOfHeadachePills = TaxedPurchase.builder().item(new Medical("packet of headache pills", false)).quantity(1).unitPrice(new BigDecimal("9.75")).build();
    TaxedPurchase boxOfImportedChocolates = TaxedPurchase.builder().item(new Food("box of imported chocolates", true)).quantity(1).unitPrice(new BigDecimal("11.25")).build();

    purchases.add(book);
    purchases.add(musicCd);
    purchases.add(chocolateBar);
    purchases.add(importedBoxOfChocolates);
    purchases.add(importedBottleOfPerfume);
    purchases.add(importedBottleOfPerfume2);
    purchases.add(bottleOfPerfume);
    purchases.add(packedOfHeadachePills);
    purchases.add(boxOfImportedChocolates);

    Receipt receipt = Receipt.from(purchases);

    Collection<TaxedPurchase> taxedPurchases = receipt.getPurchases();

    assertEquals(9, taxedPurchases.size());

    assertEquals(new BigDecimal("169.66"), receipt.getTotal());
    assertEquals(new BigDecimal("15.85"), receipt.getTaxTotal());

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
}
