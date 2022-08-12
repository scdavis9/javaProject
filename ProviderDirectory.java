package src;

// import java.io.FileWriter;
import java.io.IOException;
// import java.io.OutputStream;
import java.util.*;

/**
 * The ProviderDirectory class. Holds the provider directory and displays the provider directory.
 * Checks to ensure the service code is in the provider directory and returns the fee for a service code
 * 
 * @author Shelby Deerman
 * @version 1.0 
 */
public class ProviderDirectory {
    static List<String> serviceNames = Arrays.asList("Aerobics Exercise Session", "Dietition Session", "Group Therapy Session", "Hot Yoga Session", "Massage Session", "Spin Class", "Therapy Session", "Water Aerobics Exercise Session", "Yoga Session", "Zumba Class");
    static List<Integer> serviceCodes = Arrays.asList(883948, 598470, 123567, 465972, 236745, 509831, 973642, 200391, 724658, 138469);
    static List<Integer> serviceFees = Arrays.asList(30, 60, 40, 20, 100, 30, 90, 30, 20, 15);
    
    /**
     * Function that creates a file ProviderDirectory with the provider directory in it and says it sent as an email attachment
     */
    public static void sendEmailAttachment() {
        try {
            Formatter output = new Formatter("./ProviderDirectory.txt");
            output.format("%s", "Provider Directory: \n\n");
            output.format("%-40s%-40s%-40s%n", "Service Name:", "Service Code:", "Fee:");
            for (int i = 0; i < serviceNames.size(); i++) {
                output.format("%-40s%-40s$%-40s%n", serviceNames.get(i), serviceCodes.get(i), serviceFees.get(i));
            }
            output.close();
            System.out.println("\nEmail sent\n");
        } catch (IOException e) {
            System.out.println("Could not send email.");
            e.printStackTrace();
        }
    }

    /**
     * Displays the provider directory to the terminal screen
     */
    public static void displayProviderDirectory() {
        System.out.println("Provider Directory: \n");
        System.out.format("%-40s%-40s%-40s%n", "Service Name:", "Service Code:", "Fee:");
        for (int i = 0; i < serviceNames.size(); i++) {
            System.out.format("%-40s%-40s$%-20s%n", serviceNames.get(i), serviceCodes.get(i), serviceFees.get(i));
        }
        System.out.println();
    }

    /**
     * Takes in a service code and returns the name of the service that corresponds with the code if it exists in the provider directory
     * 
     * @param serviceCode is the service code that is entered
     * @return the name of the service that corresponds with the service code, or "false" if the service code is not in the provider directory
     */
    public static String checkServiceCode(int serviceCode) {
        int i;
        for (i = 0; i < serviceCodes.size(); i++) {
            if (serviceCodes.get(i) == serviceCode) break;
        }
        if (i == serviceCodes.size()) {
            return "false";
        }
        else {
            return serviceNames.get(i);
        }
    }

    /**
     * Takes in a service code and returns the fee that corresponds with the code if it exists in the provider directory
     * 
     * @param serviceCode is the service code that is entered 
     * @return the fee that corresponds with the service code, or -1 if the service code does not exist within the provider directory
     */
    public static int lookUpFee(int serviceCode) {
        int i;
        for (i = 0; i < serviceCodes.size(); i++) {
            if (serviceCodes.get(i) == serviceCode) break;
        }
        if (i == serviceCodes.size()) {
            return -1;
        }
        else {
            return serviceFees.get(i);
        }
    }
}
