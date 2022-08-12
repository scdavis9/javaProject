package src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * The Provider class, this constructs and holds all information and functionality related to a singular provider
 * 
 * @author Ryan Moddesette
 * @version 1.0
 */

public class Provider {
    String name;
    int accNumber;
    String address;
    String city;
    String state;
    int zipCode;
    int numberOfConsultations;
    double fee;
    Vector<ServiceProvider> providerServiceList;

    /**
     * This is a constructor for the provider class
     * @param name this is provider's name
     * @param accNumber this is the provider's accountNumber
     * @param address this is the provider's address
     * @param city this is the provider's city
     * @param state this is the provider's state
     * @param zipCode this is the provider's zipcode
     * @param fee this is the total fee that is owed to a provider
     */

    public Provider(String name,int accNumber,String address,String city,String state,int zipCode,double fee){
        this.name = name;
        this.accNumber = accNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.fee = fee;
        fee = 0;
        this.numberOfConsultations = 0;
        this.providerServiceList = new Vector<ServiceProvider>();
    }
    /**
     * The getName function gets the name of the provider
     * @return name of provider
     */
    public String getName(){
        return name;
    }
    /**
     * The getAccountNumber function gets the account number of the provider
     * @return account number of provider
     */
    public int getAccountNumber(){
        return accNumber;
    }
    /**
     * The getAddress function gets the name of the provider
     * @return address of provider
     */
    public String getAddress(){
        return address;
    }
    /**
     * The getCity function gets the city of the provider
     * @return city of provider
     */
    public String getCity(){
        return city;
    }
    /**
     * The getState function gets the state of the provider
     * @return state of provider
     */
    public String getState(){
        return state;
    }
    /**
     * The getZipCode function gets the zip code of the provider
     * @return zipCode of provider
     */
    public int getZipCode(){
        return zipCode;
    }
    /**
     * The getFee function gets the total fee that the provider is owed
     * @return total fee of provider
     */
    public double getFee() {
        return fee;
    }
    /**
     * The servicesCompleted function gets necessary information related to the member, provider and service and constructs a service object to add to the provider's service vector
     * @param serviceCode code of service that provider provided
     * @param providerNum number of provider who is providing service
     * @param memberNum number of member that is being serviced
     */
    public void servicesCompleted(int serviceCode, int providerNum, int memberNum){
        //date and time recieved
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        String dateAndTimeNow = formatter.format(date); 
        String serviceDate = BillingInfo.getDateOfServiceString();
        
        //member name
        Member curMember = MemberFiles.searchMember(memberNum);
        Provider curProvider = ProviderFiles.searchProvider(providerNum);

        //same fix as for end of member class
        int accNumber = curMember.getMemberAccountNumber();
        OperatorMenu.findMem(accNumber);

        //member number
        //service code
        //fee to be paid
        //total consultations
        //total fee for week
        int consultNum = curProvider.numberOfConsultations++;
        ServiceProvider newService = new ServiceProvider(dateAndTimeNow, serviceDate, providerNum, curProvider.name, memberNum, curMember.name, serviceCode, consultNum, fee);
        //fix: below line okay to use add() or need to figure out a way to push back?
        curProvider.providerServiceList.add(newService);
    }
}