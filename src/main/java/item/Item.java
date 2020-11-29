package item;

import static com.google.common.base.Preconditions.checkArgument;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import lombok.RequiredArgsConstructor;
import lombok.Value;

//TODO: make it abstract when requirements over this class grow more complex
@Value
@RequiredArgsConstructor(access = PRIVATE)
public class Item {

  String name;

  // TODO: use Enum when requirements over this field grow more complex
  String category;

  boolean imported;

  public static Item of(String name, String category, boolean imported) {

    checkArgument(isNotBlank(name), "Item name must be provided");
    checkArgument(isNotBlank(category), "Item category must be provided");

    return new Item(name, category, imported);
  }
}
