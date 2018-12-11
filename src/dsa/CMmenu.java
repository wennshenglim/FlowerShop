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
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";
    static Product Products; 
    
    public static void main(String[] args) {      
        
        Product Products;

        Products = new Product("Sunflowers","Fresh Flowers      ","Red rose is red","13.90","12");
        ProductList.add(Products);
        Products = new Product("Pink Rose","Floral Arrangements","Black Pink","13.90","11");
        ProductList.add(Products);
        Products = new Product("Blue Rose","Flower Bouquets    ","Blue Ocean","13.90","22");
        ProductList.add(Products);
        
        
        FlowerShopMenu();
    }
     
    public static void FlowerShopMenu() {
        
        int selection;
        do {
            System.out.println("=====----- Welcome to FlowerShop System -----=====");
            System.out.println();
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
                System.out.println(ANSI_RED+"Invalid input. Please try again! "+ANSI_RESET);
                flush();
            }
        } while (!valid);
        return selection;
    }
    private static void CatalogMaintenance() {
        
        int selection;
        do {
            System.out.println("=====----- Welcome to Catalog Maintenance Menu -----=====");
        System.out.println();
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
        
        int selection;
        do {
            System.out.println("=====----- Welcome to Maintain Product Menu -----=====");
            System.out.println();
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
                case 2:
                    SearchProduct();
                    System.out.println();
                    break;
                case 3:
                    UpdateMenu();
                    System.out.println();
                    break;
                case 4:
                    DeleteProduct();
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
        //String ProductID=Products.getProductID();
        // System.out.print("Product ID : "+ProductID);
         System.out.print("Product Name : ");
         String ProductName=input.nextLine();
         ProductTypeMenu();
         String ProductType=input.nextLine();
         System.out.print("Product Description : ");
         String ProductDesc=input.nextLine();
         System.out.print("Product Price : ");
         String ProductPrice=input.nextLine();
         
         boolean checkDouble=false;
         do{
             try{
                    double num = Double.parseDouble(ProductPrice);
                    checkDouble=true;
        } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    System.out.print("Product Price : ");
                    ProductPrice=input.nextLine();
                    checkDouble=false;
        }}while(checkDouble!=true);
         System.out.print("Product Quantity : ");
         String ProductQuantity=input.nextLine();
         boolean checkInt=false;
         do{
             try{
                    int num = Integer.parseInt(ProductQuantity);
                    checkInt=true;
        } catch (NumberFormatException e) {
                    System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    System.out.print("Product Quantity : ");
                    ProductQuantity=input.nextLine();
                    checkInt=false;
        }}while(checkInt!=true); 
         
         
//         System.out.print("Conformation : ");
//         System.out.print("Product Name : "+ProductName);
         Product Products= new Product(ProductName,ProductType,ProductDesc,ProductPrice, ProductQuantity);
         ProductList.add(Products);
         System.out.println(ANSI_GREEN+"Product Added Successfully!!!"+ANSI_RESET);
     }
    private static void SearchProduct(){
        System.out.print("Enter Product ID To Search: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         for(Product Products:ProductList)
         {
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        
                System.out.println(Products);
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;     
            }         
         }
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              SearchProduct();        
         }   
    }
    
    private static void UpdateProductPrice(){
         System.out.print("Enter Product ID To Update Product Price: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println(Products);
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;   
                  if(resultID==true)
            {
                char choice1;
                do{
                System.out.print("Do you want to update this product? (Y/N): ");
                   choice1 = input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                       flush();
                       System.out.print("Enter Product Price For Update Product: ");
                       String ProductPrice=input.nextLine();
                       boolean checkDouble=false;
                       do{
                           try{
                                  double num = Double.parseDouble(ProductPrice);
                                  checkDouble=true;
                      } catch (NumberFormatException e) {
                                  System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                  System.out.print("Enter Product Price For Update Product: ");
                                  ProductPrice=input.nextLine();
                                  checkDouble=false;
                      }}while(checkDouble!=true);
                       Products.setProductPrice(ProductPrice);
                       ProductList.set(count, Products);
                       System.out.println(ANSI_GREEN+"Product Price Updated Successful!!!\n"+ANSI_RESET);
                       MaintainProduct();
                   }
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }  
                   
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductPrice();
         }
    }
    
    private static void UpdateProductName(){
         System.out.print("Enter Product ID To Update Product Name: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println(Products);
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;  
                  if(resultID==true)
            {
                char choice1;
                do{
                System.out.print("Do you want to update this product? (Y/N): ");
                   choice1 = input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                       flush();
                       System.out.print("Enter Product Name For Update Product: ");
                       String ProductName=input.nextLine();
                       Products.setProductName(ProductName);
                       ProductList.set(count, Products);
                       System.out.println(ANSI_GREEN+"Product Name Updated Successful!!!\n"+ANSI_RESET);
                       MaintainProduct();
                   }
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }   
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductName();
         }
    }
    
    private static void UpdateProductDesc(){
         System.out.print("Enter Product ID To Update Product Description: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println(Products);
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;  
                  if(resultID==true)
            {
                char choice1;
                do{
                System.out.print("Do you want to update this product? (Y/N): ");
                   choice1 = input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                       flush();
                       System.out.print("Enter Product Description For Update Product: ");
                       String ProductDesc=input.nextLine();
                       Products.setProductDesc(ProductDesc);
                       ProductList.set(count, Products);
                       System.out.println(ANSI_GREEN+"Product Description Updated Successful!!!\n"+ANSI_RESET);
                       MaintainProduct();
                   }
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }   
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductDesc();
         }
    }
    
     private static void UpdateProductQuantity(){
         System.out.print("Enter Product ID To Update Product Quantity: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println(Products);
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;  
                  if(resultID==true)
            {
                char choice1;
                do{
                System.out.print("Do you want to update this product? (Y/N): ");
                   choice1 = input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                       flush();
                       System.out.print("Enter Product Quantity For Update Product : ");
                        String ProductQuantity=input.nextLine();
                        boolean checkInt=false;
                        do{
                            try{
                                   int num = Integer.parseInt(ProductQuantity);
                                   checkInt=true;
                       } catch (NumberFormatException e) {
                                   System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   System.out.print("Enter Product Quantity For Update Product : ");
                                   ProductQuantity=input.nextLine();
                                   checkInt=false;
                       }}while(checkInt!=true); 
                       Products.setProductQuantity(ProductQuantity);
                       ProductList.set(count, Products);
                       System.out.println(ANSI_GREEN+"Product Quantity Updated Successful!!!\n"+ANSI_RESET);
                       MaintainProduct();
                   }
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }  
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductQuantity();
         }
    }
        private static void UpdateProductType(){
         System.out.print("Enter Product ID To Update Product Type: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
       
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println(Products);
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;   
                  if(resultID==true)
            {
                   int num;
                   String Selection;
                   char choice1;
                   do{
                   System.out.print("Do you want to update this product? (Y/N): ");
                    choice1= input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                        flush();
                        ProductTypeMenu();
                        do{
                        System.out.print("Enter Number For Update Product Type : ");
                        Selection=input.nextLine();
                        boolean checkInt=false;
                        do{
                            try{
                                   num = Integer.parseInt(Selection);
                                   checkInt=true; 
                                   
                                   if(num==1)
                                   {
                                        Products.setProductType("Fresh Flowers      ");
                                        ProductList.set(count, Products);
                                        System.out.println(ANSI_GREEN+"Product Type Updated Successful!!!\n"+ANSI_RESET);
                                        MaintainProduct();
                                   }
                                   else if(num==2)
                                   {
                                        Products.setProductType("Flower Bouquets    ");
                                        ProductList.set(count, Products);
                                        System.out.println(ANSI_GREEN+"Product Type Updated Successful!!!\n"+ANSI_RESET);
                                        MaintainProduct();
                                  }
                                   else if(num==3)
                                   {
                                        Products.setProductType("Floral Arrangements");
                                        ProductList.set(count, Products);
                                        System.out.println(ANSI_GREEN+"Product Type Updated Successful!!!\n"+ANSI_RESET);
                                        MaintainProduct();
                                  }
                                   else
                                   {
                                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   }
                                   
                                   
                       } catch (NumberFormatException e) {
                                   System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   System.out.print("Enter Number For Update Product Type: ");
                                   Selection=input.nextLine();
                                   checkInt=false;
                       }}while(checkInt!=true); 
  
                   } while(Selection!="1"||Selection!="2");}
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }   
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
                  
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductType();
         }
    }
    
    private static void UpdateProductAll(){
         System.out.print("Enter Product ID To Update Product Detail: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                System.out.println(Products);
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true;  
                  if(resultID==true)
            {
                char choice1; String Selection; int num=0;
                do{
                System.out.print("Do you want to update this product? (Y/N): ");
                   choice1 = input.next().charAt(0);
                   if(choice1 == 'Y'||choice1 == 'y')
                   {
                       flush();
                       System.out.print("Product Name : ");
                       String ProductName=input.nextLine();
                       
                       
                       ProductTypeMenu();
                      
                        System.out.print("Product Type : ");
                        Selection=input.nextLine();
                        boolean checkInt=false;
                        do{
                            try{
                                   num = Integer.parseInt(Selection);
                                   checkInt=true; 
                                   
                                   if(num==1)
                                   {
                                        Products.setProductType("Fresh Flowers      ");
                                        //ProductList.set(count, Products);
                                   }
                                   else if(num==2)
                                   {
                                        Products.setProductType("Flower Bouquets    ");
                                        //ProductList.set(count, Products);
                                  }
                                    else if(num==3)
                                   {
                                        Products.setProductType("Floral Arrangements");
                                        //ProductList.set(count, Products);
                                  }
                                   else
                                   {
                                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   }
                                   
                                   
                       } catch (NumberFormatException e) {
                                   System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   System.out.print("Product Type : ");
                                   Selection=input.nextLine();
                                   checkInt=false;
                       }}while(checkInt!=true); 
  
                   
                       
                       System.out.print("Product Description : ");
                       String ProductDesc=input.nextLine();
                     
                       
                       System.out.print("Product Price : ");
                       String ProductPrice=input.nextLine();
                       boolean checkDouble=false;
                       do{
                           try{
                                  double num1 = Double.parseDouble(ProductPrice);
                                  checkDouble=true;
                      } catch (NumberFormatException e) {
                                  System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                  System.out.print("Product Price : ");
                                  ProductPrice=input.nextLine();
                                  checkDouble=false;
                      }}while(checkDouble!=true);
                      
                       
                       System.out.print("Product Quantity : ");
                        String ProductQuantity=input.nextLine();
                        boolean checkInt2=false;
                        do{
                            try{
                                   int num2 = Integer.parseInt(ProductQuantity);
                                   checkInt2=true;
                       } catch (NumberFormatException e) {
                                   System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                                   System.out.print("Product Quantity : ");
                                   ProductQuantity=input.nextLine();
                                   checkInt2=false;
                       }}while(checkInt2!=true); 
                        Products.setProductName(ProductName);
                          Products.setProductDesc(ProductDesc);
                         Products.setProductPrice(ProductPrice);
                       Products.setProductQuantity(ProductQuantity);
                       
                       ProductList.set(count, Products);
                        System.out.println(ANSI_GREEN+"Product Updated Successful!!!"+ANSI_RESET);
                       MaintainProduct();
                   }
                   else if(choice1 == 'N'||choice1 == 'n')
                   {
                      MaintainProduct();
                   }   
                    else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
            }
            }         
         }  	
         if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              UpdateProductAll();
         }
    }
    
    private static void DeleteProduct(){
         System.out.print("Enter Product ID To Delete: ");
         String ProductID=input.nextLine();
         boolean resultID=false;
         int count = -1;
         for(Product Products:ProductList)
         {
             count++;
             if(Products.getProductID().equalsIgnoreCase(ProductID))
            {
                System.out.println("\t\t\t\t\t\t\t\t--------|Product ID : "+ProductID+"|--------");
               System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                 System.out.println(Products);
                 System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
                resultID=true; 
                break;
            }       
         }
         if(resultID==true)
         {
             char choice1;
             do{
             System.out.print("Do you want to delete this product? (Y/N): ");
                choice1 = input.next().charAt(0);
                if(choice1 == 'Y'||choice1 == 'y')
                {
                    ProductList.remove(count);
                    System.out.println(ANSI_GREEN+"Product Deleted Successful!!!"+ANSI_RESET);
                    MaintainProduct();
                }
                else if(choice1 == 'N'||choice1 == 'n')
                {
                   MaintainProduct();
                }   
                 else
                    {
                       System.out.println(ANSI_RED+"Error!!! Please Enter Again."+ANSI_RESET);
                    }}while(choice1 != 'Y'||choice1 != 'y'||choice1 != 'N'||choice1 != 'n');
         }
         else if(resultID==false)
         {
              System.out.println(ANSI_RED+"Invalid Product ID!!! Please Enter Again."+ANSI_RESET);
              DeleteProduct();
         }
        
     }
     
     
    private static void DisplayAllProduct(){
        int i=0;
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t--------|Display All Products|--------");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Product ID\tProduct Name\t\t\tProduct Type\t\t\t\tProduct Description\t\t\t\t\tProduct Price\t\tProduct "+ "Quantity");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        if (ProductList.isEmpty()) {
            System.out.println("@@@@@@@@@@@        No record        @@@@@@@@@@@");
        } else {
            for (i = 0; i < ProductList.size(); i++) {
			System.out.println(ProductList.get(i));
	}
        }

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Total Number Of Products : "+i);
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }
    
    private static void UpdateMenu(){
        
        int selection;
        do {
            System.out.println("=====-----Welcome To Update Product Information Menu-----=====");
        System.out.println();
            System.out.println("Update Product Information Menu:");
            System.out.println("1 - Update Product Name");
            System.out.println("2 - Update Product Type");
            System.out.println("3 - Update Product Description");
            System.out.println("4 - Update Product Price");
            System.out.println("5 - Update Product Quantity");
            System.out.println("6 - Update Product Details");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    UpdateProductName();
                    System.out.println();
                    break;
                 case 2:
                    UpdateProductType();
                    System.out.println();
                    break;
                 case 3:
                     UpdateProductDesc();
                    System.out.println();
                    break;
               
                case 4:
                     UpdateProductPrice();                
                    System.out.println();
                    break;
                case 5:
                   UpdateProductQuantity();
                    System.out.println();
                    break;
                case 6:
                    UpdateProductAll();
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

    
    
    private static void MaintainPromotion() {
        
        int selection;
        do {
            System.out.println("=====----- Welcome to Maintain Monthly Promotion Menu -----=====");
        System.out.println();
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
      
      private static void ProductTypeMenu() {
            System.out.println("Product Type:");
            System.out.println("1 - Fresh Flowers");
            System.out.println("2 - Flower Bouquets");    
            System.out.println("3 - Floral Arrangements");
    }
      
      public static void flush() {
        input.nextLine();
    }

}