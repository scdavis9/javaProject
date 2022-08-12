package src;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The BillingInfo class. This class allows the provider to bill ChocAn when they choose "Bill ChocAn" from the Provider Menu
 * 
 * @author Shelby Deerman
 * @version 1.0
 */
public class BillingInfo {

    public static Date dateOfService;
    public static String dateOfServiceString;
    public static int serviceCode;
    public static String comment;
    public static String nameOfserviceHolder;
    public static double feeHolder;
    public static String currentDataAndTime;


    public static Scanner sc = new Scanner(System.in);
    public static FileWriter writer;

    /**
     * Setter function for the setDateOfServiceString variable
     * 
     * @param date is the Date type date variable that comes from the string the user enters
     */
    public static void setDateOfService(Date date) {
        dateOfService = date;
    }

    /**
     * Setter function for the setDateOfServiceString variable
     * 
     * @param dateString is the date that the user enters
     */
    public static void setDateOfServiceString(String dateString) {
        dateOfServiceString = dateString;
    }

    /**
     * Getter function for the dateOfServiceString variable
     * 
     * @return dateOfServiceString variable
     */
    public static String getDateOfServiceString() {
        return dateOfServiceString;
    }

    /**
     * Setter function for the serviceCode variable
     * 
     * @param code is the service code that the user enters
     */
    public static void setServiceCode(int code) {
        serviceCode = code;
    }

    /**
     * Setter function for the comment variable
     * 
     * @param com is the comment that the user enters
     */
    public static void setComment(String com) {
        comment = com;
    }

    /**
     * Allows the provider to enter the date of service and sets dateString to the user input
     */
    public static void enterServiceDate() {
        System.out.println("Enter date of service (MM-DD-YYYY): ");
        String dateString = sc.next();
        setDateOfServiceString(dateString);
    }

    /**
     * calls displayProviderDirectory() from the ProviderDirectory class
     */
    public static void callProviderDirectory() {
        ProviderDirectory.displayProviderDirectory();
    }

    /**
     * Allows the provider to enter the service code that they want and updates serviceCode variable
     */
    public static void enterServiceCode() {
        System.out.println("Enter service Code: ");
        int serviceCode = sc.nextInt();
        setServiceCode(serviceCode);
    }

    /**
     * Checks to ensure if the service code is in the Provider Directory 
     * Prints the service name and service code and asks the provider to confirm this was the requested service
     * 
     * @return either true or false depending on if the service code is in the provider directory
     */
    public static Boolean verifyServiceCode() {
        while(true) {
            String nameOfService = ProviderDirectory.checkServiceCode(serviceCode);
            if (nameOfService == "false") {
                return false;
            }
            System.out.println("\nYou entered: " + serviceCode);
            System.out.println("This code corresponds to: " + nameOfService);
            System.out.println("\nIs service code and service name correct? y/n");
            String answer = sc.next();
            if (answer.equals("y")) {
                nameOfserviceHolder = nameOfService;
                return true;
            }
            else if (answer.equals("n")) {
                System.out.println();
                ProviderDirectory.displayProviderDirectory();
                enterServiceCode();
            }
            else {
                System.out.println("\nAnswer must be \"y\" or \"n\"");
            }
        }
    }

    /**
     * Allows the provider to enter comments about the service and saves it into the comment variable
     */
    public static void enterServiceComments() {
        String com = sc.nextLine();
        System.out.println("\nEnter comments about service or type N/A: ");
        com = sc.nextLine();
        if (com.equals("NA") || com.equals("na") || com.equals("")) {
            setComment("No comment");
        } else {
            setComment(com);
        } 
    }

    /**
     * Uses the provider directory to lookup the fee that corresponds to the service code and prints to the screen
     */
    public static void displayFee() {
        double fee = ProviderDirectory.lookUpFee(serviceCode);
        if (fee != -1) {
            feeHolder = fee;
            System.out.println("\nFee:\t$" + fee);
        } 
        else {
            System.out.println("Invalid service code");
        }
    }

    /**
     * Allows the user to fill out a verification form to verify all the information they just entered
     */
    public static void verifyFee() {
        try {
            System.out.println("\nVERIFICATION FORM:\n");
            writer = new FileWriter("verification.txt",true);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            enterServiceDate();
            writer.write(formatter.format(date) + "\n" + dateOfServiceString + "\n");
            int memberNumber = 0;
            String memberName;
            while (true) {
                System.out.println("\nEnter member number: ");
                memberNumber = sc.nextInt(); 
                if (memberNumber != ProviderMenu.memberNumberHolder) {
                    System.out.println("\nMember number is incorrect. Try again");
                }
                else break;
            }
            while (true) {
                System.out.println("\nEnter member name: ");
                memberName = sc.next();
                Member member = MemberFiles.searchMember(memberNumber);
                if (!memberName.equals(member.getName())) {
                    System.out.println("\nMember name does not match member number. Try again");
                    System.out.println("Member name is " + member.name + ".");
                }
                else break;
            }
            writer.write("Member Name:\t" + memberName + "\n");
            writer.write("Member Number:\t" + memberNumber + "\n");
            writer.write("Service Code:\t" + serviceCode + "\n");
            int fee = ProviderDirectory.lookUpFee(serviceCode);
            writer.write("Fee:\t$" + fee + "\n\n");
            writer.close();
        } catch (IOException e) {}
    }

    /**
     * Main function for BillingInfo 
     */
    public static void main() {
        ProviderMenu.promptMemberInfo(); 
        enterServiceDate(); 
        System.out.println("\n");
        callProviderDirectory();
        enterServiceCode();
        while (true) {
            Boolean x = verifyServiceCode();
            if (x == false) {
                System.out.println("\nInvalid service code. Try again.\n");
                callProviderDirectory();
                enterServiceCode();
            }
            else break;
        }
        enterServiceComments();
        try {
            int memberNumberHolder = ProviderMenu.memberNumberHolder;
            int providerNumberHolder = ProviderMenu.providerNumberHolder;
            Date serviceDate = new SimpleDateFormat("MM-dd-yyyy").parse(dateOfServiceString);
            setDateOfService(serviceDate);
            Disk billingDisk = new Disk();
            billingDisk.saveData(serviceDate, BillingInfo.serviceCode, BillingInfo.comment, memberNumberHolder, providerNumberHolder);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        displayFee();
        System.out.println();
        verifyFee();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateAndTimeNow = formatter.format(date);
        ServiceMember serviceToaddM = new ServiceMember(dateAndTimeNow,dateOfServiceString,ProviderMenu.providerNumberHolder,ProviderMenu.providerName,ProviderMenu.memberNumberHolder,serviceCode,nameOfserviceHolder,comment);
        Member curMember = MemberFiles.searchMember(ProviderMenu.memberNumberHolder);
        Provider curProvider = ProviderFiles.searchProvider(ProviderMenu.providerNumberHolder);
        curProvider.numberOfConsultations++;
        curProvider.fee += feeHolder;
        ServiceProvider providerToaddM = new ServiceProvider(dateAndTimeNow,dateOfServiceString,ProviderMenu.providerNumberHolder,ProviderMenu.providerName,ProviderMenu.memberNumberHolder,ProviderMenu.memberNameHolder,serviceCode,curProvider.numberOfConsultations,feeHolder);

        curMember.memberServiceList.add(serviceToaddM);
        curProvider.providerServiceList.add(providerToaddM);
        

        //sc.close();
        
    }
    
}
