package src;

import java.util.Iterator;
import java.util.Map;

/**
 * The Manager Report class creates a summary report for the manager
 * to look at when requested
 * 
 * @author Jacob Carney
 * @version 1.0
 */
public class ManagerReport {
    
    /**
     * Prints the summary report for the manager to look at. This prints data about the provider and what
     * the provider has completed with members
     */
    public static void printSummaryReport() {
        //int consultations;
        //int totalFee;

        System.out.println("\n---------Summary Report---------");

        Iterator<Map.Entry<Integer,Provider>> mapIterator = ProviderFiles.providerMap.entrySet().iterator();

        int totalConsults = 0;
        double totalFee = 0.0;

        while (mapIterator.hasNext()) {
            Map.Entry<Integer, Provider> mapElement = (Map.Entry<Integer, Provider>)mapIterator.next();
            Provider curProvider = mapElement.getValue();
            System.out.println("Provider name: " + curProvider.name);
            //System.out.println("Provider number: " + curProvider.accNumber);
            //System.out.println("Provider street address: " + curProvider.address);
            //System.out.println("Provider city: " + curProvider.city);
            //System.out.println("Provider state: " + curProvider.state);
            //System.out.println("Provider zip code: " + curProvider.zipCode);
            //fix: print provider service list here
            System.out.println("Number of consultations: " + curProvider.numberOfConsultations);
            System.out.println("Weekly fee: " + curProvider.fee + "\n");
            totalConsults += curProvider.numberOfConsultations;
            totalFee += curProvider.fee;
        }
        System.out.println("Total number of consultations: " + totalConsults);
        System.out.println("Total fee for week: " + totalFee + "\n");
        
    }   
}