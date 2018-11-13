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
public class Product {
    private String ProductID;
    private String ProductName;
    private String ProductDesc;
    private double ProductPrice;
    private int ProductQuantity;
    private String ProductType;

    public Product(String ProductID, String ProductName,String ProductType, String ProductDesc, double ProductPrice, int ProductQuantity) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductDesc = ProductDesc;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ProductType = ProductType;
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

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int ProductQuantity) {
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
    
    

    
}
