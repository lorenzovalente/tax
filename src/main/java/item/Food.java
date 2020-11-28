package item;

import static item.ItemCategory.FOOD;

public class Food extends Item {

  public Food(String name, boolean imported) {
    super(name, FOOD, imported);
  }
}
