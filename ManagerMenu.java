package src;
import java.util.*;  

/**
 * The ManagerMenu class. This class allows managers to print different reports, run the main accounting procedure, or log out
 * 
 * @author Eleri Floyd
 * @version 1.0
 */
public class ManagerMenu {
    public static Scanner mScan = new Scanner(System.in);

    /**
     * Allows user to select which report type to print and prompts that report to be printed
     */
    public static void selectPrintReports() { 
        System.out.println("\nWhat type of report would you like to print?\n\n1: Member\t2: Provider\t3: Manager\n");
        System.out.println("Choose a selection by entering a number 1-3:");
        
        int reportType = 0;
        if (mScan.hasNextInt()) {
            reportType = mScan.nextInt();
        }
        mScan.nextLine();

        if (reportType == 1) {
            System.out.println("\nEnter member number of member you would like to view.");
            String memNum = mScan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(memNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nMember not found.");
                ManagerMenu.main();
            }
            if (MemberFiles.searchMember(num) == null) {
                System.out.println("\nMember not found.");
                ManagerMenu.main();
            }            
            Reports.signalMemberReport(num);
        }
        else if (reportType == 2) {
            System.out.println("\nEnter provider number of provider you would like to view.");
            String provNum = mScan.nextLine();
            int num = 0;
            try {
                num = Integer.parseInt(provNum);
            } catch (NumberFormatException nfe) {
                System.out.println("\nProvider not found.");
                ManagerMenu.main();
            }
            if (ProviderFiles.searchProvider(num) == null) {
                System.out.println("\nProvider not found.");
                ManagerMenu.main();
            }       
            Reports.signalProviderReport(num);
        }
        else if (reportType == 3) {
            Reports.signalManagerReport();
        }
        else {
            System.out.println("\nReport type not found. Please try again.");
            ManagerMenu.selectPrintReports();
        }
        ManagerMenu.main();
    }

    /**
     * Log user out at returns them to the main login menu
     */
    public static void logOut() {
        Main.enterCredentials();
    }

    /**
     * Main function for manager menu, allows user to select what action they would like to perform
     */
    public static void main() {
        System.out.println("\nManager Menu: What would you like to do?\n");
        System.out.println("1. Print Reports");
        System.out.println("2. Run main accounting procedure");
        System.out.println("3. Log Out\n");
        System.out.println("Choose a selection by entering a number 1-3:");
 
        int command = 0;
        if (mScan.hasNextInt()) {
            command = mScan.nextInt();
        }
        mScan.nextLine();

        if (command == 1) {
            ManagerMenu.selectPrintReports();
        }
        else if (command == 2) {
            Main.runMainAccountingProcedure();
        }
        else if(command == 3){
            ManagerMenu.logOut();
        }
        else {
            System.out.println("\nCommand not found, please try again.\n");
            ManagerMenu.main();
        }
        mScan.close();
    }
}
