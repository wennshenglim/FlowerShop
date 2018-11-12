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
    static List<Order> OrderList = new ArrayList<Order>();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    static Date localDate = new Date();
    static String lDate = dateFormat.format(localDate); 
    
    public static void main(String[] args) {      
 
        Order PastOrder;
        Date myDate = parseDate("2018-11-12");
        PastOrder = new Order("P001","dasdasd",myDate,"14：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P001","dasdasd",myDate,"15：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P001","dasdasd",myDate,"16：30","Unpick");
        OrderList.add(PastOrder);
        Date myDate1 = parseDate("2018-11-13");
        PastOrder = new Order("P002","dasdasd",myDate1,"15：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P003","dasdasd",myDate1,"16：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P004","dasdasd",myDate1,"17：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P005","dasdasd",myDate1,"18：30","Unpick");
        OrderList.add(PastOrder);
        Date myDate2 = parseDate("2018-11-14");
        PastOrder = new Order("P005","dasdasd",myDate2,"11：30","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P006","dasdasd",myDate2,"12：30","Unpick");
        OrderList.add(PastOrder);
        
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
       System.out.println("=====----- Welcome to Order Pickup Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Order Pickup Menu:");
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

    }

    private static void ViewOrderPickup() {
        List p = getOrderByDate(lDate);
        System.out.println(p);
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
    
    public static void flush() {
        input.nextLine();
    }
}
