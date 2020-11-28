package item;

import static com.google.common.base.Preconditions.checkState;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Item {

  protected String name;

  protected ItemCategory category;

  protected boolean imported;

  public Item(String name, ItemCategory category, boolean imported) {

    checkState(isNotBlank(name), "Item name must be provided");
    this.name = name;
    this.category = category;
    this.imported = imported;
  }
}
