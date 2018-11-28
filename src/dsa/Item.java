/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author kky
 */
public class Item {
    
    private String name;
    private int quantity;

    public Item(String itemname, int numPurchased) {
        name = itemname;
       quantity = numPurchased;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", quantity=" + quantity + '}';
    }
    
    
}
