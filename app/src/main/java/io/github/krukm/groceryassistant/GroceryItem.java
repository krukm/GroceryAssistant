package io.github.krukm.groceryassistant;


public class GroceryItem {
    private String itemName;
    private boolean selected;

    public GroceryItem(String name) {
        this.itemName = name;
        selected = false;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
