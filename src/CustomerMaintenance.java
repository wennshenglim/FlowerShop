
/**
 *
 * @author wennshenglim
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomerMaintenance {

    static Scanner s = new Scanner(System.in);
    static List<Consumer> ConsumerList = new ArrayList<Consumer>();
    static List<CorporateCust> CorporateCustList = new ArrayList<CorporateCust>();
    static List<Staff> StaffList = new ArrayList<Staff>();
    static Staff staffLoggedIn;

    public static List<Consumer> getConsumerList() {
        return ConsumerList;
    }

    public static List<CorporateCust> getCorporateCustList() {
        return CorporateCustList;
    }

    public static void main(String[] args) {
        Consumer consumer1 = new Consumer("wennshenglim", "LimWS", "wslim1998@gmail.com", "0123456789", "13A-12 PV16");
        Consumer consumer2 = new Consumer("waichong", "Ng Wai Chong", "waichong98@gmail.com", "0175847895", "Sungai Batu");
        ConsumerList.add(consumer1);
        ConsumerList.add(consumer2);
        CorporateCust corporateCust1 = new CorporateCust("evelnicky", "Evel", "evel@gmail.com", "0164118558", "TARUC", "Jalan Genting Klang", 250);
        CorporateCust corporateCust2 = new CorporateCust("khlim666", "Lim Kai Heng", "khlim666@gmail.com", "01115422527", "KDU", "Jalan Anson", 250);
        CorporateCustList.add(corporateCust1);
        CorporateCustList.add(corporateCust2);
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
                        staffLoggedIn = new Staff(username, StaffList.get(i).getName(), StaffList.get(i).getPassword(), StaffList.get(i).getPhoneNo());
                        CustomerMaintenanceMenu();
                        flush();
                    } else {
                        System.out.print("\nInvalid login credentials!! Please reenter\n");
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
        Consumer consumer = new Consumer(username, name, email, phoneNo, address);
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

        CorporateCust corporateCust = new CorporateCust(username, name, email, phoneNo, corporateName, address, creditLimit);
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

    public static void DeleteAcc() {
        System.out.println("");
        boolean found = false;
        System.out.println("\nDelete Account\n===============");
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
                if (found == true) {
                    System.out.print("Are you sure you want to delete this account?(Y/N): ");
                    char reply = s.next().charAt(0);
                    if (reply == 'Y' || reply == 'y') {
                        flush();
                        ConsumerList.remove(i);
                        System.out.println("\nAccount is deleted successfully!!");
                        System.out.println("Redirect to main menu...");
                        CustomerMaintenanceMenu();

                    } else {
                        flush();
                        CustomerMaintenanceMenu();
                        flush();
                    }
                }
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
                    if (found == true) {
                        System.out.print("Are you sure you want to delete this account?(Y/N): ");
                        char reply = s.next().charAt(0);
                        if (reply == 'Y' || reply == 'y') {
                            flush();
                            CorporateCustList.remove(i);
                            System.out.println("\nAccount is deleted successfully!!");
                            System.out.println("Redirect to main menu...");
                            CustomerMaintenanceMenu();

                        } else {
                            flush();
                            CustomerMaintenanceMenu();
                            flush();
                        }
                    }
                }
            }
            System.out.print("\nNo search found! Search again to delete?(Y?N): ");
            char reply = s.next().charAt(0);
            if (reply == 'Y' || reply == 'y') {
                flush();
                DeleteAcc();
                flush();
            } else {
                flush();
                CustomerMaintenanceMenu();
                flush();
            }
        }
    }

    public static void ViewAllAcc() {
        System.out.println("\nView All Account\n================");

        System.out.println("Consumer Account List");
        int indexConsumer = 0;
        int index = 0;
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+------------------------------+");
        System.out.format("| %s | %-16s | %-20s | %-24s | %-14s | %-28s |\n", "No.", "Username", "Name", "Email", "Contact Number", "Home Address");
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+------------------------------+");
        for (Consumer consumer : getConsumerList()) {
            ++index;
            System.out.format("| %-3d | %s\n", ++indexConsumer, consumer);
        }
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+------------------------------+");
        int indexCorporateCust = 0;
        System.out.println("\nCorporate Customer Account List");
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+----------------------+------------------------------+--------------+");
        System.out.format("| %s | %-16s | %-20s | %-24s | %-14s | %-20s | %-28s | %-12s |\n", "No.", "Username", "Name", "Email", "Contact Number", "Corporate Name", "Corporate Address", "Credit Limit");
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+----------------------+------------------------------+--------------+");
        for (CorporateCust corporateCust : getCorporateCustList()) {
            ++index;
            System.out.format("| %-3d | %s\n", ++indexCorporateCust, corporateCust);
        }
        System.out.println("+-----+------------------+----------------------+--------------------------+----------------+----------------------+------------------------------+--------------+");
        System.out.println("Total customer accounts: " + index);
        flush();
        System.out.println("Redirect to main menu...");
        CustomerMaintenanceMenu();
    }
}
