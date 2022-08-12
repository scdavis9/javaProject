package src;

import java.io.FileWriter;
import java.io.IOException;
/**
 * This is the report that the member would recieve by email from the provider
 * 
 * @author Jacob Carney
 * @version 1.0
 */
public class MemberReport {
    public static FileWriter memberWriter;
    
    
    /**
     * Prints the provider report to the console. This is what the 
     * member would also see in their email
     * 
     * @param memberAccountNumber the members account number
     */
    public static void printMemberReport(int memberAccountNumber){
       
        Member member = MemberFiles.searchMember(memberAccountNumber);
        String memberName = member.getName();

        System.out.print("----------------MEMBER REPORT---------------------" + "\n"+ "Name: " + memberName + "\n" + "Member number: " + memberAccountNumber + "\n" + "Address: " + member.getAddress()
        + "\n" + "City: " + member.getCity() + "\n" + "State: "+ member.getState() + "\n" + "Zip Code: " + member.getZipCode() + "\n"); 
        for (int i = 0; i < member.memberServiceList.size(); i++) {
            ServiceMember curService = member.memberServiceList.get(i);
            System.out.println("Date of Service: " + curService.dateOfService);
            System.out.println("Provider Name: " + curService.providerName);
            System.out.println("Service Name: " + curService.serviceName);

            try{
                memberWriter = new FileWriter(memberName + "_" + curService.dateOfService + ".txt");
                memberWriter.write("Name: " + memberName + "\n");
                memberWriter.write("Member number: "+ memberAccountNumber + "\n");
                memberWriter.write("Address: " + member.getAddress() + "\n");
                memberWriter.write("City: " + member.getCity() + "\n");
                memberWriter.write("State: "+ member.getState()+ "\n");
                memberWriter.write("Zip Code: " + member.getZipCode()+ "\n");
                memberWriter.write("Date of Service: " + curService.dateOfService+ "\n");
                memberWriter.write("Provider Name: " + curService.providerName + "\n");
                memberWriter.write("Service Name: " + curService.serviceName+ "\n");
                memberWriter.close();
            }catch(IOException e){
                System.out.println("Error saving data to file.\n");
                e.printStackTrace();
            }
        }
        System.out.print("--------------END MEMBER REPORT-------------------");
    }
}
