package src;   

/**
 * The ServiceMember class encapsulates a service that is done for a member and holds all relevant information relating to that
 * 
 * @author Ryan Moddesette
 * @version 1.0
 */

public class ServiceMember {
    
    String currentDateAndTime;
    String dateOfService;
    int providerNumber;
    String providerName;
    int memberNum;
    int serviceCode;
    int consultationsCompleted;
    String serviceName;
    String comments;
    int fee;

    /**
 * Service member constructor initializes the service member object
 * @param currentDateAndTime time that interaction between member and provider occured
 * @param dateOfService2 date that service is to be provided to member
 * @param providerNumber number of provider that is to provide service
 * @param providerName name of provider that is to provide service
 * @param memberNum number of member that is to receive service
 * @param serviceCode service code of service that member requested
 * @param serviceName name of service that is provided to member
 * @param comments comments relating to service
 */
    
    public ServiceMember(String currentDateAndTime, String dateOfService2, int providerNumber, String providerName, int memberNum, int serviceCode, String serviceName, String comments){
        this.currentDateAndTime = currentDateAndTime;
        this.dateOfService = dateOfService2;
        this.providerNumber = providerNumber;
        this.providerName = providerName;
        this.memberNum = memberNum;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.comments = comments;
    }
}

