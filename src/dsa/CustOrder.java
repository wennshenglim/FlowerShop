/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.Objects;

/**
 *
 * @author kky
 */
public class CustOrder {
    private CatalogOrder itemID;
    private Order orderID;
    private String custOrderID;

    public CustOrder(CatalogOrder itemID, Order orderID, String custOrderID) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.custOrderID = custOrderID;
    }

    public CatalogOrder getItemID() {
        return itemID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public String getCustOrderID() {
        return custOrderID;
    }

    public void setItemID(CatalogOrder itemID) {
        this.itemID = itemID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public void setCustOrderID(String custOrderID) {
        this.custOrderID = custOrderID;
    }

    @Override
    public String toString() {
        return "CustOrder{" + "itemID=" + itemID + ", orderID=" + orderID + ", custOrderID=" + custOrderID + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.itemID);
        hash = 97 * hash + Objects.hashCode(this.orderID);
        hash = 97 * hash + Objects.hashCode(this.custOrderID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustOrder other = (CustOrder) obj;
        if (!Objects.equals(this.custOrderID, other.custOrderID)) {
            return false;
        }
        if (!Objects.equals(this.itemID, other.itemID)) {
            return false;
        }
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        return true;
    }
    
    
}
