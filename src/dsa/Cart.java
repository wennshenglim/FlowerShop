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
public class Cart {

    private String cartID = "C00001";
    private int itemCount;
    private Item[] cart;
    private int capacity;

    public Cart(String cartID, Item[] cart) {
        this.cartID = cartID;
        this.cart = cart;
    }

    public Cart(String cartID, int itemCount, Item[] cart, int capacity) {
        this.cartID = cartID;
        this.itemCount = itemCount;
        this.cart = cart;
        this.capacity = capacity;
    }

    public Cart() {
        capacity = 5;
        cart = new Item[capacity];
        itemCount = 0;
    }

    public void addToCart(String itemname, int quantity) {
        Item temp = new Item(itemname, quantity);
        cart[itemCount] = temp;
        itemCount += 1;
        if (itemCount == capacity) {
            increaseSize();
        }
    }

    public String getCartID() {
        return cartID;
    }

    public Item[] getCart() {
        return cart;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public void setCart(Item[] cart) {
        this.cart = cart;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public java.lang.String toString() {
       // System.out.println(cartID);
      //  System.out.print("Item : ");
       for (int i = 0; i < itemCount; i++) {
         System.out.print(cart[i]+", ");
            
        }
      //  System.out.println();
        return String.format( cartID + "\t" + cart);
       
    }

    private void increaseSize() {
        Item[] temp = new Item[capacity + 3];
        for (int i = 0; i < capacity; i++) {
            temp[i] = cart[i];
        }
        cart = temp;
        temp = null;
        capacity = cart.length;
    }

}
