package item;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import org.junit.Test;

public class ItemTest {

  @Test(expected = IllegalArgumentException.class)
  public void testItemIsUninstantiableWhenNameIsNull() {

    Item.of(null, "BOOK", false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testItemIsUninstantiableWhenNameIsBlank() {

    Item.of(EMPTY, "FOOD", false);

  }
  @Test(expected = IllegalArgumentException.class)
  public void testItemIsUninstantiableWhenCategoryIsNull() {

    Item.of("book", null, false);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testItemIsUninstantiableWhenCategoryIsBlank() {

    Item.of("medical", EMPTY, false);
  }
}
