package src;

/**
 * The ServiceProvider class encapsulates a service that being done by a provider and holds all relevant information relating to that
 * 
 * @author Rediat Shamsu
 * @version 1.0
 */

public class ServiceProvider {
    
    String currentDateAndTime;
    String dateOfService;
    Object memberName;
    int providerNumber;
    String providerName;
    int memberNum;
    int serviceCode;
    int consultations;
    double fee;

    /**
 * ServiceProvider constructor creates an instance of service provider object
 * @param currentDateAndTime time that transaction between member and provider occurred
 * @param dateOfService data that service is to be provided
 * @param providerNumber number of provider providing service
 * @param providerName name of provider providing service
 * @param memberNum number of member that is being provided service
 * @param memberName name of member that is being provided for
 * @param serviceCode code of service to be provided
 * @param consultations total number of consultations that provider has given to members 
 * @param fee total fee owed to the provider
 */
    
    public ServiceProvider(String currentDateAndTime, String dateOfService, int providerNumber, String providerName, int memberNum, String memberName, int serviceCode, int consultations, double fee){
        this.currentDateAndTime = currentDateAndTime;
        this.dateOfService = dateOfService;
        this.providerNumber = providerNumber;
        this.providerName = providerName;
        this.memberNum = memberNum;
        this.memberName = memberName;
        this.serviceCode = serviceCode;
        this.consultations = consultations;
        this.fee = fee;
    }
}
