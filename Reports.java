package src;
/**
 * Reports class directs which report should be printed using signaling.
 * 
 * @author Jacob Carney
 * @version 1.0
 */
public class Reports{
    ProviderReport providerReport = new ProviderReport();
    MemberReport memberReport = new MemberReport();
    ManagerReport managerReport = new ManagerReport();
    EFTReport eftReport = new EFTReport();
    /**
     * Signals the provider report to be printed
     * 
     * @param providerNumber the providers account number
     */
    public static void signalProviderReport(int providerNumber){
        ProviderReport.printProviderReport(providerNumber);
    }
    /**
     * Signals the member report to be printed
     * 
     * @param memberAccountNumber the members account number
     */
    public static void signalMemberReport(int memberAccountNumber){
        MemberReport.printMemberReport(memberAccountNumber);
    }
    /**
     * Signals the manager report to be printed
     */
    public static void signalManagerReport(){
        ManagerReport.printSummaryReport();
    }
    /**
     * Signals the eft report to be printed
     */
    public static void signalEFTReport(){
        EFTReport.printEFTReport();
    }
    /**
     * Signals all reports to be printed
     * 
     * @param memberAccountNumber the members account number
     * @param providerAccountNumber the providers account number
     */
    public void signalAllReport(int memberAccountNumber, int providerAccountNumber){
        ProviderReport.printProviderReport(providerAccountNumber);
        MemberReport.printMemberReport(memberAccountNumber);
        ManagerReport.printSummaryReport();
        EFTReport.printEFTReport();
    }
}