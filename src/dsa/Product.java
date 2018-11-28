/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 * @author LIM
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private String ProductID;
    private String ProductName;
    private String ProductDesc;
    private String ProductPrice;
    private String ProductQuantity;
    private String ProductType;
    
    
    private static int nextID=1;


//    public Product(String ProductID, String ProductName,String ProductType, String ProductDesc, String ProductPrice, String ProductQuantity) {
//        this.ProductID = ProductID;
//        this.ProductName = ProductName;
//        this.ProductDesc = ProductDesc;
//        this.ProductPrice = ProductPrice;
//        this.ProductQuantity = ProductQuantity;
//        this.ProductType = ProductType;
//    }

        public Product(String ProductName, String ProductType,String ProductDesc, String ProductPrice, String ProductQuantity) {
        this.ProductName = ProductName;
        this.ProductDesc = ProductDesc;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ProductType = ProductType;
        this.ProductID="P" + String.format ("%04d",nextID);
        generateID();
    }
   
    
    public void generateID()
    {
         nextID ++;
    }
    

    
//    public Product(String ProductID) {
//        this.ProductID = ProductID;
//    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String ProductDesc) {
        this.ProductDesc = ProductDesc;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public String getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(String ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }
   

    

    @Override
    public String toString() {
        return ProductID + "\t\t" + ProductName + "\t\t" + ProductType +"\t\t\t"+ ProductDesc + "\t\t\t" + ProductPrice + "\t\t\t" + ProductQuantity + "\t\t\t";
    }

     public String toStringID() {
        return ProductID;
    }
    
    

    
}
