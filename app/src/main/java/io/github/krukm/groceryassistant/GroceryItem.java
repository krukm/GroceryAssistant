package io.github.krukm.groceryassistant;


public class GroceryItem {
    private String itemName;

    public GroceryItem(String name) {
        this.itemName = name;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
