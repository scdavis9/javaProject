package src;
import java.util.*;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

/**
 * This is the Main class. This allows the user to enter an email, password, occupation/position. The Main class also enables main accounting procedure to take place.
 * 
 * @author Summer Davis
 * @version 1.0
 */

public class Main {
    String message = "Invalid Login";
    String message2 = "Successful Logout";

    public Main() {
    }
    /**
     * The isValidEmail indicates additional valid characters within a user email / checks if email matches the "regex" pattern.
     * @param email this is the user email
     * @return email is valid and matches the expression/pattern
     */
    static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String comMatch = email.substring(email.length()-3);
        if((comMatch.equals("com")&email.matches(regex))|(comMatch.equals("COM")&email.matches(regex))){
            return true;
        }
        return false;
     }
     /**
      * The hasUpper function checks if password contains an uppercase letter.
      * @param password the user password
      * @return true/false depending if password contains an uppercase letter
      */
    static boolean hasUpper(String password) {   //checks if password contains an uppercase letter
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
    /**
     * The hasSpec function checks if password contains a special character(not a number or letter).
     * @param password the word/phrase user enters to gain access (the user password)
     * @return true/false depending if password contains a special character
     */
    static boolean hasSpec(String password) { //checks if password contains a special character(Not number or letter)
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if ((!Character.isLetterOrDigit(ch)) && (!Character.isWhitespace(ch))) {
                return true;
            }
        }
        return false;
    }
    /**
     * The isValidPassword checks if password meets length requirements, as well as ensures that password has at least a special character or uppercase character.
     * @param password the word/phrase user enters to gain access
     * @return true/false if the password is valid under the following conditions
     */
    static boolean isValidPassword(String password) {
        if (password.length() < 8) { //password can't be less than 8 characters
            return false;
        }
        else if (!hasSpec(password) || !hasUpper(password)) { // if either helper password functions return false password is not valid
            return false;
        }
        return true;
    }
    /**
     * The enterCredentials function prompts/allows user to enter email, password, and position in the right format.
     */
    public static void enterCredentials() {
        String email = null;
        String password = null;
        int position = 0;

        Scanner myObj = new Scanner(System.in);
        System.out.println("\nPlease enter your email or enter \"Quit\" to exit system:");
        email = myObj.nextLine();
        if (email.equals("Quit") || email.equals("quit")) {
            System.exit(0);
        }
        if (!isValidEmail(email)) {
            System.out.println("\nInvalid email format. Please use format username@email.com.\n");
            enterCredentials();
        }
        System.out.println("\nPlease enter your password:");
        password = myObj.nextLine();
        if(!isValidPassword(password)) {
            System.out.println("\nInvalid password. Password must be at least 8 characters and contain\nan uppercase letter and a special character.\n");
            enterCredentials();
        }

        System.out.println("\nPlease enter your position:");
        System.out.println("Provider = 1, Manager = 2, Operator = 3");

        while (position <= 0 || position > 3) {
            if(myObj.hasNextInt()) {
                position = myObj.nextInt();
            } 
            else {
                myObj.next();
                //System.out.println("Please reenter a numerical value. \n");
            }

            if (position == 1) {
                ProviderMenu.main();
            }
            else if (position == 2) {
                ManagerMenu.main();
            }
            else if (position == 3) {
                OperatorMenu.main();
            }
            else {
                System.out.println("\nInvalid position. Please reenter a numerical value from 1 - 3: Provider = 1, Manager = 2, Operator = 3\n");
            }
        }
        myObj.close();
    }   
    /**
     * The runMainAccountingProcedure runs through each value in member/provider hashmap and prints out the key value pairs, & prints report.
     */
    static void runMainAccountingProcedure(){
       
        Calendar calendar = Calendar.getInstance(); 
        
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int totalConsultations = 0;
        int totalNumofActiveProviders = 0;
        double overallFeeOwed = 0.0;

        for(Map.Entry mapElement :MemberFiles.memberMap.entrySet()){ // runs through each value in member hashmap and prints out the key value pairs
            int key  = (int)mapElement.getKey();
            Member value = (Member)mapElement.getValue();
            //System.out.println(value.memberAccountNumber+ "\n");
            
            if(!(value.memberServiceList.isEmpty())){ //prints report for each member that has consulted with a provider during week
                
                    if(weekOfYear == calendar.get(Calendar.WEEK_OF_YEAR)){
                        MemberReport.printMemberReport(key);}
                
                

        }
    }

        for(Map.Entry mapElement :ProviderFiles.providerMap.entrySet()){ //runs through each value in provider hashmap
            int key = (int)mapElement.getKey();
            Provider value = (Provider)mapElement.getValue();
            //System.out.println(value.accNumber+ "\n");
            if(!(value.providerServiceList.isEmpty())){
                if(weekOfYear == calendar.get(Calendar.WEEK_OF_YEAR)){
                    ProviderReport.printProviderReport(key);}
            }}
        System.out.println("\n");

        System.out.println("---------Summary Report----------\n");
        System.out.println("Providers to be paid:\n");

        for(Map.Entry mapElement :ProviderFiles.providerMap.entrySet()){
            Provider value = (Provider)mapElement.getValue();
             
            if(!(value.providerServiceList.isEmpty())){
                if(weekOfYear == calendar.get(Calendar.WEEK_OF_YEAR)){
                    try {
                        FileWriter writer = new FileWriter("EFT.txt",true);
                        writer.write(value.name + " "+ value.accNumber+ " " + value.fee + "\n");
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println(value.name + " number of consultations: " + value.numberOfConsultations+ " total fee owed: "+ value.fee + "\n");
                    totalConsultations+= value.numberOfConsultations;
                    totalNumofActiveProviders++;
                    overallFeeOwed+=value.fee;}

            }
        

        }

        System.out.println("Total number of providers who provided services: "+ totalNumofActiveProviders +" total number of consultations: "+ totalConsultations+ " total fee owed for week: " + overallFeeOwed + "\n");


    
        
        ManagerMenu.main();
        }
    
    /**
     * The isDay functions verifies that it's during the day.
     * @return true
     */    
    static Boolean isDay() {
        Calendar calendarInteractive = Calendar.getInstance();
        //int day = calendarInteractive.get(Calendar.DAY_OF_WEEK); 
        int hour = calendarInteractive.get(Calendar.HOUR_OF_DAY);
        if(hour>=9 && hour<=16){ //if the hour is between 9-5


        return true;}
        else{
            return false;
        }
    }
    
    /**
     * The main fucntion initializes hash map and prompts user to enter credentials.
     * @param args command-line arguments as an array of String objects
     */
    public static void main(String[] args) {
        HashMapInitialize.main();
        Calendar calendar = Calendar.getInstance();
    
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        
        int minute = calendar.get(Calendar.MINUTE);


        if(day ==6 && hour ==24 && minute ==0 ){
            runMainAccountingProcedure();
        }



        Main.enterCredentials();
    }
}