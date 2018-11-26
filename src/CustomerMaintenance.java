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
    static Customers consumerLoggedIn;
    static Customers corporateCustLoggedIn;
    
    public static void main(String[] args){
        CustomerMaintenanceMenu();    
    }
    public static void CustomerMaintenanceMenu(){
        int selection;
        do{
           System.out.println("Customer Maintenance & Invoice Payment Menu\n============================================");
           System.out.println("[1] Register New Account");
           System.out.println("[2] Login Account");
           System.out.println("0 - Exit");
           System.out.print("Please Select: ");
           selection = s.nextInt();
           switch (selection) {
                case 1:
                    RegisterType();
                    System.out.println();
                    break;
                case 2:
                    LoginAcc();
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nPlease choose between 0 to 2.");
                    break;
            }
        }while(selection != 0);
        
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
        String password, confirmPW;
        System.out.println("\nConsumer Menu\n=============");
        
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
           confirmPW = s.nextLine();
           if(confirmPW.equals(password)){
              Customers consumer = new Customers(username, name, password, email, phoneNo, address);
        ConsumerList.add(consumer);
        System.out.println("\nNew account created successfully!\n");  
        CustomerMaintenanceMenu();
               
           }
           else{
               System.out.println("\nPassword entered not same. Please reenter!!");
             //  checkPW1 = false;
           }
        }while(!confirmPW.equals(password));
    }
    
    public static void CorporateCustomers(){
        String password, confirmPW;
        System.out.println("\nCorporate Customers Menu\n=========================");
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
           confirmPW = s.nextLine();
           if(confirmPW.equals(password)){
            Customers corporateCust = new Customers(username, name, password, email, phoneNo, corporateName, address);
            CorporateCustList.add(corporateCust);
            System.out.println("\nNew account created successfully!\n");     
            CustomerMaintenanceMenu();
           }
           else{
                System.out.println("\nPassword entered not same. Please reenter!!");
           }
        }while(!confirmPW.equals(password));

    }
    
    public static void LoginAcc(){
        boolean consumer = false;
        boolean corporate = false;
        if(consumerLoggedIn == null && corporateCustLoggedIn == null){
            System.out.println("\nLogin\n======");

            System.out.print("Please Enter Your Username: ");
            s.nextLine();
            String username = s.nextLine();
            System.out.print("Please Enter Your Password: ");
            String password = s.nextLine(); 
            
            for(int i = 0; i <= ConsumerList.size(); i++){
                if(ConsumerList.get(i).getUsername().equals(username) && ConsumerList.get(i).getPassword().equals(password)){
                    System.out.println("\nWelcome Back " + username + "!");
                    consumerLoggedIn = new Customers(username,ConsumerList.get(i).getName(),ConsumerList.get(i).getPassword(),ConsumerList.get(i).getEmail(),
                                            ConsumerList.get(i).getPhoneNo(), ConsumerList.get(i).getCorporateName(),ConsumerList.get(i).getAddress());
                    consumer = true; 
                    break;
                } 
                else {
                    consumer = false;
                }
            }
            if(!consumer){
            for(int i = 0; i <= CorporateCustList.size(); i++){
                if(CorporateCustList.get(i).getUsername().equals(username) && CorporateCustList.get(i).getPassword().equals(password)){
                    System.out.println("\nWelcome Back " + username + " !");
                    corporateCustLoggedIn = new Customers(username,CorporateCustList.get(i).getName(),CorporateCustList.get(i).getPassword(),CorporateCustList.get(i).getEmail(),
                                       CorporateCustList.get(i).getPhoneNo(), CorporateCustList.get(i).getAddress());
                    corporate = true; 
                    break;
                } 
                else{
                    corporate = false;
                }
            }
            }
            if(!consumer && !corporate){
                System.out.println("\nInvalid Login Credentials");
                System.out.println("Please login again or create an account");
                System.out.println("[1] Login Again");
                System.out.println("[2] Create An Account");
                int choice = s.nextInt();
                switch(choice){
                    case 1: LoginAcc(); break;
                    case 2: RegisterType(); break;
                }
            }
            LoggedInMenu();
        }
        else{
            System.out.println("\nYou have logged in!");
            LoggedInMenu();
        }
    }

    public static void CustLogOut(){
        if(consumerLoggedIn != null){
            consumerLoggedIn = null;
            System.out.println("\nYou Have Logged Out Successfully!!\n");
        }
        else if(corporateCustLoggedIn != null){
            corporateCustLoggedIn = null;
            System.out.println("\nYou Have Logged Out Successfully!!\n");
        }
        CustomerMaintenanceMenu();  
    }
    
    public static void LoggedInMenu(){
        int selection;
        if(corporateCustLoggedIn == null){
            do{
                System.out.println("\nConsumer Menu\n=============");
                System.out.println("Selection:");
                System.out.println("[1] View Catalog");
                System.out.println("[2] Log Out");
                System.out.print("Please Select: ");
                selection = s.nextInt();
                s.nextLine();
                switch (selection){
                    case 1:
                        ViewCatalog();
                        System.out.println();
                        break;
                    case 2:
                        CustLogOut();
                        System.out.println();
                        break;
                    default:
                        System.out.print("\nPlease choose between 1 and 2.");
                        break;
                }
            }while(selection != 0); 
        }
        else{
            do{
                System.out.println("\nCorporate Customer Menu\n===================="); 
                System.out.println("Selection:");
                System.out.println("[1] View Catalog");
                System.out.println("[2] Log Out");
                System.out.print("Please Select: ");
                selection = s.nextInt();
                s.nextLine();
                switch (selection){
                    case 1:
                        ViewCatalog();
                        System.out.println();
                        break;
                    case 2:
                        CustLogOut();
                        System.out.println();
                        break;
                    default:
                        System.out.print("\nPlease choose between 1 and 2.");
                        break;
                }
            }while(selection != 0); 
        }
    }
}
