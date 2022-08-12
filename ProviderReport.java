package src;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This prints the report for provider
 * 
 * @author Jacob Carney
 * @version 1.0
 */
public class ProviderReport {
    /**
     * Prints provider report
     * 
     * @param providerNumber the providers account number
     */
    public static void printProviderReport(int providerNumber){
        Provider curProvider = ProviderFiles.searchProvider(providerNumber);
        if (curProvider == null) {
            System.out.println("Provider not found.");
            return;
        }
        
        Provider provider = ProviderFiles.searchProvider(providerNumber);

        System.out.println("\n----------------PROVIDER REPORT---------------------");

        System.out.println("Provider name: " + curProvider.name);
        System.out.println("Provider number: " + curProvider.accNumber);
        System.out.println("Provider street address: " + curProvider.address);
        System.out.println("Provider city: " + curProvider.city);
        System.out.println("Provider state: " + curProvider.state);
        System.out.println("Provider zip code: " + curProvider.zipCode);
        for (int i = 0; i < provider.providerServiceList.size(); i++) {
            ServiceProvider curProviderService = provider.providerServiceList.get(i);
            System.out.println("Date of service: " + curProviderService.dateOfService);
            System.out.println("Date and time data was received: " + curProviderService.currentDateAndTime);
            System.out.println("Member name: " + curProviderService.memberName);
            System.out.println("Member number: " + curProviderService.memberNum);
            System.out.println("Service Code: " + curProviderService.serviceCode);
            System.out.println("Fee to be paid: " + curProviderService.fee);
            try{
                FileWriter providerWriter = new FileWriter(curProvider.name + "_" + curProviderService.dateOfService + ".txt");
                providerWriter.write("Provider name: " + curProvider.name+ "\n");
                providerWriter.write("Provider number: " + curProvider.accNumber+"\n");
                providerWriter.write("Provider street address: " + curProvider.address+"\n");
                providerWriter.write("Provider city: " + curProvider.city+"\n");
                providerWriter.write("Provider state: " + curProvider.state+"\n");
                providerWriter.write("Provider zip code: " + curProvider.zipCode+"\n");
                providerWriter.write("Date of service: " + curProviderService.dateOfService+"\n");
                providerWriter.write("Date and time data was received: " + curProviderService.currentDateAndTime+"\n");
                providerWriter.write("Member name: " + curProviderService.memberName+"\n");
                providerWriter.write("Member number: " + curProviderService.memberNum+"\n");
                providerWriter.write("Service Code: " + curProviderService.serviceCode+"\n");
                providerWriter.write("Fee to be paid: " + curProviderService.fee+"\n");
                providerWriter.write("Total number of consultations: " + curProvider.numberOfConsultations+"\n");
                providerWriter.write("total fee: " + curProvider.fee+"\n");
                providerWriter.close();
            }catch(IOException e){
                System.out.println("Error saving data to file.\n");
                e.printStackTrace();
            }
        }
        System.out.println("Total number of consultations: " + curProvider.numberOfConsultations);
        System.out.println("Total fee: " + curProvider.fee);
        System.out.println("--------------END PROVIDER REPORT-------------------");
    }
}
