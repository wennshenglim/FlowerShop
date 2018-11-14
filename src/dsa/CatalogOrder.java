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
public class CatalogOrder {
    private String flowerID;
    private String flowerDesc;
    private String flowerName;
    private String flowerPrice;

    public CatalogOrder(String flowerID, String flowerDesc, String flowerName, String flowerPrice) {
        this.flowerID = flowerID;
        this.flowerDesc = flowerDesc;
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerID() {
        return flowerID;
    }

    public String getFlowerDesc() {
        return flowerDesc;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerID(String flowerID) {
        this.flowerID = flowerID;
    }

    public void setFlowerDesc(String flowerDesc) {
        this.flowerDesc = flowerDesc;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerPrice(String flowerPrice) {
        this.flowerPrice = flowerPrice;
    }

    @Override
    public String toString() {
        return  flowerID +"\t\t"+ flowerDesc+"\t\t\t\t"   + flowerPrice+"\t\t\t"   + flowerName ;
    }
    
   
}
