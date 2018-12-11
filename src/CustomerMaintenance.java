
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
    static List<Staff> StaffList = new ArrayList<Staff>();
    static Staff staffLoggedIn;

    public static void main(String[] args) {
        Customers consumer = new Customers("wennshenglim", "LimWS", "wslim1998@gmail.com", "0123456789", "13A-12 PV16");
        ConsumerList.add(consumer);
        Customers corporateCust = new Customers("evelnicky", "Evel", "evel@gmail.com", "0164118558", "TARUC", "Jalan Genting Klang", 250);
        CorporateCustList.add(corporateCust);
        Staff staff = new Staff("admin", "FlowerShop", "admin", "0134789658");
        StaffList.add(staff);
        LogInMenu();
    }

    public static void LogInMenu() {

        boolean check = false;
        if (staffLoggedIn == null) {

            do {
                System.out.println("\nStaff Log In Menu\n==================");
                System.out.print("Username: ");
                String username = s.nextLine();
                System.out.print("Password: ");
                String password = s.nextLine();
                for (int i = 0; i < StaffList.size(); i++) {
                    if (StaffList.get(i).getUsername().equals(username)
                            && StaffList.get(i).getPassword().equals(password)) {
                        System.out.println("\nWelcome back, " + username + "!!");
                        check = true;
                        CustomerMaintenanceMenu();
                        flush();
                    } else {
                        System.out.print("\nInvalid login credentials!! Please reenter");
                        check = false;
                    }
                }
            } while (check == false);
        } else {
            System.out.println("You have already logged in!! Redirect to main menu");
            CustomerMaintenanceMenu();
            flush();
        }
    }

    public static void CustomerMaintenanceMenu() {
        int selection;
        do {
            System.out.println("\nCustomer Maintenance & Invoice Payment Menu\n============================================");
            System.out.println("[1] Register New Account");
            System.out.println("[2] Search Account");
            System.out.println("[3] View All Accounts");
            System.out.println("[4] Update Account Details");
            System.out.println("[5] Delete Account");
            System.out.println("[6] Logout");
            System.out.print("Please Select: ");
            selection = s.nextInt();
            s.nextLine();
            switch (selection) {
                case 1:
                    RegisterType();
                    System.out.println();
                    break;
                case 2:
                    SearchAcc();
                    System.out.println();
                    break;
                case 3:
                    ViewAllAcc();
                    System.out.println();
                    break;
                case 4:
                    UpdateAcc();
                    System.out.println();
                    break;
                case 5:
                    DeleteAcc();
                    System.out.println();
                    break;
                case 6:
                    StaffLogOut();
                    System.out.println();
                    break;
                default:
                    System.out.println("\nPlease choose between 1 to 6.");
                    break;
            }
        } while (selection != 0);

    }

    public static void RegisterType() {
        int custType;
        do {
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
                    CustomerMaintenanceMenu();
                    System.out.println();
                    break;
                default:
                    System.out.print("\nPlease choose between 0 to 2.");
                    break;
            }
        } while (custType != 0);
    }

    public static void Consumers() {
        String username;
        boolean same = false;
        System.out.println("\nConsumer Menu\n=============");
        do {
            System.out.print("Username: ");
            username = s.nextLine();
            for (int i = 0; i <= ConsumerList.size(); i++) {
                if (ConsumerList.get(i).getUsername().equals(username)) {
                    System.out.println("The username already exists. Please reenter!");
                    same = true;
                    break;
                } else {
                    same = false;
                    break;
                }
            }
        } while (same == true);
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Email: ");
        String email = s.nextLine();
        System.out.print("Contact Number: ");
        String phoneNo = s.nextLine();
        System.out.print("Home Address: ");
        String address = s.nextLine();
        Customers consumer = new Customers(username, name, email, phoneNo, address);
        ConsumerList.add(consumer);
        System.out.println("\nNew account created successfully!\n");
        CustomerMaintenanceMenu();
        flush();
    }

    public static void CorporateCustomers() {

        String username;
        boolean same = false;
        System.out.println("\nCorporate Customers Menu\n=========================");
        do {
            System.out.print("Username: ");
            username = s.nextLine();
            for (int i = 0; i <= CorporateCustList.size(); i++) {
                if (CorporateCustList.get(i).getUsername().equals(username)) {
                    System.out.println("The username already exists. Please reenter!");
                    same = true;
                    break;
                } else {
                    same = false;
                    break;
                }
            }
        } while (same == true);
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
        System.out.print("Credit Limit: ");
        int creditLimit = s.nextInt();

        Customers corporateCust = new Customers(username, name, email, phoneNo, corporateName, address, creditLimit);
        CorporateCustList.add(corporateCust);
        System.out.println("\nNew account created successfully!\n");
        CustomerMaintenanceMenu();
        flush();
    }

    public static void StaffLogOut() {

        if (staffLoggedIn != null) {
            staffLoggedIn = null;
            System.out.println("\nYou Have Logged Out Successfully!!\n");
        }
        LogInMenu();
        flush();
    }

    public static void flush() {
        s.nextLine();
    }

    public static void SearchAcc() {
        System.out.println("");
        boolean found = false;
        System.out.println("\nSearch Account\n===============");
        System.out.println("Please enter username!");
        System.out.print("Username: ");
        String username = s.nextLine();

        for (int i = 0; i < ConsumerList.size(); i++) {
            if (ConsumerList.get(i).getUsername().equals(username)) {
                System.out.println("\nUsername found!!");
                System.out.println("Username: " + username);
                System.out.println("Name: " + ConsumerList.get(i).getName());
                System.out.println("Email Address: " + ConsumerList.get(i).getEmail());
                System.out.println("Phone Number: " + ConsumerList.get(i).getPhoneNo());
                System.out.println("Home Address: " + ConsumerList.get(i).getAddress());
                found = true;
                break;
            }
        }
        if (!found) {
            for (int i = 0; i < CorporateCustList.size(); i++) {
                if (CorporateCustList.get(i).getUsername().equals(username)) {
                    System.out.println("\nUsername found!!");
                    System.out.println("Username: " + username);
                    System.out.println("Name: " + CorporateCustList.get(i).getName());
                    System.out.println("Email Address: " + CorporateCustList.get(i).getEmail());
                    System.out.println("Phone Number: " + CorporateCustList.get(i).getPhoneNo());
                    System.out.println("Corporate Name: " + CorporateCustList.get(i).getCorporateName());
                    System.out.println("Corporate Address: " + CorporateCustList.get(i).getAddress());
                    System.out.println("Credit Limit: " + CorporateCustList.get(i).getCreditLimit());
                    found = true;
                    break;
                }
            }
        }
        if (found == true) {
            System.out.print("Search another username?(Y/N): ");
            char reply = s.next().charAt(0);
            if (reply == 'Y' || reply == 'y') {
                flush();
                SearchAcc();
                flush();
            } else {
                flush();
                CustomerMaintenanceMenu();
                flush();
            }
        } else {
            System.out.print("No search found! Search again?(Y?N): ");
            char reply = s.next().charAt(0);
            if (reply == 'Y' || reply == 'y') {
                flush();
                SearchAcc();
                flush();
            } else {
                flush();
                CustomerMaintenanceMenu();
                flush();
            }
        }
    }

}
