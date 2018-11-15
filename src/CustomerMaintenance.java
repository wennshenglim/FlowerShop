/**
 *
 * @author wennshenglim
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMaintenance {
    static Scanner s = new Scanner(System.in);
    static List<Customers> ConsumerList = new ArrayList<Customers>();
    static List<Customers> CorporateCustList = new ArrayList<Customers>();
    private static Customers consumerLoggedIn;
    private static Customers corporateCustLoggedIn;
    
    public static void main(String[] args){
        CustomerMaintenanceMenu();    
    }
    public static void CustomerMaintenanceMenu(){
        int selection;
        do{
           System.out.println("Customer Maintenance & Invoice Payment Menu\n============================================");
           System.out.println("[1] Register New Account");
           System.out.println("[2] Login Account");
           System.out.print("Please Select: ");
           selection = s.nextInt();
           s.nextLine();
           switch (selection) {
                case 1:
                    RegisterType();
                    System.out.println();
                    break;
                case 2:
                    LoginAcc();
                    System.out.println();
                    break;
                default:
                    System.out.println("\nPlease choose between 1 and 2.");
                    break;
            }
        }while(selection != 1 && selection != 2);
        
    }
    public static void RegisterType(){
        int custType;
        do{
           System.out.println("\nRegistration Menu\n==================");
           System.out.println("Customer Type:");
           System.out.println("[1] Consumers");
           System.out.println("[2] Corporate Customers");
           System.out.println("0 - Return to Main Menu");
           System.out.print("Please Select: ");
           custType = s.nextInt();
           s.nextLine();
           switch (custType) {
                case 1:
                    Consumers();
                    System.out.println();
                    break;
                case 2:
                    CorporateCustomers();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.print("\nPlease choose between 0 to 2.");
                    break;
            }
        }while(custType != 0);
    }
    
    public static void Consumers(){
        boolean checkPW = false;
        String password;
        System.out.println("Consumer Menu\n");
        
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Contact Number: ");
        String phoneNo = s.nextLine();
        System.out.print("Home Address: ");
        String address = s.nextLine();
        do{
           System.out.print("Password: ");
           password = s.nextLine();
           System.out.print("Confirm Password: ");
           String confirmPW = s.nextLine();
           if(confirmPW.equals(password)){
               checkPW = true;
           }
           else{
               System.out.println("Password entered not same. Please reenter!!");
           }
        }while(checkPW = false);
        
        Customers consumer = new Customers(username, name, password, email, phoneNo, address);
        ConsumerList.add(consumer);
        System.out.println("\nNew account created successfully!");  
        CustomerMaintenanceMenu();
    }
    
    public static void CorporateCustomers(){
        boolean checkPW = false;
        String password;
        System.out.println("Corporate Customers Menu\n");
        
        System.out.print("Username: ");
        String username = s.nextLine();
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Contact Number: ");
        String phoneNo = s.nextLine();
        System.out.print("Corporate Name: ");
        String corporateName = s.nextLine();
        System.out.print("Corporate Address: ");
        String address = s.nextLine();
        do{
           System.out.print("Password: ");
           password = s.nextLine();
           System.out.print("Confirm Password: ");
           String confirmPW = s.nextLine();
           if(confirmPW.equals(password)){
               checkPW = true;
           }
           else{
                System.out.println("Password entered not same. Please reenter!!");
                checkPW = false;
           }
        }while(checkPW = false);
        if(checkPW = true){
        Customers corporateCust = new Customers(username, name, password, email, phoneNo, corporateName, address);
        CorporateCustList.add(corporateCust);
        System.out.println("\nNew account created successfully!\n");     
        CustomerMaintenanceMenu();
        }
    }
    
    public static void LoginAcc(){
        if(consumerLoggedIn == null && corporateCustLoggedIn == null){
            System.out.println("\nLogin\n=======");
            s.nextLine();
            System.out.print("Please Enter Your Username: ");
            String username = s.nextLine();
            System.out.print("Please Enter Your Password: ");
            String password = s.nextLine(); 
            
            for(int i = 0; i <= ConsumerList.size(); i++){
            if(ConsumerList.get(i).getUsername().equals(username) && ConsumerList.get(i).getPassword().equals(password)){
                System.out.println("\nWelcome Back " + username + " !");
                consumerLoggedIn = new Customers(username,ConsumerList.get(i).getName(),ConsumerList.get(i).getPassword(),ConsumerList.get(i).getEmail(),
                        ConsumerList.get(i).getPhoneNo(), ConsumerList.get(i).getAddress());
                customerHit = true; break;
            } else {
                customerHit = false;
            }
        }
        }
        else{
            System.out.println("\nYou have logged in!");
        }
    }

}
