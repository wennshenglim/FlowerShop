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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DSA {

    static Scanner input = new Scanner(System.in);
    static Order o;
    static String update;
    static List<Order> OrderList = new ArrayList<Order>();
    static List<Order> DeliveryList = new ArrayList<Order>();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    static Date localDate = new Date();
    static String lDate = dateFormat.format(localDate); 
    
    public static void main(String[] args) {      
 
        /*Testing*/
        Order PastOrder;
        Date myDate = parseDate("2018-12-11");
        PastOrder = new Order("P001","dasdasd",myDate,"14:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P002","dasdasd",myDate,"15:30","40.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P003","dasdasd",myDate,"16:30","30.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        Date myDate1 = parseDate("2018-12-11");
        PastOrder = new Order("P004","dasdasd",myDate1,"15:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P005","dasdasd",myDate1,"16:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P006","dasdasd",myDate1,"17:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P007","dasdasd",myDate1,"18:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        Date myDate2 = parseDate("2018-12-12");
        PastOrder = new Order("P008","dasdasd",myDate2,"11:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        PastOrder = new Order("P009","dasdasd",myDate2,"12:30","20.00","      -       ","      -       ","      -       ","Unpick");
        OrderList.add(PastOrder);
        
        PastOrder = new Order("D001","dasdasd",myDate,"15:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D002","dasdasd",myDate,"15:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D003","dasdasd",myDate,"15:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D004","dasdasd",myDate,"14:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D005","dasdasd",myDate1,"14:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D006","dasdasd",myDate1,"14:30","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D007","dasdasd",myDate1,"16:00","20.00","      -       ","      -       ","      -       ","Undelivered");
        DeliveryList.add(PastOrder);
        PastOrder = new Order("D008","dasdasd",myDate1,"16;00","20.00","      -       ","      -       ","      -       ","Undelivered");
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
                case 4:
                    ViewAllOrder();
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
        System.out.println("=====----- Welcome to Payment Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Payment Menu:");
            System.out.println("1 - Payment for Pickup");
            System.out.println("2 - Payment for Delivery");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    PaymentPickUp();
                    System.out.println();
                    break;
                case 2:
                    PaymentDelivery();
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
    
    private static void PaymentPickUp() {
        System.out.println("=====----- Welcome to Pick-up Payment Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Payment Menu:");
            System.out.println("1 - Payment for Individual Customer");
            System.out.println("2 - Payment for Corporate Customer");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    PaymentIC();
                    System.out.println();
                    break;
                case 2:
                    PaymentCC();
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
    
    private static void PaymentIC() {
        
        String s;
        List p = getOrderByDate(lDate);       
        System.out.println();
        System.out.println("=====----- Pick-up Payment for Individual Customer -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("\tOrder ID\tDetails\t\tCollect Time\tAmount To Paid\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                if (p.isEmpty()) {
                    System.out.println("\t\t\t@@@@@@@@@@@                                       No record                                       @@@@@@@@@@@");
                } else {
                    for(int i = 0;i < p.size();i++){
                        System.out.println(i+1 + "\t" + p.get(i));
                    }
                }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println();
            System.out.println("Select one of the Order to proceed payment");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;
                case 2:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;  
                case 3:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;  
                case 0:
                    break;
                default:
                    System.out.println("Please select one of the order. Press 0 to Exit");
                    break;
            }
        } while (selection != 0); 
    }

    private static void PaymentCC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void PaymentDelivery() {
        System.out.println("=====----- Welcome to Delivery Payment Menu -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("Payment Menu:");
            System.out.println("1 - Payment for Individual Customer");
            System.out.println("2 - Payment for Corporate Customer");
            System.out.println("0 - Return to Main Menu");
            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    PaymentDIC();
                    System.out.println();
                    break;
                case 2:
                    PaymentDCC();
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
        
    private static void PaymentDCC() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    private static void PaymentDIC() {
        
        String s;
        List p = getOrderDeliveryByDate(lDate);       
        System.out.println();
        System.out.println("=====----- Pick-up Payment for Individual Customer -----=====");
        System.out.println();
        int selection;
        do {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("\tOrder ID\tDetails\t\tCollect Time\tAmount To Paid\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                if (p.isEmpty()) {
                    System.out.println("\t\t\t@@@@@@@@@@@                                       No record                                       @@@@@@@@@@@");
                } else {
                    for(int i = 0;i < p.size();i++){
                        System.out.println(i+1 + "\t" + p.get(i));
                    }
                }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println();
            System.out.println("Select one of the Order to proceed payment");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;
                case 2:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;  
                case 3:
                    s = ((Order)p.get(selection - 1)).getOrderid();
                    Payment(s);
                    System.out.println();
                    break;  
                case 0:
                    break;
                default:
                    System.out.println("Please select one of the order. Press 0 to Exit");
                    break;
            }
        } while (selection != 0); 
    }

    private static void ViewOrderDelivery() {
        String s;
        List d = getOrderDeliveryByDate(lDate);
        
        int selection;
        System.out.println();
        System.out.println("--------|All Order that ready for delivery|--------");
        do {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("\tOrder ID\tDetails\t\tCollect Time\tAmount To Paid\t\t   Address\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            if (d.isEmpty()) {
                System.out.println("@@@@@@@@@@@                                       No record                                       @@@@@@@@@@@");
            } else {
                for(int i = 0;i < d.size();i++){
                    System.out.println(i+1 + "\t" + d.get(i));
                }
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println();
            System.out.println("Select one of the Order to proceed payment");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            selection = manageSelectionError();
            flush();
            switch (selection) {
                case 1:
                    s = ((Order)d.get(selection - 1)).getOrderid();
                    SelectD(s);
                    System.out.println();
                    break;
                case 2:
                    s = ((Order)d.get(selection - 1)).getOrderid();
                    SelectD(s);
                    System.out.println();
                    break;  
                case 3:
                    s = ((Order)d.get(selection - 1)).getOrderid();
                    SelectD(s);
                    System.out.println();
                    break;  
                case 0:
                    break;
                default:
                    System.out.println("Please select one of the order. Press 0 to Exit");
                    break;
            }
        } while (selection != 0); 
    }
    
    public static void SelectD(String s){
        String p = s;
        String up = "Delivering";
        o = getOrderDeliveryAmountById(p);
        o.setStatus(up);  
    }

    private static void ViewOrderPickup() {
        List p = getOrderByDate(lDate);
        
        System.out.println();
        System.out.println("--------|All Order that ready for pick up|--------");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Order ID\tDetails\t\tCollect Time\tAmount To Paid\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
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
    public static void Payment(String s){
        String p = s;
        if("P".equals(s.substring(0, 1))){
            o = getOrderAmountById(p);
        }
        else if("D".equals(s.substring(0, 1))){
            o = getOrderDeliveryAmountById(p);
        }
        Date d = o.getOrderDate(); 
        String cDate = dateFormat.format(d); 
        
        String pay = o.getAmount();
        double payAmount = Double.parseDouble(pay);
        double a;
        boolean check = false;
        
        System.out.println();
        System.out.println("-------------------------|Order that selected|-------------------------");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Order ID : " + o.getOrderid());
        System.out.println("Order Description : " + o.getOrderDesc());
        System.out.println("Order Date : " + cDate);
        System.out.println("Order Time : " + o.getOrderTime());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Payment");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Total Amount : RM " + pay); 
        do{
            check = true;
            try{
                System.out.print("Enter the Amount : RM ");
                a = input.nextFloat();
                if(a < payAmount){
                   System.out.println("The amount is not enough!");
                   System.out.println("Please re-enter the amount!");
                   check = false;
                }
                else{
                    if(a > payAmount){
                        a -= payAmount;
                        System.out.printf("Changes : RM %.2f\n" , a);
                    }
                    updateStatus(p);
                }
            }
            catch(Exception ex){
                System.out.println("Invalid Input!");
                System.out.println("Please re-enter the amount!");
                flush();
                check = false;
            } 
        }while(check == false);

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
 
    }
    
    public static void updateStatus(String p){
        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Date localDate = new Date(); 
        String lTime = timeFormat.format(localDate);      
        if("P".equals(p.substring(0, 1))){
            o = getOrderAmountById(p);
            update = "Pick"; 
        }
        else if("D".equals(p.substring(0, 1))){
            o = getOrderDeliveryAmountById(p);
            update = "Delivered"; 
        }
        o.setPDate(lDate);
        o.setTime(lTime);
        o.setStatus(update);
        System.out.println("Payment Successful");
    }
    
    public static Order getOrderAmountById(String s){  
        Order o = null;
        
        for(int i = 0;i < OrderList.size();i++){
            String Orderid = ((Order)OrderList.get(i)).getOrderid();
            if(s.equals(Orderid)){
                o = OrderList.get(i);
            }
            else{
            }
        }
        return o;
    }
    
    public static Order getOrderDeliveryAmountById(String s){  
        Order o = null;
        
        for(int i = 0;i < DeliveryList.size();i++){
            String Orderid = ((Order)DeliveryList.get(i)).getOrderid();
            if(s.equals(Orderid)){
                o = DeliveryList.get(i);
            }
            else{
            }
        }
        return o;
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
    
     private static void ViewAllOrder() {
        System.out.println();
        System.out.println("--------|All Order|--------");
        System.out.println("--------|All Pick-up Order|--------");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Order ID\tDetails\t\tCollect Time\tAmount To Paid\tAddress\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for(int i = 0;i < OrderList.size();i++){
                System.out.println(OrderList.get(i));
            }
        System.out.println();
        System.out.println("--------|All Delivery Order|--------");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Order ID\tDetails\t\tCollect Time\tAmount To Paid\tAddress\t\tDate Picked Up\t\tTime Picked Up\t\tOrder Status");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            for(int i = 0;i < DeliveryList.size();i++){
                System.out.println(DeliveryList.get(i));
            }
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
