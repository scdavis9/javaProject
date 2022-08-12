package src;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import src.Member.memberStatus;

/**
 * The Provider Menu Class allows the user to choose provider director, validate member, bill Chocan, or log out.
 * 
 * @author Summer Davis
 * @version 1.0
 */
public class ProviderMenu {
    static public String memberNameHolder; //keeps track of member name
    static public int memberNumberHolder; //keeps track of member number
    static public int providerNumberHolder; //keeps track of provider number currently working with the provider menu
    static public boolean loginFlag =false; // flag that is raised when a provider logs in with a valid provider code
    static public String providerName;
    ProviderDirectory directory;
    BillingInfo billing;
    int memberNumber;
    MemberFiles memberFiles;
    //static Member mem;
    Main menu;

    public static Scanner scanner = new Scanner(System.in);
    /**
     * This is the constructor for Provider Menu, meant to just initialize everything.
     */
    public ProviderMenu() {
        directory = new ProviderDirectory();
        billing = new BillingInfo();
        memberFiles = new MemberFiles();
        //mem = new Member(null, 0, null, null, null, 0);
        menu = new Main();
    }
    /**
     * The selectProviderDirectory function allows the user to select Provider Directory and enter that class.
     */
    public static void selectProviderDirectory() {
        ProviderDirectory.sendEmailAttachment();
    }
    /**
     * The promptMemberInfo function allows user to be able to enter in member number and displays member status based on number entered.
     */
    public static void promptMemberInfo() {
        System.out.println("\nEnter member number: ");
        
        /*while(!myObj2.hasNextInt()) {
            myObj2.next();
            System.out.println("\nPlease reenter a numerical value. \n");
        }*/
        int number = scanner.nextInt(); 
        Member mem = MemberFiles.searchMember(number);
        if(mem == null) { //if invalid number or member not found
            System.out.println("\nInvalid Number. Member not found.\n");
            ProviderMenu.main();
        }
        if(mem.currentStatus == memberStatus.ACTIVE) {
            memberNumberHolder = number;
            memberNameHolder = mem.name;
            System.out.println("\nValidated\n"); 
            //BillingInfo.main(); 
        }
        else if(mem.currentStatus == memberStatus.SUSPENDED) {
            System.out.println("\nMember Suspended\n");
            ProviderMenu.main();
        }
    }

    /**
     * The selectBillingOption allows user to select billing option and enter Billing Info class.
     */
    public static void selectBillingOption() {
        BillingInfo.main(); //sends to billing info
    }
    /**
     * The logOut functions allows user to return to main menu.
     */
    public static void logOut() {
        Main.enterCredentials();
    }

    /**
     * This is the main function for Provider Menu, allowing user to be able to select which action to perform.
     */
    public static void main() {
         
         if(loginFlag == false){ //only runs once and stops going after provider enters a valid number
            try{ 
            System.out.println("\nEnter Provider number: "); // provider has to enter their number when the provider menu is turned on

                int providerNumber = scanner.nextInt(); //scans in provider number into providerNumber
                if(ProviderFiles.searchProvider(providerNumber)==null){
                    System.out.println("Provider number not found in data base, please try again");
                    ProviderMenu.main();}
                else{
                    Provider value = ProviderFiles.searchProvider(providerNumber);
                    providerName = value.name;
                    providerNumberHolder = providerNumber;
                    loginFlag = true;
                }
                
            }
            catch(InputMismatchException e){ //catches number if it's not an integer or out of range
                System.out.println("Input was not an integer or was out of range, please limit provider number to 9 digits max");
                ProviderMenu.main();
            }}
        
    

        System.out.println("\nProvider Menu: What would you like to do?\n");
        System.out.println("1. Select Provider Directory");
        System.out.println("2. Validate Member");
        System.out.println("3. Bill ChocAn");
        System.out.println("4. Log Out\n");
        System.out.println("Choose a selection by entering a number 1-4:");
        

        

        try{
            int selection = 0;
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
            }
            
            //if(scanner.hasNext()){
                scanner.nextLine();
            //else{
                //System.out.println("Scanner is empty");
            //}
            
            if(selection == 1) {
                ProviderMenu.selectProviderDirectory();
                ProviderMenu.main();
            }
            else if(selection == 2) {
                ProviderMenu.promptMemberInfo();
                ProviderMenu.main();
            }
            else if(selection == 3) {
                BillingInfo.main();
                ProviderMenu.main();
            }
            else if(selection == 4) {
                loginFlag = false;
                Main.enterCredentials();
            }
            else {
                System.out.println("Command not found, please try again");
                ProviderMenu.main();
            }}
        catch(NoSuchElementException e){
            e.printStackTrace();
            //ProviderMenu.main();


        }
        scanner.close();
    }
}