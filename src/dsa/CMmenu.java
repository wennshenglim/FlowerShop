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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CMmenu {
    
    static Scanner input = new Scanner(System.in);
    static List<Product> ProductList = new ArrayList<Product>();
    
        
    
    public static void main(String[] args) {      
        
        Product Products;
        Products = new Product("P001","Red Rose","Rose","Red rose is red",13.90,12);
        ProductList.add(Products);
        Products = new Product("P002","Pink Rose","Rose","BlackPink",13.90,11);
        ProductList.add(Products);
        Products = new Product("P003","Blue Rose","Rose","Blue Ocean",13.90,22);
        ProductList.add(Products);
        
        
        FlowerShopMenu();
    }
     
    public static void FlowerShopMenu() {
        System.out.println("=====----- Welcome to FlowerShop System -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Main menu:");
            System.out.println("1 - Catalog Maintenance");
            System.out.println("2 - Customer Maintenance and Invoice Payment");
            System.out.println("3 - Catalog Orders");
            System.out.println("4 - Order Pickup / Delivery and Consumer Payment Management");
            System.out.println("0 - Exit.");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    CatalogMaintenance();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nPlease choose between 0 to 6.");
                    break;
            }
        } while (selection != 0);
    }
     
    public static int manageSelectionError() {
        int selection = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Please select method : ");
                selection = input.nextInt();

                valid = true;
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again! ");
                flush();
            }
        } while (!valid);
        return selection;
    }
    private static void CatalogMaintenance() {
        System.out.println("=====----- Welcome to Catalog Maintenance Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Catalog Maintenance Menu:");
            System.out.println("1 - Maintain Product");
            System.out.println("2 - Maintain Montly Promotion");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    MaintainProduct();
                    System.out.println();
                    break;
                case 2:
                    MaintainPromotion();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nPlease choose between 0 to 2.");
                    break;
            }
        } while (selection != 0);
    }
    private static void MaintainProduct() {
        System.out.println("=====----- Welcome to Maintain Product Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Maintain Product Menu:");
            System.out.println("1 - Add New Product");
            System.out.println("2 - Search Product");
            System.out.println("3 - Update Product");
            System.out.println("4 - Delete Product");
            System.out.println("5 - Retrieve All Product");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    AddNewProduct();
                    System.out.println();
                    break;
                case 5:
                    DisplayAllProduct();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nPlease choose between 0 to 4.");
                    break;
            }
        } while (selection != 0);
    }
     private static void AddNewProduct(){
         System.out.println("Product ID =");
         String ProductID=input.nextLine();
         System.out.println("Product Name =");
         String ProductName=input.nextLine();
         System.out.println("Product Type =");
         String ProductType=input.nextLine();
         System.out.println("Product Description =");
         String ProductDesc=input.nextLine();
         System.out.println("Product Price =");
         double ProductPrice=input.nextDouble();
         System.out.println("Product Quantity =");
         int ProductQuantity=input.nextInt();
         Product Products= new Product(ProductID,ProductName,ProductType,ProductDesc,ProductPrice, ProductQuantity);
         ProductList.add(Products);
     }
     
     
     
    private static void DisplayAllProduct(){
        System.out.println();
        System.out.println("--------|Display All Product|--------");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Product ID\tProduct Name\t\tProduct Type\t\tProduct Description\t\tProduct Price\t\tProduct "
                + "Quantity");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        if (ProductList.isEmpty()) {
            System.out.println("@@@@@@@@@@@        No record        @@@@@@@@@@@");
        } else {
            for (int i = 0; i < ProductList.size(); i++) {
			System.out.println(ProductList.get(i));
	}
        }

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
    }
    
    
    
    private static void MaintainPromotion() {
        System.out.println("=====----- Welcome to Maintain Monthly Promotion Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Maintain Product Menu:");
            System.out.println("1 - Add Promotion Product");
            System.out.println("2 - Update Promotion Product");
            System.out.println("3 - Delete Promotion Product");
            System.out.println("4 - Sort By Product Type");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nPlease choose between 0 to 1.");
                    break;
            }
        } while (selection != 0);
    }
      
    public static void flush() {
        input.nextLine();
    }
    
}
