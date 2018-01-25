package io.github.krukm.groceryassistant;


public class GroceryItem {
    private String itemName;
    private boolean selected;
    private int quantity;
    private int aisle;

    public GroceryItem(String name, int quantity) {
        this.itemName = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }
}
