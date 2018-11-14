/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DSA {

    static Scanner input = new Scanner(System.in);
    static List<CatalogOrder> CO = new ArrayList<CatalogOrder>();
    static List<Order> OrderList = new ArrayList<Order>();
    static List<Order> DeliveryList = new ArrayList<Order>();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    static Date localDate = new Date();
    static String lDate = dateFormat.format(localDate); 
    
    public static void main(String[] args) {      
        
        CatalogOrder Catalog;
        Catalog = new CatalogOrder("F0001", "asssss","redrose","RM10.00");
        CO.add(Catalog);
        Catalog = new CatalogOrder("F0002", "asssss","bouquets","RM20.00");
        CO.add(Catalog);
        Catalog = new CatalogOrder("F0003", "asssss","FlowerArrangement","RM30.00");
        CO.add(Catalog);
        Catalog = new CatalogOrder("F0004", "asssss","yellowrose","RM10.00");
        CO.add(Catalog);
      
        
        Order PastOrder;
        Date myDate = parseDate("2018-11-12");
        PastOrder = new Order("P001","dasdasd",myDate,"14：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P002","dasdasd",myDate,"15：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P003","dasdasd",myDate,"16：30","Unpick");
        OrderList.add(PastOrder);
        Date myDate1 = parseDate("2018-11-13");
        PastOrder = new Order("P004","dasdasd",myDate1,"15：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P005","dasdasd",myDate1,"16：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P006","dasdasd",myDate1,"17：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P007","dasdasd",myDate1,"18：30","Unpick");
        OrderList.add(PastOrder);
        Date myDate2 = parseDate("2018-11-14");
        PastOrder = new Order("P008","dasdasd",myDate2,"11：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P009","dasdasd",myDate2,"12：30","Unpick");
        OrderList.add(PastOrder);
        
        PastOrder = new Order("D001","dasdasd",myDate,"15：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D002","dasdasd",myDate,"16：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D003","dasdasd",myDate,"17：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D004","dasdasd",myDate,"18：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D005","dasdasd",myDate1,"15：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D006","dasdasd",myDate1,"16：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D007","dasdasd",myDate1,"17：30","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D008","dasdasd",myDate1,"18：30","Undelivered");
        DeliveryList.add(PastOrder);
        
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
                case 3:
                    DisplayCatalogOrder();
                    System.out.println();
                    break;
                case 4:
                    OrderPDandPayment();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 6.");
                    break;
            }
        } while (selection != 0);
    }  
    
    private static void Customer(){
         System.out.println("=====----- Welcome to Customer Menu -----=====");
        System.out.println();
        int selection;
           do{
            System.out.println("1 - Customer");
            System.out.println("2 - Corporate Customer");     
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError5();
            flush();
         switch (selection) {
                case 1:
                   CustomerOrder();
                    System.out.println();
                    break;
                case 2:
                    CorporateCustomer();
                    System.out.println();
                    break;  
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 2.");
                    break;
            }
      
        } while (selection != 0);
    }
    
    private static void CorporateCustomer(){
        String selection1;
        String selection2 = "yes";
         System.out.println("=====----- Welcome to CorporateCustomerOrder -----=====");
        System.out.println();
        System.out.println("Your monthly credit left RM2000");
       
            CorporateCustomerOrder();
     
         
     
        
    }
        private static void CorporateCustomerOrder(){
       String selection1 = "yes";
       String selection2;
        int selection;
        
        do{
            System.out.println("Catalog Orders:");
            System.out.println("1 - fresh flowers,");
            System.out.println("2 - bouquets,");
            System.out.println("3 - floral arrangements,");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError3();
            flush();
       /*  switch (selection) {
                case 1:
                    PickDelivery();
                    System.out.println();
                    break;
                case 2:
                    PickDelivery();
                    System.out.println();
                    break;
                case 3:
                    PickDelivery();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;
            }*/
       System.out.println("Do you still want to order other items?(yes or no)");
       selection2 = input.nextLine();
      if(selection2.equals(selection1))
      {
          CorporateCustomerOrder();
      }
      else
      {
          PickDelivery();
      }
       
        } while (selection != 0);    
        }
    
    private static void CustomerOrder(){
        System.out.println("=====----- Welcome to CustomerOrder -----=====");
        System.out.println();
        int selection;
        do{
            System.out.println("Catalog Orders:");
            System.out.println("1 - fresh flowers,");
            System.out.println("2 - bouquets,");
            System.out.println("3 - floral arrangements,");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError3();
            flush();
         switch (selection) {
                case 1:
                    PickDelivery();
                    System.out.println();
                    break;
                case 2:
                    PickDelivery();
                    System.out.println();
                    break;
                case 3:
                    PickDelivery();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;
            }
            
                    
        } while (selection != 0);
        
    }
   
    
    private static void PickDelivery(){
        System.out.println("=====----- Welcome to pick-up your deliverying date and time  -----=====");
        System.out.println();
       
        int selection;
        do {
            System.out.println("Pick-up your date and time:");
            System.out.println("1 - 13-11-2018, 10:00");
            System.out.println("2 - 13-11-2018, 11:00");
            System.out.println("3 - 13-11-2018, 13:00");
            System.out.println("4 - 13-11-2018, 16:00");
            System.out.println("5 - 13-11-2018, 19:00");
            System.out.println("6 - 13-11-2018, 20:00");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError4();
            flush();
            switch (selection) {
                case 1:
                   SelectAddress();
                    System.out.println();
                    break;
                case 2:
                    SelectAddress();
                    System.out.println();
                    break;
                case 3:
                    SelectAddress();
                    System.out.println();
                    break;
                case 4:
                    SelectAddress();
                    System.out.println();
                    break;
                case 5:
                    SelectAddress();
                    System.out.println();
                    break;
                case 6:
                    SelectAddress();
                    System.out.println();
                    break;  
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 6.");
                    break;
            }
        } while (selection != 0);
    }
    
   
    private static void SelectAddress() {
        String address;
         System.out.println();
       System.out.println("=====----- Welcome to Select your address to be delivered -----=====");
       System.out.println();
       System.out.println("Enter your address:");
        address = input.nextLine();
        if(address != null){
        SalesOrder();
        }
    }
    
     private static void SalesOrder(){
        System.out.println();
        System.out.println("=====----- Welcome to Sales Order Menu -----=====");
        System.out.println();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Your sales Order:");
        System.out.println("x2 fresh flower");
        System.out.println("x1 bouquets");
        System.out.println("x1 floral arrangements,");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
         System.exit(0);
        
    }
    
     private static void DisplayCatalogOrder(){
         String ans1;
         String ans2 = "yes" ;
        
          System.out.println();
          System.out.println("--------|Catalog Order Menu|--------");
          System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
          System.out.println("Flower ID\tFlower Description\t\tFlower Price\t\tFlower Name");
          System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
           if(CO.isEmpty()){
            System.out.println("Sorry , there is no record");
        }
        else{
             for(int i = 0;i < CO.size();i++){
                System.out.println(CO.get(i));
            }
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        System.out.println("Do you want to make order?(yes or no)");
         ans1 = input.nextLine();
        if(ans1.equals(ans2))
        {
            Customer();
        }
        else
        {
            System.exit(0);
        }
       
          
     }
     
     
    private static void OrderPDandPayment() {
        System.out.println("=====----- Welcome to Order Pickup / Delivery and Customer Payment Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Order Pickup / Delivery and Customer Payment Menu:");
            System.out.println("1 - Order Pickup");
            System.out.println("2 - Order Delivery");
            System.out.println("3 - Customer Payment");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    OrderPickup();
                    System.out.println();
                    break;
                case 2:
                    OrderDelivery();
                    System.out.println();
                    break;
                case 3:
                    CustomerPayment();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 3.");
                    break;
            }
        } while (selection != 0);
    }
    
    private static void OrderPickup() {
        System.out.println("=====----- Welcome to Order Pickup Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Order Pickup Menu:");
            System.out.println("1 - View Order for Pickup");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    ViewOrderPickup();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 1.");
                    break;
            }
        } while (selection != 0);
    }

    private static void OrderDelivery() {
       System.out.println("=====----- Welcome to Order Delivery Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Order Delivery Menu:");
            System.out.println("1 - View Order for Delivery");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    ViewOrderDelivery();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please choose between 0 to 1.");
                    break;
            }
        } while (selection != 0);
    }

    private static void CustomerPayment() {
        
    }

    private static void ViewOrderDelivery() {

        List d = getOrderDeliveryByDate(lDate);
        
        System.out.println();
        System.out.println("--------|All Order that ready for pick up|--------");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Order ID\tDetails\t\tCollect Time\tOrder Status");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        if (d.isEmpty()) {
            System.out.println("@@@@@@@@@@@        No record        @@@@@@@@@@@");
        } else {
            for(int i = 0;i < d.size();i++){
                System.out.println(d.get(i));
            }
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
    }

    private static void ViewOrderPickup() {
        List p = getOrderByDate(lDate);
        
        System.out.println();
        System.out.println("--------|All Order that ready for pick up|--------");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Order ID\tDetails\t\tCollect Time\tOrder Status");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        if (p.isEmpty()) {
            System.out.println("@@@@@@@@@@@                                       No record                                       @@@@@@@@@@@");
        } else { 
            for(int i = 0;i < p.size();i++){
                System.out.println(p.get(i));
            }
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
    }
    
    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
    }
    
    public static List display(List OrderList){
        
        if(OrderList.isEmpty()){
            System.out.println("Sorry , there is no record");
        }
        else{
            
        }
        return OrderList;
    }
    
    public static List getOrderByDate(String lDate){
        Order o;  
        List<Order> OrderPList = new ArrayList<Order>();        
        
        for(int i = 0;i < OrderList.size();i++){
            o = (Order)OrderList.get(i);
            Date OrderDate = ((Order)OrderList.get(i)).getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(OrderDate); 
            if(strDate.equals(lDate)){
                OrderPList.add(o);
            }
            else{
            }
        }
        return OrderPList;
    }
    
    public static List getOrderDeliveryByDate(String lDate){
        Order o;  
        List<Order> OrderDList = new ArrayList<Order>();        
        
        for(int i = 0;i < DeliveryList.size();i++){
            o = (Order)DeliveryList.get(i);
            Date OrderDate = ((Order)DeliveryList.get(i)).getOrderDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(OrderDate); 
            if(strDate.equals(lDate)){
                OrderDList.add(o);
            }
            else{
            }
        }
        return OrderDList;
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
    
    public static int manageSelectionError3() {
        int selection = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Please select your items : ");
                selection = input.nextInt();

                valid = true;
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again! ");
                flush();
            }
        } while (!valid);
        return selection;
    }
    public static int manageSelectionError4() {
        int selection = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Please select your date and time : ");
                selection = input.nextInt();

                valid = true;
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again! ");
                flush();
            }
        } while (!valid);
        return selection;
    }
     public static int manageSelectionError5() {
        int selection = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Please select your Customer Info : ");
                selection = input.nextInt();

                valid = true;
            } catch (Exception ex) {
                System.out.println("Invalid input. Please try again! ");
                flush();
            }
        } while (!valid);
        return selection;
    }
    public static void flush() {
        input.nextLine();
    }

    

}

