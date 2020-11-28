package item;

import static item.ItemCategory.BOOK;

public class Book extends Item {

  public Book(String name, boolean imported) {
    super(name, BOOK, imported);
  }
}
