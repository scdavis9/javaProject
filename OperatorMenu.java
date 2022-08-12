package src;
import java.util.*;

import src.Member.memberStatus; 

/**
 * The OperatorMenu class. This class allows operators to log out or run interactive mode
 * 
 * @author Eleri Floyd
 * @version 1.0
 */
public class OperatorMenu {
    public static Scanner sc= new Scanner(System.in); 

    /**
     * Allows user to run interactive mode
     * Operator can select to edit, remove, or add members or providers
     */
    public static void runInteractiveMode() {
        System.out.println("\nYou have selected: Run Interactive Mode\n");
        System.out.println("Please select an action:\n");
        System.out.println("1: Add Provider  2: Remove Provider  3: Edit Provider");
        System.out.println("4: Add Member    5: Remove Member    6: Edit Member\n");
        System.out.println("Choose a selection by entering a number 1-6:");
        
        String command = sc.nextLine(); 

        if (command.equals("1")) {
            OperatorMenu.addProvider();
        }
        else if (command.equals("2")) {
            System.out.print("\nPlease enter account number of provider to be removed.\n"); 
            String accountNum = "";
            int accountNumber = 0;
            while (true) {
                try {
                    accountNum = sc.nextLine();
                    accountNumber = Integer.parseInt(accountNum);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                if (accountNum.length() != 9) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                break;
            }  
            OperatorMenu.removeProvider(accountNumber);
        }
        else if (command.equals("3")) {
            System.out.print("\nPlease enter account number of provider to be edited.\n");
            String accountNum = "";
            int accountNumber = 0;
            while (true) {
                try {
                    accountNum = sc.nextLine();
                    accountNumber = Integer.parseInt(accountNum);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                if (accountNum.length() != 9) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                break;
            } 
            OperatorMenu.editProvider(accountNumber);
        }
        else if (command.equals("4")) {
            OperatorMenu.addMem();
        }
        else if (command.equals("5")) {
            System.out.print("\nPlease enter account number of member to be removed.\n");
            String accountNum = "";
            int accountNumber = 0;
            while (true) {
                try {
                    accountNum = sc.nextLine();
                    accountNumber = Integer.parseInt(accountNum);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                if (accountNum.length() != 9) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                break;
            } 
            OperatorMenu.removeMem(accountNumber);
        }
        else if (command.equals("6")) {
            System.out.print("\nPlease enter account number of member to be edited.\n");
            String accountNum = "";
            int accountNumber = 0;
            while (true) {
                try {
                    accountNum = sc.nextLine();
                    accountNumber = Integer.parseInt(accountNum);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                if (accountNum.length() != 9) {
                    System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                    continue;
                }
                break;
            } 
            OperatorMenu.editMem(accountNumber);
        }
        else {
            System.out.println("\nCommand not found. Please try again.");
            OperatorMenu.runInteractiveMode();
        }
    }

    /**
     * Allows user to log out
     */
    public static void logOut() {
        Main.enterCredentials();
    }

    /**
     * Searches member files for member by given member account number
     * @param number the member's account number
     * @return the member found at the given account number
     */
    public static Member findMem(int number) {
        return MemberFiles.searchMember(number);
    }

    /**
     * Searches provider files for provider by given provider account number
     * @param number the provider's account number
     * @return the provider found at the given account number
     */
    public static Provider findProvider(int number) {
        return ProviderFiles.searchProvider(number);
    }

    /**
     * Prompts user to enter information for member to be added,
     * then adds member to member files with all entered information
     */
    public static void addMem() {
        System.out.print("\nPlease enter nine digit account number of member to be added.\n");
        String accountNum = "";
        int number = 0;
        while (true) {
            try {
                accountNum = sc.nextLine();
                number = Integer.parseInt(accountNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                continue;
            }
            if (accountNum.length() != 9) {
                System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                continue;
            }
            if(MemberFiles.searchMember(number) != null){
                System.out.println("\nMember already exists. Please enter account number of member to be added.\n");
                continue; 
            }
            break;
        } 
        //check for same account number vvvvvvvvv
        System.out.print("\nPlease enter name of member to be added.\n");
        String name = sc.nextLine(); 
        while (name.length() > 25) {
            System.out.println("\nInvalid member name. Member name must be 25 characters or less.\nPlease re-enter member name.\n");
            name = sc.nextLine();
        }
        System.out.print("\nPlease enter address of member to be added.\n");
        String address = sc.nextLine(); 
        while (address.length() > 25) {
            System.out.println("\nInvalid member address. Address must be 25 characters or less.\nPlease re-enter member address.\n");
            address = sc.nextLine();
        }
        System.out.print("\nPlease enter city of member to be added.\n");
        String city = sc.nextLine(); 
        while (city.length() > 14) {
            System.out.println("\nInvalid city. City must be 14 characters or less.\nPlease re-enter city.\n");
            city = sc.nextLine();
        }
        System.out.print("\nPlease enter state of member to be added.\n");
        String state = sc.nextLine(); 
        while (state.length() > 2) {
            System.out.println("\nInvalid state. State must be 2 characters.\nPlease re-enter state.\n");
            state = sc.nextLine();
        }
        System.out.print("\nPlease enter zip code of member to be added.\n");
        String zipCode = "";
        int zip = 0;
        while (true) {
            try {
                zipCode = sc.nextLine();
                zip = Integer.parseInt(zipCode);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                continue;
            }
            if (zipCode.length() != 5) {
                System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                continue;
            }
            break;
        } 
        MemberFiles.insertMember(name, number, address, city, state, zip);
        OperatorMenu.main();
    }

    /**
     * Prompts user to enter information for provider to be added,
     * then adds provider to provider files with all entered information
     */
    public static void addProvider() {
        System.out.print("\nPlease enter 9-digit provider number of provider to be added.\n");
        String accountNum = "";
        int number = 0;
        while (true) {
            try {
                accountNum = sc.nextLine();
                number = Integer.parseInt(accountNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                continue;
            }
            if (accountNum.length() != 9) {
                System.out.println("\nInvalid account number. Please enter a nine digit numerical value.\n");
                continue;
            }
            if(ProviderFiles.searchProvider(number) != null){
                System.out.println("\nProvider already exists. Please enter 9-digit provider number of provider to be added.\n");
                continue; 
            }
            break;
        } 
        System.out.print("\nPlease enter name of provider to be added.\n");
        String name = sc.nextLine(); 
        while (name.length() > 25) {
            System.out.println("\nInvalid provider name. Provider name must be 25 characters or less.\nPlease re-enter provider name.\n");
            name = sc.nextLine();
        }
        System.out.print("\nPlease enter address of provider to be added.\n");
        String address = sc.nextLine(); 
        while (address.length() > 25) {
            System.out.println("\nInvalid provider address. Provider address must be 25 characters or less.\nPlease re-enter provider address.\n");
            address = sc.nextLine();
        }
        System.out.print("\nPlease enter city of provider to be added.\n");
        String city = sc.nextLine(); 
        while (city.length() > 14) {
            System.out.println("\nInvalid city. City must be 14 characters or less.\nPlease re-enter city.\n");
            city = sc.nextLine();
        }
        System.out.print("\nPlease enter state of provider to be added.\n");
        String state = sc.nextLine(); 
        while (state.length() > 2) {
            System.out.println("\nInvalid state. State must be 2 characters.\nPlease re-enter state.\n");
            state = sc.nextLine();
        }
        System.out.print("\nPlease enter zip code of provider to be added.\n");
        String zipCode = "";
        int zip = 0;
        while (true) {
            try {
                zipCode = sc.nextLine();
                zip = Integer.parseInt(zipCode);
            } catch (NumberFormatException nfe) {
                System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                continue;
            }
            if (zipCode.length() != 5) {
                System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                continue;
            }
            break;
        }  
        ProviderFiles.insertProvider(name, number, address, city, state, zip);
        OperatorMenu.main();
    }

    /**
     * Allows user to edit member at current account number
     * Prompts the user for what field they would like to edit,
     * allows the user to enter the new information,
     * then updates the member's information
     * @param accNumber account number of the member to be edited
     */
    public static void editMem(int accNumber) {
        Member memEdit = OperatorMenu.findMem(accNumber);
        if (memEdit == null) {
            System.out.println("\nMember not found.\n");
            OperatorMenu.main();
        }
        else {
            System.out.println("\nWhat information would you like to edit?");
            System.out.println("1: Name   2: Address   3: City");
            System.out.println("4: State  5: Zip Code  6: Member Status");
        }
        String memEditCommand = sc.nextLine();
        if (memEditCommand.equals("1")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " name to?");
            System.out.println("Current member name is: " + memEdit.name);
            String newName = sc.nextLine();
            while (newName.length() > 25) {
                System.out.println("\nInvalid member name. Member name must be 25 characters or less.\nPlease re-enter member name.\n");
                newName = sc.nextLine();
            }
            memEdit.name = newName;
        }
        else if (memEditCommand.equals("2")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " address to?");
            System.out.println("Current member address is: " + memEdit.address);
            String newAdd = sc.nextLine();
            while (newAdd.length() > 25) {
                System.out.println("\nInvalid member address. Member address must be 25 characters or less.\nPlease re-enter member address.\n");
                newAdd = sc.nextLine();
            }
            memEdit.address = newAdd;
        }
        else if (memEditCommand.equals("3")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " city to?");
            System.out.println("Current member city is: " + memEdit.city);
            String newCity = sc.nextLine();
            while (newCity.length() > 14) {
                System.out.println("\nInvalid city. City must be 25 characters or lest.\nPlease re-enter city.\n");
                newCity = sc.nextLine();
            }
            memEdit.city = newCity;
        }
        else if (memEditCommand.equals("4")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " state to?");
            System.out.println("Current member state is: " + memEdit.state);
            String newState = sc.nextLine();
            while (newState.length() > 2) {
                System.out.println("\nInvalid state. State must be two characters.\nPlease re-enter state.");
                newState = sc.nextLine();
            }
            memEdit.state = newState;
        }
        else if (memEditCommand.equals("5")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " zip code to?");
            System.out.println("Current member zip code is: " + memEdit.zipCode);
            String zipCode = "";
            int newZip = 0;
            while (true) {
                try {
                    zipCode = sc.nextLine();
                    newZip = Integer.parseInt(zipCode);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                    continue;
                }
                if (zipCode.length() != 5) {
                    System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                    continue;
                }
                break;
            }  
            memEdit.zipCode = newZip;
        }
        else if (memEditCommand.equals("6")) {
            System.out.println("\nWhat would you like to update member " + accNumber + " status to?");
            System.out.println("Current member status is: " + memEdit.currentStatus);
            System.out.println("Enter 1 for active or 2 for suspended.");
            String newStatus = sc.nextLine();
            if (newStatus.equals("1")) {
                memEdit.currentStatus = memberStatus.ACTIVE;
            }
            else if (newStatus.equals("2")) {
                memEdit.currentStatus = memberStatus.SUSPENDED;
            }
            else {
                System.out.println("\nCommand not found.");
            }
        }
        else {
            System.out.println("\nCommand not found.");
        }
        OperatorMenu.main();
    }

    /**
     * Allows user to edit provider at current account number
     * Prompts the user for what field they would like to edit,
     * allows the user to enter the new information,
     * then updates the provider's information
     * @param accountNumber account number of the provider to be edited
     */
    public static void editProvider(int accountNumber) {
        Provider provEdit = OperatorMenu.findProvider(accountNumber);
        if (provEdit == null) {
            System.out.println("\nProvider not found.\n");
            OperatorMenu.main();
        }
        else {
            System.out.println("\nWhat information would you like to edit?");
            System.out.println("1: Name   2: Address   3: City");
            System.out.println("4: State  5: Zip Code");
        }
        String provEditCommand = sc.nextLine();
        if (provEditCommand.equals("1")) {
            System.out.println("\nCurrent provider name is: " + provEdit.name);
            System.out.println("What would you like to update provider " + accountNumber + " name to?");
            String newName = sc.nextLine();
            while (newName.length() > 25) {
                System.out.println("\nInvalid provider name. Provider name must be 25 characters or less.\nPlease re-enter member name.\n");
                newName = sc.nextLine();
            }
            provEdit.name = newName;
        }
        else if (provEditCommand.equals("2")) {
            System.out.println("\nCurrent provider address is: " + provEdit.address);
            System.out.println("What would you like to update provider " + accountNumber + " address to?");
            String newAdd = sc.nextLine();
            while (newAdd.length() > 25) {
                System.out.println("\nInvalid provider address. Provider address must be 25 characters or less.\nPlease re-enter member name.\n");
                newAdd = sc.nextLine();
            }
            provEdit.address = newAdd;
        }
        else if (provEditCommand.equals("3")) {
            System.out.println("\nCurrent provider city is: " + provEdit.city);
            System.out.println("What would you like to update provider " + accountNumber + " city to?");
            String newCity = sc.nextLine();
            while (newCity.length() > 14) {
                System.out.println("\nInvalid city. City must be 25 characters or less.\nPlease re-enter member name.\n");
                newCity = sc.nextLine();
            }
            provEdit.city = newCity;
        }
        else if (provEditCommand.equals("4")) {
            System.out.println("\nCurrent provider state is: " + provEdit.state);
            System.out.println("What would you like to update provider " + accountNumber + " state to?");
            String newState = sc.nextLine();
            while (newState.length() > 2) {
                System.out.println("\nInvalid state. State must be two characters.\nPlease re-enter state.");
                newState = sc.nextLine();
            }
            provEdit.state = newState;
        }
        else if (provEditCommand.equals("5")) {
            System.out.println("\nCurrent provider zip code is: " + provEdit.zipCode);
            System.out.println("What would you like to update provider " + accountNumber + " zip code to?");
            String zipCode = "";
            int newZip = 0;
            while (true) {
                try {
                    zipCode = sc.nextLine();
                    newZip = Integer.parseInt(zipCode);
                } catch (NumberFormatException nfe) {
                    System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                    continue;
                }
                if (zipCode.length() != 5) {
                    System.out.println("\nInvalid zip code. Please enter a five digit numerical value.\n");
                    continue;
                }
                break;
            } 
            provEdit.zipCode = newZip;
        }
        else {
            System.out.println("\nCommand not found.");
        }
        OperatorMenu.main();
    }

    /**
     * Removes member at given account number
     * @param number account number of member to be removed
     */
    public static void removeMem(int number) {
        Member toRemove = findMem(number);
        if (toRemove != null) {
            MemberFiles.removeMember(toRemove.memberAccountNumber);
            System.out.println("\nMember " + number + " successfully removed.");
        }
        else {
            System.out.print("\nMember not found.");
        }
        OperatorMenu.main();
    }

    /**
     * Removes provider at given account number
     * @param accountNumber account number of provider to be removed
     */
    public static void removeProvider(int accountNumber) {
        Provider toRemove = findProvider(accountNumber);
        if (toRemove != null) {
            ProviderFiles.removeProvider(accountNumber);
            System.out.println("\nProvider " + accountNumber + " successfully removed.");
        }
        else {
            System.out.print("\nProvider not found.");
        }
        OperatorMenu.main();
    }

    /**
     * Main function for operator menu, allows user to select what action they would like to perform
     */
    public static void main() {
        System.out.println("\nOperator Menu: What would you like to do?\n");
        System.out.println("1. Run Interactive Mode");
        System.out.println("2. Log Out\n");
        System.out.println("Choose a selection by entering a number 1-2:");

        int command = 0;
        if (sc.hasNextInt()) {
            command = sc.nextInt();
        }
        sc.nextLine();
        
        if (command == 1) {
            if(Main.isDay()){
                OperatorMenu.runInteractiveMode();}
            else{
                System.out.println("It it not business hours, unable to run interactive mode\n");
                OperatorMenu.main();

            }
        }
        else if (command == 2) {
           OperatorMenu.logOut();
        }
        else {
            System.out.println(command);
            System.out.println("\nCommand not found, please try again.\n");
            OperatorMenu.main();
        }
        sc.close();
    }
}
