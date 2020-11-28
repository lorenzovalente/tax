package item;

import static item.ItemCategory.MEDICAL;

public class Medical extends Item {

  public Medical(String name, boolean imported) {
    super(name, MEDICAL, imported);
  }
}
